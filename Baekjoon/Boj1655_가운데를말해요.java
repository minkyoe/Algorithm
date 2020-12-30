package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;


public class Main_1655_가운데를말해요3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		PriorityQueue<Integer> smaller = new PriorityQueue<Integer>();
		PriorityQueue<Integer> bigger = new PriorityQueue<Integer>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(bf.readLine());
			if (bigger.size() == smaller.size()) {
				if (bigger.isEmpty()) {
					bigger.offer(num);
					sb.append(bigger.peek() + "\n");
					continue;
				}
				if (num >= smaller.peek()) {
					int min = smaller.poll();
					bigger.offer(min);
					smaller.offer(num);
				} else {
					bigger.offer(num);
				}
			} else {
				if (num <= bigger.peek()) {
					int max = bigger.poll();
					smaller.offer(max);
					bigger.offer(num);
				} else {
					smaller.offer(num);
				}
			}
			
			sb.append(bigger.peek() + "\n");
		} // end of N
		System.out.println(sb);
		
	} // end of main

} // end of class
