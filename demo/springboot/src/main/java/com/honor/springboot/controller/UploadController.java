package com.honor.springboot.controller;

import com.honor.springboot.exception.UploadImageTooManyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.context.annotation.Conditional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

/**
 * com.honor.springboot.controller
 *
 * @author honor-ljp
 * 2023/1/4 12:16
 */
@RestController
@Slf4j
public class UploadController {
    @RequestMapping("/upload")
    public void multiUpload(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "singleFile", required = false) MultipartFile singleFile,
                            @RequestParam(value = "multiFile", required = false) MultipartFile[] multiFile) throws IOException {
        if (multiFile.length > 1) {
            throw new UploadImageTooManyException();
        }
        log.info("upload参数：{}-{}-{}", name, singleFile.getOriginalFilename(), multiFile.length);
        File file = new File("F:\\Java\\project\\demo\\image\\" + singleFile.getOriginalFilename());
        singleFile.transferTo(file);
        for (MultipartFile multipartFile : multiFile) {
            File file1 = new File("F:\\Java\\project\\demo\\image\\" + multipartFile.getOriginalFilename());
            multipartFile.transferTo(file1);
        }
    }
}
