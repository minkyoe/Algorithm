import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int M; // 치킨집 최대 개수
	private static int[][] map;
	static int ans = 100 * 13; // 최소 거리, 초기값은 최대거리
	private static ArrayList<Point> chickenList = new ArrayList<Point>();
	private static ArrayList<Point> homeList = new ArrayList<Point>();
	private static HashSet<Integer> selected = new HashSet<Integer>();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			for (int j = 0, index = 0; j < N; j++, index += 2) {
				map[i][j] = Character.getNumericValue((s.charAt(index)));
				if (map[i][j] == 2)
					chickenList.add(new Point(i, j));
				if (map[i][j] == 1)
					homeList.add(new Point(i, j));
			}
		}

		comb(0, 0); // 치킨리스트의 인덱스, 고른 갯수

		System.out.println(ans);

	} // end of main

	/** 최대 치킨집 개수만큼 고름, 집과 치킨거리 구함, ans와 비교 */
	private static void comb(int index, int cnt) {
		if (cnt == M) {
			int sum = 0;
			for (int i = 0; i < homeList.size(); i++) { // 집 하나 당 고른 모든 치킨집과의 거리를 구해야함
				int tmp = 50 + 50;
				for (Integer integer : selected) {
					int chickenIdx = integer.intValue();
					int dis = Math.abs(homeList.get(i).r - chickenList.get(chickenIdx).r)
							+ Math.abs(homeList.get(i).c - chickenList.get(chickenIdx).c);
					tmp = tmp > dis ? dis : tmp;
				}
				sum += tmp;
			}
			ans = ans > sum ? sum : ans;
		}

		for (int i = index; i < chickenList.size(); i++) {
			selected.add(i);
			comb(i + 1, cnt + 1);
			selected.remove(i);
		}

	}

} // end of class

class Point {
	int r;
	int c;

	public Point() {
	}

	public Point(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}

	@Override
	public String toString() {
		return "Point [r=" + r + ", c=" + c + "]";
	}

}
