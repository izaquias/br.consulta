/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Dao;

import java.util.List;

/**
 *
 * @author Izaquias
 * @param <T>
 *
 */
public interface DaoGenerico<T> {

    public void inserir(T t);

    public void alterar(T t);

    public T recuperar(Long chave);

    public void excluir(T t);

    public List<T> recuperarTodos();

}
