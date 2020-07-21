package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
    private final static String UPLOADED_FOLDER = "E://temp//";

    @PostMapping("/upload")
    @ResponseBody
    public Object upload(@RequestParam("file") MultipartFile file, HttpServletRequest request){
    	
    	//获取文件名
    	String fileName = file.getOriginalFilename();
    	System.out.println("文件名："+fileName);
    	
    	//获取文件大小
    	long size = file.getSize();
    	System.out.println("文件大小："+size);
    	
    	//获取文件名后缀（.jpg,.png等）
    	String fileNameSuffix = fileName.substring(fileName.lastIndexOf("."));
    	System.out.println("文件名后缀"+fileNameSuffix);
    	
    	//采用UUID字符串替换原来的文件名，避免同名文件冲突
    	fileName = UUID.randomUUID()+fileNameSuffix;
    	System.out.println("转换后文件名："+fileName);
    	
    	File targetFile = new File(UPLOADED_FOLDER+fileName); 
    	
    	try {
			file.transferTo(targetFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	Map<String,Object> result = new LinkedHashMap<String,Object>();
    	result.put("code", "1"); 
    	result.put("mssage", "upload success"); 
    	result.put("savepath", UPLOADED_FOLDER+fileName); 
    	return result;
    }

}