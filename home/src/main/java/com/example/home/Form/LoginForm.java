package com.example.home.Form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginForm {
    private Integer num;
    private String id;
    private String psw;
}
