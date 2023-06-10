package com.heartwoodlabs.dashboard.business;

import com.heartwoodlabs.dashboard.dao.ArticoloDao;
import com.heartwoodlabs.dashboard.dao.CampagnaDao;
import com.heartwoodlabs.dashboard.dao.ClienteDao;
import com.heartwoodlabs.dashboard.dao.VenditaDao;
import com.heartwoodlabs.dashboard.dto.*;
import com.heartwoodlabs.dashboard.model.Cliente;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class ChartManager {

	public static ChartDto nuoviClient(int limit) {
		ChartDto res = new ChartDto(ChartDto.ChartType.TABLE);
		res.setTitle("Nuovi clienti");
		res.setSubtitle("Aggiornato al " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
		res.getLabels().addAll(Arrays.asList("Cognome", "Nome", "Codice fiscale", "Data di registrazione"));

		ChartSerieDto serie = new ChartSerieDto();
		serie.setLabel("Anagrafica clienti");
		res.getSeries().add(serie);

		List<Cliente> clienti = new ClienteDao().getAll(limit);
		for (Cliente cliente : clienti) {
			ClienteDto dto = new ClienteDto(cliente.getNome(), cliente.getCognome(), cliente.getCodiceFiscale(), cliente.getDataRegistrazione().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
			serie.getData().add(dto);
		}

		return res;
	}

	public static ChartDto venditeMensili(int anno, int mese) {
		ChartDto res = new ChartDto(ChartDto.ChartType.BASIC_LINE);
		res.setTitle("Vendite del " + mese + "/" + anno);
		res.setSubtitle("Aggiornato al " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
		res.getLabels().addAll(Arrays.asList("Totale", "Giorno"));

		ChartSerieDto serie = new ChartSerieDto();
		serie.setLabel("Vendite");
		res.getSeries().add(serie);

		List<VenditaMensileDto> vendite = new VenditaDao().venditeMensili(anno, mese);
		serie.getData().add(vendite);

		return res;
	}

	public static ChartDto articoliPiuVenduti(int limit) {
		ChartDto res = new ChartDto(ChartDto.ChartType.BASIC_LINE);
		res.setTitle("Articoli più venduti");
		res.setSubtitle("Aggiornato al " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
		res.getLabels().addAll(Arrays.asList("Quantità", "Nome"));

		ChartSerieDto serie = new ChartSerieDto();
		serie.setLabel("Vendite");
		res.getSeries().add(serie);

		List<ArticoloDto> articoli = new ArticoloDao().articoliPiuVenduti(limit);
		serie.getData().add(articoli);

		return res;
	}

	public static ChartDto venditeClienti(int limit) {
		ChartDto res = new ChartDto(ChartDto.ChartType.BASIC_LINE);
		res.setTitle("Clienti che spendono di più");
		res.setSubtitle("Aggiornato al " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
		res.getLabels().addAll(Arrays.asList("Totale", "Cliente"));

		ChartSerieDto serie = new ChartSerieDto();
		serie.setLabel("Clienti");
		res.getSeries().add(serie);

		List<VenditaClienteDto> clienti = new VenditaDao().venditeClienti(limit);
		serie.getData().add(clienti);

		return res;
	}

	public static ChartDto costiVenditeMensili(int anno, int mese) {
		ChartDto res = new ChartDto(ChartDto.ChartType.DUAL_AXIS);
		res.setTitle("Vendite/costi del " + mese + "/" + anno);
		res.setSubtitle("Aggiornato al " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
		res.getLabels().addAll(Arrays.asList("Totale", "Giorno"));

		ChartSerieDto serie = new ChartSerieDto();
		serie.setLabel("Costi");
		res.getSeries().add(serie);

		List<CostoMensileDto> costi = new CampagnaDao().costiMensili(anno, mese);
		serie.getData().add(costi);

		serie = new ChartSerieDto();
		serie.setLabel("Vendite");
		res.getSeries().add(serie);

		List<VenditaMensileDto> vendite = new VenditaDao().venditeMensili(anno, mese);
		serie.getData().add(vendite);

		return res;
	}
}
