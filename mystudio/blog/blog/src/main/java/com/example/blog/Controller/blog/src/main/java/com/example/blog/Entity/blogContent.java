package com.example.blog.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class blogContent {
    @Id
    private Integer number;

    private String content;
    private String title;

    private Timestamp time;
}
