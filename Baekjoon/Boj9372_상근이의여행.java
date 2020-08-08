import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9372_상근이의여행 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int T, N, M; // 테케, 국가 수, 비행기 종류
	static int[] parent;
	static int ans = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(bf.readLine());
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parent = new int[N + 1]; // 국가의 수+1 만큼 배열 만듬 (0번 안씀)
			ans = 0;

			make(); // parent배열 초기화

			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(bf.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (union(a, b)) { // 사이클이 존재하지않으면 union
					++ans;
				}
			}
			System.out.println(ans);
		} // end of TC
	} // end of main

	private static boolean union(int a, int b) {
		int pa = getParent(a);
		int pb = getParent(b);
		if (pa == pb)
			return false;
		parent[pb] = pa;
		return true;
	}

	/** 부모 찾기 */
	private static int getParent(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = getParent(parent[a]); // path compression
	}

	/** parent 배열 초기화 */
	private static void make() {
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}

} // end of class
