/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.bos.Articulo;
import com.losalpes.bos.Mueble;
import com.losalpes.bos.TipoMueble;
import com.losalpes.servicios.IServicioCatalogo;
import com.losalpes.servicios.IServicioCompra;
import com.losalpes.servicios.ServicioCatalogoMock;
import com.losalpes.servicios.ServicioComprarMock;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author user
 */
@ManagedBean
@SessionScoped
public class CompradoBean {
    
        
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * Representa un nuevo mueble a ingresar
     */
    private Articulo articulo;

    /**
     * Relación con la interfaz que provee los servicios necesarios del catálogo.
     */
    private IServicioCompra servicioCompra;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor de la clase principal
     */
    public CompradoBean()
    {
        articulo = new Articulo();
        servicioCompra=new ServicioComprarMock();
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

  
    /**
     * Devuelve una lista con todos los muebles del sistema
     * @return muebles Muebles del sistema
     */
    public List<Articulo> getArticulos()
    {

        return servicioCompra.darArticulos();
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------

    /**
     * Agrega un nuevo mueble al sistema
    
    public String agregarMueble()
    {
        catalogo.agregarMueble(mueble);
        mueble=new Mueble();
        
        return "agregado.xhtml";
    }
     */
    public String agregarArticulo(Mueble mueble)
    {
        servicioCompra.agregarArticulo(mueble); 
        articulo=new Articulo();
        
        return "agregado.xhtml";
    }
    
    public Double getTotalCompra(){
        return servicioCompra.darTotal();
        
    }

    /**
     * Elimina la información del mueble
     */
    public void limpiar()
    {
        articulo=new Articulo();
    }

    /**
     * @return the articulo
     */
    public Articulo getArticulo() {
        return articulo;
    }

    /**
     * @param articulo the articulo to set
     */
    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
    
    


    
}
