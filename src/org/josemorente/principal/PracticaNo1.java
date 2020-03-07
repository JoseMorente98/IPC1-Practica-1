/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.josemorente.principal;

import org.josemorente.controller.ControladorPokemon;
import org.josemorente.menu.Menu;

/**
 *
 * @author Jose Morente
 */
public class PracticaNo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ControladorPokemon.getInstancia().cargarImagenes();
        ControladorPokemon.getInstancia().cargaInicial(args);
        Menu.getInstancia().mostrarMenu();
        //ControladorPokemon.getInstancia().mostrarPokemones();*/
    }
    
}
