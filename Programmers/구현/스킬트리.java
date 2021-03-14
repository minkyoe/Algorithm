package 구현;
import java.util.*;

public class 스킬트리 {

class Solution {
	public int solution(String skill, String[] skill_trees) {
		int answer = 0;

		for (int i = 0; i < skill_trees.length; i++) {
			int[] arr = new int[skill.length()];

			for (int j = 0; j < skill.length(); j++) {
				arr[j] = skill_trees[i].indexOf(skill.charAt(j));
			}

			if (skill.length() == 1) {
				++answer;
			} else {
				int before = arr[0];

				for (int j = 1; j < skill.length(); j++) {
					int now = arr[j];

					if ((before == -1 && (now != -1)) || (now < before && now != -1))
						break;
					if (j == skill.length() - 1) 
						++answer;
					before = now;
				}
			}

		}
		return answer;
	} // end of solution
} // end of class
}
