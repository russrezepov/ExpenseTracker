package com.example.russrezepov.expense.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.persistence.*;
import java.util.Set;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="users")
public class Users {
    @Id
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;

    //Set removes all duplicate values
    //OneToMany meaning:
    //One - current class User
    //Many - means User can have many categories

//    @OneToMany
//    private Set<Category> category;
}
