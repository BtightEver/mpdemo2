package com.example.mpdemo2.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.util.DigestUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.util.DigestUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Transactional
@RestController
@RequestMapping("/images")
public class ImageController {

    @GetMapping("/{imageName}")
    public ResponseEntity<Resource> getImage(@PathVariable String imageName) {
        System.out.println("执行到了imagecontroller，获得的imageName是"+imageName);
        try {
            String basePath = "D:\\code_tools\\ghc-9.2.8-x86_64-unknown-mingw32\\mpdemo2\\src\\main\\resources\\static\\img\\";  // 修改为你的基础路径
            String imagePath = basePath + imageName;

            // 创建资源对象
            File file = new File(imagePath);
            Resource resource = new FileSystemResource(file);
            // 检查资源是否存在
            if (resource.exists()) {
                // 禁用缓存
                CacheControl cacheControl = CacheControl.noCache().mustRevalidate();
                // 返回图片资源，并设置响应类型为图片类型
                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG)
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}