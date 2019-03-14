package com.mcs.mall.admin.component.file;

import com.mcs.mall.admin.config.UploadProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

@Service
public class LocalFileService implements FileService {

    private String rootLocation;

    @Autowired
    public LocalFileService(UploadProperty uploadProperty) {
        rootLocation = uploadProperty.getIMG_PATH();
    }

    @Override
    public String store(MultipartFile file) throws Exception {
        byte[] fileContent = file.getBytes();
        String fileName = genFileName(DigestUtils.md5DigestAsHex(fileContent), fileType(file.getOriginalFilename()));
        Files.write(Paths.get(rootLocation, fileName), fileContent, StandardOpenOption.CREATE);
        return fileName;
    }

    @Override
    public Stream<Path> loadAll() throws Exception {
        Path rootPath = Paths.get(this.rootLocation);
        return Files.walk(rootPath, 1)
                .filter(path -> !path.equals(rootPath))
                .map(rootPath::relativize);
    }

    public static String genFileName(String fileName, String fileType) {
        StringBuffer sb = new StringBuffer();
        sb.append(fileName);
        sb.append(".");
        sb.append(fileType);
        return sb.toString();
    }

    public static String fileType(String fileName) {
        String[] strArray = fileName.split("\\.");
        int suffixIndex = strArray.length - 1;
        return strArray[suffixIndex];
    }

    public static void main(String[] args) {
        System.out.println(genFileName("123", "jpg"));
    }
}
