package com.example.home.Service;

import com.example.home.Entity.Home;

import java.util.Optional;

public interface HomeService {
    Iterable<Home> selectAll();

    Optional<Home> selectOneById(Integer num);

    Boolean check(Integer num,String psw);

    void insertMember(Home home);
    void updateMember(Home home);
    void deleteMember(Integer num);
}
