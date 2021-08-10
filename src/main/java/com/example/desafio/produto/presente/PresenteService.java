package com.example.desafio.produto.presente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.transaction.Transactional;

@Service
@Transactional
public class PresenteService {

    @Autowired private PresenteRepository repository;

    /*
    Desafio 1
     */

    public Iterable<Presente> findAllPresente() {
        return repository.findAll();
    }

    public Optional<Presente> findByIdPresente(Long id){
        return repository.findById(id);
    }

    public Presente save(Presente presente) {
        return repository.save(presente);
    }
    
    public void delete(Long id) {
    	repository.deleteById(id);
    }
}
