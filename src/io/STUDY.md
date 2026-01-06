## 코딩 테스트 대비 IO 핵심

- 속도 
    
    Scanner보다는 무조건 BufferedReader를 쓰자. (데이터가 많아지면 시간 초과 방지의 핵심)

- 문자열 분리

    split(" ")은 느리다. StringTokenizer가 훨씬 효율적이다.

- 예외 처리:

    main 메서드 옆에 throws IOException을 적는 것을 절대 잊지 말자.

- 출력 최적화:

    System.out.println()을 반복문 안에서 수만 번 호출하면 속도가 느려진다. StringBuilder에 담아 마지막에 한 번만 호출하자. 자바 공식 문서에서도 대량의 문자열 조작 시 이를 권장한다.