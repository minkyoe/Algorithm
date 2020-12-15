package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1966_프린터큐 {

	private static int N;
	private static int M;
	private static int ans;
	private static Deque<Doc> dq;
	private static int[] imp;
	
	private static class Doc{
		int idx;
		int importance;
		
		Doc (int idx, int importance) {
			this.idx = idx;
			this.importance = importance;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int testCase = 1; testCase <= tc; testCase++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 문서 개수
			M = Integer.parseInt(st.nextToken()); // 궁금한 문서 순서
			dq = new LinkedList<Doc>();
			imp = new int[N];
			
			st = new StringTokenizer(bf.readLine(), " ");
			for (int m = 0; m < N; m++) {
				int tmp = Integer.parseInt(st.nextToken());
				dq.offerLast(new Doc (m, tmp));
				imp[m] = tmp;
			}
			
			ans = 1;
ex:			while(!dq.isEmpty()) {
				Doc tmp = dq.pollFirst();
				
				for (int i = 0; i < N; i++) {
					if (i != tmp.idx && imp[i] > tmp.importance) { // 큐 맨뒤에 넣기
						dq.offerLast(new Doc (tmp.idx, tmp.importance));
						break;
					} 
					else {
						if (i == N - 1) { // 중요성이 더 높은게 없는 경우 
							if (tmp.idx == M) {
								imp[tmp.idx] = 0;
								break ex;
							}
							else {
								imp[tmp.idx] = 0;
								++ans;
							}
						}
					}
				}
			} // end of while
			
			System.out.println(ans);
			
		} // end of testCase

	} // end of main

} // end of class
