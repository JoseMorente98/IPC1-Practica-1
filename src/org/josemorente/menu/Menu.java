/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.josemorente.menu;

import org.josemorente.beans.Pokemon;
import org.josemorente.controller.ControladorBatalla;
import org.josemorente.controller.ControladorPokemon;
import org.josemorente.ingreso.IngresoDatos;

/**
 *
 * @author Jose Morente
 */
public class Menu {
    private static Menu instancia;
    private int ingreso;
    
    public static Menu getInstancia() {
        if(instancia == null) {
            instancia = new Menu();
        }
        return instancia;
    }

    public Menu() {
    }
    
    public void mostrarMenu() {
        boolean estado = true;
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("                                          POKÉMON");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        System.out.println("  1. Administración de Pokemón");
        System.out.println("  2. Administración de Partidas");
        System.out.println("  3. Nueva Partida");
        System.out.println("  4. Salir");
        System.out.println("  Ingrese cualquier opción.");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        do {
            System.out.print(">> ");
            try {
                ingreso = Integer.parseInt(IngresoDatos.getInstancia().ingreso());
                switch(ingreso) {
                    case 1:
                       mostrarMenuPokemon();
                       estado = false;
                    break;
                    case 2: 
                       mostrarMenuPartidas();
                       estado = false;
                    break;
                    case 3: 
                       mostrarMenuPartida();
                       estado = false;
                    break;
                    case 4: 
                       System.exit(0);
                    break;
                    default:
                        System.err.println("Ingrese una de las opciones correctamente.");
                        estado = true;
                    break;
                }
            } catch (Exception e) {
                System.err.println("Debe de ingresar un número.");
                estado = true;
            };                
        } while(estado);
    }
    
    public void mostrarMenuPokemon() {
        boolean estado = true;
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("                                ADMINISTRACIÓN DE POKÉMON");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        System.out.println("  1. Lista de los Pokémon");
        System.out.println("  2. Editar Pokémon");
        System.out.println("  3. Lista de los Pokémon más utilizados");
        System.out.println("  4. Lista de los Pokémon menos utilizados");
        System.out.println("  5. Regresar");
        System.out.println("  Ingrese cualquier opción.");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        do {
            System.out.print(">> ");
            try {
                ingreso = Integer.parseInt(IngresoDatos.getInstancia().ingreso());
                switch(ingreso) {
                    case 1: 
                       ControladorPokemon.getInstancia().mostrarPokemones();
                       mostrarMenuPokemon();
                       estado = false;
                    break;
                    case 2: 
                       ControladorPokemon.getInstancia().mostrarListaPokemones();
                       actualizarPokemon();
                       estado = false;
                    break;
                    case 3: 
                       ControladorBatalla.getInstancia().pokemonMasElegido();
                       mostrarMenuPokemon();
                       estado = false;
                    break;
                    case 4: 
                       ControladorBatalla.getInstancia().pokemonMenosElegido();
                       mostrarMenuPokemon();
                       estado = false;
                    break;
                    case 5: 
                       this.mostrarMenu();
                    break;
                    default:
                        System.err.println("Ingrese una de las opciones correctamente.");
                        estado = true;
                    break;
                }
            } catch (Exception e) {
                System.err.println("Debe de ingresar un número.");
                estado = true;
            };                
        } while(estado);
    }
    
    public void mostrarMenuPartidas() {
        boolean estado = true;
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("                               ADMINISTRACIÓN DE PARTIDAS");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        System.out.println("  1. Registro de Partidas");
        System.out.println("  2. Top 5 Ganadores");
        System.out.println("  3. Top 5 Perdedores");
        System.out.println("  4. Regresar");
        System.out.println("  Ingrese cualquier opción.");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        do {
            System.out.print(">> ");
            try {
                ingreso = Integer.parseInt(IngresoDatos.getInstancia().ingreso());
                switch(ingreso) {
                    case 1: 
                       ControladorBatalla.getInstancia().mostrarBatallas();
                       mostrarMenuPartidas();
                       estado = false;
                    break;
                    case 2: 
                       ControladorBatalla.getInstancia().topGanadores();
                       mostrarMenuPartidas();
                       estado = false;
                    break;
                    case 3: 
                       ControladorBatalla.getInstancia().topPerdedores();
                       mostrarMenuPartidas();
                       estado = false;
                    break;
                    case 4: 
                       mostrarMenu();
                       estado = false;
                    break;
                    default:
                        System.err.println("Ingrese una de las opciones correctamente.");
                        estado = true;
                    break;
                }
            } catch (Exception e) {
                System.err.println("Debe de ingresar un número.");
                estado = true;
            };                
        } while(estado);
    }
    
    public void mostrarMenuPartida() {
        String jugador1, jugador2;
        Pokemon pokemon1, pokemon2, pokemon3, pokemon4;
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("                                    NUEVA PARTIDA");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        System.out.println("  Nombre del primer jugador:");
        System.out.print(">> ");
        jugador1 = IngresoDatos.getInstancia().ingreso();
        ControladorPokemon.getInstancia().mostrarListaPokemones();
        System.out.println("  Ingrese su primer pókemon:");
        pokemon1 = validarPokemon();
        ControladorPokemon.getInstancia().mostrarListaPokemones();
        System.out.println("  Ingrese su segundo pókemon:");
        pokemon2 = validarPokemon();
        System.out.println("  Nombre del segundo jugador:");
        System.out.print(">> ");
        jugador2 = IngresoDatos.getInstancia().ingreso();
        ControladorPokemon.getInstancia().mostrarListaPokemones();
        System.out.println("  Ingrese su primer pókemon:");
        pokemon3 = validarPokemon();
        ControladorPokemon.getInstancia().mostrarListaPokemones();
        System.out.println("  Ingrese su segundo pókemon:");
        pokemon4 = validarPokemon();
        ControladorBatalla.getInstancia().agregarBatalla(jugador1, pokemon1, pokemon2, jugador2, pokemon3, pokemon4);
        mostrarMenu();
    }
    
    public void mostrarRevancha(String jugador1, String jugador2) {
        Pokemon pokemon1, pokemon2, pokemon3, pokemon4;
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("                                    PARTIDA REVANCHA");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        System.out.println("  Nombre del primer jugador: " + jugador1);
        ControladorPokemon.getInstancia().mostrarListaPokemones();
        System.out.println("  Ingrese su primer pókemon:");
        pokemon1 = validarPokemon();
        ControladorPokemon.getInstancia().mostrarListaPokemones();
        System.out.println("  Ingrese su segundo pókemon:");
        pokemon2 = validarPokemon();
        System.out.println("  Nombre del segundo jugador: " + jugador2);
        System.out.print(">> ");
        ControladorPokemon.getInstancia().mostrarListaPokemones();
        System.out.println("  Ingrese su primer pókemon:");
        pokemon3 = validarPokemon();
        ControladorPokemon.getInstancia().mostrarListaPokemones();
        System.out.println("  Ingrese su segundo pókemon:");
        pokemon4 = validarPokemon();
        ControladorBatalla.getInstancia().agregarBatalla(jugador1, pokemon1, pokemon2, jugador2, pokemon3, pokemon4);
        mostrarMenu();
    }
    
    public void actualizarPokemon() {
        int id;
        String nombrePokemon;
        int contadorAtaque;
        int contadorVida;
        System.out.println("Ingresar el número del pokémon que desea editar.");
        System.out.print(">> ");
        id = validarNumero(IngresoDatos.getInstancia().ingreso());
        Pokemon p = ControladorPokemon.getInstancia().buscarPokemon(id);
        if(p != null) {
            System.out.println("════════════════════════════════════════════════════════════");
            System.out.println("Nombre: " + p.getNombrePokemon());
            System.out.println("Vida: " + p.getVidaPokemon());
            System.out.println("Ataque: " + p.getAtaquePokemon());
            if(p.isEstadoPokemon()) {
                System.out.println("Estado: Vivo");
            } else {
                System.out.println("Estado: Muerto");
            }
            System.out.println("════════════════════════════════════════════════════════════");
            ControladorPokemon.getInstancia().buscarPokemon(id);
            System.out.println("Actualizar Nombre:");
            nombrePokemon = validarNombrePokemon();
            System.out.println("Actualizar Pts. de Vida:");
            System.out.print(">> ");
            contadorVida = validarNumero(IngresoDatos.getInstancia().ingreso());
            System.out.println("Actualizar Pts. de Ataque:");
            System.out.print(">> ");
            contadorAtaque = validarNumero(IngresoDatos.getInstancia().ingreso());
            ControladorPokemon.getInstancia().actualizarPokemon(id, nombrePokemon, contadorVida, contadorAtaque);
            mostrarMenuPokemon();
        } else {
            System.err.println("Pokemón no encontrado.");
            actualizarPokemon();
        }
    }
    
    public String validarNombrePokemon(){
        boolean estado = true;
        do {
            System.out.print(">> ");
            String ingreso = IngresoDatos.getInstancia().ingreso();
            if(!ControladorPokemon.getInstancia().validarNombre(ingreso)) {
                estado = false;
                return ingreso;
            } else {
                estado = true;
                System.err.println("El nombre del pokémon ya existe.");
            }
        } while(estado);
        return null;
    }
    
    public int validarNumero(String s){
        boolean estado = true;
        do {
            try {
                ingreso = Integer.parseInt(s);
                estado = false;
                return ingreso;                
            } catch (Exception e) {
                System.err.println("Debe de ingresar un número.");
                estado = false;
            }
        } while(estado);
        return 0;
    }
    
    public Pokemon validarPokemon() {
        boolean estado = true;
        do {
            try {
                System.out.print(">> ");
                ingreso = Integer.parseInt(IngresoDatos.getInstancia().ingreso());
                Pokemon p = ControladorPokemon.getInstancia().buscarPokemon(ingreso);                
                estado = false;
                if(p != null) {
                    return p;
                } else {
                    System.err.println("Pokémon no encontrado.");
                    estado = true;
                }
            } catch (Exception e) {
                System.err.println("Debe de ingresar un número.");
                estado = true;
            }
        } while(estado);
        return null;
    }
    
}
