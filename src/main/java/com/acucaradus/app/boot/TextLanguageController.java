package com.acucaradus.app.boot;

import java.util.Locale;

import org.springframework.web.servlet.ModelAndView;

import com.bitservices.app.utils.LanguageUtils;

public class TextLanguageController {
	protected Locale ptLocale = new Locale("pt");
	private String[] commonTexts = new String[] {"errorText","news", "help", "exit","description","services","reportbug","paybeer", "wallets", "ptc", "ads", "promote"};

	protected void loadText(final String key, final ModelAndView mv, final Locale locale) {
		LanguageUtils.getInstance().loadText(mv, key, locale);
	}
	
	protected void loadTexts(final String[] keys, final ModelAndView mv, final Locale locale) {
		for (String key: keys) {
			loadText(key, mv, locale);
		}
	}
	
	protected String getTextByKey(final Locale locale, final String key) {
		return LanguageUtils.getInstance().getTextByKey(key, locale);
	}
	
	protected void loadCommonTexts(final Locale locale, final ModelAndView mv) {
		for (String key: commonTexts) {
			loadText(key, mv, locale);
		}
	}
	
}
