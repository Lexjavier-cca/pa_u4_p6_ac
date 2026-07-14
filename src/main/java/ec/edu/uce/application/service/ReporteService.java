package ec.edu.uce.application.service;

import java.util.List;

import ec.edu.uce.domain.model.Reporte;
import ec.edu.uce.infraestructure.repository.ReporteRepositoryImpl;
//import ec.edu.uce.application.service.interceptors.AuditorCreacion;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
@ApplicationScoped
@Transactional
public class ReporteService {
    @Inject
    private ReporteRepositoryImpl reporteRepositoryImpl;
    public List<Reporte> buscarTodos(){
        return (List<Reporte>) this.reporteRepositoryImpl.findAll();
    }
    public Reporte buscarPorId(Integer id){
        return this.reporteRepositoryImpl.findById(id);
    }   
    public void guardar(Reporte reporte){
        this.reporteRepositoryImpl.persist(reporte);
    }
    public void actualizar(Reporte reporte, Integer id){
        Reporte reporteBase = this.buscarPorId(id);
        reporteBase.setAutor(reporte.getAutor());
        reporteBase.setCantidadPalabras(reporte.getCantidadPalabras());
        reporteBase.setCuerpo(reporte.getCuerpo());
        reporteBase.setTitulo(reporte.getTitulo());
        reporteBase.setObservacion(reporte.getObservacion());
        //no hace falta realizar explicitamente el update
    }
    public void actualizar1(Reporte reporte){
        Reporte reporteBase = this.buscarPorId(reporte.getId());
        reporteBase.setAutor(reporte.getAutor());
        reporteBase.setAutor(reporte.getAutor());
        reporteBase.setCantidadPalabras(reporte.getCantidadPalabras());
        reporteBase.setCuerpo(reporte.getCuerpo());
        reporteBase.setTitulo(reporte.getTitulo());
        reporteBase.setObservacion(reporte.getObservacion());
    }
    public void eliminar(Reporte reporte){
        this.reporteRepositoryImpl.delete(this.buscarPorId(reporte.getId()));
    }
    
}

