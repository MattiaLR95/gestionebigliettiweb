package it.prova.gestionebigliettiweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionebigliettiweb.service.MyServiceFactory;
import it.prova.gestionebigliettiweb.model.Biglietto;
import it.prova.gestionebigliettiweb.utility.UtilityBigliettoForm;

@WebServlet("/ExecuteInsertBigliettoServlet")
public class ExecuteInsertBigliettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteInsertBigliettoServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// estraggo input
		String provenienzaInputParam = request.getParameter("provenienza");
		String destinazioneInputParam = request.getParameter("destinazione");
		String prezzoInputStringParam = request.getParameter("prezzo");
		String dataStringParam = request.getParameter("data");

		// preparo un bean (che mi serve sia per tornare in pagina
		// che per inserire) e faccio il binding dei parametri
		Biglietto articoloInstance = UtilityBigliettoForm.createBigliettoFromParams(provenienzaInputParam,
				destinazioneInputParam, dataStringParam, prezzoInputStringParam);

		 //se la validazione non risulta ok
		if (!UtilityBigliettoForm.validateBigliettoBean(articoloInstance)) {
			request.setAttribute("insert_biglietto_attr", articoloInstance);
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/biglietto/insert.jsp").forward(request, response);
			return;
		}

		// se sono qui i valori sono ok quindi posso creare l'oggetto da inserire
		// occupiamoci delle operazioni di business
		try {
			MyServiceFactory.getBigliettoServiceInstance().inserisciNuovo(articoloInstance);
			request.setAttribute("listaBigliettiAttribute", MyServiceFactory.getBigliettoServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		// andiamo ai risultati
		request.getRequestDispatcher("/biglietto/results.jsp").forward(request, response);

	}

}
