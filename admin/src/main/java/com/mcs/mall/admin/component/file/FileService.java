package com.mcs.mall.admin.component.file;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileService {
    String store(MultipartFile file) throws Exception;

    Stream<Path> loadAll() throws Exception;
}
