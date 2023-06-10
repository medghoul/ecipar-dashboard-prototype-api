package com.heartwoodlabs.dashboard.rs;

import com.heartwoodlabs.dashboard.business.ChartManager;
import com.heartwoodlabs.dashboard.dto.ChartDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/charts")
public class ChartResource {
    private static final Logger log= LogManager.getLogger(ChartResource.class);
	@GET
	@Path("/ultimiClienti/{limit}")
	public Response ultimiClienti(@PathParam("limit") int limit) {
		log.debug("Richiesta degli ultimi {} clienti",limit);
		ChartDto chart = ChartManager.nuoviClient(limit);
		return Utility.buildOkResponse(chart);
	}

	@GET
	@Path("/venditeMensili/{anno}/{mese}")
	public Response venditeMensili(@PathParam("anno") int anno, @PathParam("mese") int mese) {
		ChartDto chart = ChartManager.venditeMensili(anno, mese);
		return Utility.buildOkResponse(chart);
	}

	@GET
	@Path("/articoliPiuVenduti/{limit}")
	public Response articoliPiuVenduti(@PathParam("limit") int limit) {
		ChartDto chart = ChartManager.articoliPiuVenduti(limit);
		return Utility.buildOkResponse(chart);
	}

	@GET
	@Path("/venditeClienti/{limit}")
	public Response venditeClienti(@PathParam("limit") int limit) {
		ChartDto chart = ChartManager.venditeClienti(limit);
		return Utility.buildOkResponse(chart);
	}

	@GET
	@Path("/costiVenditeMensili/{anno}/{mese}")
	public Response costiVenditeMensili(@PathParam("anno") int anno, @PathParam("mese") int mese) {
		ChartDto chart = ChartManager.costiVenditeMensili(anno, mese);
		return Utility.buildOkResponse(chart);
	}
}
