/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.josemorente.beans;

/**
 *
 * @author Jose Morente
 */
public class BatallaPokemon {
    private String jugador1;
    private String jugador2;
    private Pokemon pokemon1;
    private boolean estadoPokemon1 = true;
    private int ataquePokemon1;
    private int recibidoPokemon1;
    private Pokemon pokemon2;
    private boolean estadoPokemon2 = true;
    private int ataquePokemon2;
    private int recibidoPokemon2;
    private Pokemon pokemon3;
    private int ataquePokemon3;
    private int recibidoPokemon3;
    private boolean estadoPokemon3 = true;
    private Pokemon pokemon4;
    private int ataquePokemon4;
    private int recibidoPokemon4;
    private boolean estadoPokemon4 = true;

    public BatallaPokemon() {
    }

    public BatallaPokemon(String jugador1, String jugador2, Pokemon pokemon1, boolean estadoPokemon1, int ataquePokemon1, int recibidoPokemon1, Pokemon pokemon2, boolean estadoPokemon2, int ataquePokemon2, int recibidoPokemon2, Pokemon pokemon3, int ataquePokemon3, int recibidoPokemon3, boolean estadoPokemon3, Pokemon pokemon4, int ataquePokemon4, int recibidoPokemon4, boolean estadoPokemon4) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.pokemon1 = pokemon1;
        this.estadoPokemon1 = estadoPokemon1;
        this.ataquePokemon1 = ataquePokemon1;
        this.recibidoPokemon1 = recibidoPokemon1;
        this.pokemon2 = pokemon2;
        this.estadoPokemon2 = estadoPokemon2;
        this.ataquePokemon2 = ataquePokemon2;
        this.recibidoPokemon2 = recibidoPokemon2;
        this.pokemon3 = pokemon3;
        this.ataquePokemon3 = ataquePokemon3;
        this.recibidoPokemon3 = recibidoPokemon3;
        this.estadoPokemon3 = estadoPokemon3;
        this.pokemon4 = pokemon4;
        this.ataquePokemon4 = ataquePokemon4;
        this.recibidoPokemon4 = recibidoPokemon4;
        this.estadoPokemon4 = estadoPokemon4;
    }
    
    /**
     * @return the jugador1
     */
    public String getJugador1() {
        return jugador1;
    }

    /**
     * @param jugador1 the jugador1 to set
     */
    public void setJugador1(String jugador1) {
        this.jugador1 = jugador1;
    }

    /**
     * @return the jugador2
     */
    public String getJugador2() {
        return jugador2;
    }

    /**
     * @param jugador2 the jugador2 to set
     */
    public void setJugador2(String jugador2) {
        this.jugador2 = jugador2;
    }

    /**
     * @return the pokemon1
     */
    public Pokemon getPokemon1() {
        return pokemon1;
    }

    /**
     * @param pokemon1 the pokemon1 to set
     */
    public void setPokemon1(Pokemon pokemon1) {
        this.pokemon1 = pokemon1;
    }

    /**
     * @return the ataquePokemon1
     */
    public int getAtaquePokemon1() {
        return ataquePokemon1;
    }

    /**
     * @param ataquePokemon1 the ataquePokemon1 to set
     */
    public void setAtaquePokemon1(int ataquePokemon1) {
        this.ataquePokemon1 = this.ataquePokemon1 + ataquePokemon1;
    }

    /**
     * @return the recibidoPokemon1
     */
    public int getRecibidoPokemon1() {
        return recibidoPokemon1;
    }

    /**
     * @param recibidoPokemon1 the recibidoPokemon1 to set
     */
    public void setRecibidoPokemon1(int recibidoPokemon1) {
        this.recibidoPokemon1 = this.recibidoPokemon1 + recibidoPokemon1;
    }

    /**
     * @return the pokemon2
     */
    public Pokemon getPokemon2() {
        return pokemon2;
    }

    /**
     * @param pokemon2 the pokemon2 to set
     */
    public void setPokemon2(Pokemon pokemon2) {
        this.pokemon2 = pokemon2;
    }

    /**
     * @return the ataquePokemon2
     */
    public int getAtaquePokemon2() {
        return ataquePokemon2;
    }

    /**
     * @param ataquePokemon2 the ataquePokemon2 to set
     */
    public void setAtaquePokemon2(int ataquePokemon2) {
        this.ataquePokemon2 = this.ataquePokemon2 + ataquePokemon2;
    }

    /**
     * @return the recibidoPokemon2
     */
    public int getRecibidoPokemon2() {
        return recibidoPokemon2;
    }

    /**
     * @param recibidoPokemon2 the recibidoPokemon2 to set
     */
    public void setRecibidoPokemon2(int recibidoPokemon2) {
        this.recibidoPokemon2 = this.recibidoPokemon2 + recibidoPokemon2;
    }

    /**
     * @return the pokemon3
     */
    public Pokemon getPokemon3() {
        return pokemon3;
    }

    /**
     * @param pokemon3 the pokemon3 to set
     */
    public void setPokemon3(Pokemon pokemon3) {
        this.pokemon3 = pokemon3;
    }

    /**
     * @return the ataquePokemon3
     */
    public int getAtaquePokemon3() {
        return ataquePokemon3;
    }

    /**
     * @param ataquePokemon3 the ataquePokemon3 to set
     */
    public void setAtaquePokemon3(int ataquePokemon3) {
        this.ataquePokemon3 = this.ataquePokemon3 + ataquePokemon3;
    }

    /**
     * @return the recibidoPokemon3
     */
    public int getRecibidoPokemon3() {
        return recibidoPokemon3;
    }

    /**
     * @param recibidoPokemon3 the recibidoPokemon3 to set
     */
    public void setRecibidoPokemon3(int recibidoPokemon3) {
        this.recibidoPokemon3 = this.recibidoPokemon3 + recibidoPokemon3;
    }

    /**
     * @return the pokemon4
     */
    public Pokemon getPokemon4() {
        return pokemon4;
    }

    /**
     * @param pokemon4 the pokemon4 to set
     */
    public void setPokemon4(Pokemon pokemon4) {
        this.pokemon4 = pokemon4;
    }

    /**
     * @return the ataquePokemon4
     */
    public int getAtaquePokemon4() {
        return ataquePokemon4;
    }

    /**
     * @param ataquePokemon4 the ataquePokemon4 to set
     */
    public void setAtaquePokemon4(int ataquePokemon4) {
        this.ataquePokemon4 = this.ataquePokemon4 + ataquePokemon4;
    }

    /**
     * @return the recibidoPokemon4
     */
    public int getRecibidoPokemon4() {
        return recibidoPokemon4;
    }

    /**
     * @param recibidoPokemon4 the recibidoPokemon4 to set
     */
    public void setRecibidoPokemon4(int recibidoPokemon4) {
        this.recibidoPokemon4 = this.recibidoPokemon4 + recibidoPokemon4;
    }

    /**
     * @return the estadoPokemon1
     */
    public boolean isEstadoPokemon1() {
        return estadoPokemon1;
    }

    /**
     * @param estadoPokemon1 the estadoPokemon1 to set
     */
    public void setEstadoPokemon1(boolean estadoPokemon1) {
        this.estadoPokemon1 = estadoPokemon1;
    }

    /**
     * @return the estadoPokemon2
     */
    public boolean isEstadoPokemon2() {
        return estadoPokemon2;
    }

    /**
     * @param estadoPokemon2 the estadoPokemon2 to set
     */
    public void setEstadoPokemon2(boolean estadoPokemon2) {
        this.estadoPokemon2 = estadoPokemon2;
    }

    /**
     * @return the estadoPokemon3
     */
    public boolean isEstadoPokemon3() {
        return estadoPokemon3;
    }

    /**
     * @param estadoPokemon3 the estadoPokemon3 to set
     */
    public void setEstadoPokemon3(boolean estadoPokemon3) {
        this.estadoPokemon3 = estadoPokemon3;
    }

    /**
     * @return the estadoPokemon4
     */
    public boolean isEstadoPokemon4() {
        return estadoPokemon4;
    }

    /**
     * @param estadoPokemon4 the estadoPokemon4 to set
     */
    public void setEstadoPokemon4(boolean estadoPokemon4) {
        this.estadoPokemon4 = estadoPokemon4;
    }

    
}
