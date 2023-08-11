package com.example.blog.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogLogin {


    private String id;
    private String psw;

//    회원변경
    private Boolean UpdateAcc;

}
