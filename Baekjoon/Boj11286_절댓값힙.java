package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_11286_절댓값힙 {
	static class Num implements Comparable<Num>{
		int realNum;
		int absNum;
		
		Num (int real, int abs) {
			this.realNum = real;
			this.absNum = abs;
		}
		
		public int compareTo(Num o) {
			if (this.absNum == o.absNum) {
				return this.realNum - o.realNum;
			}
			return this.absNum - o.absNum;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		PriorityQueue<Num> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(bf.readLine());
			
			if (input == 0) {
				if (pq.isEmpty()) System.out.println("0");
				else System.out.println(pq.poll().realNum);
			}
			else pq.offer(new Num(input, Math.abs(input)));
		}
	} // end of main

} // end of class
