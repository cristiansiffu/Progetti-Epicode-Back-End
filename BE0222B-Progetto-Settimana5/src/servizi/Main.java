package servizi;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dati.Auto;
import dati.Infrazione;
import servizi.dao.AutoDAOImpl;
import servizi.dao.InfrazioneDAOImpl;

public class Main {
	private static final String IMPORTO = "Insert amount: ";
	private static final String MODELLO = "Insert car model: example -> 500";
	private static final String MARCA = "Insert car brand: example -> Fiat";
	private static final String TARGA = "Insert car number: example -> xxx123yyy";
	private static final String MENU = "\r\n" + "SELECT OPTION:" + "\r\n" + "1 -> Add car: " + "\r\n"
			+ "2 -> Add traffic violation (car must exists): " + "\r\n" + "3 -> Get car list DB: "
			+ "\r\n" + "4 -> Get car by car number (car must exists): " + "\r\n"
			+ "5 -> Get traffic violation by car number: " + "\r\n"
			+ "6 -> Delete traffic violation by ID: ";
	private static Logger log = LoggerFactory.getLogger(Main.class);
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		scelta();
	}

	public static void scelta() {
		while (true) {
			log.info(MENU);
			int n = Integer.parseInt(scan.nextLine());

			switch (n) {
			case 1: {
				inserisciAuto();
				break;
			}
			case 2: {
				inserisciInfrazione();
				break;
			}
			case 3: {
				getAllAuto();
				break;
			}
			case 4: {
				getAutoByTarga();
				break;
			}
			case 5: {
				getInfrazioniByTarga();
				break;
			}
			case 6: {
				deleteInfrazioniById();
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + n);
			}
		}
	}

	public static void inserisciAuto() {
		AutoDAOImpl dao = new AutoDAOImpl();
		Auto auto = new Auto();
		log.info(TARGA);
		auto.setTarga(scan.nextLine().toUpperCase());
		log.info(MARCA);
		auto.setMarca(scan.nextLine().toUpperCase());
		log.info(MODELLO);
		auto.setModello(scan.nextLine().toUpperCase());
		dao.inserisciAuto(auto);
	}

	public static void inserisciInfrazione() {
		InfrazioneDAOImpl dao = new InfrazioneDAOImpl();
		Infrazione i = new Infrazione();
		Date data = new Date(0, 0, 0);
		log.info("Set day: ");
		data.setDate(Integer.parseInt(scan.nextLine()));
		log.info("Set month: ");
		data.setMonth((Integer.parseInt(scan.nextLine())) - 1);
		log.info("Set year: ");
		data.setYear((Integer.parseInt(scan.nextLine())) - 1900);

		i.setData(data);
		log.info(MODELLO);
		i.setTipo(scan.nextLine());
		log.info(TARGA);
		i.setTarga_Auto(scan.nextLine().toUpperCase());
		log.info(IMPORTO);
		i.setImporto(Double.parseDouble(scan.nextLine()));
		dao.inserisciInfrazione(i);
	}

	public static void getAllAuto() {
		AutoDAOImpl dao = new AutoDAOImpl();
		List listaAuto = dao.getAllAuto();
		listaAuto.forEach(a -> log.info(a.toString()));

	}

	public static void getAutoByTarga() {
		AutoDAOImpl dao = new AutoDAOImpl();
		log.info(TARGA);
		log.info(dao.cercaAuto(scan.nextLine().toUpperCase()).toString());
	}

	public static void getInfrazioniByTarga() {
		InfrazioneDAOImpl dao = new InfrazioneDAOImpl();
		log.info(TARGA);
		dao.stampaDatiInfrazioniAuto(scan.nextLine().toUpperCase());
	}

	public static void deleteInfrazioniById() {
		InfrazioneDAOImpl dao = new InfrazioneDAOImpl();
		log.info("Insert traffic violation ID: ");
		dao.eliminaInfrazione(Integer.parseInt(scan.nextLine()));
	}

}
