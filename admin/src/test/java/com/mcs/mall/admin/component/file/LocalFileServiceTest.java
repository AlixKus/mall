package com.mcs.mall.admin.component.file;

import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Paths;

public class LocalFileServiceTest {

    @Test
    public void store() throws Exception {
        InputStream inputStream = new FileInputStream(Paths.get("F:", "c.jpg").toFile());
        MockMultipartFile mockMultipartFile = new MockMultipartFile("c.jpg", "c.jpg", null, inputStream);
        FileService fileService = new LocalFileService();
        fileService.store(mockMultipartFile);
    }
}