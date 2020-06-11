package com.example.russrezepov.expense.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.persistence.*;
import java.time.Instant;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="expense")
public class Expense {

    @Id
    private long id;

    //Instant is used as a time stamp
    @Column(name="expenseDate")
    private Instant expenseDate;

    @Column(name="descript")
    private String descript;

    @Column(name="location")
    private String location;

    //ID(PK),   Date,       Description,    User ID,    category ID
    //1000,     6/5/2020,   'Visitng NYC',  111222,     10

    @ManyToOne
    private com.example.russrezepov.expense.model.Category category;

    @JsonIgnore
    @ManyToOne
    private com.example.russrezepov.expense.model.Users user;

}
