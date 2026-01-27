# 이진탐색 (Binary Search)

## 주요 사항
* 중간 인덱스를 계산할 때 `(left + right) / 2` 대신 `left + (right - left) / 2`를 사용하는 것이 좋다. (left + right 값이 정수(int) 범위를 초과하여 발생하는 오버플로우 문제를 방지 할 수 있다) 

* 정렬된 배열이 필수이다. 