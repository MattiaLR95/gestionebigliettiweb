package it.prova.gestionebigliettiweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.prova.gestionebigliettiweb.model.*;

@WebServlet("/PrepareInsertBigliettoServlet")
public class PrepareInsertBigliettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//metto un bean 'vuoto' in request perché per la pagina risulta necessario
		request.setAttribute("insert_biglietto_attr", new Biglietto());
		request.getRequestDispatcher("/biglietto/insert.jsp").forward(request, response);

	}

}
