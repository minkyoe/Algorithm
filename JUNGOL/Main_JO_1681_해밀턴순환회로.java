import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//5
//0 14 4 10 20 
//14 0 7 8 7 
//4 5 0 7 16 
//11 7 9 0 2 
//18 7 17 4 0
public class Main_JO_1681_해밀턴순환회로_김민경 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N; // 장소 수 , 1:회사
	private static int[][] map;
	static int[] arr;
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(bf.readLine());
		
		map = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		arr = new int[N-1];
		
		for (int i = 2; i <= N; i++) {
			arr[i-2] = i; // 1은 회사이므로 나머지 장소들에 대한 순열 구할 것임
		}
		
		perm(0); // 현재 인덱스
		System.out.println(ans);

	} // end of main

	private static void perm(int idx) {
		if (idx == N-1) {
			if (map[1][arr[0]] == 0 || map[arr[arr.length-1]][1] == 0) return;
			
			int sum = map[1][arr[0]];
			sum += map[arr[arr.length-1]][1];
			for (int i = 0; i < arr.length-1; i++) {
				int tmp = map[arr[i]][arr[i+1]];
				if (tmp == 0) return;
				sum += map[arr[i]][arr[i+1]];
			}
			
			ans = ans > sum ? sum : ans;
			return;
		}
		
		for (int i = idx; i < arr.length; i++) {
			swap(idx,i);
			perm(idx+1);
			swap(idx,i);
		}
		
	}

	private static void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

} // end of class
