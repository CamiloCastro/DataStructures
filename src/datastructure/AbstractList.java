/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure;

/**
 *
 * @author jccas
 */
public abstract class AbstractList<T> implements List<T> {

    protected int size;
    
    @Override
    public int size() {
        return size;
    }

    @Override
    public abstract T get(int index); 

    @Override
    public abstract boolean add(T element);        

    @Override
    public abstract void add(int index, T element);

    @Override
    public abstract void set(int index, T element);

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public abstract T remove(int index);

    @Override
    public abstract void clear();

    @Override
    public abstract void print();

    @Override
    public abstract void sort();
    
}
