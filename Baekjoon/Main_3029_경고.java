import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3029_경고 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), ":");
		StringBuilder sb = new StringBuilder();
		
		int bh = Integer.parseInt(st.nextToken()); // before 
		int bm = Integer.parseInt(st.nextToken());
		int bs = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine(), ":");
		int ah = Integer.parseInt(st.nextToken()); // after
		int am = Integer.parseInt(st.nextToken());
		int as = Integer.parseInt(st.nextToken());
		
		// 정인이는 적어도 1초를 기다리며, 많아야 24시간을 기다린다.
		if (bh == ah && bm == am && bs == as) {
			sb.append("24:00:00");
		}
		else {
			int dh = 0; int dm = 0; int ds = 0; // 시간 차이 (정답)
			
			if (as < bs) {
				as += 60;
				am -= 1;
			} 
			ds = (as - bs);
			
			if (am < bm) {
				am += 60;
				ah -= 1;
			}
			dm = (am - bm);
			
			if (ah < bh) {
				ah += 24;
			}
			dh = ah - bh;
			
			if (dh < 10) sb.append("0").append(dh).append(":");
			else sb.append(dh).append(":");
			
			if (dm < 10) sb.append("0").append(dm).append(":");
			else sb.append(dm).append(":");
			
			if (ds < 10) sb.append("0").append(ds);
			else sb.append(ds);
		}
		
		System.out.println(sb);
	} // end of main

} // end of class
