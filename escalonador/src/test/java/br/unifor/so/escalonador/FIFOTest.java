package br.unifor.so.escalonador;

import br.unifor.so.escalonador.fifo.outro.FIFO;
import br.unifor.so.escalonador.fifo.outro.PageGenerator;
import br.unifor.so.escalonador.fifo.outro.ReplacementAlgorithm;

public class FIFOTest {

	public static void main(String[] args) {
		PageGenerator ref = new PageGenerator();
		int[] referenceString = ref.getReferenceString();

		ReplacementAlgorithm fifo = new FIFO(3);

		// output a message when inserting a page
		for (int i = 0; i < referenceString.length; i++) {
			fifo.insert(referenceString[i]);
		}

		// report the total number of page faults
		System.out.println("\nFIFO faults = " + fifo.getPageFaultCount());
	}
}