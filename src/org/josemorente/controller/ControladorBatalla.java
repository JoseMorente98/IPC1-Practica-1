/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.josemorente.controller;

import org.josemorente.beans.BatallaPokemon;
import org.josemorente.beans.Pokemon;
import org.josemorente.ingreso.IngresoDatos;
import org.josemorente.menu.Menu;

/**
 *
 * @author Jose Morente
 */
public class ControladorBatalla {
    public static ControladorBatalla instancia;
    public BatallaPokemon[] batallas = new BatallaPokemon[100];
    public String[] perdidos = new String[5];
    public String[] ganados = new String[5];
    public int contador = 0;
    public int contadorGanador = 0;
    public int contadorPerdedor = 0;
    
    public static ControladorBatalla getInstancia() {
        if(instancia == null) {
            instancia = new ControladorBatalla();
        }
        return instancia;
    }
    
    public ControladorBatalla() {
    }
    
    //AGREGAR BATALLA
    public BatallaPokemon agregarBatalla(String jugador1, Pokemon pokemon1, Pokemon pokemon2, String jugador2, Pokemon pokemon3,Pokemon pokemon4) {
        BatallaPokemon batalla = new BatallaPokemon();
        batalla.setJugador1(jugador1);
        batalla.setJugador2(jugador2);
        batalla.setPokemon1(pokemon1);
        batalla.setPokemon2(pokemon2);
        batalla.setPokemon3(pokemon3);
        batalla.setPokemon4(pokemon4);
        batallas[contador] = batalla;
        contador++;
        empezarBatalla(batalla);
        return batalla;
    }
    
    //MOSTRAR TODAS LAS BATALLAS POKEMON
    public void mostrarBatallas() {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("                                      HISTORIAL PARTIDAS");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        for(BatallaPokemon b: batallas) {
            if(b != null) {                
                System.out.println("JUGADOR NO. 1: " + b.getJugador1());
                System.out.println("    Pokémon 1: " + b.getPokemon1());
                System.out.println("        Ataques Recibidos: " + b.getRecibidoPokemon1());
                System.out.println("        Ataques Realizados: " + b.getAtaquePokemon1());
                if(b.isEstadoPokemon1()) {
                   System.out.println("        Estado: Vivo");
                } else {
                   System.out.println("        Estado: Muerto"); 
                }
                System.out.println("    Pokémon 2: " + b.getPokemon2());
                System.out.println("        Ataques Recibidos: " + b.getRecibidoPokemon2());
                System.out.println("        Ataques Realizados: " + b.getAtaquePokemon2());
                if(b.isEstadoPokemon2()) {
                   System.out.println("        Estado: Vivo");
                } else {
                   System.out.println("        Estado: Muerto"); 
                }
                System.out.println("JUGADOR NO. 2: " + b.getJugador2());
                System.out.println("    Pokémon 1: " + b.getPokemon3());
                System.out.println("        Ataques Recibidos: " + b.getRecibidoPokemon3());
                System.out.println("        Ataques Realizados: " + b.getAtaquePokemon3());
                if(b.isEstadoPokemon3()) {
                   System.out.println("        Estado: Vivo");
                } else {
                   System.out.println("        Estado: Muerto"); 
                }
                System.out.println("    Pokémon 2: " + b.getPokemon4());
                System.out.println("        Ataques Recibidos: " + b.getRecibidoPokemon4());
                System.out.println("        Ataques Realizados: " + b.getAtaquePokemon4());
                if(b.isEstadoPokemon4()) {
                   System.out.println("        Estado: Vivo");
                } else {
                   System.out.println("        Estado: Muerto"); 
                }
                if(!b.isEstadoPokemon1() && !b.isEstadoPokemon2()) {
                    System.out.println("╔══════════════════════════════════════════════════════════╗");
                    System.out.println("                                    GANADOR: " + b.getJugador2().toUpperCase());
                    System.out.println("╚══════════════════════════════════════════════════════════╝");
                } else if(!b.isEstadoPokemon3() && !b.isEstadoPokemon4()) {
                    System.out.println("╔══════════════════════════════════════════════════════════╗");
                    System.out.println("                                    GANADOR: " + b.getJugador1().toUpperCase());
                    System.out.println("╚══════════════════════════════════════════════════════════╝");
                }
            }
        }
    }
    
    //GENERAR BATALLA
    public void empezarBatalla(BatallaPokemon batalla) {
        int turno = valorAleatorio(2);
        boolean estado = true;
        int pokemonAtaca;
        int pokemonAtacar;
        do {            
            if(turno == 1) {
                System.out.println("╔══════════════════════════════════════════════════════════╗");
                System.out.println("                                          JUGADOR 1");
                System.out.println("╚══════════════════════════════════════════════════════════╝");
                System.out.println("JUEGA: " + batalla.getJugador1());
                System.out.println("Escoga a su pokémon para atacar al jugador: " + batalla.getJugador2());
                if(batalla.getPokemon1().isEstadoPokemon()) {
                    System.out.println("1. " + batalla.getPokemon1());
                }
                if(batalla.getPokemon2().isEstadoPokemon()) {
                    System.out.println("2. " + batalla.getPokemon2());
                }
                pokemonAtaca = validarNumero();
                if(pokemonAtaca == 1) {
                    if(batalla.getPokemon1().isEstadoPokemon()) {
                        batalla.setAtaquePokemon1(1);
                        System.out.println("Escoga al pokémon que desea atacar:");
                        if(batalla.getPokemon3().isEstadoPokemon()) {
                            System.out.println("1. " + batalla.getPokemon3());
                        }
                        if(batalla.getPokemon4().isEstadoPokemon()) {
                            System.out.println("2. " + batalla.getPokemon4());
                        }
                        pokemonAtacar = validarNumero();
                        if(pokemonAtacar == 1) {
                            if(batalla.getPokemon3().getVidaPokemon() == 0) {
                                batalla.getPokemon3().setEstadoPokemon(false);
                                batalla.setEstadoPokemon3(false);
                                System.err.println("El pokémon " + batalla.getPokemon3() + " esta muerto.");
                                turno = 1;
                            } else {              
                                batalla.getPokemon3().setHerida(batalla.getPokemon1().getAtaquePokemon());
                                batalla.setRecibidoPokemon3(1);
                                if(batalla.getPokemon3().getVidaPokemon() == 0) {
                                    batalla.getPokemon3().setEstadoPokemon(false);
                                    batalla.setEstadoPokemon3(false);
                                }
                                System.out.println(batalla.getPokemon1().getImagenPokemon());
                                System.out.println("Pokémon Ataca: " + batalla.getPokemon1());
                                System.out.println("Vida: " + batalla.getPokemon1().getVidaPokemon());
                                System.out.println("Ataque: " + batalla.getPokemon1().getAtaquePokemon());
                                System.out.println(batalla.getPokemon3().getImagenPokemon());
                                System.out.println("Pokémon Herido: " + batalla.getPokemon3());
                                System.out.println("Vida: " + batalla.getPokemon3().getVidaPokemon());
                                System.out.println("Ataque: " + batalla.getPokemon3().getAtaquePokemon());
                                turno = 2;
                            }                        
                        } else if(pokemonAtacar == 2) {
                            if(batalla.getPokemon4().getVidaPokemon() == 0) {
                                batalla.getPokemon4().setEstadoPokemon(false);
                                batalla.setEstadoPokemon4(false);
                                System.err.println("El pokémon " + batalla.getPokemon4()+ " esta muerto.");
                                turno = 1;
                            } else {
                                batalla.getPokemon4().setHerida(batalla.getPokemon1().getAtaquePokemon());
                                batalla.setRecibidoPokemon4(1);
                                if(batalla.getPokemon4().getVidaPokemon() == 0) {
                                    batalla.getPokemon4().setEstadoPokemon(false);
                                    batalla.setEstadoPokemon4(false);
                                }
                                System.out.println(batalla.getPokemon1().getImagenPokemon());
                                System.out.println("Pokémon Ataca: " + batalla.getPokemon1());
                                System.out.println("Vida: " + batalla.getPokemon1().getVidaPokemon());
                                System.out.println("Ataque: " + batalla.getPokemon1().getAtaquePokemon());
                                System.out.println(batalla.getPokemon4().getImagenPokemon());
                                System.out.println("Pokémon Herido: " + batalla.getPokemon4());
                                System.out.println("Vida: " + batalla.getPokemon4().getVidaPokemon());
                                System.out.println("Ataque: " + batalla.getPokemon4().getAtaquePokemon());
                                turno = 2;
                            }                        
                        }
                    } else {
                        System.err.println("El pokémon " + batalla.getPokemon1()+ " esta muerto.");
                        turno = 1;
                    }
                } else if(pokemonAtaca == 2) {
                    if(batalla.getPokemon2().isEstadoPokemon()) {
                        batalla.setAtaquePokemon1(1);
                        System.out.println("Escoga al pokémon que desea atacar:");
                        if(batalla.getPokemon3().isEstadoPokemon()) {
                            System.out.println("1. " + batalla.getPokemon3());
                        }
                        if(batalla.getPokemon4().isEstadoPokemon()) {
                            System.out.println("2. " + batalla.getPokemon4());
                        }
                        pokemonAtacar = validarNumero();
                        if(pokemonAtacar == 1) {
                            if(batalla.getPokemon3().getVidaPokemon() == 0) {
                                batalla.getPokemon3().setEstadoPokemon(false);
                                batalla.setEstadoPokemon3(false);
                                System.out.println("El pokémon " + batalla.getPokemon3()+ " esta muerto.");
                                turno = 1;
                            } else {
                                batalla.getPokemon3().setHerida(batalla.getPokemon2().getAtaquePokemon());
                                batalla.setRecibidoPokemon3(1);
                                if(batalla.getPokemon3().getVidaPokemon() == 0) {
                                    batalla.getPokemon3().setEstadoPokemon(false);
                                    batalla.setEstadoPokemon3(false);
                                }
                                System.out.println(batalla.getPokemon2().getImagenPokemon());
                                System.out.println("Pokémon Ataca: " + batalla.getPokemon2());
                                System.out.println("Vida: " + batalla.getPokemon2().getVidaPokemon());
                                System.out.println("Ataque: " + batalla.getPokemon2().getAtaquePokemon());
                                System.out.println(batalla.getPokemon3().getImagenPokemon());
                                System.out.println("Pokémon Herido: " + batalla.getPokemon3());
                                System.out.println("Vida: " + batalla.getPokemon3().getVidaPokemon());
                                System.out.println("Ataque: " + batalla.getPokemon3().getAtaquePokemon());                                
                                turno = 2;
                            }
                        } else if(pokemonAtacar == 2) {
                            if(batalla.getPokemon4().getVidaPokemon() == 0) {
                                batalla.getPokemon4().setEstadoPokemon(false);
                                batalla.setEstadoPokemon4(false);
                                System.out.println("El pokémon " + batalla.getPokemon4()+ " esta muerto.");
                                turno = 1;
                            } else {
                                batalla.getPokemon4().setHerida(batalla.getPokemon2().getAtaquePokemon());
                                batalla.setRecibidoPokemon4(1);
                                if(batalla.getPokemon4().getVidaPokemon() == 0) {
                                    batalla.getPokemon4().setEstadoPokemon(false);
                                    batalla.setEstadoPokemon4(false);
                                }
                                System.out.println(batalla.getPokemon2().getImagenPokemon());
                                System.out.println("Pokémon Ataca: " + batalla.getPokemon2());
                                System.out.println("Vida: " + batalla.getPokemon2().getVidaPokemon());
                                System.out.println("Ataque: " + batalla.getPokemon2().getAtaquePokemon());
                                System.out.println(batalla.getPokemon4().getImagenPokemon());
                                System.out.println("Pokémon Herido: " + batalla.getPokemon4());
                                System.out.println("Vida: " + batalla.getPokemon4().getVidaPokemon());
                                System.out.println("Ataque: " + batalla.getPokemon4().getAtaquePokemon());
                                turno = 2;
                            }
                        }
                    } else {
                        System.err.println("El pokémon " + batalla.getPokemon2()+ " esta muerto.");
                        turno = 1;
                    }
                }      
                if(batalla.getPokemon3().isEstadoPokemon() == false && batalla.getPokemon4().isEstadoPokemon() == false) {
                    batalla.setEstadoPokemon4(false);
                    batalla.setEstadoPokemon3(false);
                    batalla.getPokemon1().setEstadoPokemon(true);
                    batalla.getPokemon1().setVidaPokemon(ControladorPokemon.getInstancia().valorAleatorio(120, 160));
                    batalla.getPokemon2().setEstadoPokemon(true);
                    batalla.getPokemon2().setVidaPokemon(ControladorPokemon.getInstancia().valorAleatorio(120, 160));
                    batalla.getPokemon3().setEstadoPokemon(true);
                    batalla.getPokemon3().setVidaPokemon(ControladorPokemon.getInstancia().valorAleatorio(120, 160));
                    batalla.getPokemon4().setEstadoPokemon(true);
                    batalla.getPokemon4().setVidaPokemon(ControladorPokemon.getInstancia().valorAleatorio(120, 160));
                    System.out.println("╔══════════════════════════════════════════════════════════╗");
                    System.out.println("                                    GANADOR: " + batalla.getJugador1().toUpperCase());
                    System.out.println("╚══════════════════════════════════════════════════════════╝");
                    System.out.println("¿Desea jugar nuevamente?");
                    System.out.println("1. Aceptar");
                    System.out.println("2. Finalizar");
                    int opcion = validarNumero();
                    switch(opcion) {
                        case 1: 
                            Menu.getInstancia().mostrarRevancha(batalla.getJugador1(), batalla.getJugador2());
                            estado = false;
                            break;
                        case 2:
                            estado = false;
                            break;
                    }
                } else {
                    estado = true;
                }
            } else if(turno == 2) {
                System.out.println("╔══════════════════════════════════════════════════════════╗");
                System.out.println("                                          JUGADOR 2");
                System.out.println("╚══════════════════════════════════════════════════════════╝");
                System.out.println("JUEGA: " + batalla.getJugador2());
                System.out.println("Escoga a su pokémon para atacar al jugador: " + batalla.getJugador1());
                if(batalla.getPokemon3().isEstadoPokemon()) {
                    System.out.println("1. " + batalla.getPokemon3());
                }
                if(batalla.getPokemon4().isEstadoPokemon()) {
                    System.out.println("2. " + batalla.getPokemon4());
                }
                pokemonAtaca = validarNumero();
                if(pokemonAtaca == 1) {
                    batalla.setAtaquePokemon3(1);
                    if(batalla.getPokemon3().isEstadoPokemon()) {
                        System.out.println("Escoga al pokémon que desea atacar:");
                        if(batalla.getPokemon1().isEstadoPokemon()) {
                            System.out.println("1. " + batalla.getPokemon1());
                        }
                        if(batalla.getPokemon2().isEstadoPokemon()) {
                            System.out.println("2. " + batalla.getPokemon2());
                        }
                        pokemonAtacar = validarNumero();
                        if(pokemonAtacar == 1) {
                            if(batalla.getPokemon1().getVidaPokemon() == 0) {
                                batalla.getPokemon1().setEstadoPokemon(false);
                                batalla.setEstadoPokemon1(false);
                                System.out.println("El pokémon " + batalla.getPokemon1()+ " esta muerto.");
                                turno = 2;
                            } else {
                                batalla.getPokemon1().setHerida(batalla.getPokemon3().getAtaquePokemon());
                                batalla.setRecibidoPokemon1(1);
                                if(batalla.getPokemon1().getVidaPokemon() == 0) {
                                    batalla.getPokemon1().setEstadoPokemon(false);
                                    batalla.setEstadoPokemon1(false);
                                }
                                System.out.println(batalla.getPokemon3().getImagenPokemon());
                                System.out.println("Pokémon Ataca: " + batalla.getPokemon3());
                                System.out.println("Vida: " + batalla.getPokemon3().getVidaPokemon());
                                System.out.println("Ataque: " + batalla.getPokemon3().getAtaquePokemon());
                                System.out.println(batalla.getPokemon1().getImagenPokemon());
                                System.out.println("Pokémon Herido: " + batalla.getPokemon1());
                                System.out.println("Vida: " + batalla.getPokemon1().getVidaPokemon());
                                System.out.println("Ataque: " + batalla.getPokemon1().getAtaquePokemon());
                                turno = 1;
                            }
                        } else if(pokemonAtacar == 2) {
                            if(batalla.getPokemon2().getVidaPokemon() == 0) {
                                batalla.getPokemon2().setEstadoPokemon(false);
                                batalla.setEstadoPokemon2(false);
                                System.out.println("El pokémon " + batalla.getPokemon2()+ " esta muerto.");
                                turno = 2;
                            } else {
                                batalla.getPokemon2().setHerida(batalla.getPokemon3().getAtaquePokemon());
                                batalla.setRecibidoPokemon2(1);
                                if(batalla.getPokemon2().getVidaPokemon() == 0) {
                                    batalla.getPokemon2().setEstadoPokemon(false);
                                    batalla.setEstadoPokemon2(false);
                                }
                                System.out.println(batalla.getPokemon3().getImagenPokemon());
                                System.out.println("Pokémon Ataca: " + batalla.getPokemon3());
                                System.out.println("Vida: " + batalla.getPokemon3().getVidaPokemon());
                                System.out.println("Ataque: " + batalla.getPokemon3().getAtaquePokemon());
                                System.out.println(batalla.getPokemon2().getImagenPokemon());
                                System.out.println("Pokémon Herido: " + batalla.getPokemon2());
                                System.out.println("Vida: " + batalla.getPokemon2().getVidaPokemon());
                                System.out.println("Ataque: " + batalla.getPokemon2().getAtaquePokemon());
                                turno = 1;
                            }
                        }
                    } else {
                        System.err.println("El pokémon " + batalla.getPokemon3()+ " esta muerto.");
                        turno = 2;
                    }
                } else if(pokemonAtaca == 2) {
                    if(batalla.getPokemon4().isEstadoPokemon()) {
                        batalla.setAtaquePokemon4(1);
                        System.out.println("Escoga al pokémon que desea atacar:");
                        if(batalla.getPokemon1().isEstadoPokemon()) {
                            System.out.println("1. " + batalla.getPokemon1());
                        }
                        if(batalla.getPokemon2().isEstadoPokemon()) {
                            System.out.println("2. " + batalla.getPokemon2());
                        }
                        pokemonAtacar = validarNumero();
                        if(pokemonAtacar == 1) {
                            if(batalla.getPokemon1().getVidaPokemon() == 0) {
                                batalla.getPokemon1().setEstadoPokemon(false);
                                batalla.setEstadoPokemon1(false);
                                System.out.println("El pokémon " + batalla.getPokemon1()+ " esta muerto.");
                                turno = 2;
                            } else {
                                batalla.getPokemon1().setHerida(batalla.getPokemon4().getAtaquePokemon());
                                batalla.setRecibidoPokemon1(1);
                                if(batalla.getPokemon1().getVidaPokemon() == 0) {
                                    batalla.getPokemon1().setEstadoPokemon(false);
                                    batalla.setEstadoPokemon1(false);
                                }
                                System.out.println(batalla.getPokemon4().getImagenPokemon());
                                System.out.println("Pokémon Ataca: " + batalla.getPokemon4());
                                System.out.println("Vida: " + batalla.getPokemon4().getVidaPokemon());
                                System.out.println("Ataque: " + batalla.getPokemon4().getAtaquePokemon());
                                System.out.println(batalla.getPokemon1().getImagenPokemon());
                                System.out.println("Pokémon Herido: " + batalla.getPokemon1());
                                System.out.println("Vida: " + batalla.getPokemon1().getVidaPokemon());
                                System.out.println("Ataque: " + batalla.getPokemon1().getAtaquePokemon());
                                turno = 1;
                            }
                        } else if(pokemonAtacar == 2) {
                            if(batalla.getPokemon2().getVidaPokemon() == 0) {
                                batalla.getPokemon2().setEstadoPokemon(false);
                                batalla.setEstadoPokemon2(false);
                                System.out.println("El pokémon " + batalla.getPokemon2()+ " esta muerto.");
                                turno = 2;
                            } else {
                                batalla.getPokemon2().setHerida(batalla.getPokemon4().getAtaquePokemon());
                                batalla.setRecibidoPokemon2(1);
                                if(batalla.getPokemon2().getVidaPokemon() == 0) {
                                    batalla.getPokemon2().setEstadoPokemon(false);
                                    batalla.setEstadoPokemon2(false);
                                }
                                System.out.println(batalla.getPokemon4().getImagenPokemon());
                                System.out.println("Pokémon Ataca: " + batalla.getPokemon4());
                                System.out.println("Vida: " + batalla.getPokemon4().getVidaPokemon());
                                System.out.println("Ataque: " + batalla.getPokemon4().getAtaquePokemon());
                                System.out.println(batalla.getPokemon2().getImagenPokemon());
                                System.out.println("Pokémon Herido: " + batalla.getPokemon2());
                                System.out.println("Vida: " + batalla.getPokemon2().getVidaPokemon());
                                System.out.println("Ataque: " + batalla.getPokemon2().getAtaquePokemon());
                                turno = 1;
                            }
                        }
                    } else {
                        System.err.println("El pokémon " + batalla.getPokemon4()+ " esta muerto.");
                        turno = 2;
                    }
                }
                if(batalla.getPokemon1().isEstadoPokemon() == false && batalla.getPokemon2().isEstadoPokemon() == false) {
                    batalla.setEstadoPokemon2(false);
                    batalla.setEstadoPokemon1(false);
                    batalla.getPokemon1().setEstadoPokemon(true);
                    batalla.getPokemon1().setVidaPokemon(ControladorPokemon.getInstancia().valorAleatorio(120, 160));
                    batalla.getPokemon2().setEstadoPokemon(true);
                    batalla.getPokemon2().setVidaPokemon(ControladorPokemon.getInstancia().valorAleatorio(120, 160));
                    batalla.getPokemon3().setEstadoPokemon(true);
                    batalla.getPokemon3().setVidaPokemon(ControladorPokemon.getInstancia().valorAleatorio(120, 160));
                    batalla.getPokemon4().setEstadoPokemon(true);
                    batalla.getPokemon4().setVidaPokemon(ControladorPokemon.getInstancia().valorAleatorio(120, 160));
                    System.out.println("╔══════════════════════════════════════════════════════════╗");
                    System.out.println("                                    GANADOR: " + batalla.getJugador2().toUpperCase());
                    System.out.println("╚══════════════════════════════════════════════════════════╝");
                    System.out.println("¿Desea jugar nuevamente?");
                    System.out.println("1. Aceptar");
                    System.out.println("2. Finalizar");
                    int opcion = validarNumero();
                    switch(opcion) {
                        case 1: 
                            Menu.getInstancia().mostrarRevancha(batalla.getJugador1(), batalla.getJugador2());
                            estado = false;
                            break;
                        case 2:
                            estado = false;
                            break;
                    }
                } else {
                    estado = true;
                }
            }
        } while (estado);
    }
    
    public void topGanadores() {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("                                      TOP 5 GANADORES");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        for(BatallaPokemon b: batallas) {
            if(b != null) {
                if(!b.isEstadoPokemon1() && !b.isEstadoPokemon2()) {
                    agregarGanadores(b.getJugador2());
                }
                if(!b.isEstadoPokemon3() && !b.isEstadoPokemon4()) {
                    agregarGanadores(b.getJugador1());
                }
            }       
        }
        for(int i=0; i<ganados.length; i++) {
            if(ganados[i] != null) {
                System.out.println((i+1) + ". " + ganados[i]);
            }            
        }
    }
    
    public void topPerdedores() {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("                                      TOP 5 PERDEDORES");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        for(BatallaPokemon b: batallas) {
            if(b != null) {
                if(!b.isEstadoPokemon1() && !b.isEstadoPokemon2()) {
                    agregarPerdedores(b.getJugador1());
                }
                if(!b.isEstadoPokemon3() && !b.isEstadoPokemon4()) {
                    agregarPerdedores(b.getJugador2());
                }
            }
        }
        for(int i=0; i<perdidos.length; i++) {
            if(perdidos[i] != null) {
                System.out.println((i+1) + ". " + perdidos[i]);
            }            
        }
    }
    
    public boolean validarNombreGanador(String nombre) {
        for(int i=0; i<contadorGanador; i++) {
            if(ganados[i].equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }
    
    public void agregarGanadores(String usuario) {
        if(contadorGanador < 5) {
            if(!validarNombreGanador(usuario)) {
                ganados[contadorGanador] = usuario;
                contadorGanador++;
            }
        }
    }
    
    public boolean validarNombrePerdedor(String nombre) {
        for(int i=0; i<contadorPerdedor; i++) {
            if(perdidos[i].equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }
    
    public void agregarPerdedores(String usuario) {
        if(contadorPerdedor < 5) {
            if(!validarNombrePerdedor(usuario)) {
                perdidos[contadorPerdedor] = usuario;
                contadorPerdedor++;
            }
        }
    }

    public void pokemonMasElegido() {
        int contadorPokemon1 = 0;
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("                                      MÁS VECES ELEGIDOS");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        for(int i =0; i <ControladorPokemon.getInstancia().listaPokemones.length; i++) {
            if(ControladorPokemon.getInstancia().listaPokemones[i] != null) {
                for(int j=0; j < batallas.length; j++) {
                    if(batallas[j]!=null) {
                        if(ControladorPokemon.getInstancia().listaPokemones[i].getNombrePokemon().equalsIgnoreCase(batallas[j].getPokemon1().getNombrePokemon())) {
                           contadorPokemon1 ++;
                       }
                        if(ControladorPokemon.getInstancia().listaPokemones[i].getNombrePokemon().equalsIgnoreCase(batallas[j].getPokemon2().getNombrePokemon())) {
                           contadorPokemon1 ++;
                       }
                        if(ControladorPokemon.getInstancia().listaPokemones[i].getNombrePokemon().equalsIgnoreCase(batallas[j].getPokemon3().getNombrePokemon())) {
                           contadorPokemon1 ++;
                       }
                        if(ControladorPokemon.getInstancia().listaPokemones[i].getNombrePokemon().equalsIgnoreCase(batallas[j].getPokemon4().getNombrePokemon())) {
                           contadorPokemon1 ++;
                       }  
                    }
                }
                if(contadorPokemon1 > 0) {
                    System.out.println(ControladorPokemon.getInstancia().listaPokemones[i].getImagenPokemon());
                    System.out.println("Pokémon:" + ControladorPokemon.getInstancia().listaPokemones[i]);
                    System.out.println("No. Veces Seleccionados:" + contadorPokemon1);
                    contadorPokemon1 = 0;
                }                
            }                        
        }
        
    }

    public void pokemonMenosElegido() {
        int contadorPokemon1 = 0;
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("                                      MENOS VECES ELEGIDOS");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        for(int i =0; i <ControladorPokemon.getInstancia().listaPokemones.length; i++) {
            if(ControladorPokemon.getInstancia().listaPokemones[i] != null) {
                for(int j=0; j < batallas.length; j++) {
                    if(batallas[j]!=null) {
                        if(ControladorPokemon.getInstancia().listaPokemones[i].getNombrePokemon().equalsIgnoreCase(batallas[j].getPokemon1().getNombrePokemon())) {
                           contadorPokemon1 ++;
                        }
                        if(ControladorPokemon.getInstancia().listaPokemones[i].getNombrePokemon().equalsIgnoreCase(batallas[j].getPokemon2().getNombrePokemon())) {
                           contadorPokemon1 ++;
                        }
                        if(ControladorPokemon.getInstancia().listaPokemones[i].getNombrePokemon().equalsIgnoreCase(batallas[j].getPokemon3().getNombrePokemon())) {
                           contadorPokemon1 ++;
                        }
                        if(ControladorPokemon.getInstancia().listaPokemones[i].getNombrePokemon().equalsIgnoreCase(batallas[j].getPokemon4().getNombrePokemon())) {
                           contadorPokemon1 ++;
                        }
                    }
                }
                if(contadorPokemon1 <= 0) {
                    System.out.println(ControladorPokemon.getInstancia().listaPokemones[i].getImagenPokemon());
                    System.out.println("Pokémon:" + ControladorPokemon.getInstancia().listaPokemones[i]);
                    System.out.println("No. Veces Seleccionados:" + contadorPokemon1);
                }             
                contadorPokemon1 = 0;
            }                        
        }   
    }
    
    public int validarNumero() {
        boolean estado = true;
        int ingreso;
        do {
            try {
                System.out.print(">> ");
                ingreso = Integer.parseInt(IngresoDatos.getInstancia().ingreso());
                switch(ingreso) {
                    case 1:
                        estado = false;
                        return ingreso;
                    case 2:
                        estado = false;
                        return ingreso;
                    default:
                        System.err.println("Ingrese una de las opciones correctamente.");
                        estado = true;
                    break;
                }      
            } catch (Exception e) {
                System.err.println("Debe de ingresar un número.");
                estado = true;
            }
        } while(estado);
        return 0;
    }
    
    //GENERAR UN NUMERO ENTRE DOS RANGOS
    public int valorAleatorio(int n) {
        return (int) (Math.random() * n) + 1;
    }
}
