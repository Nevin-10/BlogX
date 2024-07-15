package com.example.__spring_security.service;

import com.example.__spring_security.DAO.BlogDAO;
import com.example.__spring_security.entity.Blog;
import org.springframework.stereotype.Service;

import java.util.List;
//CONTROLS ALL THE BUSINESS LOGIC

@Service
public class BlogService {

    private final BlogDAO blogDAO;

    public BlogService(BlogDAO blogDAO) {
        this.blogDAO = blogDAO;
    }

    //Create the blog

    public void createBlog(Blog blog){
        blogDAO.save(blog);

    }

    public Blog getBlog(int id){
        Blog blog=blogDAO.getBlog(id);
        return blog;
    }


    public List<Blog> getAll(){
        List<Blog> blogs=blogDAO.getAll();
        return blogs;
    }

    public void deleteBlog(int id){
        blogDAO.delete(id);
    }

    public void updateBlog(Blog blog){
        blogDAO.update(blog);
    }



    //Get the user

    //Get all Users



    //Delete users


    //Update users..
}