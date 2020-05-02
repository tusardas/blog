package com.heytusar.blog.dao;

import java.util.List;

import com.heytusar.blog.domain.Blog;

public interface BlogDAO {
	Blog findById(int id);
	
	List<Blog> findAll();
}
