package br.unifor.so.escalonador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
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

	private List<Processo> processosEmExecucao = new ArrayList<Processo>();
	private List<Processo> processosAptos = new ArrayList<Processo>();

	private JPanel paParametros;
	private JScrollPane paProcessando;
	private JScrollPane paAProcessar;
	private JTextField tfNucleos;
	private JTextField tfProcessos;
	private JTextField tfQuantum;

	public Principal() {
		setTitle("Escalonador\n");
		getContentPane().setLayout(null);

		this.setSize(850, 550);

		this.panelParametros();
		this.panelProcessando();
		this.panelAProcessar();

		this.nucleo();
		this.processos();
		this.quantum();
		this.algoritmo();
	}

	private void panelParametros() {
		paParametros = new JPanel();
		paParametros.setBorder(new TitledBorder(null, "Par\u00E2metros ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		paParametros.setBounds(17, 21, 819, 118);
		getContentPane().add(paParametros);
		paParametros.setLayout(null);
	}

	private void panelAProcessar() {
		paProcessando = new JScrollPane();
		paProcessando.setBorder(new TitledBorder(null, "Processando ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		paProcessando.setBounds(17, 191, 819, 119);
		getContentPane().add(paProcessando);
	}

	private void panelProcessando() {
		paAProcessar = new JScrollPane();
		paAProcessar.setBorder(new TitledBorder(null, "A Processar ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		paAProcessar.setBounds(17, 322, 819, 181);
		getContentPane().add(paAProcessar);
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

		JComboBox cbAlgoritmo = new JComboBox();
		cbAlgoritmo.setBounds(351, 20, 316, 27);
		cbAlgoritmo.addItem("Selecione");
		cbAlgoritmo.addItem("FIFO");
		cbAlgoritmo.addItem("SJF - Shortest Job First");
		cbAlgoritmo.addItem("Round Robin");
		cbAlgoritmo.addItem("N-FIFO");
		cbAlgoritmo.addItem("SRT - Shortest Remaining Time");
		paParametros.add(cbAlgoritmo);

		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.montarPrecessos();
			}

			private void montarPrecessos() {
				JPanel panel = new JPanel();
				for (int i = 0; i < Integer.parseInt(tfProcessos.getText()); i++) {
					Processo processo = new Processo();
					processosAptos.add(processo);
					panel.add(processo.montarDesenhoDoProcesso());
				}
				panel.setAutoscrolls(true);
				paAProcessar.setRowHeaderView(panel);
				paAProcessar.repaint();
				paAProcessar.revalidate();
			}
		});
		btnIniciar.setBounds(569, 85, 117, 29);
		paParametros.add(btnIniciar);

		JButton btnNovoProcesso = new JButton("Novo Processos");
		btnNovoProcesso.setBounds(696, 85, 117, 29);
		paParametros.add(btnNovoProcesso);
	}

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Principal().setVisible(true);
			}
		});
	}
}