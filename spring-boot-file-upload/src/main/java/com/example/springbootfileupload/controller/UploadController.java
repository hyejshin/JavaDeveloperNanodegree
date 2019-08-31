package com.example.springbootfileupload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UploadController {
    Map<String, Object> result = new HashMap<>();
    /// Receive message
    @RequestMapping("/uploadFile")
    public String  uploadFile(@RequestParam("attach") MultipartFile file) throws IOException {
        // File info
        System.out.println("File name = "  + file.getOriginalFilename());
        System.out.println("File type = " + file.getContentType());

        // Save to disk
        // file path example 1) Windows c:/, 3) Mac ~/Documents/
        String filePath = "C:/Users/shins/Documents/";
        System.out.println(filePath + file.getOriginalFilename());
        file.transferTo(new File(filePath + file.getOriginalFilename()));
        result.put("Success", true);
        return "success";
    }

}
