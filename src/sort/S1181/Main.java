package src.sort.S1181;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 중복 제거를 위한 HashSet 사용
        Set<String> words = new HashSet<>();
        for (int i=0; i<N; i++) {
            words.add(br.readLine());
        }

        // HashSet을 ArrayList로 변환
        List<String> wordList = new ArrayList<>(words);

        // sol 1. Comparator를 이용한 정렬
        /*
        Collections.sort(wordList, new Comparator<String>() {

            public int compare(String s1, String s2) {
                // 길이순
                if (s1.length() != s2.length()) return s1.length() - s2.length();
                // 길이가 같으면 사전순
                return s1.compareTo(s2);
            }
        });
        */

        // sol 2. Lambda & Stream
        wordList.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
        /*
        wordList.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // 1. Comparator.comparingInt(String::length) 부분
                // 두 단어의 길이를 먼저 비교합니다.
                int res = Integer.compare(s1.length(), s2.length());
                
                // 2. .thenComparing(Comparator.naturalOrder()) 부분
                // 만약 길이가 같다면(res == 0), 사전순(Natural Order)으로 비교합니다.
                if (res == 0) {
                    res = s1.compareTo(s2);
                }
                
                return res;
            }
        });
        */

        // 결과 출력
        for (String word : wordList) {
            System.out.println(word);
        }
    }
}
