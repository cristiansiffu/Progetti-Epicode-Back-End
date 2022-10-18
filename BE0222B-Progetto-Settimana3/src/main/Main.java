package main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import classi.Scuola;
import classi.Studente;
import classi.ThreadScuola;

public class Main {
	
	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File fileScuola = new File("src/scuola.txt");
		logger.info("Cristian Siffu");
		
		Studente cristian1 = new Studente(0, "Cristian", "Siffu", 'M');
		Studente daniele1 = new Studente(1, "Daniele", "Liburdi", 'M');
		Studente luigi1 = new Studente(2, "Luigi", "Catania", 'F');
		Studente adam1 = new Studente(3, "Adam", "Losio", 'F');
		Studente francesco1 = new Studente(4, "Francesco", "Giorgiò", 'M');
		
		Studente cristian2 = new Studente(5, "Cristian2", "Siffu2", 'M');
		Studente daniele2 = new Studente(6, "Daniele2", "Liburdi2", 'M');
		Studente luigi2 = new Studente(7, "Luigi2", "Catania2", 'F');
		Studente adam2 = new Studente(8, "Adam2", "Losio2", 'F');
		Studente francesco2 = new Studente(9, "Francesco2", "Giorgiò2", 'M');
		
		List<Studente> listaStudenti1 = new ArrayList<>();
        listaStudenti1.add(cristian1);
        listaStudenti1.add(daniele1);
        listaStudenti1.add(luigi1);
        listaStudenti1.add(adam1);
        listaStudenti1.add(francesco1);
        
        List<Studente> listaStudenti2 = new ArrayList<>();
        listaStudenti2.add(cristian2);
        listaStudenti2.add(daniele2);
        listaStudenti2.add(luigi2);
        listaStudenti2.add(adam2);
        listaStudenti2.add(francesco2);
		
        
        Scuola scuola1 = new Scuola(listaStudenti1);
		Scuola scuola2 = new Scuola(listaStudenti2);
		
		ThreadScuola threadScuola1 = new ThreadScuola(scuola1);
		ThreadScuola threadScuola2 = new ThreadScuola(scuola2);
		
		scuola1.salvaStudenti(fileScuola);
		scuola2.salvaStudenti(new File("src/scuola2.txt"));
		
		Thread thread1 = new Thread(threadScuola1);
        Thread thread2 = new Thread(threadScuola2);
        
        thread1.start();
        thread2.start();
	}
	
}
