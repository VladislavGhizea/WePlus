package com.weplus.app.controller;

import com.weplus.app.entita.IndiceHobby;
import com.weplus.app.repository.IndiceHobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/IndiceHobby")
public class IndiceHobbyController implements IController<IndiceHobby, Integer>{

    @Autowired
    private IndiceHobbyRepository indiceHobbyRepository;

    @Override
    public void create(@RequestBody IndiceHobby entity) {
        indiceHobbyRepository.save(entity);
    }

    @Override
    public IndiceHobby getById(@PathVariable Integer id) {
        return indiceHobbyRepository.findById(id).orElse(null);
    }

    @Override
    public List<IndiceHobby> getAll() {
        return indiceHobbyRepository.findAll();
    }

    @Override
    public void update(@PathVariable Integer id, @RequestBody IndiceHobby entity) {
        //non c'è nulla da modificare
    }

    @Override //cancellato=true
    public void delete(@PathVariable Integer id) {
        indiceHobbyRepository.deleteById(id);
    }
}
