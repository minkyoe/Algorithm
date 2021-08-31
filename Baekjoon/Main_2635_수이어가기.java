import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_2635_수이어가기 {

	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(bf.readLine());
		
		int maxCnt = 0;
		ArrayList<Integer> maxNums = new ArrayList<>();
		ArrayList<Integer> nums = new ArrayList<>();
		
		for (int n = N/2; n <= N; n++) {
			nums.add(N);
			nums.add(n);
			
			while (true) {
				int tmp = nums.get(nums.size()-2) - nums.get(nums.size()-1);
				if (tmp < 0) break;
				nums.add(tmp);
			}
			
			if (maxCnt < nums.size()) {
				maxCnt = nums.size();
				maxNums.clear();
				for (int i = 0; i < nums.size(); i++) {
					maxNums.add(nums.get(i));
				}
			}
			
			nums.clear();
		}

		sb.append(maxCnt).append("\n");
		for (int i = 0; i < maxNums.size(); i++) {
			sb.append(maxNums.get(i)).append(" ");
		}
		
		System.out.println(sb);
	} // end of main

} // end of class
