import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4013_특이한자석 {

	private static int K;
	private static int[][] steel;
	private static int[][] steelCopy;
	private static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		
		for (int testCase = 1; testCase <= tc; testCase++) {
			K = Integer.parseInt(bf.readLine()); // 회전 횟수
			steel = new int[5][8];
			steelCopy = new int[5][8];
			// N극 : 0, S극 : 1
			for (int i = 1; i <= 4; i++) {
				String s = bf.readLine();
				for (int j = 0, index = 0; j < 8; j++,index+=2) {
					steel[i][j] = s.charAt(index) - '0';
					steelCopy[i][j] = steel[i][j];
				}
			}
			
			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
				visited = new boolean[5];
				rotate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				copy(steel, steelCopy);
			}
			
			int ans = getAnswer();
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(testCase).append(" ").append(ans);
			System.out.println(sb.toString());
		} // end of testCase

	} // end of main

	private static int getAnswer() {
		int sum = 0;
		
		for (int i = 1; i <= 4; i++) {
			if(steel[i][0] == 1) sum += (1 << (i-1));
		}
		return sum;
	}

	private static void copy(int[][] origin, int[][] target) {
		for (int i = 1; i <= 4; i++) {
			for (int j = 0; j < 8; j++) {
				target[i][j] = origin[i][j];
			}
		}
	}

	// 시계방향 : 1 , 반시계 방향 : -1  
	private static void rotate(int idx, int dir) {
		visited[idx] = true;
		int before = idx - 1;
		int next = idx + 1;
		
		// 자기  자리 회전
		int[] copy = new int[8];
		
		for (int i = 0; i < 8; i++) {
			copy[i] = steel[idx][i];
		}
		if (dir == 1) { // 시계방향
			for (int i = 0; i < 8; i++) {
				steel[idx][(i+1)%8] = copy[i];
			}
		} else { // 반시계방향
			for (int i = 0; i < 8; i++) {
				steel[idx][(i+7)%8] = copy[i];
			}
		}
		
		
		// 앞, 뒤 조건 체크 후 회전
		if (before != -1 && steelCopy[idx][6] != steelCopy[before][2] && !visited[before]) rotate(before, dir*-1);
		if (next != 5 && steelCopy[idx][2] != steelCopy[next][6] && !visited[next]) rotate(next, dir*-1);
		return;
	}

}
