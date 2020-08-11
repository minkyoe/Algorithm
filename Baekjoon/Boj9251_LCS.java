import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9251_LCS {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static String a, b;
	static int[][] lcs;

	public static void main(String[] args) throws IOException {
		a = bf.readLine();
		b = bf.readLine();

		// 0행 0열은 항상 0으로 초기화 해주고 시작
		a = '0' + a;
		b = '0' + b;

		int aLen = a.length();
		int bLen = b.length();
		lcs = new int[aLen][bLen];

		for (int i = 0; i < aLen; i++) {
			for (int j = 0; j < bLen; j++) {
				if (i == 0 || j == 0) {
					lcs[i][j] = 0;
					continue;
				}

				// 현재 비교하는 값이 서로 같다면, lcs는 + 1
				if (a.charAt(i) == b.charAt(j))
					lcs[i][j] = lcs[i - 1][j - 1] + 1;

				// 서로 다르다면 왼쪽, 위 중에 큰값 가져옴
				else {
					lcs[i][j] = (lcs[i - 1][j] > lcs[i][j - 1]) ? lcs[i - 1][j] : lcs[i][j - 1];
				}

			}
		} // end of for
		System.out.println(lcs[aLen - 1][bLen - 1]);

	} // end of main

} // end of class
