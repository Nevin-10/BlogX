package com.example.__spring_security.DAO;

import com.example.__spring_security.entity.Blog;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BlogDAOImpl implements BlogDAO {

    private final EntityManager em;
    public BlogDAOImpl(EntityManager em) {
        this.em = em;
    }


    @Override
    @Transactional
    public void save(Blog blog) {
        em.persist(blog);
    }

    @Override
    public Blog getBlog(int id) {
        Blog blog = em.find(Blog.class, id);
        return blog;

    }

    @Override
    public List<Blog> getAll() {
        List<Blog> blogs = em.createQuery("from blog", Blog.class).getResultList();
        return blogs;
    }

    @Override
    public void delete(int id) {
        Blog blog = em.find(Blog.class, id);
        em.remove(blog);

    }

    @Override
    public void update(Blog blog) {
        em.merge(blog);

    }
}
