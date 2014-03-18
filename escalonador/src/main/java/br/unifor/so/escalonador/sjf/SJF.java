package br.unifor.so.escalonador.sjf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.unifor.so.escalonador.model.Processo;

public class SJF implements Serializable {
	
	private static final long serialVersionUID = 2570825148671880521L;

	private List<Processo> processos;
	private int tempo;
	private int numero;
	private int total = 0;
	private float avg = 0;
	
	public List<Processo> getProcessos() {
		if (processos == null) {
			processos = new ArrayList<Processo>();
		}
		return processos;
	}
	public void setProcessos(List<Processo> processos) {
		this.processos = processos;
	}
	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public float getAvg() {
		return avg;
	}
	public void setAvg(float avg) {
		this.avg = avg;
	}
}