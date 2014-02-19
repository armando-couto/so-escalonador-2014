package br.unifor.so.escalonador.fifo;

import java.util.ArrayList;

public class Fifo<E> {

	private ArrayList<E> lista;
	
	public Fifo() {
		lista = new ArrayList<E>();
	}
	
	public void push(E obj) {
		lista.add(obj);
	}
	
	public E pull() {
		if(!lista.isEmpty()) {
			E obj = lista.get(0);
			lista.remove(0);
			return obj;
		}
		return null;
	}
	
	public int size() {
		if(!lista.isEmpty()) {
			return lista.size();
		}
		return 0;
	}
}
