import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15918_랭퍼든수열쟁이야 {

	private static int n, x, y, ans;
	private static boolean[] isUsed;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		ans = 0;
		
		isUsed = new boolean[n+1]; // 해당 숫자가 이미 배치되었는지
		arr = new int[n*2+1]; // 배치된 숫자 배열
		
		arr[x] = arr[y] = (y - x - 1);
		isUsed[y - x - 1] = true;
		
		go(1);
		
		System.out.println(ans);
	} // end of main

	private static void go(int idx) {
		if (idx == n*2) {
			++ans;
			return;
		}
		
		if (arr[idx] != 0) go(idx+1);
		
		for (int num = 1; num <= n; num++) {
			int from = idx; 
			int to = idx + num + 1;
			
			if (from > n*2 || to > n*2) return; // 뒤에 더 진행할 인덱스가 없으므로
			if (isUsed[num] || arr[from] != 0 || arr[to] != 0) continue;
			
			arr[from] = num;
			arr[to] = num;
			isUsed[num] = true;
			
			go (from+1);
			
			arr[from] = 0;
			arr[to] = 0;
			isUsed[num] = false;
		}
		
	}

} // end of class
