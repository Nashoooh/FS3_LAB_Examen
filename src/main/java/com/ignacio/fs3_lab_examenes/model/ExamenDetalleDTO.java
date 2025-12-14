package com.ignacio.fs3_lab_examenes.model;

import java.time.LocalDate;

public class ExamenDetalleDTO {
    private Long id;
    private LocalDate fechaExamen;
    private Long usuarioId;
    private String resultado;
    private Long laboratorioId;
    private String laboratorioDireccion;
    private Long analisisId;
    private String analisisNombre;
    private String analisisDescripcion;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getFechaExamen() { return fechaExamen; }
    public void setFechaExamen(LocalDate fechaExamen) { this.fechaExamen = fechaExamen; }
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public String getResultado() { return resultado; }
    public void setResultado(String resultado) { this.resultado = resultado; }
    public Long getLaboratorioId() { return laboratorioId; }
    public void setLaboratorioId(Long laboratorioId) { this.laboratorioId = laboratorioId; }
    public String getLaboratorioDireccion() { return laboratorioDireccion; }
    public void setLaboratorioDireccion(String laboratorioDireccion) { this.laboratorioDireccion = laboratorioDireccion; }
    public Long getAnalisisId() { return analisisId; }
    public void setAnalisisId(Long analisisId) { this.analisisId = analisisId; }
    public String getAnalisisNombre() { return analisisNombre; }
    public void setAnalisisNombre(String analisisNombre) { this.analisisNombre = analisisNombre; }
    public String getAnalisisDescripcion() { return analisisDescripcion; }
    public void setAnalisisDescripcion(String analisisDescripcion) { this.analisisDescripcion = analisisDescripcion; }
}
