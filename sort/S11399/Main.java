package sort.S11399;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int answer = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<=i; j++) {
                answer += arr[j];
            }
        }

        System.out.println(answer);
    }
}
