package com.example.blog.Form;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogLoginForm {

    private Integer number;

    @NotBlank
    private String id;

    @NotBlank
    private String psw;

}
