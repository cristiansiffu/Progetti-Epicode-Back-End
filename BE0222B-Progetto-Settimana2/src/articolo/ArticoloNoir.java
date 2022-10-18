package articolo;

import java.util.Date;

public class ArticoloNoir extends Articolo {

	private String descrizione;

	public ArticoloNoir(int id, String titolo, Date data, String testo, Autore autore, Tags tags) {
		super(id, titolo, data, testo, autore, tags);
		// TODO Auto-generated constructor stub
		this.descrizione = "Un articolo noir";
		this.setCategoria("Noir");
	}

	@Override
	public String toString() {
		String stringa = "";
		stringa = "*************************" + "\n" + "Titolo: " + super.getTitolo() + "\n" + "Data: " + super.getData() + "\n" + "Categoria: "
				+ super.getCategoria() + "\n" + "Descrizione: " + this.descrizione + "\n" + "Testo: " + super.getTesto()
				+ "\n" + "Autore: " + super.getAutore().getNome() + " " + super.getAutore().getCognome() + "\n"
				+ "Tags: " + super.getTags().toString() + "\n" + "*************************" + "\n";
		return stringa;
	}
}
