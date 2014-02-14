package br.unifor.so.escalonador;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class App extends JFrame {

	private static final long serialVersionUID = 170081653347677490L;

	public App() {
		super("Minha primeira janela");
		setTitle("Escalonador");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		final App mpf = new App();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				mpf.setVisible(true);
			}
		});
	}
}
