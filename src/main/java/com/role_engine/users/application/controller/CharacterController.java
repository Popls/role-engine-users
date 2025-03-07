package com.role_engine.users.application.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.role_engine.users.domain.model.Personaje;
import com.role_engine.users.domain.service.CharacterService;

@RestController
@RequestMapping("/character")
public class CharacterController {

    private CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<Personaje> getCharacter(@PathVariable Integer id) {
        return ResponseEntity.ok(characterService.getCharacter(id));
    }

    @PostMapping
    public ResponseEntity<Personaje> createCharacter(@RequestBody Personaje character) {
        characterService.saveCharacter(character);
        return ResponseEntity.status(201).body(character);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Integer id) {
        characterService.deleteCharacter(id);
        return ResponseEntity.ok().build();
    }

}
