package com.yyc.my_pro.interceptor;


import com.yyc.my_pro.Dao.LoginTicketDAO;
import com.yyc.my_pro.Dao.UserDAO;
import com.yyc.my_pro.model.HostHolder;
import com.yyc.my_pro.model.LoginTicket;
import com.yyc.my_pro.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

//拦截器
@Component
public class PassportInterceptor implements HandlerInterceptor{

    @Autowired
    private LoginTicketDAO ldao;

    @Autowired
    private UserDAO udao;

    @Autowired
    private HostHolder hostHolder;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object o)
                            throws Exception {
        String ticket = null;
        if (httpServletRequest.getCookies() != null) {
            //System.out.println("------------------");
            for (Cookie cookie : httpServletRequest.getCookies()) {
                if (cookie.getName().equals("ticket")) {
                    ticket = cookie.getValue();
                    //System.out.println("ticket:" + ticket);
                    break;
                }
            }
        }
        if (ticket != null) {
            LoginTicket loginTicket = ldao.selectByTicket(ticket);
            if (loginTicket == null || loginTicket.getExpired().before(new Date()) ||
                    loginTicket.getStatus()!=0) {
                    return true;
            }
            User user = udao.sel_user(loginTicket.getUserId());
            //
            hostHolder.setUser(user);
            //System.out.println("-----------over here");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {
        if (modelAndView != null && hostHolder.getUser() != null) {
            modelAndView.addObject("user", hostHolder.getUser());
            //System.out.println(hostHolder.getUser());
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
        hostHolder.clear();
    }
}
