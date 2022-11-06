package it.prova.gestionebigliettiweb.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionebigliettiweb.dao.BigliettoDAO;
import it.prova.gestionebigliettiweb.model.Biglietto;
import it.prova.gestionebigliettiweb.listener.LocalEntityManagerFactoryListener;

public class BigliettoServiceImpl implements BigliettoService {

	private BigliettoDAO bigliettoDAO;

	@Override
	public void setBigliettoDao(BigliettoDAO bigliettoDAO) {
		this.bigliettoDAO = bigliettoDAO;
	}

	@Override
	public List<Biglietto> listAll() throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			bigliettoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return bigliettoDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public Biglietto caricaSingoloElemento(Long idInput) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			bigliettoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return bigliettoDAO.findOne(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiorna(Biglietto input) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			bigliettoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			bigliettoDAO.update(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void inserisciNuovo(Biglietto input) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			bigliettoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			bigliettoDAO.insert(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void rimuovi(Long idArticoloToRemove) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			bigliettoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			bigliettoDAO.delete(bigliettoDAO.findOne(idArticoloToRemove));

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public List<Biglietto> findByExample(Biglietto input) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
