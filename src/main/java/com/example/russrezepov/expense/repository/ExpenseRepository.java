package com.example.russrezepov.expense.repository;

import com.example.russrezepov.expense.model.Category;
import com.example.russrezepov.expense.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
