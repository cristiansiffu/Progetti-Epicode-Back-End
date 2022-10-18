import java.util.Date;
import java.util.Scanner;

import articolo.Articolo;
import articolo.ArticoloFantasy;
import articolo.ArticoloNoir;
import articolo.Autore;
import articolo.BlogImp;
import articolo.Tags;
import articolo.interfacce.Blog;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Autore cristian = new Autore(0, "Cristian", "Siffu");
		Tags hashtags1 = new Tags(new String[] { "Non", "so", "cosa", "scrivere" });
		Tags hashtags2 = new Tags(new String[] { "Boh", "scrivo", "a", "caso" });
		Articolo articolo1 = new Articolo(0, "Titolo1", new Date(), "Fantasy", "Testo1", cristian, hashtags1);
		Articolo articolo2 = new Articolo(1, "Titolo2", new Date(), "Noir", "Testo2", cristian, hashtags2);
		Articolo articolo3 = new ArticoloFantasy(2, "Titolo3", new Date(), "Testo3", cristian, hashtags1);
		Articolo articolo4 = new ArticoloNoir(3, "Titolo4", new Date(), "Testo4", cristian, hashtags2);

		BlogImp blog = new BlogImp(new Articolo[] { articolo1, articolo2, articolo3, articolo4 });

		opzioneStampa(blog);
	}

	static void opzioneStampa(Blog blog) {
		System.out.println("Opzioni di stampa: " + "\n" + "1 per stampare tutti gli articoli" + "\n"
				+ "2 per stampare gli articoli in base all'ID selezionato" + "\n");
		Scanner scanner = new Scanner(System.in);
		int opzione = Integer.parseInt(scanner.nextLine());
		if (opzione == 1) {
			System.out.println("Articoli stampati correttamente" + "\n");
			blog.stampaArticoli();
		} else if (opzione == 2) {
			System.out.println("Scegli l'ID dell'articolo che vuoi visualizzare: " + "\n");
			int opzionePerId = Integer.parseInt(scanner.nextLine());
			blog.stampaArticoloPerId(opzionePerId);
		}
		opzioneStampa(blog);
	}
}
