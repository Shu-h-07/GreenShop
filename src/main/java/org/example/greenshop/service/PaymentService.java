package org.example.greenshop.service;

import org.example.greenshop.dto.PaymentDto;
import org.example.greenshop.model.Payment;
import org.example.greenshop.model.Result;
import org.example.greenshop.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    PaymentRepo paymentRepo;

    public List<Payment> getAllP() {
        return paymentRepo.findAll();
    }
    public Payment getByIdP(Integer id) {
        return paymentRepo.findById(id).get();
    }
    public Result addP(PaymentDto paymentDto){
        Payment payment = new Payment();
        payment.setName(paymentDto.getName());
        payment.setNumber(paymentDto.getNumber());
        payment.setCvv_num(paymentDto.getCvv_num());
        payment.setExpire_date(paymentDto.getExpire_date());
        paymentRepo.save(payment);
        return new Result(true , "Payment added");
    }
    public Result updateP(PaymentDto paymentDto , Integer id){
        Optional<Payment> optionalPayment = paymentRepo.findById(id);
        if(optionalPayment.isPresent()){
            Payment payment = optionalPayment.get();
            payment.setName(paymentDto.getName());
            payment.setNumber(paymentDto.getNumber());
            payment.setCvv_num(paymentDto.getCvv_num());
            payment.setExpire_date(paymentDto.getExpire_date());
            paymentRepo.save(payment);
            return new Result(true , "Payment updated");
        }
        return new Result(false, "Payment not found");
    }
    public Result deleteP(Integer id) {
        paymentRepo.deleteById(id);
        return new Result(true , "Payment deleted");
    }

}
