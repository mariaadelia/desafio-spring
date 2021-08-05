package com.example.desafio.produto.presente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/presentes")
public class PresenteResource {

    @Autowired private PresenteService presenteService;

    /*
    As alterações do Desafio 1 vão aqui...
     */
}
