package br.unifor.so.escalonador.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.unifor.so.escalonador.Principal;
import br.unifor.so.escalonador.algoritmo.FIFO;
import br.unifor.so.escalonador.algoritmo.NFIFO;
import br.unifor.so.escalonador.algoritmo.RR;
import br.unifor.so.escalonador.algoritmo.SJF;
import br.unifor.so.escalonador.algoritmo.SRT;

public class BotaoIniciar implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Principal.algoritmoENUM.getId()) {
		case 0:
			JOptionPane.showMessageDialog(null, "Selecione um Algoritmo.");
			break;
		case 1:
			Principal.tfQuantum.setEditable(false);
			Principal.btnIniciar.addActionListener(new FIFO());
			break;
		case 2:
			Principal.tfQuantum.setEditable(false);
			Principal.btnIniciar.addActionListener(new SJF());
			break;
		case 3:
			Principal.tfQuantum.setEditable(true);
			Principal.btnIniciar.addActionListener(new RR());
			break;
		case 4:
			Principal.tfQuantum.setEditable(false);
			Principal.btnIniciar.addActionListener(new NFIFO());
			break;
		case 5:
			Principal.tfQuantum.setEditable(false);
			Principal.btnIniciar.addActionListener(new SRT());
			break;
		}
	}
}