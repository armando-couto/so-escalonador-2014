package br.unifor.so.escalonador;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import br.unifor.so.escalonador.component.BotaoNovo;
import br.unifor.so.escalonador.component.BotaoNovoProcesso;
import br.unifor.so.escalonador.model.Processo;

public class Principal extends JFrame {

	private static final long serialVersionUID = 8936578361797638901L;

	public static Thread processamento;

	public static List<Processo> processosEmExecucao;
	public static List<Processo> processosAptos;

	public static JPanel paParametros;
	public static JPanel paProcessando;
	public static JScrollPane spaProcessando;
	public static JPanel paAProcessar;
	public static JScrollPane spaAProcessar;
	public static JTextField tfNucleos;
	public static JTextField tfProcessos;
	public static JTextField tfQuantum;
	@SuppressWarnings("rawtypes")
	public static JComboBox cbAlgoritmo;
	public static JButton btnIniciar;
	
	private JButton btnNovoProcesso;

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

	@SuppressWarnings({ "rawtypes", "unchecked" })
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
		btnIniciar = new JButton("Iniciar");
		btnIniciar.setBounds(531, 85, 117, 29);
		paParametros.add(btnIniciar);

		btnNovoProcesso = new JButton("Novo Processos");
		btnNovoProcesso.setBounds(661, 85, 152, 29);
		paParametros.add(btnNovoProcesso);
		
//		btnIniciar.addActionListener(new BotaoNovo());
		cbAlgoritmo.addActionListener(new BotaoNovo());
		btnNovoProcesso.addActionListener(new BotaoNovoProcesso());
	}

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Principal().setVisible(true);
			}
		});
	}
}