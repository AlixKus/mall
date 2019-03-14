package com.mcs.mall.admin.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class UploadConfig implements WebMvcConfigurer {

    private Logger logger = LoggerFactory.getLogger(UploadConfig.class);
    @Autowired
    UploadProperty uploadProperty;

    public static void main(String[] args) {
        Path p = Paths.get("F:", "img");
        System.out.println(p.toString());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //指向外部目录
        String dir = uploadProperty.getIMG_PATH();
        File dirFile = new File(dir);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
            logger.info("文件目录不存在创建了:" + dirFile.toString());
        }
        String filePath = "file:" + dir;
        logger.info("filePath=" + filePath);
        registry.addResourceHandler("img//**").addResourceLocations(filePath);
    }
}
