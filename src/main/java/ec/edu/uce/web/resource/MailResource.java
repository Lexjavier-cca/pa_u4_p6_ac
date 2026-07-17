package ec.edu.uce.web.resource;

import java.util.List;

import ec.edu.uce.application.service.MailService;
import ec.edu.uce.domain.model.Mail;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/mails")
public class MailResource {
    @Inject
    private MailService mailService;
    @Path("/buscarPorId/{id}")
    @GET
    public Mail buscarPorId(@PathParam("id") Integer id){
        return this.mailService.buscarPorId(id);
    }
    @Path("/todos")
    @GET
    public List<Mail> buscarTodos(){
        return this.mailService.buscarTodos();
    }

    @Path("/guardar")
    @POST
    public void guardar(Mail mail){
        this.mailService.guardar(mail);
    }
    
    @Path("/actualizar/{id}")
    @PUT
    public void actualizar(Mail mail, @PathParam("id") Integer id){
        this.mailService.actualizar(mail, id);
    }

    @Path("/eliminar/{id}")
    @DELETE
    public void eliminar(@PathParam("id") Integer id){
        this.mailService.eliminar(id);
    }

}
