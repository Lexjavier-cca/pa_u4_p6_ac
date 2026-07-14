package ec.edu.uce.application.service;

import java.util.List;

import ec.edu.uce.domain.model.Mail;
import ec.edu.uce.infraestructure.repository.MailRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class MailService {
    @Inject
    private MailRepositoryImpl mailRepositoryImpl;
    public List<Mail> buscarTodos(){
        return (List<Mail>) this.mailRepositoryImpl.findAll();
    }
    public void guardar(Mail mail){
        this.mailRepositoryImpl.persist(mail);
    }
    public Mail buscarPorId(Integer id){
        return this.mailRepositoryImpl.findById(id);
    }
    public void actualizar(Mail mail, Integer id){
        Mail mailBase = this.buscarPorId(id);
        mailBase.setAsunto(mail.getAsunto());
        mailBase.setCuerpo(mail.getCuerpo());
        mailBase.setDireccionDestino(mail.getDireccionDestino());
        mailBase.setDireccionOrigen(mail.getDireccionOrigen());
        mailBase.setPrioridad(mail.getPrioridad());

    }
    public void actualizar1(Mail mail){
        Mail mailBase = this.buscarPorId(mail.getId());
        mailBase.setAsunto(mail.getAsunto());
        mailBase.setCuerpo(mail.getCuerpo());
        mailBase.setDireccionDestino(mail.getDireccionDestino());
        mailBase.setDireccionOrigen(mail.getDireccionOrigen());
        mailBase.setPrioridad(mail.getPrioridad());
        
    }
    public void eliminar(Mail mail){
        this.mailRepositoryImpl.delete(this.buscarPorId(mail.getId()));
    }


}
