package com.example.demo.repositery;

import com.example.demo.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email,Long> {

    List<Email> findEmailsByFromm(String fromm);
}
