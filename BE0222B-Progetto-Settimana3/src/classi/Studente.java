package classi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Studente{
	private int id;
	private String nome;
	private String cognome;
	private char genere;
	private HashMap<String, List<Double>> voti;

	public Studente(int id, String nome, String cognome, char genere) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.genere = genere;
		this.voti = assegnaVotiMaterie();
	}

	// Getter
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public char getGenere() {
		return genere;
	}

	public HashMap<String, List<Double>> getVoti() {
		return voti;
	}

	// Setter
	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setGenere(char genere) {
		this.genere = genere;
	}

	public void setVoti(HashMap<String, List<Double>> voti) {
		this.voti = voti;
	}

	// Methods
	public List<Double> generaVoti() {
		List<Double> votiRandom = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Double random = 2 + Math.random() * 8;
			votiRandom.add(Double.parseDouble(random.toString().substring(0, 3)));
		}
		return votiRandom;
	}

	public HashMap<String, List<Double>> assegnaVotiMaterie() {
		HashMap<String, List<Double>> assegnaVoti = new HashMap<>();
		assegnaVoti.put("Matematica", generaVoti());
		assegnaVoti.put("Fisica", generaVoti());
		assegnaVoti.put("Chimica", generaVoti());
		assegnaVoti.put("Inglese", generaVoti());
		assegnaVoti.put("Italiano", generaVoti());
		assegnaVoti.put("Grammatica", generaVoti());
		return assegnaVoti;
	}

	public double mediaVotoMateria(String materia) {
		double mediaVoti = voti.get(materia).stream().reduce((double) 0, (voto, item) -> voto + item)
				/ voti.get(materia).size();
		return mediaVoti;
	}

	public double votoMiglioreMateria(String materia) {
		double listaVoti = voti.get(materia).stream().reduce((double) 0, (voto, tot) -> tot > voto ? voto = tot : voto);
		return listaVoti;
	}

	public boolean promosso() {
		HashMap<String, List<Double>> listaVoti = getVoti();
		Stream<String> listaMaterie = listaVoti.keySet().stream();
		long insufficienza = listaMaterie.filter(materia -> mediaVotoMateria(materia) < 6).count();
		if (insufficienza >= 4) {
			return false;
		} else {
			return true;
		}
	}
	
	public double mediaTotale() {
		double mediaTotale = 0;
		for (String materia : voti.keySet()) {
			mediaTotale += (this.getVoti().get(materia).stream().reduce(0.0, (voto, elemento) -> voto + elemento)
					/ this.getVoti().get(materia).size());
		}
		mediaTotale /= voti.size();
		return mediaTotale;
	}

	@Override
	public String toString() {
		return "\n Nome: " + nome + "\n Cognome: " + cognome + "\n Genere: " + genere + "\n Voti: " + voti + "\n";
	}
}
