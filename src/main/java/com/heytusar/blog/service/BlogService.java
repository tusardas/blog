package com.heytusar.blog.service;

import java.util.List;

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
    
	public Blog findById(int id) {
		 return this.blogDAO.findById(id);
	}
	
	public List<Blog> findAll() {
		 return this.blogDAO.findAll();
	}
	
}
