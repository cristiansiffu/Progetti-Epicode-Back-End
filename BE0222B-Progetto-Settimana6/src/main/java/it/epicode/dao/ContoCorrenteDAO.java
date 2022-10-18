package it.epicode.dao;

import it.epicode.data.ContoCorrente;
import jakarta.ejb.Local;

@Local
public interface ContoCorrenteDAO {
	boolean versa(String numero, float quantita);
	public boolean preleva(String numero, float quantita);
	public boolean esiste(String numero);
	public ContoCorrente getContoCorrente(String numero);
}