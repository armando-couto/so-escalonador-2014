package br.unifor.so.escalonador.rr;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class RoundRobin implements Serializable {

	private static final long serialVersionUID = -3748406811457211357L;
	
	private int numeroProcessos;
	private int quantum;
	private int sum = 0;
	private int bt[];
	private int wt[];
	private int tat[];
	private int a[];
	
	public void algoritmo() {
		wt = new int[numeroProcessos];
		tat = new int[numeroProcessos];
		a = new int[numeroProcessos];
				
		for (int i = 0; i < numeroProcessos; i++)
			a[i] = bt[i];
		for (int i = 0; i < numeroProcessos; i++)
			wt[i] = 0;
		do {
			for (int i = 0; i < numeroProcessos; i++) {
				if (bt[i] > quantum) {
					bt[i] -= quantum;
					for (int j = 0; j < numeroProcessos; j++) {
						if ((j != i) && (bt[j] != 0))
							wt[j] += quantum;
					}
				} else {
					for (int j = 0; j < numeroProcessos; j++) {
						if ((j != i) && (bt[j] != 0))
							wt[j] += bt[i];
					}
					bt[i] = 0;
				}
			}
			sum = 0;
			for (int k = 0; k < numeroProcessos; k++)
				sum = sum + bt[k];
		} while (sum != 0);
		for (int i = 0; i < numeroProcessos; i++)
			tat[i] = wt[i] + a[i];
	}

	public void colocarTempo() throws NumberFormatException, IOException {
		Scanner s = new Scanner(System.in);
		bt = new int[numeroProcessos];
		System.out.println("Enter brust Time:");
		for (int i = 0; i < numeroProcessos; i++) {
			System.out.println("Enter brust Time for   " + (i + 1));
			bt[i] = s.nextInt();
		}
	}
	
	public void imprimir() {
		System.out.println("process\t\tBT\tWT\tTAT");
		for (int i = 0; i < numeroProcessos; i++) {
			System.out.println("process" + (i + 1) + "\t" + a[i] + "\t" + wt[i] + "\t" + tat[i]);
		}
		float avg_wt = 0;
		float avg_tat = 0;
		for (int j = 0; j < numeroProcessos; j++) {
			avg_wt += wt[j];
		}
		for (int j = 0; j < numeroProcessos; j++) {
			avg_tat += tat[j];
		}
		System.out.println("average wating time " + (avg_wt / numeroProcessos) + "\nAverage turn around time" + (avg_tat / numeroProcessos));
	}
	
	public int getNumeroProcessos() {
		return numeroProcessos;
	}

	public void setNumeroProcessos(int numeroProcessos) {
		this.numeroProcessos = numeroProcessos;
	}

	public int getQuantum() {
		return quantum;
	}

	public void setQuantum(int quantum) {
		this.quantum = quantum;
	}
}