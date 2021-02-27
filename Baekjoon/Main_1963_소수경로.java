import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1963_소수경로 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());

		for (int testCase = 1; testCase <= tc; testCase++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int before = Integer.parseInt(st.nextToken());
			int after = Integer.parseInt(st.nextToken());

			if (before == after) {
				System.out.println(0);
				continue;
			}

			boolean[] isDeleted = new boolean[10001];
			isDeleted[0] = isDeleted[1] = true;

			for (int i = 2; i <= 9999; i++) {
				for (int j = i + i; j <= 9999; j += i) {
					isDeleted[j] = true;
				}
			}

			Queue<int[]> q = new LinkedList<>();
			boolean[] visited = new boolean[10001];
			q.offer(new int[] {before, 0});
			int ans = -1;
			
			while(!q.isEmpty()) {
				int[] tmp = q.poll();
				int now = tmp[0];
				int cnt = tmp[1];
				
				if (now == after) {
					ans = cnt;
					break;
				}
				
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j <= 9; j++) {
						String s = String.valueOf(now).substring(0, i) + String.valueOf(j) 
									+ String.valueOf(now).substring(i+1);
						int tmpInt = sToInt(s);
						
						if (tmpInt < 1000 || visited[tmpInt] || isDeleted[tmpInt]) continue;
						visited[tmpInt] = true;
						q.offer(new int[] {tmpInt, cnt+1});
					}
				}
			}

			if (ans == -1) System.out.println("Impossible");
			else System.out.println(ans);
		} // end of tc

	} // end of main

	private static int sToInt(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0') continue;
			result += Math.pow(10, 4-i-1) * (s.charAt(i) - '0');
		}
		return result;
	}

} // end of class
