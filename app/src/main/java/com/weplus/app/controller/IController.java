package com.weplus.app.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/default")
public interface IController<T, ID> {
    @PostMapping
    T create(@RequestBody T entity);

    @GetMapping("/{id}")
    T getById(@PathVariable ID id);

    @GetMapping
    List<T> getAll();

    @PutMapping("/{id}")
    T update(@PathVariable ID id, @RequestBody T entity);

    @DeleteMapping("/{id}")
    void delete(@PathVariable ID id);

    //todo, metodo per prendere i dati json in input (pensavamo di fargli creare l'entitàb)

}
