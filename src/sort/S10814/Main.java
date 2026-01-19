package src.sort.S10814;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 이름 때문에 String 배열로로 선언 
        String[][] members = new String[N][2];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            members[i][0] = st.nextToken();
            members[i][1] = st.nextToken();
        }

        // Arrays.sort(members, (m1, m2) -> {
        //     return Integer.parseInt(m1[0]) - Integer.parseInt(m2[0]);
        // });

        Arrays.sort(members, Comparator.comparing((String[] a) -> Integer.parseInt(a[0])));

        for (int i=0; i<N; i++) {
            System.out.println(members[i][0] + " " + members[i][1]);
        }
    }
}
