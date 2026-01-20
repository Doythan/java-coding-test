# Sorting (Java)

코딩 테스트에서 가장 자주 등장하는 정렬 유형을 Java 기준으로 정리한다.
정렬 알고리즘 구현보다는 **라이브러리 활용 + Comparator 사용**에 집중한다.

---

## 1. 1차원 배열 정렬

### 오름차순

```java
int arr[] = {1, 10, 9, 8, 7, 6, 2, 3, 4, 5};
Arrays.sort(arr);
```
* 시간복잡도: `O(N log N)`
* primitive 타입은 내부적으로 **Dual-Pivot QuickSort** 사용

### 내림차순

```java
Integer arr[] = {1, 10, 9, 8, 7, 6, 2, 3, 4, 5};
Arrays.sort(arr, Collections.reverseOrder());
```
* `int[]`에는 `reverseOrder()` 사용 불가 → `Integer[]` 필요

## 2. 2차원 배열 정렬

```java
// 방법 1.
Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));  // 오름차순
Arrays.sort(arr, Comparator.comparingInt((int[] a) -> a[0]).reversed());  // 내림차순
Arrays.sort(arr, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));  // 다중 조건: a[0]이 같으면, a[1] 비교
Arrays.sort(arr, Comparator.comparingInt((int[] a) -> a[0]).reversed().thenComparingInt(a -> a[1]).reversed());  // 다중 조건: a[0]이 같으면, a[1] 비교 (내림차순)

// 방법 2.
Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));  // 오름차순
Arrays.sort(arr, (a, b) -> Integer.compare(b[0], a[0]));  // 내림차순
Arrays.sort(arr, (a, b) -> {
    if (a[0] == b[0]) {
        return Integer.compare(a[1], b[1]);
    }
    return Integer.compare(a[0], b[0]);
});  // 다중 조건 
Arrays.sort(arr, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));  // 다중 조건(삼항연산자) 


// 방법 3.
Arrays.sort(arr, (a, b) -> a[0] - b[0]);  // 오름차순
Arrays.sort(arr, (a, b) -> b[0] - a[0]);  // 내림차순
```
* 첫 번째 기준이 같을 때 두 번째 기준 적용
* 좌표 정렬, 범위 문제에서 자주 등장

## 3️⃣ 문자열 정렬

```java
String[] words = {"banana", "apple", "watermelon", "ABC"};
Arrays.sort(words);
```

* 기본: **사전순**
* 대소문자 포함 시 ASCII 코드 기준


## 4️⃣ List 정렬

```java
List<Integer> list = Arrays.asList(5, 1, 4, 2, 3);

// 오름차순
list.sort(Integer::compareTo);

// 내림차순
list.sort(Comparator.reverseOrder());
```

* `Collections.sort()`보다 `list.sort()`가 최신 스타일


## 5️⃣ 객체 정렬 (Comparator)

```java
people.sort(
    Comparator.comparingInt((Person p) -> p.age)
              .thenComparing(p -> p.name)
);
```

* **코딩 테스트에서는 Comparable보다 Comparator가 정답**
* 다중 조건 정렬은 거의 무조건 이 패턴

### 자주 쓰는 패턴

* 나이 오름차순: `comparingInt(p -> p.age)`
* 나이 내림차순: `.reversed()`
* 문자열 기준: `Comparator.comparing(p -> p.name)`


## 정리

* 정렬 알고리즘 직접 구현 ❌
* Java 라이브러리 + Comparator 활용 ⭕
* 다중 조건 정렬은 **thenComparing**으로 처리
* 코테에서 정렬은 “패턴 암기 + 빠른 구현”이 핵심
