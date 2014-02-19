package br.unifor.so.escalonador.sjf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SchedulingAlgorithms {
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter file name: ");
		Scanner s = new Scanner(new BufferedReader(new FileReader(in.next())));
		int numData = 0;
		String jobArr[] = new String[20];
		int timeArr[] = new int[20];

		// read job.txt
		while (s.hasNext()) {
			String temp;
			if (!s.hasNextInt())
				jobArr[numData] = s.next();
			else {
				timeArr[numData] = s.nextInt();
				numData++;
			}
		}// end while

		System.out.println("\n\nFILE CONTENTS");
		for (int a = 0; a < numData; a++) {
			System.out.println(jobArr[a]);
			System.out.println(timeArr[a]);
		}
		System.out.println();

		float avgTimesArr[] = new float[4];
		String scheduleNames[] = { "FCFS", "SJF", "RR - 3", "RR - 5" };
		avgTimesArr[0] = FCFS(numData, jobArr, timeArr);
		avgTimesArr[1] = SJF(numData, jobArr, timeArr);
		avgTimesArr[2] = RR(numData, jobArr, timeArr, 3);
		avgTimesArr[3] = RR(numData, jobArr, timeArr, 5);
		System.out.println();
		System.out.println();

		float copyAvgTimesArr[] = new float[4];
		System.out.println("ALGORITHM\t\tTIME");
		for (int a = 0; a < 4; a++) {
			copyAvgTimesArr[a] = avgTimesArr[a];
			System.out.println(scheduleNames[a] + "\t" + avgTimesArr[a]);
		}

		Arrays.sort(copyAvgTimesArr);
		System.out.println();
		for (int a = 0; a < 4; a++) {
			if (copyAvgTimesArr[0] == avgTimesArr[a])
				System.out.println(scheduleNames[a] + " is the fastest");
			if (copyAvgTimesArr[3] == avgTimesArr[a])
				System.out.println(scheduleNames[a] + " is the slowest");
		}

	}// end class main

	public static float RR(int numData, String[] jobArr, int[] timeArr, int timeSlice) {
		System.out.println("\n\n Round Robin with time slice = " + timeSlice);
		int[] copyTimeArr = new int[200]; // for gant chart
		String[] copyJobArr = new String[200]; // for gant chart
		Queue<Integer> timeQ = new LinkedList<Integer>();
		Queue<String> jobQ = new LinkedList<String>();
		for (int a = 0; a < numData; a++) {
			timeQ.add(timeArr[a]);
			jobQ.add(jobArr[a]);
		}

		int pos = 0, tempInt = 0, currentTime = 0, cPos = 0;
		int[] completedTimeArr = new int[numData];
		String[] completedJobArr = new String[numData];
		String tempString;
		while (!timeQ.isEmpty()) {
			if (timeQ.peek() <= timeSlice) {
				tempInt = timeQ.remove();
				copyTimeArr[pos] = tempInt;
				tempString = jobQ.remove();
				copyJobArr[pos] = tempString;

				currentTime += tempInt;

				completedTimeArr[cPos] = currentTime;
				completedJobArr[cPos] = tempString;
				pos++;
				cPos++;
			} else { // is > than timeslice
				tempInt = timeQ.remove() - timeSlice;
				copyTimeArr[pos] = timeSlice;
				tempString = jobQ.remove();
				copyJobArr[pos] = tempString;

				timeQ.add(tempInt);
				jobQ.add(tempString);

				currentTime += timeSlice;
				pos++;
			}
		}// end while

		printGantt(pos, copyJobArr, copyTimeArr);
		System.out.print("\n Average Completion Time: (" + completedTimeArr[0]);
		float finalTime, avgTime = completedTimeArr[0];
		for (int a = 1; a < numData; a++) {
			System.out.print(" + " + completedTimeArr[a]);
			avgTime += completedTimeArr[a];
		}

		finalTime = avgTime / (float) numData;
		System.out.println(") / " + numData + " = " + finalTime);
		return finalTime;

	}// end method RR

	public static float SJF(int numData, String[] jobArr, int[] timeArr) {
		System.out.println("\n\n Shortest Job First");
		int[] copyTimeArr = new int[numData];
		String[] copyJobArr = new String[numData];

		// copy timeArr
		for (int a = 0; a < numData; a++)
			copyTimeArr[a] = timeArr[a];

		Arrays.sort(copyTimeArr);

		// rearrange Job array to match sorted Time array
		for (int a = 0; a < numData; a++) {
			for (int b = 0; b < numData; b++) {
				if (copyTimeArr[a] == timeArr[b]) {
					copyJobArr[a] = jobArr[b];
				}
			}// end inner for loop
		}// end out for loop

		printGantt(numData, copyJobArr, copyTimeArr);
		int completedTime = copyTimeArr[0], avgTime = copyTimeArr[0];
		float finalTime;

		System.out.print("\n Average Completion Time: (" + copyTimeArr[0]);
		for (int a = 1; a < numData; a++) {
			completedTime += copyTimeArr[a];
			avgTime += completedTime;
			System.out.print(" + " + completedTime);
		}
		finalTime = (float) avgTime / (float) numData;
		System.out.println(") / " + numData + " = " + finalTime);
		return finalTime;
	}// end method SJF

	public static float FCFS(int numData, String[] jobArr, int[] timeArr) {
		System.out.println(" First Come First Serve");
		printGantt(numData, jobArr, timeArr);
		int completedTime = timeArr[0], avgTime = timeArr[0];
		float finalTime;

		System.out.print("\n Average Completion Time: (" + timeArr[0]);
		for (int a = 1; a < numData; a++) {
			completedTime += timeArr[a];
			avgTime += completedTime;
			System.out.print(" + " + completedTime);
		}
		finalTime = (float) avgTime / (float) numData;
		System.out.println(") / " + numData + " = " + finalTime);
		return finalTime;
	}// end method FCFS

	public static void printGantt(int numData, String[] jobArr, int[] timeArr) {
		int copyData = numData;
		int track, total = 0;
		int track2 = 0, track3 = 0;

		while (copyData > 0) {

			if (copyData > 6) {
				track = 6;
			} else { // copyData < 6
				track = copyData;
			}

			// top of gantt chart
			System.out.print("  "); // 2 spaces
			for (int a = 0; a < track; a++) {
				System.out.print("________ ");
			}
			// middle of gantt chart
			System.out.print("\n "); // 1 space
			for (int a = 0; a < track; a++) {
				System.out.print("| " + jobArr[track2] + " ");
				track2++;
			}
			System.out.println("|");
			// bottom of gantt chart
			System.out.print(" |");
			for (int a = 0; a < track; a++) {
				System.out.print("________|");
			}
			System.out.print("\n ");
			// wait time for gantt chart

			System.out.print(total + "       ");
			for (int a = 0; a < track; a++) {
				total += timeArr[track3];
				if (total < 10)
					System.out.print(" " + total + "       ");
				else
					System.out.print(total + "       ");
				track3++;
			}

			System.out.println();
			copyData -= 6;
		}// end while
	}// end method printGantt
}// end class p1