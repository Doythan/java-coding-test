# Sorting (Java)

코딩 테스트에서 가장 자주 등장하는 정렬 유형을 Java 기준으로 정리한다.
정렬 알고리즘 구현보다는 **라이브러리 활용 + Comparator 사용**에 집중한다.

---

## 1️⃣ 기본 배열 정렬

### 오름차순

```java
int[] arr = {5, 1, 4, 2, 3};
Arrays.sort(arr);
```

* 시간복잡도: `O(N log N)`
* primitive 타입은 내부적으로 **Dual-Pivot QuickSort** 사용

### 내림차순

```java
Integer[] arr = {5, 1, 4, 2, 3};
Arrays.sort(arr, Collections.reverseOrder());
```

⚠️ `int[]`에는 `reverseOrder()` 사용 불가 → `Integer[]` 필요

## 2️⃣ 2차원 배열 정렬 (다중 조건)

```java
Arrays.sort(arr, (a, b) ->
    a[0] == b[0] ? Integer.compare(a[1], b[1])
                 : Integer.compare(a[0], b[0])
);
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
