package com.dolsoft.licensingservice.service;

import com.dolsoft.licensingservice.model.Blog;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class BlogService {

    public Blog getBlog(String blogId, String organizationId) {
        Blog blog = new Blog();
        blog.setId(new Random().nextInt(1000));
        blog.setTitle("My First Blog");
        blog.setContent("This is a test blog content.");
        blog.setCreationDate("2026-10-20");
        blog.setAuthorId(1);
        return blog;
    }

    public String createBlog(Blog blog, String organizationId) {
        if (blog != null) {
            return String.format("This is the post and the object is: %s", blog.toString());
        }
        return null;
    }

    public String updateBlog(Blog blog, String organizationId) {
        if (blog != null) {
            return String.format("This is the put and the object is: %s", blog.toString());
        }
        return null;
    }

    public String deleteBlog(String blogId, String organizationId) {
        return String.format("Deleting blog with id %s for the organization %s", blogId, organizationId);
    }
}