package it.epicode.services;

import it.epicode.data.ContoCorrente;
import jakarta.ejb.Local;

@Local
public interface ContoCorrenteService {
	boolean controllaOperazione(String operazione, String numero, float quantita);
	public ContoCorrente getContoCorrente(String numero);
	public boolean versa(String numero, float quantita);
	public boolean preleva(String numero, float quantita);
}