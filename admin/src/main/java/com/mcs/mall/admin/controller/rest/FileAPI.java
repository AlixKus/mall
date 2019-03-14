package com.mcs.mall.admin.controller.rest;

import com.mcs.mall.admin.component.file.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileAPI {
    @Autowired
    FileService fileService;

    @RequestMapping("/file")
    public String file() {
        return "file";
    }

    @ResponseBody
    @PostMapping("/upload")
    public String upload(@RequestParam("icon") MultipartFile file) throws Exception {
        String filename = fileService.store(file);
        return filename;
    }

}
