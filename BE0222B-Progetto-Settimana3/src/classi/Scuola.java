package classi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;

public class Scuola {
	private List<Studente> scuola;

	public Scuola(List<Studente> scuola) {
		this.scuola = scuola;
	}

	public List<Studente> getScuola() {
		return this.scuola = scuola;
	}

	public List<Studente> getPromossi() {
		List<Studente> listaPromossi = new ArrayList<>();
		Stream<Studente> studentePromosso = getScuola().stream();
        studentePromosso.filter(studente -> studente.promosso()).forEach(listaPromossi::add);
		return listaPromossi;
	}

	public List<Studente> getStudenti() {
		return scuola;
	}

	public Studente getStudenteMigliore() {
		return scuola.stream().reduce(scuola.get(0),
				(migliore, studente) -> migliore = studente.mediaTotale() > migliore.mediaTotale() ? studente : migliore);
	}
	
	public Studente getStudente(int id) {
		Studente studente = scuola.get(id);
		return studente;
	}

	@SuppressWarnings("deprecation")
	public void salvaStudenti(File file) {
		String studenti = "";
		for(int i = 0; i < getStudenti().size(); i++) {
			studenti += getStudente(i).toString();
		}
		try {
			FileUtils.writeStringToFile(file, studenti, "UTF-8");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
