package br.unifor.so.escalonador.algoritmo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import br.unifor.so.escalonador.Principal;
import br.unifor.so.escalonador.model.Processo;
import br.unifor.so.escalonador.model.thread.ProcessoThreadFIFO;

public class FIFO implements ActionListener {

	@Override
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		if (Principal.processamento != null)
			Principal.processamento.stop();

		Principal.processosAptos = new ArrayList<Processo>();
		Principal.processosEmExecucao = new ArrayList<Processo>();
		this.criarProcessos();
		this.montarNucleos();
		this.montarPrecessos();
		
		Principal.processamento = new ProcessoThreadFIFO();
		Principal.processamento.start();
	}

	public void criarProcessos() {
		for (int i = 0; i < Integer.parseInt(Principal.tfProcessos.getText()); i++) {
			Processo processo = new Processo();
			Principal.processosAptos.add(processo);
		}
	}

	private void montarNucleos() {
		JPanel panel = new JPanel();
		Principal.paProcessando.removeAll();
		for (int i = 0; i < Integer.parseInt(Principal.tfNucleos.getText()); i++) {
			Principal.processosEmExecucao.add(Principal.processosAptos.get(i));
			panel.add(Principal.processosEmExecucao.get(i).montarDesenhoDoProcesso());
		}
		Principal.processosAptos.removeAll(Principal.processosEmExecucao);
		Principal.paProcessando.add(new JScrollPane(panel));
		Principal.paProcessando.repaint();
		Principal.paProcessando.revalidate();
	}

	public void montarPrecessos() {
		JPanel panel = new JPanel();
		Principal.paAProcessar.removeAll();
		for (int i = 0; i < Principal.processosAptos.size(); i++) {
			panel.add(Principal.processosAptos.get(i).montarDesenhoDoProcesso());
		}
		Principal.paAProcessar.add(new JScrollPane(panel));
		Principal.paAProcessar.repaint();
		Principal.paAProcessar.revalidate();
	}
}