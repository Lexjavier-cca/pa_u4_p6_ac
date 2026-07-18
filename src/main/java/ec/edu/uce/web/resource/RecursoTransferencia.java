package ec.edu.uce.web.resource;

import ec.edu.uce.application.service.TransferenciaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/transferencia")
public class RecursoTransferencia {
    @Inject
    private TransferenciaService ts;
    @Path("/realizar")
    @POST
    public String realizar(TransferenciaResource transferencia){
        return this.ts.realizar(transferencia.getCuentaOrigen(), transferencia.getCuentaDestino(), transferencia.getMonto());

    }

    @Path("/realizarReactiva")
    @POST
    public String realizarReactiva(TransferenciaResource transferencia){
        return this.ts.realizarReactiva(transferencia.getCuentaOrigen(), transferencia.getCuentaDestino(), transferencia.getMonto());
    }
}
