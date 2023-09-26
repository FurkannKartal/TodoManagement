package com.kartal.todomanagement.service;

import com.kartal.todomanagement.service.requests.CreateTodosRequest;
import com.kartal.todomanagement.service.requests.DeleteTodosRequest;
import com.kartal.todomanagement.service.requests.UpdateTodosRequest;
import com.kartal.todomanagement.service.responses.GetAllTodosResponse;

import java.util.List;

public interface ITodoService {
    //List<Todo> getAll();        // get all todos Direk veritabanınını kullanıcıya açtık
    //Veritabanını varlığını kullanıcıya açmamamız lazım
    List<GetAllTodosResponse> getAll();

    void add(CreateTodosRequest createTodosRequest);
    void delete(DeleteTodosRequest deleteTodosRequest);
    void update(UpdateTodosRequest updateTodosRequest);





}
