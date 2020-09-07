package KAKAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Solution_2018_캐시 {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
//		String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
		int cacheSize = 5;
		System.out.println(s.solution(cacheSize, cities));
		
	}
}

class Solution {
	static final int HIT = 1;
	static final int MISS = 5;
	
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if (cacheSize == 0) return cities.length*MISS;
        if (cities.length == 0) return 0;
        
        ArrayList<String> cityList = new ArrayList<>();
        
        int start = 0;
        while(start < cities.length) {
        	if (cityList.contains(cities[start].toLowerCase())) {
        		answer += HIT;
        		cityList.remove(cities[start].toLowerCase());
        		cityList.add(cities[start].toLowerCase());
        	}
        	else {
        		answer += MISS;
        		if (cityList.size() < cacheSize) {
        			cityList.add(cities[start].toLowerCase());
        		}
        		else {
        			cityList.remove(0);
            		cityList.add(cities[start].toLowerCase());
        		}
        	}
        	start++;
        }
        
        return answer;
    }
}