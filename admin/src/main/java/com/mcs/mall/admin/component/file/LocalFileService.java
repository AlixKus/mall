package com.mcs.mall.admin.component.file;

import com.mcs.mall.admin.config.UploadProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Service
public class LocalFileService implements FileService {
    public static final String TYPE_JPG = "jpg";
    public static final String TYPE_GIF = "gif";
    public static final String TYPE_PNG = "png";
    public static final String TYPE_BMP = "bmp";


    @Autowired
    UploadProperty uploadProperty;

    @Override
    public String store(MultipartFile file) throws Exception {
        byte[] fileContent = file.getBytes();
        String fileName = genFileName(DigestUtils.md5DigestAsHex(fileContent), imgType(file.getOriginalFilename()));
        String rootLocation = "F:\\upload/img/";//uploadProperty.getIMG_PATH();
        Files.write(Paths.get(rootLocation, fileName), fileContent, StandardOpenOption.CREATE);
        return fileName;
    }

    public static String genFileName(String fileName, String fileType) {
        StringBuffer sb = new StringBuffer();
        sb.append(fileName);
        sb.append(".");
        sb.append(fileType);
        return sb.toString();
    }

    public static String imgType(String fileName) {
        String[] strArray = fileName.split("\\.");
        int suffixIndex = strArray.length - 1;
        return strArray[suffixIndex];
    }

    private boolean checkImg(String fileType) {
        return true;
    }

    public static void main(String[] args) {
        System.out.println(genFileName("123", "jpg"));
    }
}
