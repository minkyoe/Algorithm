package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10816_숫자카드2_2 {
	private static int N;
	private static int M;
	private static int[] arr;
	static final int MAX = 1000_0000;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		arr = new int[2*MAX+1];
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			arr[now+MAX]++;
		} 
		
 		M = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			System.out.print(arr[num+MAX] + " ");
		}
		
		
	} // end of main
}
