package com.blog.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    
    @Column(name = "post_title", length = 100, nullable = false)
    private String title;
    
    @Column(name = "post_content", length = 1000)
    private String content;
    
    private String imageName;
    
    private Date addDate;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties("posts")
    private Category category;
    
    @ManyToOne
    @JsonIgnoreProperties("posts")
    private User user;
}
