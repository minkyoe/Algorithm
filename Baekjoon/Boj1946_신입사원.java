import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1946_신입사원 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N; // 지원자 수
	static ArrayList<Grade> gl = new ArrayList<Grade>();
	static int ans;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(bf.readLine());
		
		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(bf.readLine());
			/** 초기 */
			ans = 0;
			gl.clear();
			
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(bf.readLine(), " ");
				gl.add(new Grade(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			Collections.sort(gl); // 서류 순위로 정렬
			
			int top = gl.get(0).interview; // 현재 뚫어야하는 면접순위
			ans++; // 일단 서류 1등 선발인원에 추가
			
			for (int j = 1; j < gl.size(); j++) {
				int tmp = gl.get(j).interview;
				if (top > tmp) {
					top = tmp;
					ans++;
				}
			}
			
			System.out.println(ans);
			
			
		} // end of TC
	} // end of main
} // end of class

class Grade implements Comparable<Grade>{
	int paper; // 서류 심사 성적 순위
	int interview; // 면접 심사 성적 순위
	
	public Grade() {
	}

	public Grade(int paper, int interview) {
		super();
		this.paper = paper;
		this.interview = interview;
	}

	@Override
	public String toString() {
		return "Grade [paper=" + paper + ", interview=" + interview + "]";
	}

	@Override
	public int compareTo(Grade o) {
		return this.paper - o.paper;
	}
}