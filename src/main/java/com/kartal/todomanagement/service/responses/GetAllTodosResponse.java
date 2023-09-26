package com.kartal.todomanagement.service.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTodosResponse {
    //Kullanıcıya vermek istediğim bilgiler id ve name
    private int id;
    private String name;

}
