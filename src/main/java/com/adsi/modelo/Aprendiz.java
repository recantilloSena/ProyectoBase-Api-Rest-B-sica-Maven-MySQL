/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adsi.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author RICARDO
 */
public class Aprendiz {

    
    
    private Integer idAprendices;
    private String apellido1;
    private String apellido2;
    private String nombres;
    private String documento;
    private Integer fkCurso;
    private String jornada;
    private String sexo;

    public Aprendiz() {
    }

    public Integer getIdAprendices() {
        return idAprendices;
    }

    public void setIdAprendices(Integer idAprendices) {
        this.idAprendices = idAprendices;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Integer getFkCurso() {
        return fkCurso;
    }

    public void setFkCurso(Integer fkCurso) {
        this.fkCurso = fkCurso;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    
    
    public static Aprendiz load(ResultSet rs)throws SQLException{
        Aprendiz aprendiz= new Aprendiz();
        
        aprendiz.setIdAprendices(rs.getInt(1));
        aprendiz.setApellido1(rs.getString(2));
        aprendiz.setApellido2(rs.getString(3));
        aprendiz.setNombres(rs.getString(4));
        aprendiz.setDocumento(rs.getString(5));
        aprendiz.setFkCurso(rs.getInt(6));  
        aprendiz.setJornada(rs.getString(7));
        aprendiz.setSexo(rs.getString(8));
        
                       
        return aprendiz;
    }
    
    
    
    
}
