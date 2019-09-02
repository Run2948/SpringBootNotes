package com.borun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class TestController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadFile(MultipartFile fileInput, HttpServletRequest request) {
        logger.debug("单文件上传");

        // 创建文件在服务器端的存放路径
        String dir = request.getServletContext().getRealPath("/upload");
        File fileDir = new File(dir);
        if (!fileDir.exists())
            fileDir.mkdirs();

        // 生成文件在服务器端存放的名字
        String fileSuffix = fileInput.getOriginalFilename().substring(fileInput.getOriginalFilename().lastIndexOf("."));
        String fileName = UUID.randomUUID().toString() + fileSuffix;

        // 上传
        String filePath = fileDir + "/" + fileName;
        try {
            fileInput.transferTo(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return filePath;
    }

    @RequestMapping("/index")
    public String toUpload() {
        return "upload";
    }

    @RequestMapping("/index/batch")
    public String toMultiUpload() {
        return "uploads";
    }

    @ResponseBody
    @RequestMapping(value = "/upload/batch", method = RequestMethod.POST)
    public List<String> uploadFiles(MultipartFile[] fileInput, HttpServletRequest request) {
        logger.debug("多文件上传");

        // 创建文件在服务器端的存放路径
        String dir = request.getServletContext().getRealPath("/upload");
        File fileDir = new File(dir);
        if (!fileDir.exists())
            fileDir.mkdirs();

        List<String> filePaths = new ArrayList<>();

        try {
            for (int i = 0; i < fileInput.length; i++) {
                // 生成文件在服务器端存放的名字
                String fileSuffix =
                        fileInput[i].getOriginalFilename().substring(fileInput[i].getOriginalFilename().lastIndexOf(
                                "."));
                String fileName = UUID.randomUUID().toString() + fileSuffix;
                // 上传
                String filePath = fileDir + "/" + fileName;

                fileInput[i].transferTo(new File(filePath));

                filePaths.add(filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePaths;
    }
}
