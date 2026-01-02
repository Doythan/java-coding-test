package CT.sortlab;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortPrac {
    public static void main(String[] args) {
        SortPrac sp = new SortPrac();;
        System.out.println();
        System.out.println("       [ 정렬 연습 결과 ]       ");
        System.out.println("========================================");

        // 1. 일반 배열 정렬
        System.out.println("[1] 일차원 배열 정렬");
        System.out.print("▶ 오름차순: ");
        sp.ascendingOrder();
        
        System.out.print("▶ 내림차순: ");
        sp.descendingOrder();

        // 2. 2차원 배열 정렬
        System.out.println("\n----------------------------------------");
        System.out.println("[2] 2차원 배열 정렬 (다중 조건)");
        sp.arr2Order();
        
        // 3. 문자열 정렬
        System.out.println("\n----------------------------------------");
        System.out.println("[3] 문자열 정렬");
        sp.stringOrder();

        System.out.println("\n----------------------------------------");
        System.out.println("[4] 리스트 정렬");
        sp.ListOrder();

        System.out.println("\n----------------------------------------");
        System.out.println("[5] 객체 정렬 (나이순 -> 이름순)");
        sp.new Person(0, "").objectOrder();  // 내부 클래스 호출을 위한 임시 객체 활용

        System.out.println("\n========================================");
    }

    /// 배열 정렬 - 오름차순
    /// 시간복잡도: O(N long N)
    /// 내부 구현: dual-Pivot QuickSort(primitive)
    private void ascendingOrder() {
        int arr[] = {5, 1, 4, 2, 3};
        Arrays.sort(arr);

        for(int i=0; i<arr.length; i++) System.out.print(arr[i] + " ");
        System.out.println();
    }

    /// 배열 정렬 - 내림차순
    /// int[]에는 reverseOrder() 불가 -> Integer[]로 변경
    private void descendingOrder() {
        Integer arr[] = {5, 1, 4, 2, 3};
        Arrays.sort(arr, Collections.reverseOrder());

        for(int i=0; i<arr.length; i++) System.out.print(arr[i] + " ");
        System.out.println();
    }

    /// 2차원 배열 정렬
    private void arr2Order() {
        int arr2[][] = {
            {3, 12},
            {3, 11},
            {3, 10},
            {1, 3},
            {1, 2},
        };

        Arrays.sort(arr2, (a, b) -> Integer.compare(a[0], b[0])); // 오름차순
        Arrays.sort(arr2, (a, b) -> Integer.compare(b[0], a[0])); // 내림차순 
        Arrays.sort(arr2, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0])); // 정렬 기준 2개, 첫번째 기준 같으면 두번째 기준으로

         for (int i=0; i<arr2.length; i++) {
            for (int j=0; j<arr2[i].length; j++) {
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }
    }

    /// 문자열 정렬
    /// 기본: 사전순, 대소문자 포함이면 ASCII 기준
    private void stringOrder() {
        String[] words = {"banana", "apple", "watermelon", "ABC"};
        Arrays.sort(words);

        for(String w: words) System.out.print(w + " ");
        System.out.println();
    }

    /// 리스트 정렬
    private void ListOrder() {
        List<Integer> list = Arrays.asList(5, 1, 4, 2, 3);
        
        // 1. 예전 스타일
        Collections.sort(list);
        Collections.sort(list, Comparator.reverseOrder());

        // 2. 요즘 스타일: (a, b) -> a.compareTo(b)와 완전히 동일함
        list.sort(Integer::compareTo);
        list.sort(Comparator.reverseOrder());

        System.out.println(list);
    }

    // 객체 정렬 클래스
    class Person {
        int age;
        String name;

        Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        // 객체 정렬 메서드
        public void objectOrder() {
            List<Person> people = Arrays.asList(
                new Person(29, "도경원"),
                new Person(22, "김서현"),
                new Person(29, "정병학"),
                new Person(28, "정원영")
            );

            // 조건 1개
            people.sort(Comparator.comparingInt(p -> p.age)); // 나이 오름차순 
            people.sort(Comparator.comparingInt((Person p) -> p.age).reversed()); // 나이 내림차순
            people.sort(Comparator.comparing(p -> p.name)); // 이름 사전순
            people.sort(Comparator.comparing((Person p) -> p.name).reversed()); // 이름 사전 반대순
            
            // 다중 조건 정렬 (나이 오름차순 -> 이름 사전순), 코테 단골
            people.sort(
                Comparator.comparingInt((Person p) -> p.age).thenComparing(p -> p.name)
            );

            for (Person p : people) System.out.println(p.name + " (" + p.age + "세)");
        }
    }
}
