package articolo;

import java.util.Date;

public class Articolo {
	private int id;
	private String titolo;
	private Date data;
	private String categoria;
	private String testo;
	private Autore autore;
	private Tags tags;

	public Articolo(int id, String titolo, Date data, String categoria, String testo, Autore autore, Tags tags) {
		this.id = id;
		this.titolo = titolo;
		this.data = data;
		this.categoria = categoria;
		this.testo = testo;
		this.autore = autore;
		this.tags = tags;
	}

	public Articolo(int id2, String titolo2, Date data2, String testo2, Autore autore2, Tags tags2) {
		// TODO Auto-generated constructor stub
		this.id = id2;
		this.titolo = titolo2;
		this.data = data2;
		this.testo = testo2;
		this.autore = autore2;
		this.tags = tags2;
	}

	public int getId() {
		return id;
	}

	public String getTitolo() {
		return titolo;
	}

	public Date getData() {
		return data;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTesto() {
		return testo;
	}

	public Autore getAutore() {
		return autore;
	}

	public Tags getTags() {
		return tags;
	}

	@Override
	public String toString() {
		String stringa = "";
		stringa = "*************************" + "\n" + "Titolo: " + this.titolo + "\n" + "Data: " + this.data + "\n" + "Categoria: " + this.categoria + "\n"
				+ "Testo: " + this.testo + "\n" + "Autore: " + this.autore.getNome() + " " + this.autore.getCognome()
				+ "\n" + "Tags: " + this.tags.toString() + "\n" + "*************************" + "\n";
		return stringa;
	}

}
