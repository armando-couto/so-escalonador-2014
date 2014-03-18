package br.unifor.so.escalonador.model;

import java.awt.Color;
import java.io.Serializable;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class Processo implements Serializable {

	private static final long serialVersionUID = 1038124241569745320L;

	private int codigo;
	private int tempoInicial;
	private int tempoFinal;

	public Processo() {
		Random r = new Random();
		this.codigo = r.nextInt(1000);
		this.tempoInicial = 0;
		this.tempoFinal = r.nextInt(Integer.MAX_VALUE);
	}
	
	public JLabel montarDesenhoDoProcesso() {
		StringBuilder sb = new StringBuilder();
		JLabel label = new JLabel();
		sb.append("<html>I: " + this.codigo + "<br>");
		sb.append("TI: " + this.tempoInicial + "<br>");
		sb.append("TF: " + this.tempoFinal + "<br></html");
		label.setText(sb.toString());
		label.setForeground(Color.BLUE);
		label.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		return label;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getTempoInicial() {
		return tempoInicial;
	}

	public void setTempoInicial(int tempoInicial) {
		this.tempoInicial = tempoInicial;
	}

	public int getTempoFinal() {
		return tempoFinal;
	}

	public void setTempoFinal(int tempoFinal) {
		this.tempoFinal = tempoFinal;
	}
}