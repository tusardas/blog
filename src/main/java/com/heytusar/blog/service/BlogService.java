package com.heytusar.blog.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heytusar.blog.dao.BlogDAO;
import com.heytusar.blog.domain.Blog;

@Service
@Transactional
public class BlogService {
	
	private BlogDAO blogDAO;
	
    @Autowired
    public BlogService(BlogDAO blogDAO) {
        this.blogDAO = blogDAO;
    }
	
	public List<Blog> findAll() {
		 return this.blogDAO.findAll();
	}
	
	public Object createBlog(Object args) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", "failed");
		Blog blog = this.blogDAO.createBlog(args);
		if(blog != null) {
			result.put("status", "ok");
			result.put("blog", blog);
		}
		else {
			result.put("errMsg", "Could not save new blog");
		}
		return result;
	}
	
	public Object getBlog(Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", "failed");
		Blog blog = this.blogDAO.findById(id);
		if(blog != null) {
			result.put("status", "ok");
			result.put("blog", blog);
		}
		else {
			result.put("errMsg", "Could not find blog");
		}
		return result;
	}

	public Object updateBlog(Long id, Map<String, String> args) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", "failed");
		Blog blog = this.blogDAO.updateBlog(id, args);
		if(blog != null) {
			result.put("status", "ok");
			result.put("blog", blog);
		}
		else {
			result.put("errMsg", "Could not update blog");
		}
		return result;
	}
}
