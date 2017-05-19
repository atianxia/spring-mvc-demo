package com.qihoo.study;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.thrift.TException;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.qihoo.study.thrift.Calculator;

/**
 * Handles requests for the application home page.
 */
@Controller
@CrossOrigin
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
		ServletRequestAttributes attributes = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes());
		HttpServletRequest request = attributes.getRequest();
		Cookie[] cookies =  request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getName());
				System.out.println(cookie.getValue());
			}
		}
		HttpServletResponse response = attributes.getResponse();
		System.out.println("++++++++++++++++++++++++===");
//		response.addCookie(new Cookie("userId", "123"));
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
	@ResponseBody
	public SearchResponse get(Locale locale, Model model) throws TException, UnknownHostException {
		TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
				.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
//				.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("host2"), 9300));

		SearchResponse response = client.prepareSearch("index1", "index2")
				.setTypes("type1", "type2")
				.setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
				.setQuery(QueryBuilders.termQuery("multi", "test"))                 // Query
				.setPostFilter(QueryBuilders.rangeQuery("age").from(12).to(18))     // Filter
				.setFrom(0).setSize(60).setExplain(true)
				.get();
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
//		System.out.println("*********get attribute************" + request.getSession().getAttribute("test") + " sessionId****" + request.getSession().getId());
		return response;
	}

	@RequestMapping(value = "/json", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public Map<String, String> get() throws TException {
		Map<String, String> map = new HashMap<>();
		map.put("name", "1111");
		map.put("desc", "dfds");
		return map;
	}
	
}
