import java.io.IOException;
import java.util.Scanner;

public class Main_5639_이진검색트리 {

	private static int[] arr;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		arr = new int[10001];
		int idx = 0;
		
		// 입력
		while (sc.hasNext()) {
			arr[idx++] = sc.nextInt();
		}
		sc.close();
		
		recur(0, idx-1);
	} // end of main

	private static void recur(int start, int end) {
		if (start > end) return;
		
		int tmp = start + 1;
		while (tmp <= end && arr[tmp] < arr[start]) {
			tmp++;
		}
		
		recur(start+1, tmp-1);
		recur(tmp, end);
		System.out.println(arr[start]);
		
	}

} // end of class
