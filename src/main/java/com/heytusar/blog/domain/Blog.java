package com.heytusar.blog.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="blog")
@NamedQueries({
	@NamedQuery(
        name = "findBlogById",
        query = "from Blog b where b.id = :id"
        ),
    @NamedQuery(
        name = "findBlogByAuthor",
        query = "from Blog b where b.author = :author"
        ),
    @NamedQuery(
        name = "findBlogByBlogCategory",
        query = "from Blog b where b.blogCategory = :blogCategory"
        ),
    @NamedQuery(
        name = "findAllBlog",
        query = "from Blog b"
        ),
})
public class Blog {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id; 
    @Column(name = "blogCategory") private String blogCategory;
    @Column(name = "headLine") private String headLine;
    @Column(name = "content") private String content;
    @Column(name = "publishedOn") private Date publishedOn;
    @Column(name = "author") private String author;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBlogCategory() {
		return blogCategory;
	}
	public void setBlogCategory(String blogCategory) {
		this.blogCategory = blogCategory;
	}
	public String getHeadLine() {
		return headLine;
	}
	public void setHeadLine(String headLine) {
		this.headLine = headLine;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPublishedOn() {
		return publishedOn;
	}
	public void setPublishedOn(Date publishedOn) {
		this.publishedOn = publishedOn;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
