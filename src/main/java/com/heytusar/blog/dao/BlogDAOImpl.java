package com.heytusar.blog.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.heytusar.blog.domain.Blog;

@Repository
public class BlogDAOImpl implements BlogDAO {
	
	final static Logger logger = LoggerFactory.getLogger(BlogDAOImpl.class);
    private SessionFactory sessionFactory;
    
    @Autowired
    public BlogDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public Blog findById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Blog> query = session.getNamedQuery("findBlogById");  
        query.setParameter("id", id);
        Blog blog = query.getSingleResult();
        return blog;
	}

	public List<Blog> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Blog> query = session.getNamedQuery("findAllBlog");  
        List<Blog> blogList = query.getResultList();
        return blogList;
	}
	
	public Blog createBlog(Object args) {
		Blog blog = null;
		Map<String, String> argsMap = (Map<String, String>) args;
		try {
			String author = argsMap.get("author");
			Date publishedOn = new Date();
			String blogCategory = argsMap.get("blogCategory");
			String headLine = argsMap.get("headLine");
			String content = argsMap.get("content");
			
			blog = new Blog();
			blog.setAuthor(author);
			blog.setBlogCategory(blogCategory);
			blog.setPublishedOn(publishedOn);
			blog.setHeadLine(headLine);
			blog.setContent(content);
			
			Session sessionOne = this.sessionFactory.openSession();
			sessionOne.beginTransaction();
			 
			/* saving the blog object here */
			sessionOne.saveOrUpdate(blog);
			sessionOne.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return blog;
	}

	public Blog updateBlog(Long id, Object args) {
		Blog blog = findById(id);
		Map<String, String> argsMap = (Map<String, String>) args;
		try {
			String author = argsMap.get("author");
			//Date publishedOn = new Date();
			String blogCategory = argsMap.get("blogCategory");
			String headLine = argsMap.get("headLine");
			String content = argsMap.get("content");
			
			blog.setAuthor(author);
			blog.setBlogCategory(blogCategory);
			blog.setHeadLine(headLine);
			blog.setContent(content);
			
			Session sessionOne = this.sessionFactory.openSession();
			sessionOne.beginTransaction();
			 
			/* saving the blog object here */
			sessionOne.saveOrUpdate(blog);
			sessionOne.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return blog;
	}
}
