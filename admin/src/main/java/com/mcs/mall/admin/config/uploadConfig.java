package com.mcs.mall.admin.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class uploadConfig extends WebMvcConfigurerAdapter {

    private Logger logger = LoggerFactory.getLogger(uploadConfig.class);
    @Autowired
    UploadProperty uploadProperty;

    public static void main(String[] args) {
        Path p = Paths.get("F:", "img");
        System.out.println(p.toString());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //指向外部目录

        String filePath = "file:" + uploadProperty.getIMG_PATH();
        logger.info("filePath=" + filePath);
        registry.addResourceHandler("img//**").addResourceLocations(filePath);
        super.addResourceHandlers(registry);
    }
}
