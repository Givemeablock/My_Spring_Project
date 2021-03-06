package com.yyc.my_pro.controller;

import com.yyc.my_pro.service.News_Service;
import com.yyc.my_pro.tools.userTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
public class NewsController {

    private static final Logger logger = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    News_Service n_s;

    @RequestMapping(path = {"/uploadImage"}, method = {RequestMethod.POST})
    @ResponseBody
    public String uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String fileUrl = n_s.saveImage(file);
            //String fileUrl = qiniuService.saveImage(file);
            //System.out.println("000000000" + fileUrl);
            if (fileUrl == null) {
                return userTool.getJSONString(1, "上传图片失败");
            }
            return userTool.getJSONString(0, fileUrl);
        } catch (Exception e) {
            logger.error("上传图片失败" + e.getMessage());
            //System.out.println("==");
            return userTool.getJSONString(1, "上传失败");
        }
    }

    @RequestMapping(value = "/image", method = RequestMethod.GET)
    @ResponseBody
    public void getImage(@RequestParam("name") String imageName,
                         HttpServletResponse response) {
        response.setContentType("image/jpeg");
        try {
            StreamUtils.copy(new FileInputStream(new File(userTool.upload_path +
                    imageName)), response.getOutputStream());
        } catch (IOException e) {
            logger.error("读取错误");
        }
    }
}
