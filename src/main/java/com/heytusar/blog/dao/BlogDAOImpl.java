package com.heytusar.blog.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
    
    public Blog findById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Blog> query = session.getNamedQuery("findBlogById");  
        query.setParameter("id", id);
        Blog blog = query.getSingleResult();
        return blog;
	}

	public List<Blog> findAll() {
		logger.info("sessionFactory ----> " + sessionFactory);
		Session session = this.sessionFactory.getCurrentSession();
		logger.info("session ------>" + session);
        TypedQuery<Blog> query = session.getNamedQuery("findAllBlog");  
        logger.info("query ------>" + query);
        List<Blog> blogList = query.getResultList();
        return blogList;
	}

}
