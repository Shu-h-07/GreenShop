package org.example.greenshop.service;

import org.example.greenshop.dto.UsersDto;
import org.example.greenshop.model.Address;
import org.example.greenshop.model.Result;
import org.example.greenshop.model.Users;
import org.example.greenshop.repository.AddressRepo;
import org.example.greenshop.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    UsersRepo usersRepo;

    @Autowired
    AddressRepo addressRepo;

    // get all
    public List<Users> getall() {
        return usersRepo.findAll();
    }

    // get by id
    public Users getbyid(Integer id) {
        return usersRepo.findById(id).get();
    }

    // create
    public Result create(UsersDto usersDto) {
        boolean existsed = usersRepo.existsByEmail(usersDto.getEmail());
        if (existsed) {
            return new Result(false, "Bunday email mavjud");
        }
        Users users = new Users();
        users.setFirstname(usersDto.getFirstname());
        users.setLastname(usersDto.getLastname());
        users.setEmail(usersDto.getEmail());
        users.setPassword(usersDto.getPassword());
        users.setPhone_Number(usersDto.getPhone_Number());
        Optional<Address> optionalAddress =
                addressRepo.findById(usersDto.getAddress().getId());
        Address address = optionalAddress.get();
        users.setAddress(address);
        users.setOrder_nodes(usersDto.getOrder_nodes());
        usersRepo.save(users);
        return new Result(true, "Saqlandi");
    }
    // delete
    public Result delete(UsersDto usersDto, Integer id) {
        usersRepo.deleteById(id);
        return new Result(true, "Deleted");
    }

}
