package br.unifor.so.escalonador.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.unifor.so.escalonador.Principal;
import br.unifor.so.escalonador.algoritmo.FIFO;
import br.unifor.so.escalonador.algoritmo.SJF;

public class BotaoNovo implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Principal.cbAlgoritmo.getSelectedItem().toString()) {
		case "FIFO":
			Principal.btnIniciar.addActionListener(new FIFO());
			break;
		case "SJF - Shortest Job First":
			Principal.btnIniciar.addActionListener(new SJF());
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