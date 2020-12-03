package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_6198_옥상정원꾸미기 {
	
	private static int N;
	private static int[] arr;
	private static long ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		arr = new int[N];
		ans = 0;
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < N; i++) {
			while (!st.empty() && st.peek() <= arr[i]) st.pop();
			ans += st.size();
			st.push(arr[i]);
		}
		
		System.out.println(ans);
	}

}
