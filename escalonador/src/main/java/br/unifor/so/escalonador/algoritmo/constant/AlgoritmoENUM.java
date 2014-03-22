package br.unifor.so.escalonador.algoritmo.constant;

public enum AlgoritmoENUM {

	SELECIONE (0, "Selecione"),
	FIFO (1, "FIFO"),
	SJF (2, "SJF - Shortest Job First"),
	RR (3, "Round Robin"),
	N_FIFO (4, "N-FIFO"),
	SRT (5, "SRT - Shortest Remaining Time");
	
	private int id;
	private String descricao;
	
	private AlgoritmoENUM(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}