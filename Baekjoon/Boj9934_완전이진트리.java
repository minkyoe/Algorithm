package Baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main_9934_완전이진트리 {
	private static int K;
	private static int[] ans;
	private static int order;
	private static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(bf.readLine());
		arr = new int[(1<<K)];
		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 1; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		ans = new int[(1<<K)];
		order = 1;
		inOrder(1, 1);
		for (int i = 0, idx = 1; i < K; i++) {
			for (int j = 0; j < 1<<i; j++, idx++) {
				System.out.print(ans[idx] + " ");
			}
			System.out.println();
		}
	} // end of main
	private static void inOrder(int idx, int cnt) {
		if (cnt == K) {
//			System.out.println("idx " + arr[idx]);
//			System.out.println("order " + order);
			ans[order++] = arr[idx];
			return;
		}
		
		inOrder(idx*2, cnt+1);
		ans[order++] = arr[idx];
		inOrder(idx+1, cnt+1);
		
	}
} // end of class