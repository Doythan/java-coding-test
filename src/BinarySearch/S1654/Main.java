package src.BinarySearch.S1654;

import java.util.*;
import java.io.*;

public class Main {
    static int K, N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        for (int i=0; i<K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        checkMaxLan(N);
    }

    static void checkMaxLan(int lanNumber) {
        long left = 1; 
        long right = arr[K-1];
        
        while (left <= right) {
            
        }
    }
}
