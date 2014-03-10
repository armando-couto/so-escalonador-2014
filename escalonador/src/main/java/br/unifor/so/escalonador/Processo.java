package br.unifor.so.escalonador;

import java.io.Serializable;

public class Processo implements Serializable {

	private static final long serialVersionUID = 1038124241569745320L;

	private int pTempo;
	private int wTempo;
	private String dados;

	public int getpTempo() {
		return pTempo;
	}
	public void setpTempo(int pTempo) {
		this.pTempo = pTempo;
	}
	public int getwTempo() {
		return wTempo;
	}
	public void setwTempo(int wTempo) {
		this.wTempo = wTempo;
	}
	public String getDados() {
		return dados;
	}
	public void setDados(String dados) {
		this.dados = dados;
	}
}