package it.prova.gestionebigliettiweb.model;

import java.util.Date;

public class Biglietto {
	private Long id;
	private String provenienza;
	private String destinazione;
	private Date data;
	private int prezzo;

	public Biglietto() {
		super();
	}

	public Biglietto(String provenienza, String destinazione, Date data, int prezzo) {
		super();
		this.provenienza = provenienza;
		this.destinazione = destinazione;
		this.data = data;
		this.prezzo = prezzo;
	}

	public Biglietto(Long id, String provenienza, String destinazione, Date data, int prezzo) {
		super();
		this.id = id;
		this.provenienza = provenienza;
		this.destinazione = destinazione;
		this.data = data;
		this.prezzo = prezzo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProvenienza() {
		return provenienza;
	}

	public void setProvenienza(String provenienza) {
		this.provenienza = provenienza;
	}

	public String getDestinazione() {
		return destinazione;
	}

	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

}
