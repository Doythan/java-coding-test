package src.sort;

import java.util.*;
public class SortPracTwo {

    public static void main(String[] args) {
        SortPracTwo spt = new SortPracTwo();
        spt.new Person(0, "").objectOrder();
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
            
            // 다중 조건 정렬 (나이 오름차순 -> 이름 사전순)
            people.sort(
                Comparator.comparingInt((Person p) -> p.age).thenComparing(p -> p.name)
            );


            for (Person p : people) System.out.println(p.name + " (" + p.age + "세)");
        }
    }
}

