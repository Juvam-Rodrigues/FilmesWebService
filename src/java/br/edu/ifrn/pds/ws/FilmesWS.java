/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package br.edu.ifrn.pds.ws;

import br.edu.ifrn.pds.dominio.Filme;
import br.edu.ifrn.pds.persistencia.FilmeDAO;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author ASUS i5
 */
@WebService(serviceName = "FilmesWS")
public class FilmesWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "inserirFilme")
    public boolean inserirFilme(@WebParam(name = "objFilme") Filme objFilme) {
        FilmeDAO objDao = new FilmeDAO();
        return objDao.inserirFilme(objFilme);
    }
    @WebMethod(operationName = "deletarFilme")
    public boolean deletarFilme(@WebParam(name = "idFilme") int idFilme) {
        FilmeDAO objDao = new FilmeDAO();
        return objDao.removerFilme(idFilme);
    }
    @WebMethod(operationName = "alterarFilme")
    public boolean alterarFilme(@WebParam(name = "objFilme") Filme objFilme) {
        FilmeDAO objDao = new FilmeDAO();
        return objDao.alterarFilme(objFilme);
    }
    @WebMethod(operationName = "buscarFilme")
    public Filme buscarFilme(@WebParam(name = "nomeFilme") String nomeFilme) {
        FilmeDAO objDao = new FilmeDAO();
        return objDao.buscarFilme(nomeFilme);
    }
    @WebMethod(operationName = "listarTodosOsFilmes")
    public List<Filme>listarTodosOsFilmes() {
        FilmeDAO objDao = new FilmeDAO();
        return objDao.buscarTodos();
    }
    @WebMethod(operationName = "verificarExistencia")
    public boolean verificarExistencia(@WebParam(name = "nomeFilme") String nomeFilme) {
        FilmeDAO objDao = new FilmeDAO();
        return objDao.verificarExistencia(nomeFilme);
    }
    
}
