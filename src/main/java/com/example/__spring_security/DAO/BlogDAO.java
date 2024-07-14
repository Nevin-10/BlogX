package com.example.__spring_security.DAO;

import com.example.__spring_security.entity.Blog;

import java.util.List;

public interface BlogDAO {
    void save(Blog blog);
    Blog getBlog(int id);

    List<Blog> getAll();
    void delete(int id);
    void update(Blog blog);
}
