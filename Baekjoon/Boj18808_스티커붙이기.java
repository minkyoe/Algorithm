import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_18808_스티커붙이기 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, M; // 세로, 가로
	static int K; // 스티커 개수
	static boolean[] isFixed; // (arraylist 인덱스별) 스티커가 붙여졌는지
	static int[] oneCnt;
	static ArrayList<Sticker> stickers = new ArrayList<>();
	static int[][] board;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		oneCnt = new int[K];
		isFixed = new boolean[K];
		
		// 스티커 입력 받기
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int[][] map = new int[11][11];
			
			for (int j = 0; j < r; j++) {
				String s = bf.readLine();
				for (int k = 0,index = 0; k < c; k++,index+=2) {
					map[j][k] = Character.getNumericValue(s.charAt(index));
					if (map[j][k] == 1) oneCnt[i]++;
				}
			}
			stickers.add(new Sticker(r,c,map));
		}
		
		
		
		for (int s = 0; s < K; s++) {
			int sr = stickers.get(s).r;
			int sc = stickers.get(s).c;
			
			go(sr, sc, s);
		}
		
		
		int ans = 0;
		for (int i = 0; i < K; i++) {
			if (isFixed[i]) ans += oneCnt[i];
		}
		
		System.out.println(ans);
		
	} // end of main

	private static void go(int sr, int sc, int idx) {
ex:		for (int d = 0; d <= 4; d++) { // 회전
			if (d!=0) rotate(idx);
			sr = stickers.get(idx).r;
			sc = stickers.get(idx).c;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (i + sr > N || j + sc > M) {
						continue;
					}
					if (check(i, j, sr, sc, idx)) {
						// 다 0이면 스티커 붙임, isFixed갱신, 다른 스티커 ㄱㄱ (return)
						fix(i, j, sr, sc, idx);
						isFixed[idx] = true;
						return;
					} else {
						continue; // 아니면 회전
					}

				}
			}
		}
	}

	private static void fix(int startR, int startC, int sr, int sc, int idx) {
		for (int i = startR; i < startR + sr; i++) {
			for (int j = startC; j < startC + sc; j++) {
				if (stickers.get(idx).map[i-startR][j-startC] == 0) continue;
				board[i][j] = 1;
			}
		}
	}

	private static boolean check(int startR, int startC, int sr, int sc, int idx) {
		for (int i = startR; i < startR + sr; i++) {
			for (int j = startC; j < startC + sc; j++) {
				if (stickers.get(idx).map[i-startR][j-startC] == 0) continue;
				if (board[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}

	private static void rotate(int idx) {
		int r = stickers.get(idx).r;
		int c = stickers.get(idx).c;
		int[][] tmp = new int[c][r];
		for (int j = 0; j < r; j++) {
			for (int k = 0; k < c; k++) {
				tmp[k][r - 1 - j] = stickers.get(idx).map[j][k];
			}
		}
		swap(idx);
		// 갱신
		r = stickers.get(idx).r;
		c = stickers.get(idx).c;
		
		for (int j = 0; j < r; j++) {
			for (int k = 0; k < c; k++) {
				stickers.get(idx).map[j][k] = tmp[j][k];
			}
		}
	}

	private static void swap(int idx) {
		int tmp = stickers.get(idx).r;
		stickers.get(idx).r = stickers.get(idx).c;
		stickers.get(idx).c = tmp;
	}
} // end of class


class Sticker {
	int r; //세로 사이즈
	int c; //가로 사이즈
	int[][] map;
	
	public Sticker() {
		// TODO Auto-generated constructor stub
	}

	public Sticker(int r, int c, int[][] map) {
		super();
		this.r = r;
		this.c = c;
		this.map = map;
	}
}
