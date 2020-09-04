import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main_백준_18513_샘터 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, K; // 샘터 수, 지을 집 수
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Queue<int[]> q = new LinkedList<>();
		HashSet<Integer> visited = new HashSet<>();
		
		st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int chicken = Integer.parseInt(st.nextToken());
			q.offer(new int[] {chicken, 0});
			visited.add(chicken);
		}
		
		int cnt = 0;
		long sum = 0; // 불행도 합 (최악일경우 10만*10만 이므로 int형 범위 벗어남)
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int now = tmp[0];
			int dist = tmp[1];
			
			if (!visited.contains(now-1)) {
				visited.add(now-1);
				q.offer(new int[] {now-1, dist+1});
				++cnt;
				sum += dist+1;
				if (cnt == K) {
					break;
				}
			}
			
			if (!visited.contains(now+1)) {
				visited.add(now+1);
				q.offer(new int[] {now+1, dist+1});
				++cnt;
				sum += dist+1;
				if (cnt == K) {
					break;
				}
			}
		}
		
		System.out.println(sum);
		
		
 	} // end of main
} // end of class
