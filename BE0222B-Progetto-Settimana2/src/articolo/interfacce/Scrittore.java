package articolo.interfacce;

import java.util.Date;

import articolo.Tags;

public interface Scrittore {
	public void scriviArticolo(String titolo, String categoria, String testo, Tags tags);
}
