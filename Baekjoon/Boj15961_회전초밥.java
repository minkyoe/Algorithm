import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

//8 30 4 30
//7
//9
//7
//30
//2
//7
//9
//25
public class Main_JO_2577_회전초밥 {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, d, k, c; // 접시 , 초밥 가지수 , 연속 접시수 , 쿠폰번호
	static int maxCnt;
	static Deque<Integer> dq = new LinkedList<>();
	static ArrayList<Integer> chobab = new ArrayList<>();
	private static int[] chobabCnt;
	private static int kind;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 접시 수
		d = Integer.parseInt(st.nextToken()); // 초밥 가지 수
		k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
		c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		maxCnt = 0;
		dq = new LinkedList<>();
		chobabCnt = new int[d + 1]; // 0번 안씀, 현재 dq에 있는 초밥 개수 카운트
		kind = 0; // dq에 들어있는 초밥 종류 개수

		for (int i = 0; i < N; i++) {
			chobab.add(Integer.parseInt(bf.readLine()));
		}

		for (int i = 0; i < k; i++) {
			int now = chobab.get(i);
			dq.offerLast(chobab.get(i));

			if (chobabCnt[now] == 0) {
				kind++; // 덱에 들어있는 초밥 종류 세기
			}
			chobabCnt[chobab.get(i)]++; // 덱에 들어있는 초밥 개수 세기
		}
		maxCnt = maxCnt < kind ? kind : maxCnt;

		for (int i = 0; i < N - 1; i++) {
			int now = chobab.get(i);
			dq.pollFirst();
			chobabCnt[now]--;
			if (chobabCnt[now] == 0) { // 해당 초밥이 덱에 없으면 kind--
				kind--;
			}

			int next = chobab.get((i + k) % N); // 다음 초밥 넣기, 인덱스 잘보기
			dq.offerLast(next);

			if (chobabCnt[next] == 0) { // 덱에 없던 초밥이라면 kind++
				kind++;
			}
			chobabCnt[next]++;

			if (chobabCnt[c] == 0) { // 쿠폰 초밥 안 먹었다면
				maxCnt = maxCnt < kind + 1 ? kind + 1 : maxCnt;
			} else {
				maxCnt = maxCnt < kind ? kind : maxCnt;
			}

		}

		System.out.println(maxCnt);

	} // end of main

} // end of class
