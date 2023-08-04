package com.example.login.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Login {


    @Id
    @Column("user_no")
    private Integer no;

    @Column("user_id")
    private String id;

    @Column("user_name")
    private String name;

    @Column("user_pws")
    @Length(message = "값을 넣어야 합니다.")
    private String pws;

    private String author;



    @Column("ad")
    private Timestamp time;

    @Email(message = "이메일을 작성해 주십시오.")
    private String email;

//    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
//    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
//    private LocalDateTime ad_date;

}
