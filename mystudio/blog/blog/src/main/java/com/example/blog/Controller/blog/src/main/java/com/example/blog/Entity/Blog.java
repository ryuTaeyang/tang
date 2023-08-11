package com.example.blog.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    private Integer number;

   private String id;
   private String psw;
   private String name;
   private String email;
   private Timestamp time;
}
