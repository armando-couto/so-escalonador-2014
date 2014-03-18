//package br.unifor.so.escalonador.sjf;
//
//import java.util.Scanner;
//
//import br.unifor.so.escalonador.model.Processo;
//
//public class Main {
//
//	public static void main(String args[]) {
//		SJF sjf = new SJF();
//		Scanner get = new Scanner(System.in);
//
//		System.out.println("Enter Number of Processes:");
//		sjf.setNumero(get.nextInt());
//		for (int i = 0; i < sjf.getNumero(); i++) {
//			sjf.getProcessos().add(new Processo());
//		}
//		
//		for (int i = 0; i < sjf.getNumero(); i++) {
//			System.out.println("Enter Process " + (i + 1) + " Burst Time: ");
//			sjf.getProcessos().get(i).setpTempo(get.nextInt());
//		}
//
//		for (int i = 0; i < sjf.getNumero() - 1; i++) {
//			for (int j = i + 1; j < sjf.getNumero(); j++) {
//				if (sjf.getProcessos().get(i).getpTempo() > sjf.getProcessos().get(j).getpTempo()) {
//					sjf.setTempo(sjf.getProcessos().get(i).getpTempo());
//					sjf.getProcessos().get(i).setpTempo(sjf.getProcessos().get(j).getpTempo());
//					sjf.getProcessos().get(j).setpTempo(sjf.getTempo());
//					sjf.setTempo(sjf.getProcessos().indexOf(sjf.getProcessos().get(i)));
//					sjf.getProcessos().set(i, sjf.getProcessos().get(j));
////					sjf.getProcessos().set(j, sjf.getTempo());
////					process[j] = temp;
//				}
//			}
//		}
//
//		sjf.getProcessos().get(0).setwTempo(0);
//		for (int i = 1; i < sjf.getNumero(); i++) {
//			sjf.getProcessos().get(i).setwTempo(sjf.getProcessos().get(i - 1).getwTempo() + sjf.getProcessos().get(i - 1).getpTempo());
//			sjf.setTotal( sjf.getTotal() + sjf.getProcessos().get(i).getwTempo());
//		}
//		sjf.setAvg((float) sjf.getTotal() / sjf.getNumero());
//		System.out.println("P_ID\tP_TIME\tW_TIME");
//		for (int i = 0; i < sjf.getNumero(); i++) {
//			System.out.println(sjf.getProcessos().get(i).toString() + "\t" + sjf.getProcessos().get(i).getpTempo() + "\t" + sjf.getProcessos().get(i).getwTempo());
//		}
//		
//		System.out.println("Total Waiting Time: " + sjf.getTempo());
//		System.out.println("Average Waiting Time: " + sjf.getAvg());
//	}
//}
