package com.sjsu.javageeks.payment.dao.interfaces;

import com.sjsu.javageeks.payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentDAO extends JpaRepository<Payment, Long> {
    List<Payment> findByOrderid(String orderId);


}
