package com.example.__spring_security.entity;


import jakarta.persistence.*;

@Entity(name="blog")
public class Blog {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    @Column(name="id")
    private int id;

    @Column(name="entry")
    private String entry;

    public Blog() {
    }

    public Blog(String entry) {
        this.entry = entry;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", entry='" + entry + '\'' +
                '}';
    }
}
