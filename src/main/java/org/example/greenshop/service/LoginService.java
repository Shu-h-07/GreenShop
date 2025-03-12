package org.example.greenshop.service;

import org.example.greenshop.dto.LoginDto;
import org.example.greenshop.model.Login;
import org.example.greenshop.model.Result;
import org.example.greenshop.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    LoginRepo loginRepo;

    public List<Login> getAll() {
        return loginRepo.findAll();
    }

    public Result create(LoginDto loginDto) {
        Login login = new Login();
        login.setCreated_date(loginDto.getCreated_date());
        login.setConfirm_password(loginDto.getConfirm_password());
        login.setName(loginDto.getName());
        login.setEmail(loginDto.getEmail());
        login.setPassword(loginDto.getPassword());
        loginRepo.save(login);
        return new Result(true, "👍🏻");

    }

    public Result update(Integer id, LoginDto loginDto) {
        Optional<Login> byId = loginRepo.findById(id);
        if (byId.isPresent()) {
            Login login = byId.get();
            login.setEmail(loginDto.getEmail());
            login.setPassword(loginDto.getPassword());
            login.setName(loginDto.getName());
            login.setCreated_date(loginDto.getCreated_date());
            login.setConfirm_password(loginDto.getConfirm_password());
            loginRepo.save(login);
            return new Result(true, "👍🏻");
        }
        return new Result(false, "👎🏻");
    }

    public Result delete(LoginDto loginDto, Integer id) {
        boolean byEmail = loginRepo.existsByEmail(loginDto.getEmail());
        if (byEmail) {
            Optional<Login> optionalLogin = loginRepo.findById(id);
            Login login = optionalLogin.get();
            loginRepo.delete(login);
            return new Result(true, "Deleted");
        }
        return new Result(false, "Not found");
    }
}
