/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rappi.ejb;

import javax.ejb.Local;

/**
 *
 * @author ASUS
 */
@Local
public interface RappiFecadeLocal {
    
    void generarLlave();
    
}
