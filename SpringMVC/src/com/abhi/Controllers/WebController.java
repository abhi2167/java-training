package com.abhi.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.SpringJDBC.NewsService.NewsService;
import com.abhi.News.*;

@Controller
public class WebController {
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView myMVCPage1() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("first");
		return mav;
	}
	
	@RequestMapping(value="/second",method=RequestMethod.GET)
	public ModelAndView myMVCPage2() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("second");
		mav.addObject("message", "First Project On Spring MVC");
		mav.addObject("text", "spring mvc object 2");
		return mav;
		
	}
	
	@RequestMapping(value="/third",method=RequestMethod.GET)
	public ModelAndView myMVCPage3() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("third");
		News n = new News(System.currentTimeMillis(), "Facebook is becoming popular", "facebook", "SocialMedia");
		mav.addObject("mynews", n);
		return mav;
	}

	@RequestMapping(value="/fourth",method=RequestMethod.GET)
	public ModelAndView myMVCPage4() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("fourth");
		
		List<News> allnews = new ArrayList<News>();
		News n1 = new News(System.currentTimeMillis(), "Facebook is becoming popular", 
				"facebook", "SocialMedia");
		
		News n2 = new News(System.currentTimeMillis(), "Twiter is becoming popular", 
				"facebook", "SocialMedia");
		
		News n3 = new News(System.currentTimeMillis(), "Google Plus  is becoming popular", 
				"facebook", "SocialMedia");
		allnews.add(n1);
		allnews.add(n2);
		allnews.add(n3);
		mav.addObject("newsList", allnews);
		return mav;
	}
	
	@RequestMapping(value="/fifth",method=RequestMethod.GET)
	public ModelAndView myMVCPage5(@RequestParam("q") Long q, @RequestParam("y") String y) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("third");
		News n = new News(q, "Facebook is becoming popular", "facebook", y);
		
		//  
		mav.addObject("mynews", n);
		return mav;
	} //?q=technical & 

	@RequestMapping(value="/six/{q}/{y}",method=RequestMethod.GET)
	public ModelAndView myMVCPage6(@PathVariable("q") Long q, @PathVariable("y") String y) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("third");
		News n = new News(q, "Facebook is becoming popular", "facebook", y);		  
		mav.addObject("mynews", n);
		return mav;
	}
	
	@RequestMapping(value="/seven",method=RequestMethod.GET)
	public ModelAndView myMVCPage7() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("seven");
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		NewsService service = (NewsService) context.getBean("newsService");
		List<com.SpringJDBC.Domain.News> news=service.getAllNews();
		mav.addObject("newsList", news);
		return mav;
	}
	
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public ModelAndView getForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("form");
		News n = new News();
		mav.addObject("news", n);
		
		return mav;
	}
	
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public ModelAndView getFormEdit(@RequestParam("id") Long id) {
		System.out.println(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("form");
		News n = new News(id,"apple","iphone","technology");
		mav.addObject("news", n);
		
		return mav;
	}
	
	@RequestMapping(value="/form",method=RequestMethod.POST)
	public ModelAndView getFormWithData(@ModelAttribute("news")News news) {
		
		System.out.println(news);
		ModelAndView mav = new ModelAndView();
		//mav.setViewName("/WEB-INF/pages/formWithData.jsp");		
		mav.setViewName("formWithData");
		mav.addObject("news", news);		
		return mav;
	}
}
