package com.example.blog.Form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogLoginForm {
    private Integer num;

    @NotBlank
    private String content;
    @NotBlank
    private String title;
    private Boolean newMember;
    private Timestamp time;
}
