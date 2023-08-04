package com.example.login.Form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class LoginForm {
    @Id
    @Column("user_no")
    private Integer no;

    @Column("user_id")
    @NotBlank(message = "아이뒤를 지정해야 합니다.")
    private String id;

    @Column("user_name")
    @NotBlank(message = "작성자가 누군지 알아야합니다.")
    private String name;

    @Column("user_pws")
    @NotBlank(message = "패스워드를 지정해야 합니다")
    private String pws;


    private String author;



    @Column("ad")
    private Timestamp time;


    @Email
    private  String email;

    private Boolean newUser; /* 등록 또는 변경용*/

    }