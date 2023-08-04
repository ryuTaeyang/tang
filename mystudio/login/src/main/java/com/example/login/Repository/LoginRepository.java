package com.example.login.Repository;

import com.example.login.entity.Login;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<Login, Integer> {
    @Query("SELECT user_id,user_name,user_pws,author,user_no,ad,email FROM login ")
    Iterable<Login> showAll();
}
