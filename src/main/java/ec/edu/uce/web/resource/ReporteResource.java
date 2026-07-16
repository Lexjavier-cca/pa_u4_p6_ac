package ec.edu.uce.web.resource;

import java.util.List;

import ec.edu.uce.application.service.ReporteService;
import ec.edu.uce.domain.model.Reporte;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/reportes")
public class ReporteResource {
    @Inject
    private ReporteService reporteService;

    // http://localhost:8080/reportes/todos
    @Path("/todos")
    @GET
    public List<Reporte> buscarTodos(){
        return this.reporteService.buscarTodos();
    }
    
    @Path("/porid/{id}")
    @GET
    public Reporte buscarPorId(@PathParam(value = "id") Integer id){
        return this.reporteService.buscarPorId(id);
    }
    @Path("/guardar")
    @POST
    public void guardar(Reporte reporte){
        this.reporteService.guardar(reporte);
    }
    @Path("/actualizar/{id}")
    @PUT
    public void actualizar(Reporte reporte, @PathParam("id") Integer id){
        this.reporteService.actualizar(reporte, id);
    }
    @Path("/eliminar/{id}")
    @DELETE
    public void eliminar(@PathParam ("id") Integer id){
        this.reporteService.eliminar(id);
    }

}
