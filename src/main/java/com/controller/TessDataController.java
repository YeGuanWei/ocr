package com.controller;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.net.URL;

/**
 * @author: YeGuanWei
 * @date: 2021/12/07
 */
@RestController
@RequestMapping("/ocr/tessdata")
public class TessDataController {

    /**
     * 图片识别文字
     *
     * @param imgPath 图片路径  C:\Develop\10609092630.png
     */
    public static void identify(@RequestParam(value = "imgPath") String imgPath) {
        File imageFile = new File(imgPath);
        ITesseract instance = new Tesseract();
        // 需要指定训练集
        URL url = ClassLoader.getSystemResource("tessdata");
        String path = url.getPath().substring(1);
        instance.setDatapath(path);
        // 默认是英文（识别字母和数字），如果要识别中文(数字 + 中文），需要制定语言包
        instance.setLanguage("chi_sim");
        try {
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.out.println(e.getMessage());
        }
    }

}
