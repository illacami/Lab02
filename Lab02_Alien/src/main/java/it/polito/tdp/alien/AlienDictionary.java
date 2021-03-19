package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	private List<Word> dizionario;
	private Map<String, Word> mappaDizionario;
	
	
	public AlienDictionary() {
		this.dizionario = new LinkedList<>();
		this.mappaDizionario = new HashMap<>();
	}

	public void addWord(String alienWord, String translation) {
		
		Word nuova = new Word(alienWord, translation);
		
		dizionario.add(nuova);
		mappaDizionario.put(alienWord, nuova);
	}
	
	public String transalteWord(String alienWord) {
		
		return mappaDizionario.get(alienWord).getTranslation();
	}


}
