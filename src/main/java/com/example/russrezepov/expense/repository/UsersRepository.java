package com.example.russrezepov.expense.repository;

import com.example.russrezepov.expense.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {
    List<Users> findAll();
}
