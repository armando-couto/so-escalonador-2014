package br.unifor.so.escalonador.algoritmo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import br.unifor.so.escalonador.Principal;
import br.unifor.so.escalonador.model.Processo;
import br.unifor.so.escalonador.model.thread.ProcessoThreadSRT;

public class SRT extends Algoritmo implements ActionListener {

	@Override
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		if (Principal.processamento != null)
			Principal.processamento.stop();

		Principal.processosAptos = new ArrayList<Processo>();
		Principal.processosEmExecucao = new ArrayList<Processo>();
		criarProcessos();
		montarNucleos();
		montarPrecessos();
		
		Principal.processamento = new ProcessoThreadSRT();
		Principal.processamento.start();
	}
	
	@Override
	public void criarProcessos() {
		super.criarProcessos();
		Principal.processosAptos.addAll(Principal.processosEmExecucao);
		for (Processo processo : Principal.processosAptos) {
			processo.calculaTempoAindaDeExecucao();
		}
		Collections.sort(Principal.processosAptos, new Processo());
	}
}