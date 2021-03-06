package com.mcs.mall.admin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UploadProperty {
    @Value("${file.rootPath}")
    private String ROOT_PATH;

    @Value("${file.imgPath}")
    private String IMG_PATH;

    public String getIMG_PATH() {
        return ROOT_PATH + IMG_PATH;
    }

    public String getIMG_PREFIX() {
        return IMG_PATH;
    }


}
