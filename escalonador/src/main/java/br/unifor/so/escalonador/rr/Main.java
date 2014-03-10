package br.unifor.so.escalonador.rr;

import java.io.DataInputStream;
import java.io.IOException;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String args[]) throws IOException {
		DataInputStream in = new DataInputStream(System.in);
		RoundRobin rr = new RoundRobin();
		
		System.out.println("Enter number of process:");
		rr.setNumeroProcessos(Integer.parseInt(in.readLine()));
		rr.colocarTempo();
		
		System.out.println("Enter Time quantum:");
		rr.setQuantum(Integer.parseInt(in.readLine()));
		rr.algoritmo();
		rr.imprimir();
	}
}