/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rappi.util;

import javax.ejb.Stateless;

/**
 *
 * @author ASUS
 */
@Stateless
public class OperacionUtil {
    
    private String tipo;    
    private int v1;
    private int v2;
    private int v3;
    private int v4;
    private int v5;
    private int v6;

    public OperacionUtil() {
    }

    public OperacionUtil(String tipo, int v1, int v2, int v3, int v4, int v5, int v6) {
        this.tipo = tipo;
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.v4 = v4;
        this.v5 = v5;
        this.v6 = v6;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getV1() {
        return v1;
    }

    public void setV1(int v1) {
        this.v1 = v1;
    }

    public int getV2() {
        return v2;
    }

    public void setV2(int v2) {
        this.v2 = v2;
    }

    public int getV3() {
        return v3;
    }

    public void setV3(int v3) {
        this.v3 = v3;
    }

    public int getV4() {
        return v4;
    }

    public void setV4(int v4) {
        this.v4 = v4;
    }

    public int getV5() {
        return v5;
    }

    public void setV5(int v5) {
        this.v5 = v5;
    }

    public int getV6() {
        return v6;
    }

    public void setV6(int v6) {
        this.v6 = v6;
    }
    
    
    
}
