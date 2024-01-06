package com.example.mpdemo2.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Transactional
@RestController
public class FileUploadController {
    @PostMapping(value="/up")
    public String up(String nickname, MultipartFile photo, HttpServletRequest request) throws IOException {
        System.out.println("nick"+nickname);
        System.out.println(photo.getOriginalFilename());
        System.out.println(photo.getContentType());
        String path=request.getServletContext().getRealPath(("/upload/"));
        System.out.println(path);
        saveFile(photo,nickname);
        return "upload success";
    }

    public void saveFile(MultipartFile photo,String path) throws IOException {
        File dir=new File(path);
        if(!dir.exists()){
            dir.mkdir();
        }
        File file=new File("D:\\code_tools\\ghc-9.2.8-x86_64-unknown-mingw32\\mpdemo2\\src\\main\\resources\\static\\img\\"+photo.getOriginalFilename());
        photo.transferTo(file);
    }
}
