package articolo;

import java.util.Date;

import articolo.interfacce.Scrittore;

public class Autore implements Scrittore {
	private int id;
	private String nome;
	private String cognome;
	
	public Autore(int id, String nome, String cognome) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCognome() {
		return cognome;
	}

	@Override
	public void scriviArticolo(String titolo, String categoria, String testo, Tags tags) {
		// TODO Auto-generated method stub
		new Articolo(id, titolo, new Date(), categoria, testo, new Autore(this.id, this.nome, this.cognome), tags);
	}
}
