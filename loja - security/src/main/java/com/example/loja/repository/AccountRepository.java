package com.example.loja.repository;

import com.example.loja.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findOneByEmail(String email);
}
