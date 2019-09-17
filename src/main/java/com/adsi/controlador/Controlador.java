/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adsi.controlador;

import com.adsi.modelo.Aprendiz;
import com.adsi.modelo.Curso;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author RICARDO
 */
public class Controlador extends Conexion{
    
    
    public LinkedList findAllAprendices( ) throws SQLException {
        if (!hayConexion()) {
            throw new SQLException(" No existe conexion abierta ");
        }
        
        
        PreparedStatement pst = null;
        ResultSet rst = null;
        LinkedList lista = new LinkedList();
        try {
            String query;
            query = "select * from aprendices order by id_aprendices desc ";    //Definir la consulta
            pst = con.prepareStatement(query);                      //Prepararla
                  
            rst = pst.executeQuery();                               //Ejecutarla 
            
            
            while (rst.next()) {
                lista.add(Aprendiz.load(rst));     //Recorre el RS y llena una lista
            }
            System.out.println("El Query " + query );
            
        }  finally {
            if (pst != null) {
                pst.close();
                pst = null;
            }
            if (rst != null) {
                rst.close();
                rst = null;
            }
        }
        return lista;                            //Retorna la lista llena
    }

    public LinkedList findByJornada( ) throws SQLException {
        if (!hayConexion()) {
            throw new SQLException(" No existe conexion abierta ");
        }
        
        
        PreparedStatement pst = null;
        ResultSet rst = null;
        LinkedList lista = new LinkedList();
        try {
            String query;
            query = "SELECT * FROM aprendices WHERE jornada ='T' ";    //Definir la consulta
            pst = con.prepareStatement(query);                      //Prepararla
                  
            rst = pst.executeQuery();                               //Ejecutarla 
            
            
            while (rst.next()) {
                lista.add(Aprendiz.load(rst));     //Recorre el RS y llena una lista
            }
            System.out.println("El Query " + query );
            
        }  finally {
            if (pst != null) {
                pst.close();
                pst = null;
            }
            if (rst != null) {
                rst.close();
                rst = null;
            }
        }
        return lista;                            //Retorna la lista llena
    }

    public LinkedList findAprendicesByFkCurso( Integer p_curso) throws SQLException {
        if (!hayConexion()) {
            throw new SQLException(" No existe conexion abierta ");
        }
        
        
        PreparedStatement pst = null;
        ResultSet rst = null;
        LinkedList lista = new LinkedList();
        try {
            String query;
            query = "SELECT * FROM aprendices where fk_curso= ? ";    //Definir la consulta
            pst = con.prepareStatement(query);                      //Prepararla
            pst.setInt(1, p_curso);     
            
            rst = pst.executeQuery();                               //Ejecutarla 
            
            
            while (rst.next()) {
                lista.add(Aprendiz.load(rst));     //Recorre el RS y llena una lista
            }
            System.out.println("El Query " + query );
            
        }  finally {
            if (pst != null) {
                pst.close();
                pst = null;
            }
            if (rst != null) {
                rst.close();
                rst = null;
            }
        }
        return lista;                            //Retorna la lista llena
    }
    
    
    
    public void adicionarAprendiz(Aprendiz aprendiz) throws SQLException, IOException {
        if (!hayConexion()) {
            throw new SQLException("SIN CONEXION");
        }
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            pst = con.prepareStatement("INSERT INTO `aprendices` "
                    + "(`apellido1`,`apellido2`, `nombres`, `documento`, `fk_curso`, `jornada`,`sexo`) "
                    + " VALUES (?, ?, ?, ?, ?, ?,?);  ");
                    pst.setString(1, aprendiz.getApellido1());
                    pst.setString(2, aprendiz.getApellido2());
                    pst.setString(3, aprendiz.getNombres());
                    pst.setString(4, aprendiz.getDocumento());
                    pst.setInt(5, aprendiz.getFkCurso());
                    pst.setString(6, aprendiz.getJornada());
                    pst.setString(7, aprendiz.getSexo());
           
            pst.execute();

        }catch(Exception Ex){
            System.out.println("Error en AdicionarDato : \n"+Ex);
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (rst != null) {
                rst.close();
            }
        }
    }

    
    
    
    public LinkedList findAllCursos( ) throws SQLException {
        if (!hayConexion()) {
            throw new SQLException(" No existe conexion abierta ");
        }
        
        
        PreparedStatement pst = null;
        ResultSet rst = null;
        LinkedList lista = new LinkedList();
        try {
            String query;
            query = "select * from cursos order by 2 asc ";    //Definir la consulta
            pst = con.prepareStatement(query);                      //Prepararla
                  
            rst = pst.executeQuery();                               //Ejecutarla 
            
            
            while (rst.next()) {
                lista.add(Curso.load(rst));     //Recorre el RS y llena una lista
            }
            System.out.println("El Query " + query );
            
        }  finally {
            if (pst != null) {
                pst.close();
                pst = null;
            }
            if (rst != null) {
                rst.close();
                rst = null;
            }
        }
        return lista;                            //Retorna la lista llena
    }
    
    
    public LinkedList findCursosById(Integer id_curso ) throws SQLException {
        if (!hayConexion()) {
            throw new SQLException(" No existe conexion abierta ");
        }
        
        
        PreparedStatement pst = null;
        ResultSet rst = null;
        LinkedList lista = new LinkedList();
        try {
            String query;
            query = "select * from cursos where id_curso = ? ";    //Definir la consulta
            pst = con.prepareStatement(query);                      //Prepararla
            pst.setInt(1, id_curso);
            rst = pst.executeQuery();                               //Ejecutarla 
            
            
            while (rst.next()) {
                lista.add(Curso.load(rst));     //Recorre el RS y llena una lista
            }
            System.out.println("El Query " + query );
            
        }  finally {
            if (pst != null) {
                pst.close();
                pst = null;
            }
            if (rst != null) {
                rst.close();
                rst = null;
            }
        }
        return lista;                            //Retorna la lista llena
    }
    
    
    
    
    public LinkedList Aprendicesxjornadaxcurso(String jornada,Integer curso ) throws SQLException {
        if (!hayConexion()) {
            throw new SQLException(" No existe conexion abierta ");
        }
        
        
        PreparedStatement pst = null;
        ResultSet rst = null;
        LinkedList lista = new LinkedList();
        try {
            String query;
            query = "SELECT * FROM aprendices where jornada = ? and fk_curso = ?";    //Definir la consulta
            pst = con.prepareStatement(query);
            pst.setString(1, jornada); 
            pst.setInt(2,curso);//Prepararla
                  
            rst = pst.executeQuery();
            //Ejecutarla 
            
            
            while (rst.next()) {
                lista.add(Aprendiz.load(rst));     //Recorre el RS y llena una lista
            }
            System.out.println("El Query " + query );
            
        }  finally {
            if (pst != null) {
                pst.close();
                pst = null;
            }
            if (rst != null) {
                rst.close();
                rst = null;
            }
        }
        return lista;                            //Retorna la lista llena
    }
    
    
     public LinkedList findAprendicesByDocumento(String documento ) throws SQLException {
        if (!hayConexion()) {
            throw new SQLException(" No existe conexion abierta ");
        }
        
        
        PreparedStatement pst = null;
        ResultSet rst = null;
        LinkedList lista = new LinkedList();
        try {
            String query;
            query = "SELECT * FROM aprendices where documento = ? ";    //Definir la consulta
            pst = con.prepareStatement(query);                          //Prepararla
                  pst.setString(1,documento );                          //Setear Parámetros
                  
            rst = pst.executeQuery();                                  //Ejecutarla 
            
            
            while (rst.next()) {
                lista.add(Aprendiz.load(rst));     //Recorre el RS y llena una lista
            }
            System.out.println("El Query " + query );
            
        }  finally {
            if (pst != null) {
                pst.close();
                pst = null;
            }
            if (rst != null) {
                rst.close();
                rst = null;
            }
        }
        return lista;                            //Retorna la lista llena
    }

   public LinkedList findAprendicesApe(String cadena) throws SQLException {
        if (!hayConexion()) {
            throw new SQLException(" No existe conexion abierta ");
        }
        
        
        PreparedStatement pst = null;
        ResultSet rst = null;
        LinkedList lista = new LinkedList();
        try {
            String query;
            query = "SELECT * FROM aprendices where  apellido1 LIKE  ? or apellido2  LIKE ? ";    //Definir la consulta
            pst = con.prepareStatement(query);                      //Prepararla
             pst.setString(1, "%"+cadena+"%");
             pst.setString(2, "%"+cadena+"%");
             
            rst = pst.executeQuery();                               //Ejecutarla 
            
            
            while (rst.next()) {
                lista.add(Aprendiz.load(rst));     //Recorre el RS y llena una lista
            }
            System.out.println("El Query " + query );
            
        }  finally {
            if (pst != null) {
                pst.close();
                pst = null;
            }
            if (rst != null) {
                rst.close();
                rst = null;
            }
        }
        return lista;                            //Retorna la lista llena
    }  
     
     
      public LinkedList findAllNombreCurso(String cadena ) throws SQLException {
        if (!hayConexion()) {
            throw new SQLException(" No existe conexion abierta ");
        }
        
        
        PreparedStatement pst = null;
        ResultSet rst = null;
        LinkedList lista = new LinkedList();
        try {
            String query;
            query = "SELECT a.* FROM aprendices a, cursos c where a.fk_curso = c.id_curso  and nombre_curso like ?";    //Definir la consulta
            pst = con.prepareStatement(query);                      //Prepararla
                pst.setString(1, "%"+cadena+"%");  
            rst = pst.executeQuery();                               //Ejecutarla 
            
            
            while (rst.next()) {
                lista.add(Aprendiz.load(rst));     //Recorre el RS y llena una lista
            }
            System.out.println("El Query " + query );
            
        }  finally {
            if (pst != null) {
                pst.close();
                pst = null;
            }
            if (rst != null) {
                rst.close();
                rst = null;
            }
        }
        return lista;                            //Retorna la lista llena
    }

    
    
}


