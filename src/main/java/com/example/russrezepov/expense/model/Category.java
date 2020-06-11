package com.example.russrezepov.expense.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.lang.NonNull;

import javax.persistence.*;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@NoArgsConstructor
@Entity
@Data
@Table(name="category")
public class Category {

    @Id
    @NonNull
    private long id;
    //Category names such as Travel, Grocery...
    @NonNull
    @Column(name="categoryName")
    private String name;

    //Many categories can be connected to one user
    // PERSIST - when category is added it needs to have a user
    @JsonIgnore
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Users user;
}
