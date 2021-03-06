package com.mcs.mall.admin.controller.rest;

import com.mcs.mall.admin.component.file.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.stream.Collectors;

@Controller
public class FileAPI {
    @Autowired
    FileService fileService;

    @GetMapping("/file")
    public String file(Model model) throws Exception {
        model.addAttribute("files", fileService.loadAll().map(
                path -> "/img/" + path.getFileName())
                .collect(Collectors.toList()));
        return "file";
    }

    @ResponseBody
    @PostMapping("/upload")
    public String upload(@RequestParam("img") MultipartFile file) throws Exception {
        String filename = fileService.store(file);
        return filename;
    }

}
