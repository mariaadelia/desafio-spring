package com.example.desafio.produto.presente;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/presentes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PresenteResource {

    @Autowired private PresenteService presenteService;

    /*
    Desafio 1
     */
    
    
    //Get all
    
    @GetMapping("/todos")
    public ResponseEntity<Iterable<Presente>> getAllPresente(){
    	return ResponseEntity.ok(presenteService.findAllPresente());
    }
    
    
    //Get By Id
    @GetMapping("/{id}")
    public ResponseEntity<Presente> getPresenteById(@PathVariable Long id){
    	return presenteService.findByIdPresente(id)
    			.map(resp -> ResponseEntity.ok(resp))
    			.orElse(ResponseEntity.notFound().build());
    }
    
    //Post
    @PostMapping("/novo")
    public ResponseEntity<Presente> createPresente(@RequestBody Presente presente){
    	return ResponseEntity.status(HttpStatus.CREATED).body(presenteService.save(presente));
    }
    
    //Put
    @PutMapping("/atualizar")
    public ResponseEntity<Presente> updatePresente(@RequestBody Presente presente){
    	return ResponseEntity.status(HttpStatus.OK).body(presenteService.save(presente));
    }
    
    //Delete
    @DeleteMapping("/apagar/{id}")
    public void deletePresente(@PathVariable Long id) {
    	presenteService.delete(id);
    }
    
}
