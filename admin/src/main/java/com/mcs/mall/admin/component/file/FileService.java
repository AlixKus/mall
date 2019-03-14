package com.mcs.mall.admin.component.file;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String store(MultipartFile file) throws Exception;
}
