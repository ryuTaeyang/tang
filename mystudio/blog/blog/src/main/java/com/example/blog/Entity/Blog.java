package com.example.blog.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.sql.In;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    private Integer num;

    private String name;
    private String id;
    private String psw;
    private Timestamp time;

    private String email;



}
