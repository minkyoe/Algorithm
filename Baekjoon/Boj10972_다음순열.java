package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10972_다음순열 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] input;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(bf.readLine());
		input = new int[N];
		
		st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		if(np()) {
			for (int i = 0; i < N; i++) {
				System.out.print(input[i] + " ");
			}
		} else {
			System.out.println(-1);
		}
		
	} // end of main

	private static boolean np() {
		int top = N-1;
		while (top >= 1 && input[top-1] >= input[top]) {
			--top;
		}
		if (top == 0) return false;
		
		int target = N-1;
		while (input[target] <= input[top-1]) {
			--target;
		}
		
		swap(target, top-1);
		
		int left = top;
		int right = N-1;
		while (left < right) {
			swap(left, right);
			left++;
			right--;
		}
		return true;

	}
	private static void swap(int target, int i) {
		int tmp = input[target];
		input[target] = input[i];
		input[i] = tmp;
	}
} // end of class
