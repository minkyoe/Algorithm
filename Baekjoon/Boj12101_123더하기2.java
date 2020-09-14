import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_12101_123더하기2 {
	static int n, k;
	static ArrayList<Integer> nums = new ArrayList<>();
	static ArrayList<String> result = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken()); // 숫자 합 
		k = Integer.parseInt(st.nextToken()); // k번째 수
		
		go(0);
		Collections.sort(result);
		if (result.size() < k) System.out.println("-1");
		else System.out.println(result.get(k-1));
		
	} // end of main
	private static void go(int sum) {
		if (sum == n) {
			String tmp = "";
			for (int i = 0; i < nums.size(); i++) {
				tmp = tmp + String.valueOf(nums.get(i)) + "+";
			}
			tmp = tmp.substring(0, tmp.length()-1);
			result.add(tmp);
			return;
		}
		
		for (int i = 1; i <= 3; i++) {
			if (sum + i > n) break;
			nums.add(i);
			go(sum+i);
			nums.remove(nums.size()-1);
		}
		
	}
} // end of class
