package br.unifor.so.escalonador;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Principal extends JFrame {

	private static final long serialVersionUID = 8936578361797638901L;

	private JPanel paParametros;
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
		JPanel paProcessando = new JPanel();
		paProcessando.setBorder(new TitledBorder(null, "Processando ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		paProcessando.setBounds(17, 191, 819, 119);
		getContentPane().add(paProcessando);
	}

	private void panelProcessando() {
		JPanel paAProcessar = new JPanel();
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
		paParametros.add(cbAlgoritmo);
	}

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Principal().setVisible(true);
			}
		});
	}
}