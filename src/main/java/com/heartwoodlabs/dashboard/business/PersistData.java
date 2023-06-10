package com.heartwoodlabs.dashboard.business;

import com.heartwoodlabs.dashboard.dao.*;
import com.heartwoodlabs.dashboard.model.*;
import net.datafaker.Faker;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class  PersistData {

	private static boolean insertCliente = true;
	private static boolean insertProdotto = true;
	private static boolean insertVendita = true;
	private static boolean insertCampagna = true;

	public static void main(String[] args) throws Exception {
		BaseDao.initFactory();
		Faker faker = new Faker(Locale.ITALIAN);

		if (insertCliente) {
			ClienteDao dao = new ClienteDao();

			for (int i = 0; i < 50; i++) {
				Cliente cliente = new Cliente();
				cliente.setNome(faker.name().firstName());
				cliente.setCognome(faker.name().lastName());
				cliente.setCodiceFiscale(faker.bothify("????????????????", true));
				cliente.setDataRegistrazione(faker.date().past(365, TimeUnit.DAYS).toLocalDateTime());

				dao.save(cliente);
			}
		}

		if (insertProdotto) {
			CategoriaDao categoriaDao = new CategoriaDao();
			ProdottoDao prodottoDao = new ProdottoDao();

			for (int i = 0; i < 50; i++) {
				Prodotto prodotto = new Prodotto();
				prodotto.setNome(faker.commerce().productName());

				NumberFormat format = NumberFormat.getInstance(Locale.ITALIAN);
				prodotto.setPrezzo(BigDecimal.valueOf(format.parse(faker.commerce().price()).doubleValue()));

				Categoria categoria = new Categoria();
				categoria.setNome(faker.commerce().department());
				prodotto.setCategoria(categoria);

				categoriaDao.save(categoria);
				prodottoDao.save(prodotto);
			}
		}

		if (insertVendita) {
			List<Cliente> clienti = new ClienteDao().getAll(Cliente.class);
			List<Prodotto> prodotti = new ProdottoDao().getAll(Prodotto.class);
			List<Articolo> articoli = new ArrayList<>();

			ArticoloDao articoloDao = new ArticoloDao();
			VenditaDao venditaDao = new VenditaDao();

			for (Prodotto prodotto : prodotti) {
				Articolo articolo = new Articolo();
				articolo.setQuantita(faker.number().numberBetween(1, 5));
				articolo.setProdotto(prodotto);
				articolo.setPrezzo(prodotto.getPrezzo().multiply(BigDecimal.valueOf(articolo.getQuantita())));

				articoloDao.save(articolo);
				articoli.add(articolo);
			}

			for (Cliente cliente : clienti) {
				Vendita vendita = new Vendita();
				vendita.setData(faker.date().past(90, TimeUnit.DAYS).toLocalDateTime());
				vendita.setCliente(cliente);

				int articoliVenduti = faker.number().numberBetween(1, 10);
				for (int i = 0; i < articoliVenduti; i++) {
					int indiceRandom = faker.random().nextInt(0, articoli.size() - 1);
					vendita.getArticoli().add(articoli.get(indiceRandom));
				}

				BigDecimal prezzo = BigDecimal.ZERO;
				for (Articolo articolo : vendita.getArticoli()) {
					prezzo = prezzo.add(articolo.getPrezzo());
				}
				vendita.setPrezzo(prezzo);

				venditaDao.save(vendita);
			}
		}

		if (insertCampagna) {
			CampagnaDao campagnaDao = new CampagnaDao();
			VenditaDao venditaDao = new VenditaDao();

			for (int i = 0; i < 500; i++) {
				Campagna campagna = new Campagna();
				campagna.setNome(faker.marketing().buzzwords());
				campagna.setPrezzo(BigDecimal.valueOf(NumberFormat.getInstance(Locale.ITALIAN).parse(faker.commerce().price()).doubleValue()));
				campagna.setData(faker.date().past(90, TimeUnit.DAYS).toLocalDateTime());

				campagnaDao.save(campagna);
			}
		}

		BaseDao.shutdownFactory();
	}
}
