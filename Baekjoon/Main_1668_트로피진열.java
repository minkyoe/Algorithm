import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1668_트로피진열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		int before = arr[0];
		int smallCnt = 1;
		int bigCnt = 1;
		
		// 왼쪽부터
		for (int i = 1; i < N; i++) {
			if (before < arr[i]) {
				++smallCnt;
				before = arr[i];
			}
		}
		
		before = arr[N-1];
		
		// 오른쪽부터
		for (int i = N-2; i >= 0; i--) {
			if (before < arr[i]) {
				++bigCnt;
				before = arr[i];
			}
		}
		
		System.out.println(smallCnt);
		System.out.println(bigCnt);

	} // end of main

} // end of class
