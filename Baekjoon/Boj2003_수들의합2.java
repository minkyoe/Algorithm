import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2003_수들의합2 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M; // 개수, 합
	static int[] arr;
	static int cnt;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0, end = 0;
		int sum = arr[0];
		
		while (start < N) { // start가 끝까지 갈때까지
			if (sum >= M) {
				if (sum == M) cnt++;
				
				start++;
				sum -= arr[start-1];
			}
			else {
				if (end == N-1) break; // end가 더 증가할 수 없을때 sum이 구하고자하는 값보다 작으면 
										// sum이 감소할경우밖에 안남았으므로 구하고자하는 값과 일치하는 일 없음
				end++;
				sum += arr[end];
			}
		}
		
		System.out.println(cnt);
				
	} // end of main
} // end of class
