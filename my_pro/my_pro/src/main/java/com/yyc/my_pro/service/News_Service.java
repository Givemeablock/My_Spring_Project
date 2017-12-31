package com.yyc.my_pro.service;

import com.yyc.my_pro.Dao.NewsDAO;
import com.yyc.my_pro.model.News;
import com.yyc.my_pro.tools.userTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import static com.yyc.my_pro.tools.userTool.isAllowedType;

@Service
public class News_Service {
    @Autowired
    private NewsDAO news;

    public List<News> getLatestNews(int userId, int offset, int limit) {
        return news.selectByUserIdAndOffset(userId, offset, limit);
    }

    public List<News> get_allNews() {
        return news.get_allnews();
    }

    public String saveImage(MultipartFile file) throws IOException {
        System.out.println("---------");
        int dotPos = file.getOriginalFilename().lastIndexOf(".");
        if (dotPos < 0) {
            return null;
        }
        String fileExt = file.getOriginalFilename().substring(dotPos + 1).toLowerCase();
        if (!userTool.isAllowedType(fileExt)) {
            return null;
        }

        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + "." + fileExt;
        Files.copy(file.getInputStream(), new File(userTool.upload_path + fileName).toPath(),
                StandardCopyOption.REPLACE_EXISTING);
        return userTool.local_domain + "image?name=" + fileName;
    }
}
