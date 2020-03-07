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
public class Pokemon {
    private String nombrePokemon;
    private String imagenPokemon;
    private int vidaPokemon;
    private int ataquePokemon;
    private boolean estadoPokemon;

    /**
     * @return the nombrePokemon
     */
    public String getNombrePokemon() {
        return nombrePokemon;
    }

    /**
     * @param nombrePokemon the nombrePokemon to set
     */
    public void setNombrePokemon(String nombrePokemon) {
        this.nombrePokemon = nombrePokemon;
    }

    /**
     * @return the imagenPokemon
     */
    public String getImagenPokemon() {
        return imagenPokemon;
    }

    /**
     * @param imagenPokemon the imagenPokemon to set
     */
    public void setImagenPokemon(String imagenPokemon) {
        this.imagenPokemon = imagenPokemon;
    }

    /**
     * @return the vidaPokemon
     */
    public int getVidaPokemon() {
        return vidaPokemon;
    }

    /**
     * @param vidaPokemon the vidaPokemon to set
     */
    public void setVidaPokemon(int vidaPokemon) {
        this.vidaPokemon = vidaPokemon;
    }

    /**
     * @return the ataquePokemon
     */
    public int getAtaquePokemon() {
        return ataquePokemon;
    }

    /**
     * @param ataquePokemon the ataquePokemon to set
     */
    public void setAtaquePokemon(int ataquePokemon) {
        this.ataquePokemon = ataquePokemon;
    }

    /**
     * @return the estadoPokemon
     */
    public boolean isEstadoPokemon() {
        return estadoPokemon;
    }

    /**
     * @param estadoPokemon the estadoPokemon to set
     */
    public void setEstadoPokemon(boolean estadoPokemon) {
        this.estadoPokemon = estadoPokemon;
    }
    
    public void setHerida(int bajarPuntos) {
        this.vidaPokemon = ((this.vidaPokemon - bajarPuntos)>=0)?(this.vidaPokemon - bajarPuntos):0;
    }

    @Override
    public String toString() {
        return getNombrePokemon();
    }
    
}
