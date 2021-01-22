package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16953_A화살표B {

	private static long A;
	private static long B;
	private static long ansCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		if (bfs(A)) System.out.println(ansCnt+1);
		else System.out.println(-1);
	}

	private static boolean bfs(long num) {
		Queue<long[]> q = new LinkedList<>();
		q.offer(new long[] {num, 0});
		ansCnt = 0;
		
		while(!q.isEmpty()) {
			long[] tmp = q.poll();
			long tnum = tmp[0];
			long tcnt = tmp[1];
			ansCnt = tcnt;
			
			if (tnum == B) return true;
			
			if (tnum*2 <= B) q.offer(new long[] {tnum*2, tcnt+1});
			if (tnum*10+1 <= B) q.offer(new long[] {tnum*10+1, tcnt+1});
		}
		return false;
	}
}
