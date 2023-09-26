package com.kartal.todomanagement.model;

import com.kartal.todomanagement.service.responses.GetAllTodosResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "todos")
@Data               // lombok Getter Setter oluşturur
@AllArgsConstructor // lombok Parametreli Constructor oluşturur
@NoArgsConstructor      // lombok Parametresiz Constructor oluşturur
@Entity         // JPA

public class Todo {
    @Id     // Veritabanında primary key olduğunu belirtir
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // Veritabanında auto increment olduğunu belirtir
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="done")
    private boolean done;


// Veritabanından Todos -> id, name, description, done verileri gelir
    // GetAllTodosResponse -> id, name verileri gelir

    // id idye name namee  atanır. Bu işlem mappeleme işlemidir.





}
