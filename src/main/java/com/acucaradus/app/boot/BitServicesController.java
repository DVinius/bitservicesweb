package com.acucaradus.app.boot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitservices.app.dao.FaucetDAO;
import com.bitservices.app.dao.MobileRechargeDAO;
import com.bitservices.app.dao.NewsDAO;
import com.bitservices.app.dao.PromoDAO;
import com.bitservices.app.dao.UberGiftDAO;
import com.bitservices.app.enums.FaucetType;
import com.bitservices.app.models.Faucet;
import com.bitservices.app.models.News;
import com.bitservices.app.models.PhoneRecharge;
import com.bitservices.app.models.PromoCode;
import com.bitservices.app.models.UberGift;
import com.bitservices.app.models.User;
import com.bitservices.app.models.Wallet;

@Controller
public class BitServicesController extends TextLanguageController{
	
	@Autowired 
	private FaucetDAO faucetDAO;
	@Autowired 
	private MobileRechargeDAO mobileRechargeDAO;
	@Autowired 
	private NewsDAO newsDAO;
	@Autowired 
	private PromoDAO promoDAO;
	@Autowired
	private UberGiftDAO uberGiftDAO;
	
	@RequestMapping("/bitservices")
	public ModelAndView bitServices(final Locale locale){
		final ModelAndView model = new ModelAndView("bitservices/home");
		loadCommonTexts(locale, model);
		
		final List<Faucet> servicesList = this.faucetDAO.getAllActivesByType(locale, FaucetType.SERVICE);
		model.addObject("servicesList", servicesList);
		/*	
		final List<Faucet> adsList = this.faucetDAO.getAllActivesByType(locale, FaucetType.ADVERTISE);
		model.addObject("adsList", adsList);
		*/
		
		final String[] pageTexts = new String[] {"servicesDefinition"};
		loadTexts(pageTexts, model, locale);
		
		final String displayCountry = locale.getDisplayCountry();
		model.addObject("displayCountry", displayCountry);
		
		final String[] texts = new String[] {"servicesunavailable"};
		loadTexts(texts, model, locale);
		
		return model;
	}
	
	@RequestMapping("/news")
	public ModelAndView onShowNews(final Locale locale){
		final ModelAndView model = new ModelAndView("bitservices/news");
		loadCommonTexts(locale, model);
		
		//load news from DAO
		final List<News> latestNews = this.newsDAO.getLatestNews();
		model.addObject("latestNews", latestNews);
		
		final List<News> burningNews = null;
		model.addObject("burningNews", burningNews);
		
		loadTexts(new String[] {"original","newsIntro", "news", "donotpress"}, model, locale);
		
		return model;
	}
	
	@RequestMapping("/wallets")
	public ModelAndView onShowWallets(final Locale locale){
		final ModelAndView model = new ModelAndView("bitservices/wallets");
		loadCommonTexts(locale, model);
		
		final List<Wallet> walletsList = this.faucetDAO.getAllActiveWallets(locale);
		model.addObject("walletsList", walletsList);
		
		loadText("walletDefinition", model, locale);
		
		return model;
	}

	@RequestMapping("/ptc")
	public ModelAndView onShowPayToClick(final Locale locale){
		final ModelAndView model = new ModelAndView("bitservices/ptc");
		loadCommonTexts(locale, model);
		
		final List<Faucet> ptcSites = this.faucetDAO.getAllActivesByType(locale, FaucetType.PTC_SITE);
		model.addObject("ptcSites", ptcSites);
		
		loadText("ptcDefinition", model, locale);
		
		return model;
	}
	
	@RequestMapping("/apps")
	public ModelAndView onShowAndroidApps(final Locale locale){
		final ModelAndView model = new ModelAndView("bitservices/apps");
		loadCommonTexts(locale, model);
		
		final List<Faucet> androidApps = this.faucetDAO.getAllActivesByType(locale, FaucetType.ANDROID_APP);
		model.addObject("androidApps", androidApps); 	
		
		final String[] texts = new String[] {"androidAppDefinition"};
		loadTexts(texts, model, locale);
		
		return model;
	}
	
	@RequestMapping("/faucets")
	public ModelAndView onShowFaucets(final Locale locale){
		final ModelAndView model = new ModelAndView("bitservices/faucets");
		loadCommonTexts(locale, model);
		
		final List<Faucet> faucetsSite = this.faucetDAO.getAllActivesByType(locale, FaucetType.FAUCET_SITE);
		model.addObject("faucets", faucetsSite);		
		
		final String[] texts = new String[] {"faucetDefinition","help","exit","servicesunavailable","name", "description","services","checkongoplay","reportbug","sitepresentation","faucetsubtitle","paybeer", "wallets", "ptc", "ads", "promote"};
		loadTexts(texts, model, locale);
		
		return model;
	}
	
	@RequestMapping("/promote")
	public ModelAndView promote(Device device, final Locale locale){
		return underConstruction(locale);
	}
	
	@RequestMapping("/reportbug")
	public ModelAndView reportbug(Device device, final Locale locale){
		return underConstruction(locale);
	} 
	
	@RequestMapping("/paybeer")
	public ModelAndView payMeABeer(Device device, final Locale locale){
		return underConstruction(locale);
	}
	
	@RequestMapping("/help")
	public ModelAndView onShowHelp(final Locale locale){
		final ModelAndView mv = new ModelAndView("bitservices/help");
		loadCommonTexts(locale, mv);
		loadTexts(new String[] {"helpText"}, mv, locale);
		return mv;
	}
	
	public ModelAndView underConstruction(final Locale locale) {
		final ModelAndView mv = new ModelAndView("bitservices/underConstruction");
		loadCommonTexts(locale, mv);
		final String[] texts = new String[] {"ads","underConstructionText"};
		loadTexts(texts, mv, locale);
		
		return mv;
	}
	
	@RequestMapping("/phonerecharge")
	public ModelAndView onPhoneRecharge(final Locale locale, @ModelAttribute PhoneRecharge phoneRecharge){
		System.out.println("phoneRecharge");
		final ModelAndView mv = new ModelAndView("bitservices/phonerecharge");
		loadCommonTexts(locale, mv);
		
		final String[] texts = new String[] {"inputValidationPhone","sorry","recErrorMessage","rechargeValue","selectOption","mobileProvider","phoneNumber","name","fillFormRecharge"};
		loadTexts(texts, mv, locale);
		
		final User user = phoneRecharge.getUser();
		final Integer rechargeValue = phoneRecharge.getValue();
		
		if (user != null && rechargeValue != null) {
			final String phoneNumber = user.getMobilePhoneNumber();
			if (phoneNumber == null) {
				return mv;
			}
			try {
				final String calcServiceUrl = String.format("http://localhost:8081/getMobileRech?rechargeValue=%s&phoneNumber=%s", rechargeValue, phoneNumber);
				final URL url = new URL(calcServiceUrl);
				final HttpURLConnection con = (HttpURLConnection) url.openConnection();
				final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				final StringBuffer content = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					content.append(inputLine);
				}
				final JSONObject result = new JSONObject(content.toString());//(JsonObject) jsonParser.parse(content.toString());
				System.out.println(result);
				
				final String walletAddress = result.getString("bitWalletAddress");
				final String wName = "Coinbase";
				final String valueToDeposit = new BigDecimal(result.getDouble("valueToDeposit")).setScale(8, RoundingMode.CEILING).toPlainString();
				final Wallet walletToDeposit = new Wallet(0, wName, null, null, walletAddress);
				phoneRecharge.setWallet(walletToDeposit);	
				phoneRecharge.setValueToDeposit(valueToDeposit);
				 
				in.close(); 
				con.disconnect();
				
				final boolean saveResult = mobileRechargeDAO.registerRecharge(phoneRecharge);
				System.out.println(saveResult);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				mv.addObject("showError", true);
			}
		} else {
			System.out.println("phone number or recharge value is null!");
		}
		
		return mv; 
	}
	
	@RequestMapping("/ubergift")
	public ModelAndView onShowUberGift(final Locale locale, @ModelAttribute UberGift uberGift, @RequestParam(value="promocode", required=false) String promocode){
		final ModelAndView model = new ModelAndView("bitservices/ubergift");
		loadCommonTexts(locale, model);
		final String[] uberPageTexts = new String[] {"promocodeOptional","invalidField","value","fillFormUberGift","firstName", "lastName", "phoneNumber"};
		loadTexts(uberPageTexts, model, locale);

		if (promocode != null && !"".equalsIgnoreCase(promocode)) {
			final PromoCode promoObj = this.promoDAO.findByCode(promocode);
			if (promoObj != null && !promoObj.isActive()) {
				final String oops = super.getTextByKey(locale, "oops");
				final String promoCodeNotActive = super.getTextByKey(locale, "invalidPromoCode");

				model.addObject("showError", true);
				model.addObject("uberGiftError", String.format(oops, promoCodeNotActive));
				return model;
			}
			final Boolean canConsume = promoObj.getAmount() > promoObj.getUsed();
			if (canConsume) {
				final Date usedDate = this.promoDAO.checkIfAlreadyUsed(uberGift.getUser(), promocode);
				if (usedDate != null) {
					System.out.println(String.format("code %s already used by this user: &%s", promocode, uberGift.getUser().getId() ));
					final String oops = super.getTextByKey(locale, "oops");
					final String promoCodeNotActive = super.getTextByKey(locale, "alreadyUsedCode");

					model.addObject("showError", true);
					model.addObject("uberGiftError", String.format(oops, promoCodeNotActive));
					return model;
				} else {
					final Date successUsedDate = this.promoDAO.useCode(uberGift.getUser(), promoObj);
					if (successUsedDate != null) {
						loadText("successPromo", model, locale);
						return model;
					}
				}
			} else {
				System.out.println("cannot consume this code: "+promocode);
			}
		}
		//normal flow
		if (uberGift.getUser() != null && !calculateValueToDeposit(uberGift)) {
			model.addObject("showError", true);
			final String oops = super.getTextByKey(locale, "oops");
			final String promoCodeNotActive = super.getTextByKey(locale, "errorText");
			model.addObject("uberGiftError", String.format(oops, promoCodeNotActive));
		}
		
		return model;
	}
	
	protected boolean calculateValueToDeposit(final UberGift uberGift) {
		try {
			final String calcServiceUrl = String.format("http://localhost:8081/getMobileRech?rechargeValue=%s&phoneNumber=%s", uberGift.getValue(), null);
			final URL url = new URL(calcServiceUrl);
			final HttpURLConnection con = (HttpURLConnection) url.openConnection();
			final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			final StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			final JSONObject result = new JSONObject(content.toString());//(JsonObject) jsonParser.parse(content.toString());
			System.out.println(result);
			
			final String walletAddress = result.getString("bitWalletAddress");
			final String wName = "Coinbase";
			final String valueToDeposit = new BigDecimal(result.getDouble("valueToDeposit")).setScale(8, RoundingMode.CEILING).toPlainString();
			final Wallet walletToDeposit = new Wallet(0, wName, null, null, walletAddress);
			uberGift.setWallet(walletToDeposit);	
			uberGift.setValueToDeposit(valueToDeposit);
			
			final int affectedRows = this.uberGiftDAO.createUberGift(uberGift);
			if (affectedRows == 1) {
				System.out.println("uber gift registered");
			} else {
				System.out.println("uber gift NOT registered");
			}
			 
			in.close(); 
			con.disconnect();
			return true;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@RequestMapping("/article")
	public ModelAndView onShowArticle(@RequestParam String nid, final Locale locale){
		System.out.println("nid: "+nid);
		final ModelAndView mv = new ModelAndView("bitservices/article");
		loadCommonTexts(locale, mv);
		final String[] uberPageTexts = new String[] {"original", "submit"};
		loadTexts(uberPageTexts, mv, locale);
		
		final News newsItem = this.newsDAO.findById(nid);
		mv.addObject("newsItem", newsItem);

		return mv;
	}
	 
}
