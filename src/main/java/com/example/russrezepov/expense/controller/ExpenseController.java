package com.example.russrezepov.expense.controller;

import com.example.russrezepov.expense.model.Expense;
import com.example.russrezepov.expense.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ExpenseController {

    @Autowired

    private ExpenseRepository expenseRepository;

    public ExpenseController(ExpenseRepository expenseRepository) {
        super();
        this.expenseRepository = expenseRepository;
    }

    @GetMapping("/expenses")
    List<Expense> getExpenses() {
        //select * from expenses
        return expenseRepository.findAll();
    }

    @DeleteMapping("/expenses/{id}")
    ResponseEntity<?> deleteExpense(@PathVariable Long id) {
        expenseRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    //INSERT INTO TABLE implementation
    @PostMapping("/expenses{id}")
    ResponseEntity<Expense> createExpense(@Valid @RequestBody Expense expenses) throws URISyntaxException {
        Expense result = expenseRepository.save(expenses);
        return ResponseEntity.created(new URI("/api/expenses" + result.getId())).body(result);
    }


    @PutMapping("/expenses/{id}")
    ResponseEntity<Expense> updateUsers(@Valid @RequestBody Expense expenses) {
        Expense result = expenseRepository.save(expenses);
        return ResponseEntity.ok().body(result);
    }




}
