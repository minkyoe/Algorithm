package KAKAO;

public class Solution_2020_자물쇠와열쇠 {
	public static void main(String[] args) {
		Solution s = new Solution();
		boolean ans = s.solution(new int[][] { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } },
				new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } });
		System.out.println(ans);
	}

	static class Solution {

		static int[][] board;
		static int[][][] rotatedKey;
		static int N, M, B; // key길이, lock길이, board 길이

		public boolean solution(int[][] key, int[][] lock) {
			boolean answer = true;

			N = key.length;
			M = lock.length;
			// B = (M - 2) + 2 * N;
			B = M + 2 * N - 1;

			board = new int[B][B];
			rotatedKey = new int[4][N][N];

	
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					rotatedKey[0][i][j] = key[i][j]; // 회전 0도 key
				}
			}
			
			// key 회전
			for (int i = 1; i < 4; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						rotatedKey[i][k][N - 1 - j] = rotatedKey[i - 1][j][k];
					}
				}
			}

			// 큰 맵에 자물쇠 값 넣기
			for (int i = N - 1; i < N - 1 + M; i++) {
				for (int j = N - 1; j < N - 1 + M; j++) {
					board[i][j] = lock[i - (N - 1)][j - (N - 1)];
				}
			}
			
			// 한 점마다 key 넣어보면서 답이 될 수 있는지 체크
			for (int i = 0; i < B - N; i++) {
				for (int j = 0; j < B - N; j++) {
					for (int k = 0; k < 4; k++) {

						if (!isAnswer(i, j, k))
							continue;
						else
							return true;
					}
				}
			}

			return false;
		}

		private boolean isAnswer(int i, int j, int idx) { // 시작 좌표, 회전시킨 열쇠 배열 인덱스
			int[][] tmpBoard = new int[B][B];
			for (int k = 0; k < B; k++) {
				for (int l = 0; l < B; l++) {
					tmpBoard[k][l] = board[k][l];
				}
			}

			for (int r = i; r < i + N; r++) {
				for (int c = j; c < j + N; c++) {
					tmpBoard[r][c] += rotatedKey[idx][r - i][c - j];
				}
			}

			for (int a = N - 1; a < N - 1 + M; a++) {
				for (int b = N - 1; b < N - 1 + M; b++) {
					if (tmpBoard[a][b] != 1) 
						return false;
				}
			}
			return true;
		}

	}
}
