## 6주차 : 우선순위 큐 [𝑄](https://www.acmicpc.net/workbook/view/9502) & 연결 리스트 [🍪](https://www.acmicpc.net/workbook/view/7308)
### 문제 목록
#### 1158번 요세푸스 문제
- 원소의 삭제가 매 턴마다 계속해서 일어나기 때문에 연결 리스트를 자료구조로 선택
- 삭제할 `index` 위치를 잘 계산하는 것이 관건인 문제이다.
```
int index = (index + K - 1) % size;
```
- 하나씩 삭제되면서 전체 리스트의 사이즈는 계속 변화하지만, K번째 원소를 삭제한다는 규칙은 유효하다.
- 따라서 내부 값이 아닌, 인덱스의 변화에 중점을 맞춰서 이해하자.
- 이번 턴에 0번 인덱스였다면 그 다음은 0+K, 그 다음은 0+K+K.. 리스트 사이즈를 넘어가면 모듈러 연산을 통해 처리
#### 1406번 에디터
- 일반적인 순회로 문제를 풀이할 경우 시간초과가 난다. 스택을 사용하든지, `Iterator`를 사용해서 풀이한다.
- `ListIterator`를 사용하여 커서의 앞 뒤 이동을 효율적으로 하도록 구현
#### 5397번 키로거
- 에디터와 비슷한 결의 문제로 이번에는 스택을 이용해 풀이했다.
- 스택을 2개 만들어서 커서를 기준으로 왼쪽에 있는 문자는 왼쪽 스택, 나머지는 오른쪽 스택에 넣고, 조건에 맞춰서
스택을 왔다갔다 하면서 옮겨준다.
#### 1927번 최소 힙
- 우선순위 큐와 조건문을 적절히 활용하여 풀이
#### 11279번 최대 힙
- 최소 힙 문제와 비슷하나, 이번에는 힙 안에서 가장 큰 수를 출력해야 하기 때문에 `Comparator`를 오버라이딩해서 사용했다.
#### 2075번 N번째 큰 수
- 역시 우선순위 큐와 `Comparator`를 사용한다.
- 주어진 모든 수를 담은 다음 N-1 번 만큼 큐를 비우고, N번째 값을 출력한다.