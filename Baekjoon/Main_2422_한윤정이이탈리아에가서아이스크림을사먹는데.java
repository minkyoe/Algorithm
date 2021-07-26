import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2422_한윤정이이탈리아에가서아이스크림을사먹는데 {

	private static int N;
	private static int M;
	private static boolean[][] isNoGood;
	private static int[] selected;
	private static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selected = new int[3];
		ans = 0;
		isNoGood = new boolean[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			isNoGood[a][b] = true;
			isNoGood[b][a] = true;
		}
		
		go(1, 0);
		System.out.println(ans);
	} // end of main

	private static void go(int idx, int cnt) {
		if (cnt == 3) {
			boolean canMix = true;
			
ex:			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (i == j) continue;
					if (isNoGood[selected[i]][selected[j]] || 
							isNoGood[selected[j]][selected[i]]) {
						canMix = false;
						break ex;
					}
				}
			}
			
			if (canMix) ++ans;
			return;
		}
		
		for (int i = idx; i <= N; i++) {
			selected[cnt] = i;
			go(i+1, cnt+1);
		}
	}

} // end of class
