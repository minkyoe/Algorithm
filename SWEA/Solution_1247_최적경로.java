import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1247_최적경로 {
	
	static int tc;
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int[][] companyHouse;
	static int[][] cusHouses;
	static int[] order;
	static boolean[] visited;
	static int answer;
	static int N;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		tc = Integer.parseInt(bf.readLine());
		
		for (int testCase = 1; testCase <= tc; testCase++) {
			N = Integer.parseInt(bf.readLine()); // 고객 수

			answer = Integer.MAX_VALUE;
			cusHouses = new int[N][2];
			order = new int[N];
			companyHouse = new int[2][2];
			visited = new boolean[N];
			
			st = new StringTokenizer(bf.readLine());
			companyHouse[0][0] = Integer.parseInt(st.nextToken());
			companyHouse[0][1] = Integer.parseInt(st.nextToken());
			companyHouse[1][0] = Integer.parseInt(st.nextToken());
			companyHouse[1][1] = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < N; i++) {
				cusHouses[i][0] = Integer.parseInt(st.nextToken());
				cusHouses[i][1] = Integer.parseInt(st.nextToken());
			}
			
			// 고객 집 좌표 순열 구하기
			perm(0);
			System.out.println("#"+testCase+" "+answer);
			
			
		} // end of testCase
		
	} // end of main 

	private static void perm(int cnt) {
		if (cnt == N) {
			// 순열 다 구했으면  총 거리 구하기
			int dis = 0;
			
			dis += getDistance(companyHouse[0][0], companyHouse[0][1], cusHouses[order[0]][0], cusHouses[order[0]][1]);
			for (int i = 0; i < N-1; i++) {
				dis += getDistance(cusHouses[order[i]][0],cusHouses[order[i]][1],cusHouses[order[i+1]][0],cusHouses[order[i+1]][1]);
			}
			dis += getDistance(cusHouses[order[N-1]][0],cusHouses[order[N-1]][1], companyHouse[1][0], companyHouse[1][1]);
			answer = answer > dis ? dis : answer;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			order[cnt] = i;
			perm(cnt+1);
			
			visited[i] = false;
		}
		
	}

	private static int getDistance(int y1, int x1, int y2, int x2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
	

} // end of class

