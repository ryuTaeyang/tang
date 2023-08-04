package com.example.login.Service;

import com.example.login.Repository.LoginRepository;
import com.example.login.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginRepository repository;
    @Override
    public Iterable<Login> selectAll() {
        return  repository.findAll();
    }

    @Override
    public Optional<Login> selectOneById(Integer user_no) {
        return repository.findById(user_no);
    }

    @Override
    public Boolean checkPws(Integer user_no, String pws) {
        Boolean check = false;
        Optional<Login> loginOpt = repository.findById(user_no);
//        System.out.println(pws);
//        System.out.println(loginOpt.get().getPws());
       if(loginOpt.get().getPws().equals(pws)){
            check =true;
       }
       return check;
    }

//    @Override
//    public Optional<Login> selectDtOne(Integer user_no) {
//
//            Integer OneDtId = repository.(user_no);
//            if (OneDtId == null){
//                return Optional.empty();
//            }
//            return repository.findById(OneDtId);

//    }





    @Override
    public void insertUser(Login login) {
        repository.save(login);

    }

    @Override
    public void updateUser(Login login) {
        repository.save(login);

    }

    @Override
    public void deleteUserById(Integer user_no) {
        repository.deleteById(user_no);

    }
}
