package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기 {
	private static int N;
	private static int W;
	private static int H;
	private static int[][] map;
	private static int[][] copy;
	private static ArrayList<Integer> target;
	private static int brickCnt;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	private static int brickCntCopy;
	private static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		
		for (int testCase = 1; testCase <= tc; testCase++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 구슬 개수
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			copy = new int[H][W];
			brickCnt = 0;
			brickCntCopy = 0;
			ans = Integer.MAX_VALUE;
					
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(bf.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					copy[i][j] = map[i][j];
					if (map[i][j] != 0) brickCnt++;
				}
			}
			brickCntCopy = brickCnt;
			
			target = new ArrayList<Integer>();
			comb(0);
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(testCase).append(" ").append(ans);
			System.out.println(sb.toString());
			
		} // end of tc
	} // end of main

	private static void comb(int cnt) {
		if (cnt == N) {
			for (int i = 0; i < target.size(); i++) {
				bomb(target.get(i));
				push();
			}
			ans = ans > brickCnt ? brickCnt : ans;
			
			// 원본으로 초기화 작업
			brickCnt = brickCntCopy;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = copy[i][j];
				}
			}
			return;
		}
		
		for (int i = 0; i < W; i++) {
			target.add(i);
			comb(cnt+1);
			target.remove(target.size()-1);
		}
		
	}

	private static void push() {
		for (int col = 0; col < W; col++) {
			Stack<Integer> st = new Stack<>();
			for (int row = 0; row < H; row++) {
				if (map[row][col] == 0) continue;
				st.push(map[row][col]);
			}
			
			int idx = H-1;
			while(!st.isEmpty()) {
				map[idx][col] = st.pop();
				idx--;
			}
			
			for (int row = idx; row >= 0; row--) {
				map[row][col] = 0;
			}
		}
		
	}

	private static void bomb(int col) {
		int row = 0;
		for (row = 0; row < H; row++) {
			if (map[row][col] == 0) continue;
			else break;
		}
		if(row == H) return;
		go(row, col);
		
	}

	private static void go(int r, int c) {
		if (map[r][c] == 0) return;
		int range = map[r][c] - 1;
		map[r][c] = 0;
		brickCnt--;
		
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j <= range; j++) {
				int nr = r + dy[i]*j;
				int nc = c + dx[i]*j;
				if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
				if (map[nr][nc] == 0) continue;
				go(nr, nc);
			}
		}
	}
}
