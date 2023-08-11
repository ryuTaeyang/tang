package com.example.blog.Form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogForm {

    private Integer number;

    @NotBlank
    private String id;

    @NotBlank
    private String psw;

    @NotBlank
    private String name;

    @Email
    private String email;

    private Timestamp time;

    private Boolean newMember;
}

