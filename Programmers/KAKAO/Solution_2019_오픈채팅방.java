package KAKAO;

import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_2019_오픈채팅방 {
	public static void main(String[] args) {
		Solution s = new Solution();

		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		String[] answer = s.solution(record);

		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	static class Solution {
		public String[] solution(String[] record) {
			int cnt = 0;

			HashMap<String, String> hm = new HashMap<>();
			for (String string : record) {
				StringTokenizer st = new StringTokenizer(string, " ");

				// Leave일때는 hashmap 변경사항 없으므로 건너뜀. 대신 answer배열 사이즈 재야하기 때문에 cnt++
				if (st.countTokens() == 2) {
					cnt++;
					continue;
				}

				String mode = st.nextToken();
				String id = st.nextToken();
				String name = st.nextToken();

				if ("Enter".equals(mode)) {
					cnt++;
					hm.put(id, name);
				} else if ("Change".equals(mode)) {
					hm.replace(id, name);
				}
			}

			String[] answer = new String[cnt];
			int idx = 0;
			for (String string : record) {
				String[] tmp = string.split(" ");

				String mode = tmp[0];
				String id = tmp[1];
				String name = hm.get(id);

				if ("Enter".equals(mode)) {
					answer[idx++] = name + "님이 들어왔습니다.";
				} else if ("Leave".equals(mode)) {
					answer[idx++] = name + "님이 나갔습니다.";
				}
			}

			return answer;
		}
	}
}
