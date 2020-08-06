package live06_0806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1931 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N; // 회의 수
	static Conference[] arr;
	static int ans = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(bf.readLine());
		arr = new Conference[N];

		int from, to;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			arr[i] = new Conference(from, to);
		}

		Arrays.sort(arr); // 종료시간 이른것부터 정렬

		int beforeTo = 0; // 직전에 끝난 회의 시간
		for (int i = 0; i < N; i++) {
			if (arr[i].from >= beforeTo) { // 직전에 끝난 회의시간보다 같거나 늦게 시작하면 선택
				++ans;
				beforeTo = arr[i].to;
			}
		}

		System.out.println(ans);
	} // end of main
} // end of class

class Conference implements Comparable<Conference> {
	int from, to;

	public Conference() {
	}

	public Conference(int from, int to) {
		super();
		this.from = from;
		this.to = to;
	}

	@Override
	public String toString() {
		return "Conference [from=" + from + ", to=" + to + "]";
	}

	@Override
	public int compareTo(Conference o) {
		if (this.to == o.to) {
			return Integer.compare(this.from, o.from);
		}
		return Integer.compare(this.to, o.to);
	}

}