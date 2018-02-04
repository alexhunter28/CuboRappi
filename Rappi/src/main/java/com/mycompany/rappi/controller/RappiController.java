/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rappi.controller;

import com.mycompany.rappi.ejb.RappiFecadeLocal;
import com.mycompany.rappi.util.OperacionUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author ASUS
 */
@ManagedBean
@SessionScoped
public class RappiController implements Serializable{
    
    @EJB
    RappiFecadeLocal rappiFecadeLocal;
    
    private int numeroCasosPrueba;
    private int valorN; // ME DICE EL VALOR QUE TENDRÁ LA MATRIZ
    private int valorM; // LA CANTIDAD DE OPERACIONES QUE NECESITO ADICIONAR YA SEAN QUERY O UPDATE
    private String operacion; //EL TIPO DE OPERACIÓN QUE QUIERO ADICIONAR QUERY O UPDATE
    
    //VALORES REQUERIDOS POR UPDATE
    private int x;
    private int y;
    private int z;
    private int W;
    
    //VALORES REQUERIDOS POR QUERY
    private int x1;
    private int y1;
    private int z1;
    private int x2;
    private int y2;
    private int z2;
    
    private boolean esQuery; // PARA CARGAR LOS CAMPOS QUE SOLICITA LA OPERACIÓN QUERY
    private boolean esUpdate; // PARA CARGAR LOS CAMPOS QUE SOLICITA LA OPERACIÓN UPDATE
    
    private List<OperacionUtil> lstOperacion;
    
    
    public RappiController(){
        this.numeroCasosPrueba = 0;
        this.valorN = 0;
        this.valorM = 0;        
        this.esQuery = false;
        this.esUpdate = false;
        
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.W = 0;
        
        this.x1 =0;
        this.y1 =0;
        this.z1 =0;
        this.x2 =0;
        this.y2 =0;
        this.z2 =0;
        
        lstOperacion = new ArrayList<>();
        
    }
    
    
    
    public void generarLLave() throws Exception{
        try{
            
        }catch(Exception e){
            throw new Exception("Opss...!! ocurrio un problema");
        }
   
    }
    
    
    public void cargarCampos(String operacion){
        
        if(operacion.equals("UPDATE")){
            esUpdate = true;
            esQuery = false;
            
        }else if(operacion.equals("QUERY")){
            esUpdate = false;
            esQuery = true;
        }
        
    }
    
    public void agregarOperacion(){
        OperacionUtil operacionTemp = new OperacionUtil();
        
        if(operacion.equals("UPDATE")){
            operacionTemp.setTipo(operacion);
            operacionTemp.setV1(x);
            operacionTemp.setV2(y);
            operacionTemp.setV3(z);
            operacionTemp.setV4(W);
            lstOperacion.add(operacionTemp);
        }else{
            operacionTemp.setTipo(operacion);
            operacionTemp.setV1(x1);
            operacionTemp.setV2(y1);
            operacionTemp.setV3(z1);            
            operacionTemp.setV4(x2);
            operacionTemp.setV5(y2);
            operacionTemp.setV6(z2);            
            lstOperacion.add(operacionTemp);
        }
        
    }
    

    public RappiFecadeLocal getRappiFecadeLocal() {
        return rappiFecadeLocal;
    }

    public void setRappiFecadeLocal(RappiFecadeLocal rappiFecadeLocal) {
        this.rappiFecadeLocal = rappiFecadeLocal;
    }

    public int getNumeroCasosPrueba() {
        return numeroCasosPrueba;
    }

    public void setNumeroCasosPrueba(int numeroCasosPrueba) {
        this.numeroCasosPrueba = numeroCasosPrueba;
    }

    public int getValorN() {
        return valorN;
    }

    public void setValorN(int valorN) {
        this.valorN = valorN;
    }

    public int getValorM() {
        return valorM;
    }

    public void setValorM(int valorM) {
        this.valorM = valorM;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public boolean isEsQuery() {
        return esQuery;
    }

    public void setEsQuery(boolean esQuery) {
        this.esQuery = esQuery;
    }

    public boolean isEsUpdate() {
        return esUpdate;
    }

    public void setEsUpdate(boolean esUpdate) {
        this.esUpdate = esUpdate;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getW() {
        return W;
    }

    public void setW(int W) {
        this.W = W;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getZ1() {
        return z1;
    }

    public void setZ1(int z1) {
        this.z1 = z1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getZ2() {
        return z2;
    }

    public void setZ2(int z2) {
        this.z2 = z2;
    }

    public List<OperacionUtil> getLstOperacion() {
        return lstOperacion;
    }

    public void setLstOperacion(List<OperacionUtil> lstOperacion) {
        this.lstOperacion = lstOperacion;
    }

    
    
}
