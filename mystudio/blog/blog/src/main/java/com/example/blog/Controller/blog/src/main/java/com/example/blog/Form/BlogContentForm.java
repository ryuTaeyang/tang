package com.example.blog.Form;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogContentForm {

    private Integer number;


    private String id;
    private String psw;
    private String content;
    private String title;
    private Timestamp time;
}
