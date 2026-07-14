package ec.edu.uce.web.resource;

import ec.edu.uce.application.service.MailService;
import ec.edu.uce.domain.model.Mail;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

@Path("/mails")
public class MailResource {
    @Inject
    private MailService mailService;
    public Mail buscarPorId(Integer id){
        return this.mailService.buscarPorId(id);
    }

}
