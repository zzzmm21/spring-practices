package com.bitacademy.fileupload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	
	@RequestMapping("/form")
	public String form() {
		return "/WEB-INF/views/form.jsp";
	}
	@RequestMapping("/upload")
	public String upload(
			@RequestParam("email") String email,
			@RequestParam("file") MultipartFile multipartfile) {
		
		return "/WEB-INF/views/result.jsp";
	}
}
