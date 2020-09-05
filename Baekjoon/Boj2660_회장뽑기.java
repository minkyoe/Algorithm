import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_백준_2660_회장뽑기 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N; // 회원 수
	static int[][] map;
	static final int INF = 51;
	static ArrayList<Integer> candidates = new ArrayList<>();
	static ArrayList<int[]> scoreList = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(bf.readLine());
		map = new int[N+1][N+1]; // 0번 안씀

		for (int i = 1; i <= N; i++) {
			Arrays.fill(map[i], INF);
		}
		for (int i = 1; i <= N; i++) {
			map[i][i] = 0;
		}

		// 입력 받기
		while (true) {
			st = new StringTokenizer(bf.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			if (n1 == -1) break;
			
			map[n1][n2] = map[n2][n1] = 1;
		}
		// 플로이드 와샬 
		for (int k = 1; k <= N; k++) { // 거쳐가는 정점
			for (int i = 1; i <= N; i++) { // 출발 정점
				for (int j = 1; j <= N; j++) { // 도착 정점
					if (i == j || j == k || k == i) continue;
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		
		int min = INF; // 점수 최소값
		for (int i = 1; i <= N; i++) { 
			int score = 0;
			for (int j = 1; j <= N; j++) { 
				if (i == j) continue;
					score = score < map[i][j] ? map[i][j] : score; // 한 회원당 가지는 최대 점수
			}
			scoreList.add(new int[] {i, score});
			min = min > score ? score : min;
		}
		
		for (int i = 0; i < scoreList.size(); i++) {
			if (scoreList.get(i)[1] == min) {
				candidates.add(scoreList.get(i)[0]);
			}
		}
		
		Collections.sort(candidates);
		
		System.out.println(min + " " + candidates.size());
		for (int i = 0; i < candidates.size(); i++) {
			System.out.print(candidates.get(i) + " ");
		}
		
	} // end of main
} // end of class
