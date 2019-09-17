/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adsi.rest;


import com.adsi.controlador.Controlador;
import com.adsi.modelo.Aprendiz;
import com.adsi.modelo.Curso;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author RICARDO
 */
@Path("/rest")

public class RestController {
    
    private final Controlador repo = new Controlador();
    
    public RestController() throws SQLException, IOException {
        repo.conectar();
    }

          
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/get")
    public String get() {
        //TODO return proper representation object
        return "Hola Rest GET";
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/aprendices/list")
    public List<Aprendiz> findAllAprendices() throws SQLException {
        //TODO return proper representation object
        return this.repo.findAllAprendices();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/aprendices/apellido/{cadena}")
    public List<Aprendiz>findAprendicesApe(@PathParam("cadena") String cadena)  throws SQLException {
        //TODO return proper representation object
        return this.repo.findAprendicesApe(cadena);
    }
    
    
    
    
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/aprendices/documento")
    public List<Aprendiz> findAprendicesByDocumento(@QueryParam("documento")String documento  ) throws SQLException {
        //TODO return proper representation object
        return this.repo.findAprendicesByDocumento(documento);
    }
    
    //
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/aprendices/curso/{id}")
    public List<Aprendiz> findAprendicesByFkCurso(@PathParam("id") Integer p_curso) throws SQLException {
        //TODO return proper representation object
        return this.repo.findAprendicesByFkCurso(p_curso);
    }
    
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/curso/id/{id}")
    public List<Curso> findCursosById(@PathParam("id") Integer p_curso) throws SQLException {
        //TODO return proper representation object
        return this.repo.findCursosById(p_curso);
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/jornadaycurso/{jornada}/{curso}")
    public List<Aprendiz> Aprendicesxjornadaxcurso(@PathParam("jornada") String  jornada,@PathParam("curso") Integer curso ) throws SQLException {
        //TODO return proper representation object
        return this.repo.Aprendicesxjornadaxcurso(jornada, curso);
    }
    
    
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/aprendices/add")
    public Aprendiz adicionarAprendiz(  Aprendiz aprendiz) throws SQLException, IOException {
        //TODO return proper representation object
          this.repo.adicionarAprendiz(aprendiz);
          return aprendiz;
    }
     @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/curso/aprendices/{cadena}")
    public List<Curso> findAllNombreCurso(@PathParam("cadena")String cadena) throws SQLException {
        //TODO return proper representation object
        return this.repo.findAllNombreCurso(cadena);
    }
}
