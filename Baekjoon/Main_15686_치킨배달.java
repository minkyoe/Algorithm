import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {

	private static int N;
	private static int M;
	private static int[][] map;
	private static ArrayList<Pos> chicken;
	private static ArrayList<Pos> home;
	private static int[] selected;
	private static int ans;
	
	static class Pos {
		int r;
		int c;
		
		Pos (int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		selected = new int[M];
		chicken = new ArrayList<Pos>();
		home = new ArrayList<Pos>();
		ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			for (int j = 0, index = 0; j < N; j++, index += 2) {
				map[i][j] = s.charAt(index) - '0';
				if (map[i][j] == 2) chicken.add(new Pos(i,j));
				else if (map[i][j] == 1) home.add(new Pos(i,j));
			}
		}
		comb(0, 0);
		System.out.println(ans);
	} // end of main

	private static void comb(int idx, int cnt) {
		if (cnt == M) {
			int sum = 0; 
			for (int i = 0; i < home.size(); i++) {
				int hr = home.get(i).r;
				int hc = home.get(i).c;
				int dist = Integer.MAX_VALUE;
				
				for (int j = 0; j < M; j++) {
					int cr = chicken.get(selected[j]).r;
					int cc = chicken.get(selected[j]).c;
					int tmp = Math.abs(hr - cr) + Math.abs(hc - cc);
					dist = Math.min(dist, tmp);
				}
				
				sum += dist;
			}
			ans = Math.min(ans, sum);
			return;
		}
		
		for (int i = idx; i < chicken.size(); i++) {
			selected[cnt] = i;
			comb(i+1, cnt+1);
		}
	}

} // end of class
