package com.example.login.Service;

import com.example.login.entity.Login;

import java.util.Optional;


public interface LoginService {
    Iterable<Login> selectAll();

    Optional<Login> selectOneById(Integer user_no);

//    Optional<Login> selectDtOne(Integer user_no);

    Boolean checkPws(Integer user_no, String pws );

    void insertUser(Login login);

    void updateUser(Login login);

    void deleteUserById(Integer user_no);


}
