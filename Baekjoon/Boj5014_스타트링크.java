package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main_5014_스타트링크 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int F, S, G, U, D;
	static int ans;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(bf.readLine(), " ");
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		visited = new boolean[F+1];
		
		if (S == G) {
			System.out.println("0");
			System.exit(0);
		}
		
		if ((S > G && D == 0) || (S < G && U == 0)) {
			System.out.println("use the stairs");
			System.exit(0);
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {S,0});
		visited[S] = true;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int now = tmp[0];
			int cnt = tmp[1];
			
			if (now == G) {
				ans = cnt;
				break;
			}
			
			if (now + U <= F && !visited[now+U]) {
				q.offer(new int[] {now+U, cnt+1});
				visited[now+U] = true;
			}
			
			if (now - D >= 1 && !visited[now-D]) {
				q.offer(new int[] {now-D, cnt+1});
				visited[now-D] = true;
			}
		}
		
		if (ans == 0) {
			System.out.println("use the stairs");
		} else {
			System.out.println(ans);
		}
		
	} // end of main
} // end of class
