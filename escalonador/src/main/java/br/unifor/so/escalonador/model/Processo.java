package br.unifor.so.escalonador.model;

import java.awt.Color;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class Processo implements Comparator<Processo>, Serializable {

	private static final long serialVersionUID = 1038124241569745320L;

	private Integer codigo;
	private Integer tempoInicial;
	private Integer tempoFinal;

	public Processo() {
		Random r = new Random();
		this.codigo = r.nextInt(40);
		this.tempoInicial = 0;
		this.tempoFinal = r.nextInt(100);
	}
	
	public JLabel montarDesenhoDoProcesso() {
		StringBuilder sb = new StringBuilder();
		JLabel label = new JLabel();
		sb.append("<html>Id: " + this.codigo + "<br>");
		sb.append("TI: " + this.tempoInicial + "<br>");
		sb.append("TF: " + this.tempoFinal + "<br></html");
		label.setText(sb.toString());
		label.setForeground(Color.BLUE);
		label.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		return label;
	}
	
	public void processamento() {
		if (tempoInicial < tempoFinal)
			tempoInicial++;
	}
	
	public boolean checarSeOTempoZerou() {
		if (tempoInicial >= tempoFinal)
			return true;
		else
			return false;
	}
	
	@Override
	public int compare(Processo o1, Processo o2) {
		return o1.getTempoFinal().compareTo(o2.getTempoFinal());
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getTempoInicial() {
		return tempoInicial;
	}

	public void setTempoInicial(Integer tempoInicial) {
		this.tempoInicial = tempoInicial;
	}

	public Integer getTempoFinal() {
		return tempoFinal;
	}

	public void setTempoFinal(Integer tempoFinal) {
		this.tempoFinal = tempoFinal;
	}
}