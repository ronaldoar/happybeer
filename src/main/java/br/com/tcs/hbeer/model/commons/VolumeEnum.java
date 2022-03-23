package br.com.tcs.hbeer.model.commons;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum VolumeEnum {
	
	ML110("110ml", 0),
	ML190("190ml", 1),
	ML290("290ml", 2),
	ML500("500ml", 3),
	ML600("600ml", 4),
	ML900("900ml", 5),
	ML1000("1000ml", 6);
	
	private final String nome;
	private final int id;
	
	private VolumeEnum(String nome, int id){
		this.nome  = nome;
		this.id    = id;
	}
	
	/**
	 * 
	 * @param text
	 * @return enum or null
	 */
	public static VolumeEnum fromText(String text) {
		
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
