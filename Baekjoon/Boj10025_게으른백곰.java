import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10025_게으른백곰 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, K;
	static final int MAX = 100_0001;
	private static int[] map;
	private static int move;
	private static int cnt;
	private static int maxCnt;
	private static int maxPoint;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 양동이 개수
		K = Integer.parseInt(st.nextToken()); // 움직일수 있는 거리 (양쪽)
		move = K + K; // 구간 길이
		map = new int[MAX];
		cnt = 0; // 구간에 있는 얼음 합
		maxCnt = 0;
		maxPoint = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int ice = Integer.parseInt(st.nextToken());
			int point = Integer.parseInt(st.nextToken());
			maxPoint = maxPoint < point ? point : maxPoint; // 양동이 좌표 최대 값
			map[point] = ice;
		}

		for (int i = 0; i <= move && i <= maxPoint; i++) {
			cnt += map[i];
		}
		maxCnt = maxCnt < cnt ? cnt : maxCnt;
		
		// move >= maxPoint -> 곰의 이동 가능한 거리가 양동이 좌표 최대값보다 크다는 것은 구간합에서 이미 존재하는 얼음을 다 더했다는 뜻이므로 
		//					  얼음을 다 더한 값이 최대값임
		
		for (int start = 1; start <= maxPoint - move; start++) {
			// 앞에 있는 원소 빼고
			cnt -= map[start - 1];

			// 뒤에 있는 원소 넣고
			cnt += map[start + move];

			// 최대값 계산
			maxCnt = maxCnt < cnt ? cnt : maxCnt;
		}

		System.out.println(maxCnt);

	} // end of main

} // end of class
