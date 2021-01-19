package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2960_에라토스테네스의체 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		boolean[] visited = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}
		
		int deleteCnt = 0;
		int deleteNum = 0;
ex:		for (int i = 2; i <= N; i++) {
			for (int j = i; j <= N; j += i) {
				if (!visited[j]) {
					++deleteCnt;
					deleteNum = j;
					visited[j] = true;
					if (deleteCnt == K) break ex;
				}
			}
		}
		
		System.out.println(deleteNum);

	}

}
