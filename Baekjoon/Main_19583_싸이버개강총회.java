import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_19583_싸이버개강총회 {

	public static int startPartyHour, startPartyMin, endPartyHour, endPartyMin, endStreamHour, endStreamMin;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		int order = 0; int ans = 0;
		startPartyHour = 0; startPartyMin = 0;
		endPartyHour = 0; endPartyMin = 0;
		endStreamHour = 0; endStreamMin = 0;
		
		while (st.hasMoreTokens()) {
			StringTokenizer st2 = new StringTokenizer(st.nextToken(), ":");
			if (order == 0) {
				startPartyHour = Integer.parseInt(st2.nextToken());
				startPartyMin = Integer.parseInt(st2.nextToken());
			}
			else if (order == 1) {
				endPartyHour = Integer.parseInt(st2.nextToken());
				endPartyMin = Integer.parseInt(st2.nextToken());
			}
			else {
				endStreamHour = Integer.parseInt(st2.nextToken());
				endStreamMin = Integer.parseInt(st2.nextToken());
			}
			
			order = (order + 1) % 3;
		}
		
		HashMap<String, Integer> nameMap = new HashMap<>();
		boolean[][] startEnd = new boolean[10_0000][2]; // 0:출석, 1:퇴장
		HashSet<String> alreadySuccess = new HashSet<>();
		
		int nameIdx = 0;
		while (true) {
			String info = bf.readLine();
			if (info.equals("")) break;
			
			st = new StringTokenizer(info, " ");
			
			int hour = 0; int min = 0; String name = "";
			StringTokenizer st2 = new StringTokenizer(st.nextToken(), ":");
			hour = Integer.parseInt(st2.nextToken());
			min = Integer.parseInt(st2.nextToken());
			name = st.nextToken();
			
			// 이미 성공한 사람이면 패스함
			if (alreadySuccess.contains(name)) continue;
			
			// 이름 인덱스 지정
			int idx = 0;
			if (nameMap.containsKey(name)) {
				idx = nameMap.get(name);
			} else {
				nameMap.put(name, nameIdx);
				idx = nameIdx++;
			}
			
			// 시간 체크
			int result = timeCheck(hour, min);
			if (result == 0) {
				startEnd[idx][0] = true;
			}
			else if (result == 1) {
				startEnd[idx][1] = true;
			}
			
			// 출석 안했는데 퇴실 했을 경우는 그냥 패스함
			if (!startEnd[idx][0] && startEnd[idx][1]) continue;
			
			// 출석과 퇴실 둘다 했으면 정답 증가시킴
			if (startEnd[idx][0] && startEnd[idx][1]) {
				++ans;
				alreadySuccess.add(name);
			}
		} // end of while
		
		System.out.println(ans);

	} // end of main
	
	// 0 <= <= startParty : 출석 O -> return 0;
	// endParty <= <= endStream : 퇴실 O -> return 1;
	// 그 이외 : 아무것도 X -> return 2;
	public static int timeCheck (int hour, int min) {
		if (0 <= hour && hour < startPartyHour) {
			return 0;
		}
		else if (hour == startPartyHour) {
			if (min <= startPartyMin) return 0;
		}
		else {
			if (endPartyHour <= hour && hour < endStreamHour) {
				return 1;
			}
			else if (hour == endStreamHour) {
				if (min <= endStreamMin) return 1;
			}
			else {
				return 2;
			}
		}
		
		return -1;
	}

} // end of class
