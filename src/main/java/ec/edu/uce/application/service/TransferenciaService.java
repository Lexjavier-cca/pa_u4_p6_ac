package ec.edu.uce.application.service;

import java.math.BigDecimal;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class TransferenciaService {
    @Inject
    private CuentaBancariaService cbs;
    @Inject
    private MailService ms;
    @Inject
    private AuditoriaService as;


    public String realizar(String cuentaOrigen, String cuentaDestino, BigDecimal monto){


        Long tiempoInicial = System.currentTimeMillis();
        BigDecimal saldoDestino  =this.cbs.agregarMonto(cuentaDestino, monto);
        BigDecimal saldoOrigen =  this.cbs.restarMonto(cuentaOrigen, monto);
        this.ms.enviarMail("PepitoPerez@gmail.com", "asunto", "Realizando el taller 35 ");
        this.as.guardar("auditoria");
        String msg = "Se realizo con exito, su saldo destino es: " + saldoDestino + " mientras que mi saldo origen es: " + saldoOrigen;
        Long tiempoFinal = System.currentTimeMillis();
        Long tiempos = (tiempoFinal - tiempoInicial);
        return msg + " " + " en " + tiempos + " ms" + " con el id de hilo " + Thread.currentThread().threadId();
    }

    public String realizarReactiva(String cuentaOrigen, String cuentaDestino, BigDecimal monto){

        System.out.println("id de hilo con realizar reactiva" + Thread.currentThread().threadId());
        Long tiempoInicial = System.currentTimeMillis();
        Uni<BigDecimal> saldoDestino  =this.cbs.agregarMontoPromesa(cuentaDestino, monto);
        Uni<BigDecimal> saldoOrigen =  this.cbs.restarMontoPromesa(cuentaOrigen, monto);
        this.ms.enviarMail("PepitoPerez@gmail.com", "asunto", "Realizando el taller 35 ");
        this.as.guardar("auditoria");

        
        
        Uni.combine().all().unis(saldoDestino,saldoOrigen).asTuple().map(resultado -> {
            String mensaje = "Se realizo con exito, su saldo destino es: " + saldoDestino + " mientras que mi saldo origen es: " + saldoOrigen;
            return mensaje;
                        
        }).toString();
        Long tiempoFinal = System.currentTimeMillis();
        Long tiempos = (tiempoFinal - tiempoInicial);
        return  " en tiempos " + tiempos + " ms " + " con el id de realizar transferencia promesa de  " + Thread.currentThread().threadId();
    }
}
