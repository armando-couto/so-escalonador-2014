package br.unifor.so.escalonador.algoritmo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import br.unifor.so.escalonador.Principal;
import br.unifor.so.escalonador.model.Processo;
import br.unifor.so.escalonador.model.thread.ProcessoThreadSJF;

/**
 * Shortest Job First - SJF
 * 
 * @author armandocouto
 * @email coutoarmando@gmail.com
 * @date 20/03/2014
 */
public class SJF extends Algoritmo implements ActionListener {

	@Override
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		if (Principal.processamento != null)
			Principal.processamento.stop();

		Principal.processosAptos = new ArrayList<Processo>();
		Principal.processosEmExecucao = new ArrayList<Processo>();
		this.criarProcessos();
		montarNucleos();
		montarPrecessos();
		
		Principal.processamento = new ProcessoThreadSJF();
		Principal.processamento.start();
	}

	@Override
	public void criarProcessos() {
		super.criarProcessos();
		Collections.sort(Principal.processosAptos, new Processo());
	}
}