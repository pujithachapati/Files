package com.fileupload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileController {
	
	@RequestMapping("/upload-form")
    public String showUploadForm() {
        return "upload-form";
    }

    @RequestMapping("/upload-success")
    public ModelAndView handleFileUpload(@RequestParam("file") MultipartFile file) {
        ModelAndView modelAndView = new ModelAndView("upload-success");
        modelAndView.addObject("message", "File uploaded successfully");
        return modelAndView;
    }

}
