package com.example.desafio.produto;

import java.util.ArrayList;
import java.util.List;

//@Getter
public class Produto10DTO {
	
	private List<String> nome = new ArrayList<>();
    private List <Double> mediaNotas = new ArrayList<>();
    
	public List<String> getNome() {
		return nome;
	}
	public void setNome(List<String> nome) {
		this.nome = nome;
	}
	public List<Double> getMediaNotas() {
		return mediaNotas;
	}
	public void setMediaNotas(List<Double> mediaNotas) {
		this.mediaNotas = mediaNotas;
	}
    
    
    
}
