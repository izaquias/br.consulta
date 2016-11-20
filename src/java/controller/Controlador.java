/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;

/**
 *
 * @author Izaquias
 * 
 */
public interface Controlador {

    public String inserir();

    public String alterar();

    public String deletar();

    public Object recuperar(Long id);

    public List recuperarTodos();

}
