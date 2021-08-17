package com.example.desafio.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio.produto.chocolate.Chocolate;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
@Transactional
public class ProdutoService {

    @Autowired private ProdutoRepository repository;
        
    
    public List<Produto> getTop10Notas() {
    	 	
        /*
        As alterações do Desafio 3 vão aqui...
        Lembre-se que o tipo da lista para retorno não é Produto, e sim uma classe de DTO que deverá ser criada!
         */
    	
    	List<Produto> produto = (List<Produto>) repository.findAll();
    	
    	Stream<List<Double>> notaProduto = produto.stream().map(Produto::getNota);
    	
    	Stream<String> nomeProduto = produto.stream().map(Produto::getNome);
    	
    	
    	    	
    	//
    	
        return Collections.emptyList();
    }
}
