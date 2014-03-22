package br.unifor.so.escalonador.algoritmo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

import br.unifor.so.escalonador.Principal;
import br.unifor.so.escalonador.model.Processo;
import br.unifor.so.escalonador.model.thread.ProcessoThreadNFIFO;

/**
 * N-FIFO ou filas de prioridade.
 * 
 * @author armandocouto
 * @email coutoarmando@gmail.com
 * @date 20/03/2014
 */
public class NFIFO extends Algoritmo implements ActionListener {

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

		Principal.processamento = new ProcessoThreadNFIFO();
		Principal.processamento.start();
	}

	@Override
	public void criarProcessos() {
		super.criarProcessos();
		Principal.processosAptos.addAll(Principal.processosEmExecucao);
		for (Processo processo : Principal.processosAptos) {
			processo.gerarPrioridade();
		}
		Collections.sort(Principal.processosAptos, new Processo());
	}

	public static void montarNucleos() {
		JPanel panel = new JPanel();
		Principal.paProcessando.removeAll();
		for (int i = 0; i < Integer.parseInt(Principal.tfNucleos.getText()); i++) {
			Principal.processosEmExecucao.add(Principal.processosAptos.get(i));
			panel.add(Principal.processosEmExecucao.get(i).montarDesenhoDoProcessoComPrioridade());
		}
		Principal.reorganizarProcessandoClasse(panel);
	}

	public static void montarPrecessos() {
		JPanel panel = new JPanel();
		Principal.paAProcessar.removeAll();
		for (int i = 0; i < Principal.processosAptos.size(); i++) {
			panel.add(Principal.processosAptos.get(i).montarDesenhoDoProcessoComPrioridade());
		}
		Principal.reorganizarAProcessar(panel);
	}
}