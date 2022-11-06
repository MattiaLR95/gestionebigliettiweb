package it.prova.gestionebigliettiweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionebigliettiweb.service.MyServiceFactory;

/**
 * Servlet implementation class PrepareUpdateBigliettoServlet
 */
@WebServlet("/PrepareUpdateBigliettoServlet")
public class PrepareUpdateBigliettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idBigliettoParam = request.getParameter("idBiglietto");

		if (!NumberUtils.isCreatable(idBigliettoParam)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore123.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		try {
			request.setAttribute("update_biglietto_attr", MyServiceFactory.getBigliettoServiceInstance()
					.caricaSingoloElemento(Long.parseLong(idBigliettoParam)));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/biglietto/update.jsp").forward(request, response);

	}

}