package com.kartal.todomanagement.service;

import com.kartal.todomanagement.model.Todo;
import com.kartal.todomanagement.repository.ITodoRepository;
import com.kartal.todomanagement.service.requests.CreateTodosRequest;
import com.kartal.todomanagement.service.requests.DeleteTodosRequest;
import com.kartal.todomanagement.service.requests.UpdateTodosRequest;
import com.kartal.todomanagement.service.responses.GetAllTodosResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TodoService implements ITodoService {
    private ITodoRepository todoRepository;

    public TodoService(ITodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<GetAllTodosResponse> getAll() {

        List<Todo> todos = todoRepository.findAll();
        List<GetAllTodosResponse> getAllTodosResponses = new ArrayList<GetAllTodosResponse>();
        for (Todo todo : todos) {
            GetAllTodosResponse responseItem = new GetAllTodosResponse();
            responseItem.setId(todo.getId());
            responseItem.setName(todo.getName());
            getAllTodosResponses.add(responseItem);


        }
        return getAllTodosResponses;        // get all todos

    }

    @Override
    public void add(CreateTodosRequest createTodosRequest) {
        Todo todo = new Todo();
        todo.setName(createTodosRequest.getName());
        this.todoRepository.save(todo);
    }

    @Override
    public void delete(DeleteTodosRequest deleteTodosRequest) {
        this.todoRepository.deleteById(deleteTodosRequest.getId());
    }

    @Override
    public void update(UpdateTodosRequest updateTodosRequest) {
        Todo todo = this.todoRepository.findById(updateTodosRequest.getId()).get();     //updateTodosRequest.getId() ile gelen id'yi bulup todo değişkenine atıyoruz.
        if (!isExist(todo)) {
            todo.setName(updateTodosRequest.getName());
            this.todoRepository.save(todo);
        }
        else {
            throw new RuntimeException("This todo already exist.");
        }

    }

    public boolean isExist(Todo todo) {
        boolean exist = false;
        List<Todo> todos = todoRepository.findAll();
        for (Todo todoItem : todos) {
            if (todoItem.getName().equals(todo.getName())) {
                exist = true;
                break;
            }

            }
        return exist;
    }


}


