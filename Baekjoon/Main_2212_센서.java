import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2212_센서 {

	private static int N;
	private static int K;
	private static int[] arr;
	private static int[] diff;
	private static int totalDist;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		K = Integer.parseInt(bf.readLine());
		
		arr = new int[N];
		diff = new int[N-1];
		totalDist = 0;
		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		// ArrayIndexOutOfBounds 에러 방지
		// 집중국 세울 수 있는 개수가 센서 개수보다 많을때
		if (N <= K) 
			K = N;
		
		for (int i = 0; i < N-1; i++) {
			diff[i] = arr[i+1] - arr[i];
			totalDist += diff[i];
		}
		
		Arrays.sort(diff);
		
		for (int i = 0; i < K-1; i++) {
			totalDist -= diff[N-2-i];
		}
		
		System.out.println(totalDist);
		
	} // end of main

} // end of class
