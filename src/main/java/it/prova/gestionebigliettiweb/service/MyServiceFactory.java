package it.prova.gestionebigliettiweb.service;

import it.prova.gestionebigliettiweb.dao.BigliettoDAO;
import it.prova.gestionebigliettiweb.dao.BigliettoDAOImpl;

public class MyServiceFactory {

	// implementiamo il singleton in modo da evitare
	// proliferazione di riferimenti
	private static BigliettoService BIGLIETTO_SERVICE_INSTANCE = null;
	private static BigliettoDAO BIGLIETTODAO_INSTANCE = null;

	public static BigliettoService getBigliettoServiceInstance() {
		if (BIGLIETTO_SERVICE_INSTANCE == null)
			BIGLIETTO_SERVICE_INSTANCE = new BigliettoServiceImpl();

		if (BIGLIETTODAO_INSTANCE == null)
			BIGLIETTODAO_INSTANCE = new BigliettoDAOImpl();

		BIGLIETTO_SERVICE_INSTANCE.setBigliettoDao(BIGLIETTODAO_INSTANCE);

		return BIGLIETTO_SERVICE_INSTANCE;
	}

}
