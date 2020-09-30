package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//x+d1+d2 ≤ N, 1 ≤ y-d1 < y < y+d2 ≤ N
public class Main_17779_게리맨더링2 {

	private static int N;
	private static int[][] map;
	private static int[] sum;
	private static int[][] mapCnt;
	private static int totalSum;
	private static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		mapCnt = new int[N+1][N+1];
		totalSum = 0;
		result = Integer.MAX_VALUE;

		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				mapCnt[i][j] = Integer.parseInt(st.nextToken());
				totalSum += mapCnt[i][j];
			}
		}

		for (int x = 1; x <= N; x++) {
			for (int y = 1; y <= N; y++) {
				for (int d1 = 1; d1 <= N; d1++) {
					for (int d2 = 1; d2 <= N; d2++) {
						sum = new int[5];
						map = new int[N+1][N+1];
						
						if (x + d1 + d2 <= N && 1 <= y - d1 && y + d2 <= N) {
							setBounds(x, y, d1, d2);
							count(x, y, d1, d2);
							
//							System.out.println("======");
//							for (int i = 1; i <= N; i++) {
//								for (int j = 1; j <= N; j++) {
//									System.out.print(map[i][j] + " ");
//								}
//								System.out.println();
//							}
							
							Arrays.sort(sum);
							int tmp = sum[4]-sum[0];
							result = result > tmp ? tmp : result;
						}
					}
				}
			}
		}
		
		System.out.println(result);

	} // end of main
	
	// 경계선 두기
	public static void setBounds(int x, int y, int d1, int d2){
//		System.out.println("x y " + x + " , " + y );
		map[x][y] = 5;
		//1
		for (int i = 1; i <= d1; ++i) {
//			System.out.println("x+i y-i " + (x+i) + " , " + (y-i));
			map[x + i][y - i] = 5;
		}
		//2
		for (int i = 1; i <= d2; ++i) {
//			System.out.println("x+i y+i " + (x+i) + " , " + (y+i));
			map[x + i][y + i] = 5;
		}
		//3
		for (int i = 1; i <= d2; ++i) {
//			System.out.println("x+d1+i  y-d1+i " + (x+d1+i) + " , " + (y-d1+i));
			map[x + d1 + i][y - d1 + i] = 5;
		}
		//4
		for (int i = 1; i <= d1; ++i) {
//			System.out.println("x+d2+i  y+d2-i " + (x+d2+i) + " , " + (y+d2-i));
			map[x + d2 + i][y + d2 - i] = 5;
		}
    }
	
	private static void count(int x, int y, int d1, int d2) {
		// 1
		for (int r = 1; r < x + d1; r++) {
			for (int c = 1; c <= y; c++) {
				if (map[r][c] == 5) break;
				map[r][c] = 1;
				sum[0] += mapCnt[r][c];
			}
		}

		// 2
		for (int r = 1; r <= x + d2; r++) {
			for (int c = N; c >= y+1; c--) {
				if (map[r][c] == 5) break;
				map[r][c] = 2;
				sum[1] += mapCnt[r][c];
			}
		}

		// 3
		for (int r = x + d1; r <= N; r++) {
			for (int c = 1; c < y - d1 + d2; c++) {
				if (map[r][c] == 5) break;
				map[r][c] = 3;
				sum[2] += mapCnt[r][c];
			}
		}

		// 4
		for (int r = x + d2 + 1; r <= N; r++) {
			for (int c = N; c >= y - d1 + d2; c--) {
				if (map[r][c] == 5) break;
				map[r][c] = 4;
				sum[3] += mapCnt[r][c];
			}
		}
		
		sum[4] = totalSum - (sum[0]+sum[1]+sum[2]+sum[3]);

	}
} // end of class
