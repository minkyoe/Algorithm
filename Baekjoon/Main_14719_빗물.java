import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14719_빗물 {

	private static int H;
	private static int W;
	private static int[] arr;
	private static int highest;
	private static int sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		arr = new int[W];
		highest = 0;
		sum = 0;
		
		st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			highest = Math.max(highest, arr[i]);
		}
		
		if (highest == 0 || (arr[0] == 0 && arr[W-1] == 0)) System.out.println(0);
		else {
			// 제일 첫번째와 맨 마지막은 건너뜀
			for (int i = 1; i < arr.length-1; i++) {
				int now = arr[i];
				if (now == highest) continue;
				
				int left = 0;
				int right = 0;
				
				for (int j = 0; j < i; j++) {
					left = Math.max(left, arr[j]);
				}
				
				for (int j = i+1; j < arr.length; j++) {
					right = Math.max(right, arr[j]);
				}
				
				if (left < now || right < now) continue;
				sum += Math.abs(now - (Math.min(left, right)));
			}
			
			System.out.println(sum);
		}
		
	} // end of main

} // end of class