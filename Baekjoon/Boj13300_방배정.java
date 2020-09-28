import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static int N;
	private static int K;
	private static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 학생 수
		K = Integer.parseInt(st.nextToken()); // 방 최대 인원 수
		arr = new int[7][2]; // 학년, 여/남 (여: 0, 남: 1)
		int cnt = 0; // 방 수
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int g = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[c][g]++;
		}
		
		for (int i = 1; i <= 6; i++) {
			for (int j = 0; j < 2; j++) {
				if (arr[i][j] != 0) {
					if (arr[i][j] % K == 0) {
						cnt += arr[i][j] / K;
					}
					else {
						cnt += arr[i][j] / K;
						cnt += 1;
					}
				}
			}
		}
		System.out.println(cnt);
	} // end of main

} // end of class
