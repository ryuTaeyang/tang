package com.example.home.Service;

import com.example.home.Entity.Home;
import com.example.home.Repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@Transactional
public class HomeServiceImpl implements HomeService {
    @Autowired
    HomeRepository repository;
    @Override
    public Iterable<Home> selectAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Home> selectOneById(Integer num) {
        return repository.findById(num);
    }

    @Override
    public Boolean check(Integer num, String psw) {
        Boolean check = false;
        Optional<Home> homeOpt = repository.findById(num);
        if(homeOpt.get().getNum().equals(num)&& homeOpt.get().getPsw().equals(psw)){
            System.out.println("값 넣어주기 바람");
            check = true;
        }
        return check;
    }

    @Override
    public void insertMember(Home home) {
        repository.save(home);

    }

    @Override
    public void updateMember(Home home) {
        repository.save(home);

    }

    @Override
    public void deleteMember(Integer num) {
        repository.deleteById(num);

    }
}
