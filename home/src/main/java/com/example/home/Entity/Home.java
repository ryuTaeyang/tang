package com.example.home.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Home")
public class Home {
    @Id
    private Integer num;

    private String id;
    private String psw;
    private String user_name;
    private String email;
    private String content;
    private String title;
    private Timestamp user_time;
}
