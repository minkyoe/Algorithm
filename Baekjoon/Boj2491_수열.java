import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2491_수열 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N];
		int max = 0;
		String str = bf.readLine();
		
		for (int i = 0,index = 0; i < N; i++, index+=2) {
			arr[i] = str.charAt(index) - '0';
		}
		int cnt = 0;
		boolean isUp = false;
		
		for (int i = 0; i < N-1; i++) {
			if (i==0) {
				++cnt;
				if (arr[i] < arr[i+1]) isUp = true;
				continue;
			}
			if (!isUp && arr[i] < arr[i+1]) {
				isUp = true;
				System.out.println(i+ "번째 " + arr[i] + ", " + cnt);
				max = max < cnt ? cnt : max;
				cnt = 0;
				continue;
			}
			if (isUp && arr[i] > arr[i+1]) {
				isUp = false;
				System.out.println(i+ "번째 " + arr[i] + ", " + cnt);
				max = max < cnt ? cnt : max;
				cnt = 0;
				continue;
			}
			else {
				++cnt;
				System.out.println(i+ "번째 " + arr[i] + ", " + cnt);
			}
		}
		
		System.out.println(max);
	} // end of main
} // end of class
