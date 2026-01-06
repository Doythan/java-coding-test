package src.io;

import java.io.*;
import java.util.*;

public class InputOutputPrac {
    public static void main(String[] args) throws IOException {
        // 실제 시험에서는 필요한 메서드 내용만 main에 작성하세요.
        System.out.println("--- [1] 기본 숫자 및 공백 데이터 ---");
        // basicInput();

        System.out.println("\n--- [2] 공백 없는 숫자 배열 (미로 등) ---");
        // gridInput();

        System.out.println("\n--- [3] 많은 양의 문자열 입력 ---");
        // stringInput();

        System.out.println("\n--- [4] 끝이 지정되지 않은 입력 (EOF) ---");
        eofInput();
    }

    /**
     * 상황 1: N(개수)이 주어지고 그 다음 줄에 공백으로 구분된 숫자들이 올 때
     * 예시:
     * 3
     * 10 20 30
     */
    static void basicInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 첫 줄 정수 읽기
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine()); // 두 번째 줄 읽기
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println("결과: " + Arrays.toString(arr));
    }

    /**
     * 상황 2: 공백 없이 숫자가 붙어서 들어오는 경우 (그래프, 미로 탐색)
     * 예시:
     * 2
     * 10
     * 11
     */
    static void gridInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        for (int i=0; i<n; i++) {
            String line = br.readLine();
            for (int j=0; j<line.length(); j++) {
                // 문자를 숫자로 바꿀 때 '0'을 빼는 것이 가장 빠름
                map[i][j] = line.charAt(j) - '0';
            }
        }
        System.out.println("결과: " + map[0][0] + " " + map[0][1]);
    }

    /**
     * 상황 3: 대량의 데이터를 출력해야 할 때 (StringBuilder 필수)
     */
    static void stringInput() throws IOException {
        StringBuilder sb = new StringBuilder();
        // 출력이 10,000개 이상이면 반드시 StringBuilder를 사용해 모아서 한번에 출력
        for (int i=1; i<=5; i++) {
            sb.append(i).append("번 결과값\n");
        }
        System.out.print(sb);
    }

    /**
     * 상황 4: 입력의 개수가 주어지지 않았을 때 (EOF 처리)
     * 테스트 케이스가 몇 개인지 모를 때 사용
     */
    static void eofInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        // 더 이상 읽을 라인이 없을 때까지 반복
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            System.out.println("입력된 값: " + line);
        }
    }
}
