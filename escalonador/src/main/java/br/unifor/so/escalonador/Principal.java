package br.unifor.so.escalonador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import br.unifor.so.escalonador.model.Processo;

public class Principal extends JFrame {

	private static final long serialVersionUID = 8936578361797638901L;

	private Thread processamento;

	public static List<Processo> processosEmExecucao;
	private List<Processo> processosAptos;

	private JPanel paParametros;
	public static JPanel paProcessando;
	private JScrollPane spaProcessando;
	private JPanel paAProcessar;
	private JScrollPane spaAProcessar;
	private JComboBox cbAlgoritmo;
	private JTextField tfNucleos;
	private JTextField tfProcessos;
	private JTextField tfQuantum;

	public Principal() {
		setTitle("Escalonador\n");
		getContentPane().setLayout(null);

		this.setSize(850, 550);
		spaProcessando = new JScrollPane(paProcessando);
		spaAProcessar = new JScrollPane(paAProcessar);

		this.panelParametros();
		this.panelProcessando();
		this.panelAProcessar();

		this.nucleo();
		this.processos();
		this.quantum();
		this.algoritmo();

		this.acoes();
	}

	private void panelParametros() {
		paParametros = new JPanel();
		paParametros.setBorder(new TitledBorder(null, "Par\u00E2metros ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		paParametros.setBounds(17, 21, 819, 118);
		getContentPane().add(paParametros);
		paParametros.setLayout(null);
	}

	private void panelProcessando() {
		paProcessando = new JPanel();
		paProcessando.setBorder(new TitledBorder(null, "Processando ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		paProcessando.setBounds(17, 191, 819, 104);
		getContentPane().add(paProcessando);
		paProcessando.setLayout(new BorderLayout(0, 0));
	}

	private void panelAProcessar() {
		paAProcessar = new JPanel();
		paAProcessar.setBorder(new TitledBorder(null, "A Processar ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		paAProcessar.setBounds(17, 322, 819, 104);
		getContentPane().add(paAProcessar);
		paAProcessar.setLayout(new BorderLayout(0, 0));
	}

	private void nucleo() {
		JLabel lbNucleos = new JLabel("Núcleos:");
		lbNucleos.setBounds(46, 24, 55, 16);
		paParametros.add(lbNucleos);

		tfNucleos = new JTextField();
		tfNucleos.setBounds(106, 18, 132, 28);
		paParametros.add(tfNucleos);
		tfNucleos.setColumns(100);
	}

	private void processos() {
		JLabel lbProcessos = new JLabel("Processos:");
		lbProcessos.setBounds(34, 57, 67, 16);
		paParametros.add(lbProcessos);

		tfProcessos = new JTextField();
		tfProcessos.setBounds(106, 51, 132, 28);
		paParametros.add(tfProcessos);
		tfProcessos.setColumns(100);
	}

	private void quantum() {
		JLabel lbQuantum = new JLabel("Quantum:");
		lbQuantum.setBounds(39, 90, 62, 16);
		paParametros.add(lbQuantum);

		tfQuantum = new JTextField();
		tfQuantum.setBounds(106, 84, 132, 28);
		paParametros.add(tfQuantum);
		tfQuantum.setColumns(100);
	}

	private void algoritmo() {
		JLabel lbAlgoritmo = new JLabel("Algoritmo:");
		lbAlgoritmo.setBounds(276, 24, 72, 16);
		paParametros.add(lbAlgoritmo);

		cbAlgoritmo = new JComboBox();
		cbAlgoritmo.setBounds(351, 20, 316, 27);
		cbAlgoritmo.addItem("Selecione");
		cbAlgoritmo.addItem("FIFO");
		cbAlgoritmo.addItem("SJF - Shortest Job First");
		cbAlgoritmo.addItem("Round Robin");
		cbAlgoritmo.addItem("N-FIFO");
		cbAlgoritmo.addItem("SRT - Shortest Remaining Time");
		paParametros.add(cbAlgoritmo);
	}

	private void acoes() {
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (processamento != null)
					processamento.stop();
				
				processosAptos = new ArrayList<Processo>();
				processosEmExecucao = new ArrayList<Processo>();
				this.criarProcessos();
				this.montarNucleos();
				this.montarPrecessos();

				class HelloThread extends Thread {

					@SuppressWarnings("static-access")
					public void run() {
						boolean checar = true;
						while (checar) {
							JPanel panel = new JPanel();
							for (int i = 0; i < processosEmExecucao.size(); i++) {
								Processo processo = processosEmExecucao.get(i);
								processo.processamento();
								if (processo.checarSeOTempoZerou()) {
									processosEmExecucao.remove(processo);
									if ( !processosAptos.isEmpty()) {
										panel.add(processosAptos.get(0).montarDesenhoDoProcesso());
										processosEmExecucao.add(processosAptos.get(0));
										processosAptos.remove(0);
										
										paAProcessar.removeAll();
										
										JPanel panelAptos = new JPanel();
										for (Processo processoAptos : processosAptos) {
											panelAptos.add(processoAptos.montarDesenhoDoProcesso());
										}
										paAProcessar.add(new JScrollPane(panelAptos));
										paAProcessar.repaint();
										paAProcessar.revalidate();
									} 
								} else {
									panel.add(processosEmExecucao.get(i).montarDesenhoDoProcesso());
									processosEmExecucao.set(i, processo);
								}
							}
							paProcessando.removeAll();
							paProcessando.add(new JScrollPane(panel));
							paProcessando.repaint();
							paProcessando.revalidate();
							try {
								checar = !processosEmExecucao.isEmpty();
								processamento.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}
				processamento = new HelloThread();
				processamento.start();
			}

			private void criarProcessos() {
				for (int i = 0; i < Integer.parseInt(tfProcessos.getText()); i++) {
					Processo processo = new Processo();
					processosAptos.add(processo);
				}
			}

			private void montarNucleos() {
				JPanel panel = new JPanel();
				paProcessando.removeAll();
				for (int i = 0; i < Integer.parseInt(tfNucleos.getText()); i++) {
					processosEmExecucao.add(processosAptos.get(i));
					panel.add(processosEmExecucao.get(i).montarDesenhoDoProcesso());
				}
				processosAptos.removeAll(processosEmExecucao);
				paProcessando.add(new JScrollPane(panel));
				paProcessando.repaint();
				paProcessando.revalidate();
			}

			private void montarPrecessos() {
				JPanel panel = new JPanel();
				paAProcessar.removeAll();
				for (int i = 0; i < processosAptos.size(); i++) {
					panel.add(processosAptos.get(i).montarDesenhoDoProcesso());
				}
				paAProcessar.add(new JScrollPane(panel));
				paAProcessar.repaint();
				paAProcessar.revalidate();
			}
		});
		btnIniciar.setBounds(531, 85, 117, 29);
		paParametros.add(btnIniciar);

		JButton btnNovoProcesso = new JButton("Novo Processos");
		btnNovoProcesso.setBounds(661, 85, 152, 29);
		paParametros.add(btnNovoProcesso);
	}

	private void escolherAlgoritmo() {
		switch (cbAlgoritmo.getSelectedItem().toString()) {
		case "FIFO":

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

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Principal().setVisible(true);
			}
		});
	}
}