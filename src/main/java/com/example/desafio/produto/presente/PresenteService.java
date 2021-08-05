package com.example.desafio.produto.presente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PresenteService {

    @Autowired private PresenteRepository repository;

    /*
    As alterações do Desafio 1 vão aqui...
     */
}
