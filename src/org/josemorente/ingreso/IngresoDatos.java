/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.josemorente.ingreso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Jose Morente
 */
public class IngresoDatos {
    public static IngresoDatos instancia;

    public static IngresoDatos getInstancia() {
        if(instancia == null) {
            instancia = new IngresoDatos();
        }
        return instancia;
    }
    
    public String ingreso() {
	String ingreso = null;
	BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
	try {
	    ingreso = leer.readLine();
        } catch(IOException e) {
            System.out.println("Error de entrada y salida.");
            System.exit(1);
	}
        return ingreso;
    }
    
}
