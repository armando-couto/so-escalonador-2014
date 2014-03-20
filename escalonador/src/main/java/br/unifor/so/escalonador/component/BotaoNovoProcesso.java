package br.unifor.so.escalonador.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.unifor.so.escalonador.Principal;
import br.unifor.so.escalonador.algoritmo.FIFO;

public class BotaoNovoProcesso implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Principal.cbAlgoritmo.getSelectedItem().toString()) {
		case "FIFO":
			FIFO fifo = new FIFO();
			fifo.criarProcessos();
			fifo.montarPrecessos();
			break;
		case "SJF - Shortest Job First":

			break;
		case "Round Robin":

			break;
		case "N-FIFO":

			break;
		case "SRT - Shortest Remaining Time":

			break;
		default:

			break;
		}
	}
}