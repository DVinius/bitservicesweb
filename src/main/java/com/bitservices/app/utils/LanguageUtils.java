package com.bitservices.app.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

import org.springframework.web.servlet.ModelAndView;

public class LanguageUtils {
	private static LanguageUtils instance;
	protected Properties englishProps = new Properties();
	protected Properties portugueseProps = new Properties();
	
	private LanguageUtils() {
		super();
		try {
			
			final ClassLoader loader = Thread.currentThread().getContextClassLoader();
			try(InputStream resourceStream = loader.getResourceAsStream("text-en.properties")) {
				englishProps.load(resourceStream);
			}
			
			try(InputStream resourceStream = loader.getResourceAsStream("text-pt.properties")) {
				portugueseProps.load(resourceStream);
			}

		} catch (IOException io) {
			io.printStackTrace();
		} 
	}
	
	public static LanguageUtils getInstance() {
		if (instance == null) {
			instance = new LanguageUtils();
		}
		return instance;
	}

	public void loadText(final ModelAndView mv, final String key, final Locale locale) {
		String text = null;
		switch (locale.getLanguage()) {
		case "pt":
			text = this.portugueseProps.getProperty(key, "["+key+"]"); break;
		default:
			text = this.englishProps.getProperty(key, "["+key+"]"); 
		}
		mv.addObject(key, text);
	}
	
	public String getTextByKey(final String key, final Locale locale) {
		
		switch (locale.getLanguage()) {
		case "pt":
			return this.portugueseProps.getProperty(key, "["+key+"]"); 
		default:
			return this.englishProps.getProperty(key, "["+key+"]"); 
		}
	}
}
