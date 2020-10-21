package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1145_적어도대부분의배수 {
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		arr = new int[5];
		
		for (int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int val = 1;
		int count = 0;
		while(true) {
			for (int i = 0; i < 5; i++) {
				if (val % arr[i] == 0) count++;
			}
			if (count >= 3) {
				System.out.println(val);
				break;
			}
			val++;
			count = 0;
		}
	}
}
