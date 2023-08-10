package com.example.blog.Form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogForm {
    private Integer num;

    @NotBlank
    private String name;
    @NotBlank
    private  String id;
    @NotBlank
    private String psw;
    @NotBlank
    private String email;
    private Timestamp time;
    private Boolean newMember;
}
