package com.example.home.Form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomeForm {
    @Id
    public Integer num;

    private String id;
    private String psw;
    private String user_name;
    private String email;
    private String content;
    private String title;
    private Timestamp user_time;

//    새로만들기
    private Boolean newMember;


}
