package classi;

import java.util.logging.Logger;

import org.slf4j.LoggerFactory;

public class ThreadScuola implements Runnable {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(ThreadScuola.class);
	private Scuola scuola;

	public ThreadScuola(Scuola scuola) {
		this.scuola = scuola;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < scuola.getStudenti().size(); i++) {
			logger.info(scuola.getStudente(i).toString());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
