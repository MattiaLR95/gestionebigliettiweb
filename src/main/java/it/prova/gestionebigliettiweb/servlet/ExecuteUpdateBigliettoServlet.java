package it.prova.gestionebigliettiweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionebigliettiweb.model.Biglietto;
import it.prova.gestionebigliettiweb.service.MyServiceFactory;
import it.prova.gestionebigliettiweb.utility.UtilityBigliettoForm;

/**
 * Servlet implementation class ExecuteUpdateBigliettoServlet
 */
@WebServlet("/ExecuteUpdateBigliettoServlet")
public class ExecuteUpdateBigliettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idInputParam = request.getParameter("idBiglietto");
		String provenienzaInputParam = request.getParameter("provenienza");
		String destinazioneInputParam = request.getParameter("destinazione");
		String prezzoInputStringParam = request.getParameter("prezzo");
		String dataStringParam = request.getParameter("data");

		Biglietto bigliettoInstance = UtilityBigliettoForm.createBigliettoFromParams(provenienzaInputParam,
				destinazioneInputParam, dataStringParam, prezzoInputStringParam);
		bigliettoInstance.setId(Long.parseLong(idInputParam));

		if (!UtilityBigliettoForm.validateBigliettoBean(bigliettoInstance)) {
			request.setAttribute("update_biglietto_attr", bigliettoInstance);
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/biglietto/update.jsp").forward(request, response);
			return;
		}

		if (!NumberUtils.isCreatable(idInputParam)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore11.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		try {
			MyServiceFactory.getBigliettoServiceInstance().aggiorna(bigliettoInstance);
			request.setAttribute("listaBigliettiAttribute", MyServiceFactory.getBigliettoServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/biglietto/results.jsp").forward(request, response);

	}
}