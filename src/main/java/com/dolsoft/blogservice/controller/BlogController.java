package com.dolsoft.blogservice.controller;

import com.dolsoft.blogservice.model.Blog;
import com.dolsoft.blogservice.service.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

@RestController
@RequestMapping(value = "v1/organization/{organizationId}/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/{blogId}", method = RequestMethod.GET)
    public ResponseEntity<Blog> getBlog(
            @PathVariable("organizationId") String organizationId,
            @PathVariable("blogId") String blogId) {

        Blog blog = blogService.getBlog(blogId, organizationId);

        blog.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BlogController.class)
                .getBlog(organizationId, blogId)).withSelfRel());
        blog.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BlogController.class)
                .createBlog(organizationId, blog)).withRel("createBlog"));
        blog.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BlogController.class)
                .updateBlog(organizationId, blog)).withRel("updateBlog"));
        blog.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BlogController.class)
                .deleteBlog(organizationId, String.valueOf(blog.getId()))).withRel("deleteBlog"));

        return ResponseEntity.ok(blog);
    }

    @PutMapping
    public ResponseEntity<String> updateBlog(
            @PathVariable("organizationId") String organizationId,
            @RequestBody Blog request) {
        return ResponseEntity.ok(blogService.updateBlog(request, organizationId));
    }

    @PostMapping
    public ResponseEntity<String> createBlog(
            @PathVariable("organizationId") String organizationId,
            @RequestBody Blog request) {
        return ResponseEntity.ok(blogService.createBlog(request, organizationId));
    }

    @DeleteMapping(value = "/{blogId}")
    public ResponseEntity<String> deleteBlog(
            @PathVariable("organizationId") String organizationId,
            @PathVariable("blogId") String blogId) {
        return ResponseEntity.ok(blogService.deleteBlog(blogId, organizationId));
    }
}