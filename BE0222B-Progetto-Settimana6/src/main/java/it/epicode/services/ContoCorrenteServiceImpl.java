package it.epicode.services;

import it.epicode.dao.ContoCorrenteDAO;
import it.epicode.data.ContoCorrente;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

@Stateless
@LocalBean
public class ContoCorrenteServiceImpl implements ContoCorrenteService {

	@EJB
	private ContoCorrenteDAO dao;

	@Override
	public boolean controllaOperazione(String operazione, String numero, float quantita) {
		if (operazione.equals("preleva") && quantita > 0 && dao.esiste(numero)
				&& dao.getContoCorrente(numero).getSaldo() > quantita) {
			return true;
		} else if (operazione.equals("versa") && quantita > 0 && dao.esiste(numero)) {
			return true;
		}
		return false;
	}

	public ContoCorrente getContoCorrente(String numero) {
		return dao.getContoCorrente(numero);
	}

	@Override
	public boolean versa(String numero, float quantita) {
		if (controllaOperazione("versa", numero, quantita)) {
			dao.versa(numero, quantita);
			return true;
		}
		return false;
	}

	@Override
	public boolean preleva(String numero, float quantita) {
		if (controllaOperazione("preleva", numero, quantita)) {
			dao.preleva(numero, quantita);
			return true;
		}
		return false;
	}

}
