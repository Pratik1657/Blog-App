package com.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.payload.ApiResponse;
import com.blog.payload.PostDTO;
import com.blog.services.PostService;



@RestController
@RequestMapping("/api/")
public class PostController {
    @Autowired
    private PostService postService;
    
    // Create
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDTO> createPost(
            @RequestBody PostDTO postDTO,
            @PathVariable Integer userId,
            @PathVariable Integer categoryId
            ) {
        PostDTO createPost = this.postService.createPost(postDTO, userId, categoryId);
        return new ResponseEntity<>(createPost, HttpStatus.CREATED);
    }

    // Update
    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDTO> updatePost(
            @RequestBody PostDTO postDTO,
            @PathVariable Integer postId
            ) {
        PostDTO updatedPost = this.postService.updatePost(postDTO, postId);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }

    // Delete
    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId) {
        this.postService.deletePost(postId);
        return new ResponseEntity<>(new ApiResponse("Post is deleted successfully", true), HttpStatus.OK);
    }

    // Get All Posts
    @GetMapping("/posts")
    public ResponseEntity<List<PostDTO>> getAllPost() {
        List<PostDTO> allPosts = this.postService.getAllPost();
        return ResponseEntity.ok(allPosts);
    }

    // Get Post by ID
    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Integer postId) {
        PostDTO postDTO = this.postService.getPostById(postId);
        return ResponseEntity.ok(postDTO);
    }

    // Get Posts by Category
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDTO>> getPostsByCategory(@PathVariable Integer categoryId) {
        List<PostDTO> posts = this.postService.getPostsByCategory(categoryId);
        return ResponseEntity.ok(posts);
    }

    // Get Posts by User
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDTO>> getPostsByUser(@PathVariable Integer userId) {
        List<PostDTO> posts = this.postService.getPostsByUser(userId);
        return ResponseEntity.ok(posts);
    }

    // Search Posts
    @GetMapping("/posts/search/{keyword}")
    public ResponseEntity<List<PostDTO>> searchPosts(@PathVariable String keyword) {
        List<PostDTO> posts = this.postService.searchPosts(keyword);
        return ResponseEntity.ok(posts);
    }
}

