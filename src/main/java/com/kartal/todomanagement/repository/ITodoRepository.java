package com.kartal.todomanagement.repository;

import com.kartal.todomanagement.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITodoRepository extends JpaRepository<Todo,Integer> {



}
