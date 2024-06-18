package com.blog.payload;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDTO {
    private String title;
    private String content;
    private String imageName;
    private Date addDate;
    private CategoryDTO category;
    private UserDTO user;
}