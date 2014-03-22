package br.unifor.so.escalonador.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.unifor.so.escalonador.Principal;
import br.unifor.so.escalonador.algoritmo.constant.AlgoritmoENUM;

public class ComboBoxSelecao implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// Zera o código do ID quando troca.
		Principal.codigo = 0;
		switch (Principal.cbAlgoritmo.getSelectedItem().toString()) {
		case "Selecione":
			Principal.tfQuantum.setEditable(false);
			break;
		case "FIFO":
			Principal.algoritmoENUM = AlgoritmoENUM.FIFO;
			break;
		case "SJF - Shortest Job First":
			Principal.algoritmoENUM = AlgoritmoENUM.SJF;
			Principal.tfQuantum.setEditable(false);
			break;
		case "Round Robin":
			Principal.algoritmoENUM = AlgoritmoENUM.RR;
			Principal.tfQuantum.setEditable(true);
			break;
		case "N-FIFO":
			Principal.algoritmoENUM = AlgoritmoENUM.N_FIFO;
			Principal.tfQuantum.setEditable(false);
			break;
		case "SRT - Shortest Remaining Time":
			Principal.algoritmoENUM = AlgoritmoENUM.SRT;
			Principal.tfQuantum.setEditable(false);
			break;
		}
	}
}