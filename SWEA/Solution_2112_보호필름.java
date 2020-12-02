package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2112_보호필름 {

	private static int D; // 두께
	private static int W; // 가로 길이
	private static int K; // 합격 기준 (세로로 연속으로 있어야하는 개수)
	private static int[][] map;
	private static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		
		for (int testCase = 1; testCase <= tc; testCase++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[D][W];

			for (int i = 0; i < D; i++) {
				String s = bf.readLine();
				for (int j = 0, index = 0; j < W; j++,index+=2) {
					map[i][j] = s.charAt(index) - '0';
				}
			}
			
			ans = Integer.MAX_VALUE;
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(testCase).append(" ");
			if(isPass(map)) sb.append("0");
			else {
				go(0, 0);
				sb.append(ans);
			}
			
			System.out.println(sb);
		} // end of testCase
	} // end of main

	private static void go(int row, int cnt) {
		
        if(isPass(map)) {
            ans = ans > cnt ? cnt : ans;
            return;
        }
        if(ans < cnt)
            return;
        
        if(row == D)
            return;
		
		int[] copy = new int[W];
		for (int i = 0; i < W; i++) {
			copy[i] = map[row][i];
		}
		
		// 주입 안하고 그냥 감
		go(row+1, cnt);
		
		// A 주입
		for (int i = 0; i < W; i++) {
			map[row][i] = 0;
		}
		go(row+1, cnt+1);

		// B 주입
		for (int i = 0; i < W; i++) {
			map[row][i] = 1;
		}
		go(row+1, cnt+1);
		
		// 복원
		for (int i = 0; i < W; i++) {
			map[row][i] = copy[i];
		}
		
		
	}

	private static boolean isPass(int[][] map) {
		for (int i = 0; i < W; i++) {
			int cnt = 1;
			int last = map[0][i]; // 0 = A , 1 = B
			for (int j = 1; j < D; j++) {
				int now = map[j][i];
				if (now != last) {
					cnt = 1;
					last = now;
				} else {
					cnt++;
				}
				
				if (cnt >= K) break;
			}
			if (cnt < K) return false;
		}
		return true;
	}

} // end of class
