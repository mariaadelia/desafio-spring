package com.example.desafio;

import com.example.desafio.produto.presente.Presente;
import com.example.desafio.produto.presente.PresenteService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PresenteTest {

    @Autowired private PresenteService presenteService;

    /*
    Desafio 1.1
     */
    
    @Autowired private TestRestTemplate testRestTemplate;
    
    @Test
    void testeCriacaoPresente() {
    	var presente = new Presente();
    	presente.setNome("Kit Aniversário");
    	presente.setPreco(23.99);
    	
    	presenteService.save(presente);
    	
    	HttpEntity<Presente> request = new HttpEntity<Presente>(presente);
    	ResponseEntity<Presente> resposta = testRestTemplate
    			.exchange("/presentes/novo", HttpMethod.POST,request, Presente.class);
    	
    	assertEquals(HttpStatus.CREATED,resposta.getStatusCode());
    }
    
    
    @Test
    void testeAtualizarPresente() {
    	var presente = new Presente();
    	presente.setNome("Kt Nam");
    	presente.setPreco(30.99);
    	
    	presenteService.save(presente);
    	
    	var idPresente = presente.getId();
    	
    	presente.setNome("Kit Namoro");
    	presenteService.save(presente);
    	
    	HttpEntity<Presente> request = new HttpEntity<Presente>(presente);
    	ResponseEntity<Presente> resposta = testRestTemplate
    			.exchange("/presentes/atualizar", HttpMethod.PUT,request, Presente.class);
    	
    	assertEquals(idPresente, presente.getId());
    	assertEquals(HttpStatus.OK,resposta.getStatusCode());
    }
    
    
    @Test
    void testeTodosPresentes() {
    	var presente = new Presente();
    	presente.setNome("Kit Família");
    	presente.setPreco(50.99);
    	
    	presenteService.save(presente);
    	
    	var presente1 = new Presente();
    	presente1.setNome("Kit Amigos");
    	presente1.setPreco(35.99);
    	
    	presenteService.save(presente1);
    	
    	ResponseEntity<String> resposta = testRestTemplate
    			.exchange("/presentes/todos", HttpMethod.GET, null,String.class);
    	
    	var listaPresentes = presenteService.findAllPresente();
    	
    	assertNotNull(listaPresentes);
    	assertEquals(HttpStatus.OK, resposta.getStatusCode());
    }
    
    
    @Test
    void testeVerPresentePorId() {
    	ResponseEntity<String> resposta = testRestTemplate
    			.exchange("/presentes/2", HttpMethod.GET, null,String.class);
    	
    	assertEquals(HttpStatus.OK, resposta.getStatusCode());
    }
    
    @Test
    void testeApagarPresentePorId() {
    	ResponseEntity<String> resposta = testRestTemplate
    			.exchange("/presentes/apagar/3", HttpMethod.DELETE, null,String.class);
    	
    	assertEquals(HttpStatus.OK, resposta.getStatusCode());
    }
    
    
    
    
}
