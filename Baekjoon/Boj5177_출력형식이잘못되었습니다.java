import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * 알파벳 대문자와 소문자는 구별하지 않는다. 공백이 하나 이상이라면, 공백의 크기는 관계없다. 물론 어떤 문자열엔 공백이 있고 어떤 문자열엔
 * 공백이 없는 것, 즉 공백 유무의 차이 자체는 문제가 된다. 문자열의 맨 앞 혹은 맨 뒤에 나타나는 공백은 있으나 없으나 관계없다. 특수
 * 부호의 바로 앞이나 바로 뒤에 나오는 공백도 있으나 없으나 상관없다. 여는 괄호끼리는 종류를 구별하지 않는다. 닫는 괄호끼리는 종류를
 * 구별하지 않는다. 쉼표(",")와 세미콜론(";")은 구별하지 않는다.
 *
 */

public class Main_5177_출력형식이잘못되었습니다 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	static int K = 0; // 테스트 케이스 수
	static String s1, s2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		K = Integer.parseInt(bf.readLine());
		for (int i = 1; i <= K; i++) {
			sb = new StringBuilder();
			sb.append("Data Set ").append(i).append(": ");
			s1 = bf.readLine();
			s2 = bf.readLine();

			// 규칙에 따라 문자열 대체
			s1 = replace(s1);
			s2 = replace(s2);

			// 공백 여러개면 한개로 치환
			s1 = removeSpace(s1);
			s2 = removeSpace(s2);

			// 특수문자 앞 뒤 공백 없앰
			s1 = removeSign(s1);
			s2 = removeSign(s2);

			boolean isSame = s1.equalsIgnoreCase(s2);
			if (isSame)
				sb.append("equal");
			else
				sb.append("not equal");
			System.out.println(sb.toString());
			System.out.println();

		} // end of TC
	} // end of main

	private static String removeSign(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == ' ') {
				if (i - 1 >= 0) {
					if (str.charAt(i - 1) == '(' || str.charAt(i - 1) == ')' || str.charAt(i - 1) == ','
							|| str.charAt(i - 1) == '.' || str.charAt(i - 1) == ':') { // 공백 앞에 특수문자가 있다면
						continue;
					}
				}
				if (i + 1 < str.length()) {
					if (i + 1 < str.length() && str.charAt(i + 1) == '(' || str.charAt(i + 1) == ')'
							|| str.charAt(i + 1) == ',' || str.charAt(i + 1) == '.' || str.charAt(i + 1) == ':') { // 공백 뒤에 특수문자가 있다면
						continue;
					}
				}
			}
			result += c;
		}
		return result;
	}

	private static String removeSpace(String str) {
		String result = "";
		int index = 0;
		while (index < str.length()) {
			char c = str.charAt(index++);
			result += c;
			if (index == str.length())
				break;
			if (c == ' ') {
				while (index < str.length() && str.charAt(index) == ' ') {
					++index;
				}
			}
		}
		return result;
	}

	private static String replace(String str) {
		// 여는 괄호
		str = str.replace('{', '(');
		str = str.replace('[', '(');
		// 닫는 괄호
		str = str.replace('}', ')');
		str = str.replace(']', ')');
		// ; ==> ,
		str = str.replace(';', ',');
		return str;
	}

} // end of class
