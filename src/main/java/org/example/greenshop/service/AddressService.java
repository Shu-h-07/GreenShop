package org.example.greenshop.service;

import org.example.greenshop.dto.AddressDto;
import org.example.greenshop.model.Address;
import org.example.greenshop.model.Result;
import org.example.greenshop.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressRepo addressRepo;

    public List<Address> getAllA() {
        return addressRepo.findAll();
    }
    public Address getByIdA(Integer id) {
       return addressRepo.findById(id).get();
    }
    public Result addA(AddressDto addressDto) {
        Address address = new Address();
        address.setFirstName(addressDto.getFirstName());
        address.setLastName(addressDto.getLastName());
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());
        address.setState(addressDto.getState());
        address.setZip(addressDto.getZip());
        address.setCountry(addressDto.getCountry());
        address.setEmail(addressDto.getEmail());
        address.setPhoneNumber(addressDto.getPhoneNumber());
        address.setOrder_notes(addressDto.getOrder_notes());
        addressRepo.save(address);
        return new Result(true,"Address created successfully");
    }
    public Result updateA(AddressDto addressDto , Integer id) {
        Optional<Address> addressOptional = addressRepo.findById(id);
        if (addressOptional.isPresent()) {
            Address address = addressOptional.get();
            address.setFirstName(addressDto.getFirstName());
            address.setLastName(addressDto.getLastName());
            address.setCity(addressDto.getCity());
            address.setStreet(addressDto.getStreet());
            address.setState(addressDto.getState());
            address.setZip(addressDto.getZip());
            address.setCountry(addressDto.getCountry());
            address.setEmail(addressDto.getEmail());
            address.setPhoneNumber(addressDto.getPhoneNumber());
            address.setOrder_notes(addressDto.getOrder_notes());
            addressRepo.save(address);
            return new Result(true,"Address updated successfully");
        }

        return new Result(false , "Address not updated ");
    }
    public Result deleteA(Integer id) {
        addressRepo.deleteById(id);
        return new Result(true,"Address deleted successfully");
    }
}
