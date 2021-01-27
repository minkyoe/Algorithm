package Baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9934_완전이진트리 {

	private static int K;
	private static int[] ans;
	private static int order;
	private static int[] arr;
	private static int rootIdx;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(bf.readLine());
		arr = new int[(1<<K)];
		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 1; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		rootIdx = (1 << K) / 2;
		
		ans = new int[(1 << K) - 1];
		order = 0;
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(rootIdx);	
		
		int n = K - 2;
		for (int i = K; i >= 1; i--) {
			int num = 1 << n; // 인덱스에서 빼야 할 값 
			int size = 1 << (K-i); // 큐에서 꺼내야 할 값 개수
			while(size-- > 0) {
				int nowIdx = q.poll();
				
				ans[order++] = arr[nowIdx];
				
				if (nowIdx - num > 0) 
					q.offer(nowIdx - num);
				if (nowIdx + num < (1<<K)) 
					q.offer(nowIdx + num);
			}
			n--;
		}
		
		for (int i = 0, idx = 0; i < K; i++) {
			for (int j = 0; j < 1<<i; j++, idx++) {
				System.out.print(ans[idx] + " ");
			}
			System.out.println();
		}
	} // end of main
} // end of class