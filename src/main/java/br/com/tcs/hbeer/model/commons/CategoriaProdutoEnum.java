package br.com.tcs.hbeer.model.commons;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum CategoriaProdutoEnum {
	
	DESTILADA("Destilada", 0),
	FERMENTADA("Fermentada", 1),
	GASEIFICADA("Fermentada", 2);
	
	private final String nome;
	private final int id;
	
	private CategoriaProdutoEnum(String nome, int id){
		this.nome  = nome;
		this.id    = id;
	}
	
	/**
	 * 
	 * @param text
	 * @return enum or null
	 */
	public static CategoriaProdutoEnum fromText(String text) {
		
		try {
			return Arrays.stream(values())
					.filter(bl -> bl.getNome().equalsIgnoreCase(text))
					.findFirst().get();
			
		}catch(NoSuchElementException ex) {
			return null;
		}
		
    }
	
	public String getNome() {
		return nome;
	}

	public int getId() {
		return id;
	}
	
}
