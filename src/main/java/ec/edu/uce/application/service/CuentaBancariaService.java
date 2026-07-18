package ec.edu.uce.application.service;

import java.math.BigDecimal;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CuentaBancariaService {
    public BigDecimal agregarMonto(String numeroCuenta, BigDecimal monto){
        System.out.println("id de hilo de agregar" + Thread.currentThread().threadId());
        BigDecimal saldo = BigDecimal.valueOf(1000);
        saldo = saldo.add(monto);
        return saldo;
    }
    public BigDecimal restarMonto(String numeroCuenta, BigDecimal monto){
        System.out.println("id de hilo de restar" + Thread.currentThread().threadId());
        BigDecimal saldo = BigDecimal.valueOf(2200);
        saldo = saldo.subtract(monto);
        return saldo;
    }
    public Uni<BigDecimal> agregarMontoPromesa(String numeroCuenta, BigDecimal monto){
        System.out.println("id de hilo de agregar promesa" + Thread.currentThread().threadId());
        return  Uni.createFrom().item(this.agregarMonto(numeroCuenta, monto));
    }
    public Uni<BigDecimal> restarMontoPromesa(String numeroCuenta, BigDecimal monto){
        System.out.println("id de hilo de restar promesa" + Thread.currentThread().threadId());
        return Uni.createFrom().item(() -> {
            //todolo que demora en ejecutar
            return this.restarMonto(numeroCuenta, monto);
        });
    }
}
