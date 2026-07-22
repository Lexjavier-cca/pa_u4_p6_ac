package ec.edu.uce.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class MailService {
    
    public void enviarMail(String destino, String asunto, String cuerpo){
        System.out.println("id de hilo con mail" + Thread.currentThread().threadId());
        System.out.print("Se envia un mail a la cuenta de destino " + destino);
    }
}
