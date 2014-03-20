package br.unifor.so.escalonador.algoritmo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import br.unifor.so.escalonador.Principal;
import br.unifor.so.escalonador.model.Processo;
import br.unifor.so.escalonador.model.thread.ProcessoThreadRR;

/**
 * Round Robin
 * 
 * @author armandocouto
 * @email coutoarmando@gmail.com
 * @date 20/03/2014
 */
public class RR extends Algoritmo implements ActionListener {

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
		
		Principal.processamento = new ProcessoThreadRR();
		Principal.processamento.start();
	}
}