//c.v.
package it.epicode.dao;

import it.epicode.data.ContoCorrente;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Stateless
@LocalBean
public class ContoCorrenteDAOImpl implements ContoCorrenteDAO {

	@PersistenceContext(unitName = "ContoCorrentePU")
	private EntityManager em;

	@Override
	public boolean versa(String numero, float quantita) {
		if (esiste(numero)) {
			ContoCorrente cc = getContoCorrente(numero);
			cc.setSaldo(cc.getSaldo() + quantita);
			em.merge(cc);
			return true;
		}
		return false;
	}

	@Override
	public boolean preleva(String numero, float quantita) {
		if (esiste(numero)) {
			ContoCorrente cc = getContoCorrente(numero);
			if (cc.getSaldo() > quantita) {
				cc.setSaldo(cc.getSaldo() - quantita);
				em.merge(cc);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean esiste(String numero) {
		ContoCorrente conto = getContoCorrente(numero);
		if (conto != null) {
			return true;
		}
		return false;
	}

	@Override
	public ContoCorrente getContoCorrente(String numero) {
		return em.find(ContoCorrente.class, numero);
	}

}
