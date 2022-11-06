package it.prova.gestionebigliettiweb.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionebigliettiweb.model.Biglietto;

//nel nome della classe vi è Articolo in quanto è una classe specifica
public class UtilityBigliettoForm {

	public static Biglietto createBigliettoFromParams(String provenienzaInputParam, String destinazioneInputParam,
			String dataStringParam, String prezzoInputStringParam) {

		Biglietto result = new Biglietto(provenienzaInputParam, destinazioneInputParam);

		if (NumberUtils.isCreatable(prezzoInputStringParam)) {
			result.setPrezzo(Integer.parseInt(prezzoInputStringParam));
		}
		result.setData(parseDateFromString(dataStringParam));

		return result;
	}

	public static Biglietto createBigliettoFromParamsConId(String idInputParam, String provenienzaInputParam,
			String destinazioneInputParam, String dataStringParam, String prezzoInputStringParam) {

		Biglietto result = new Biglietto(provenienzaInputParam, destinazioneInputParam);

		if (NumberUtils.isCreatable(prezzoInputStringParam)) {
			result.setPrezzo(Integer.parseInt(prezzoInputStringParam));
		}
		result.setData(parseDateFromString(dataStringParam));

		return result;
	}

	public static boolean validateBigliettoBean(Biglietto bigliettoToBeValidated) {
		// prima controlliamo che non siano vuoti i parametri
		if (StringUtils.isBlank(bigliettoToBeValidated.getProvenienza())
				|| StringUtils.isBlank(bigliettoToBeValidated.getDestinazione())
				|| bigliettoToBeValidated.getPrezzo() == null || bigliettoToBeValidated.getPrezzo() < 1
				|| bigliettoToBeValidated.getData() == null) {
			return false;
		}
		return true;
	}

	public static Date parseDateFromString(String dataStringParam) {
		if (StringUtils.isBlank(dataStringParam))
			return null;

		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dataStringParam);
		} catch (ParseException e) {
			return null;
		}
	}

}
