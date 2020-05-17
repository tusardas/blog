package com.heytusar.blog.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.heytusar.blog.service.BlogService;
import com.heytusar.blog.domain.Blog;

@Controller
public class BlogController {
	
	private static final Logger log = LoggerFactory.getLogger(BlogController.class);
	
	@Autowired 
	private BlogService blogService;
	
	@RequestMapping("/")
	public String index(Model model
			, HttpServletRequest request) {
		
		String title = "Recent Posts";
		model.addAttribute("title", title);
		model.addAttribute("blogList", this.blogService.findAll());
		
		String successMsg = request.getParameter("successMsg");
		model.addAttribute("successMsg", successMsg);
		return "blogListing";
	}
	
	@RequestMapping("/newBlog")
	public String createBlog(Model model) {
		String title = "Create Blog";
		model.addAttribute("title", title);
		return "createBlog";
	}
	
	@RequestMapping(value = "/blog", method = RequestMethod.POST)
	public ResponseEntity<Object> createBlog(
			@RequestParam("headLine") String headLine
			,@RequestParam("content") String content
			,@RequestParam("blogCategory") String blogCategory
			,@RequestParam("author") String author
			) {
		Map<String, String> args = new HashMap<String, String>();
		args.put("headLine", headLine);
		args.put("content", content);
		args.put("blogCategory", blogCategory);
		args.put("author", author);
		Object result = blogService.createBlog(args);
		return new ResponseEntity<Object>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/blog/{id}", method = RequestMethod.GET)
	public String getBlog(@PathVariable("id") Long id, Model model) {
		Object result = blogService.getBlog(id);
		model.addAttribute("result", result);
		model.addAttribute("title", "Update Blog");
		return "createBlog";
	}
	
	@RequestMapping(value = "/updateBlog/{id}", method = RequestMethod.POST)
	public ModelAndView updateBlog(
			@PathVariable("id") Long id
			,@RequestParam("headLine") String headLine
			,@RequestParam("content") String content
			,@RequestParam("blogCategory") String blogCategory
			,@RequestParam("author") String author
			//,RedirectAttributes redirectAttributes
			,ModelMap modelMap) {
		Map<String, String> args = new HashMap<String, String>();
		args.put("headLine", headLine);
		args.put("content", content);
		args.put("blogCategory", blogCategory);
		args.put("author", author);
		Object result = blogService.updateBlog(id, args);
		
		log.info("updateBlog result -----> " + result);
		//return new ResponseEntity<Object>(result, HttpStatus.OK);
		//redirectAttributes.addAttribute("successMsg", "Blog updated successfully!");
		//return new ModelAndView("redirect:/");
		
		modelMap.addAttribute("successMsg", "Blog updated successfully!");
		return new ModelAndView("redirect:/", modelMap);
	}
}
