import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_12852_1로만들기2 {

	private static boolean[] visited;
	private static int[] saved;
	private static int num;
	private static int ansCnt;
	private static ArrayList<Integer> ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(bf.readLine());
		ansCnt = 0;
		ans = new ArrayList<>();
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {num, 0});
		
		visited = new boolean[num+1];
		saved = new int[num+1];
		
		visited[num] = true;
		saved[num] = num;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int now = tmp[0];
			int cnt = tmp[1];
						
			if (now == 1) {
				ansCnt = cnt;
				break;
			}
			
			if (!visited[now/3] && now % 3 == 0 && now / 3 > 0) {
				q.offer(new int[] {now/3, cnt+1});
				visited[now/3] = true;
				saved[now/3] = now;
			}
			if (!visited[now/2] && now % 2 == 0 && now / 2 > 0) {
				q.offer(new int[] {now/2, cnt+1});
				visited[now/2] = true;
				saved[now/2] = now;
			}
			if (!visited[now-1] && now - 1 > 0) {
				q.offer(new int[] {now-1, cnt+1});
				visited[now-1] = true;
				saved[now-1] = now;
			}
			
		}
		
		// 횟수
		System.out.println(ansCnt);
		
		// 포함되어 있는 수
		ans.add(1);
		addAns(1);
		for (int i = ans.size()-1; i >= 0; i--) {
			System.out.print(ans.get(i) + " ");
		}

	}
	
	private static void addAns(int n) {
		if (n == num) return;
		ans.add(saved[n]);
		addAns(saved[n]);
	}
}
