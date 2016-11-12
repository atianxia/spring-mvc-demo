package com.qihoo.study;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.qihoo.study.thrift.Calculator;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

//	@Resource
//	private Calculator.Iface calculator;

	@Resource
	private TestJson testJson;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws TException {
		
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		request.getSession().setAttribute("test", "test1");
		System.out.println("*********set attribute************sessionId****" + request.getSession().getId());
//		logger.info("Welcome home! The client locale is {}.", locale);
////		int result = this.calculator.add(1, 2);
////		System.out.println(result + "-----------------------------");
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		model.addAttribute("serverTime", formattedDate );
//		System.out.println("*********************" + testJson.getJobService());
		return "home";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String get(Locale locale, Model model) throws TException {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		System.out.println("*********get attribute************" + request.getSession().getAttribute("test") + " sessionId****" + request.getSession().getId());
		return "home";
	}
	
}
