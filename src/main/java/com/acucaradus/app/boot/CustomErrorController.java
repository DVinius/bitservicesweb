package com.acucaradus.app.boot;

import java.util.Locale;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomErrorController extends TextLanguageController implements ErrorController{

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public ModelAndView error() {
    	System.err.println("Error!");    
    	final ModelAndView mv = new ModelAndView("bitservices/errorPage");
    	loadCommonTexts(new Locale("en"), mv);
        return mv;
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}