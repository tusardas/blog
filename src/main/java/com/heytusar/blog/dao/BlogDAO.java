package com.heytusar.blog.dao;

import java.util.List;

import com.heytusar.blog.domain.Blog;

public interface BlogDAO {
	Blog findById(Long id);
	
	List<Blog> findAll();
	
	Blog createBlog(Object args);
	
	Blog updateBlog(Long id, Object args);
}
