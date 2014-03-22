package br.unifor.so.escalonador.model.thread;

import javax.swing.JPanel;

import br.unifor.so.escalonador.Principal;
import br.unifor.so.escalonador.model.Processo;

public class ProcessoThreadNFIFO extends Thread {

	@SuppressWarnings("static-access")
	public void run() {
		boolean checar = true;
		while (checar) {
			JPanel panel = new JPanel();
			for (int i = 0; i < Principal.processosEmExecucao.size(); i++) {
				Processo processo = Principal.processosEmExecucao.get(i);
				processo.processamento();
				if (processo.checarSeOTempoZerou()) {
					Principal.processosEmExecucao.remove(processo);
					if (!Principal.processosAptos.isEmpty()) {
						panel.add(Principal.processosAptos.get(0).montarDesenhoDoProcessoComPrioridade());
						Principal.processosEmExecucao.add(i, Principal.processosAptos.get(0));
						Principal.processosAptos.remove(0);

						Principal.paAProcessar.removeAll();

						JPanel panelAptos = new JPanel();
						for (Processo processoAptos : Principal.processosAptos) {
							panelAptos.add(processoAptos.montarDesenhoDoProcessoComPrioridade());
						}
						Principal.reorganizarAProcessar(panelAptos);
					}
				} else {
					panel.add(Principal.processosEmExecucao.get(i).montarDesenhoDoProcessoComPrioridade());
					Principal.processosEmExecucao.set(i, processo);
				}
			}
			Principal.reorganizarProcessando(panel);

			try {
				checar = !Principal.processosEmExecucao.isEmpty();
				Principal.processamento.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}