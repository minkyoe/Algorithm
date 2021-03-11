package DP;

import java.util.*;

public class 땅따먹기 {

	class Solution {
		int N, M;
		int answer;
		int[][] dp;

		int solution(int[][] land) {
			answer = Integer.MIN_VALUE;
			N = land.length; // 행
			M = land[0].length; // 열
			dp = new int[N][M];

			for (int i = 0; i < N; i++) { // 행
				for (int j = 0; j < M; j++) { // 열
					dp[i][j] = land[i][j];
				}
			}

			for (int i = 1; i < N; i++) { // 행
				for (int j = 0; j < M; j++) { // 열
					for (int k = 0; k < M; k++) { // 이전 열
						if (j == k)
							continue;
						dp[i][j] = Math.max(dp[i - 1][k] + land[i][j], dp[i][j]);
					}
				}
			}

			for (int i = 0; i < M; i++) {
				answer = Math.max(answer, dp[N - 1][i]);
			}

			return answer;
		}

	}
}
