import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10973_이전순열 {

	private static int N;
	private static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int idx1 = 0;
		int idx2 = 0;
		boolean flag = false;
		
		for (int i = N-1; i > 0; i--) {
			if (arr[i-1] <= arr[i]) {
				if (i == 1) {
					flag = true;
				}
				continue;
			}
			idx1 = i-1;
			break;
		}
		
		if (flag || N == 1) System.out.println("-1");
		else {
			for (int i = N-1; i > idx1; i--) {
				if (arr[idx1] <= arr[i]) {
					continue;
				}
				idx2 = i;
				break;
			}
			
			int tmp = arr[idx1];
			arr[idx1] = arr[idx2];
			arr[idx2] = tmp;
			
			int front = idx1 + 1;
			int end = N - 1;
			
			while (front < end) {
				int tmp2 = arr[front];
				arr[front] = arr[end];
				arr[end] = tmp2;
				front++;
				end--;
			}
			
			for (int i = 0; i < N; i++) {
				System.out.print(arr[i] + " ");
			}
		}

	} // end of main

} // end of class
