package com.kartal.todomanagement.controller;


import com.kartal.todomanagement.model.Todo;
import com.kartal.todomanagement.service.TodoService;
import com.kartal.todomanagement.service.requests.CreateTodosRequest;
import com.kartal.todomanagement.service.requests.DeleteTodosRequest;
import com.kartal.todomanagement.service.requests.UpdateTodosRequest;
import com.kartal.todomanagement.service.responses.GetAllTodosResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/getall")
    public List<GetAllTodosResponse> getAll() {
        return todoService.getAll();
    }
    @PostMapping("/add")
    public void add(CreateTodosRequest createTodosRequest) {    //@Requestbody e bak ??????
        this.todoService.add(createTodosRequest);

    }
    @DeleteMapping("/delete")
    public void delete(DeleteTodosRequest deleteTodosRequest) {
        todoService.delete(deleteTodosRequest);
    }

    @PutMapping("/update")
    public void update(UpdateTodosRequest updateTodosRequest) {
        todoService.update(updateTodosRequest);
    }

}
