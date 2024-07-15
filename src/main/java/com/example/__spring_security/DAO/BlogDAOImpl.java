package com.example.__spring_security.DAO;

import com.example.__spring_security.entity.Blog;
import com.example.__spring_security.exception.ResourceNotFoundException;
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
        return em.find(Blog.class, id);

    }

    @Override
    public List<Blog> getAll() {
        return em.createQuery("from blog", Blog.class).getResultList();
    }

    @Transactional
    @Override
    public void delete(int id) {
        Blog blog = em.find(Blog.class, id);
        if(blog==null)
        {
            throw new ResourceNotFoundException("Blog not found with id: " + id);
        }
        em.remove(blog);

    }
    @Transactional
    @Override
    public void update(Blog blog) {
        em.merge(blog);

    }
}
