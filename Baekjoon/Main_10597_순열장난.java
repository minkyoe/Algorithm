import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_10597_순열장난 {

	private static int N;
	private static boolean[] visited;
	private static StringBuilder sb;
	private static String str;
	private static int len;
	private static ArrayList<Integer> ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		str = bf.readLine();
		len = str.length();
		N = 0;
		ans = new ArrayList<Integer>();
		
		// N 구하기
		if (len > 9) {
			N = 9 + ((len - 9) / 2); 
		}
		else {
			N = len;
		}
		
		visited = new boolean[N+1];
		sb = new StringBuilder();
		go(0);
		
		for (int i = 0; i < ans.size(); i++) {
			sb.append(ans.get(i)).append(" ");
		}
		
		System.out.println(sb);
	} // end of main 

	private static boolean go(int idx) {
		if (idx == len) return true;
		
		// 한자리수
		int a = str.charAt(idx) - '0';
		if (!visited[a] && a != 0) {
			visited[a] = true;
			ans.add(a);
			if (go(idx + 1)) return true;
			else {
				ans.remove(ans.size()-1);
				visited[a] = false;
			}
		}
		
		// 두자리수 구해야되는데 str 길이 넘어가면 안됨
		if (idx + 1 == len) return false;
		
		// 두자리수
		int b = (str.charAt(idx) - '0') * 10 + (str.charAt(idx + 1) - '0');
		if (b > N) return false; // 최대 N까지 존재함
		else if (!visited[b] && b != 0){
			visited[b] = true;
			ans.add(b);
			if (go(idx + 2)) return true;
			else {
				ans.remove(ans.size() - 1);
				visited[b] = false;
			}
		}
		
		return false;
	}

} // end of class
