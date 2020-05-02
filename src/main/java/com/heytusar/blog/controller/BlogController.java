package com.heytusar.blog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.heytusar.blog.service.BlogService;
import com.heytusar.blog.domain.Blog;

@Controller
public class BlogController {
	
	private static final Logger log = LoggerFactory.getLogger(BlogController.class);
	
	@Autowired 
	private BlogService blogService;
	
	@RequestMapping("/")
	public String index(Model model) {
		log.error("Testing logs----------------->");
		
		String title = "Recent Posts";
		model.addAttribute("title", title);
		
		//Blog blog = this.blogService.findById(1);
		//model.addAttribute("blog", blog);
		//throw new RuntimeException("aaa");
		
		model.addAttribute("blogList", this.blogService.findAll());
		
		return "blogListing";
	}
}
