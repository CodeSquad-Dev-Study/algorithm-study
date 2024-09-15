## 1주차 : 그리디 [🔗](https://www.acmicpc.net/workbook/view/7320)
### 문제 목록
#### 11047번 동전
- 해당 문제는 어떤 가치를 만들기 위한 최소 동전의 개수를 구하는 문제이므로,
사용할 수 있는 동전 중에서 가장 가치가 큰 동전을 우선적으로 사용하여 문제를 해결했다.
#### 1541번 잃어버린 괄호
- 문제를 풀 때 최적의 알고리즘이 뭔지 모르는 상태에서 시작한다고 가정하고 완전탐색 방법을 생각해보았다.
&rarr; 비슷한 문제로 16637번 괄호 추가하기 문제가 있어서 학습
#### 11501번 주식
- 맨 처음에서부터 반복하면서 최대 가격을 구하고 최대 가격을 만나면 판매한 후, 다시 최대 가격을 갱신하는 방법으로 구현한 첫 번째 풀이 시간 초과 
  - 최대 가격을 갱신하는 부분에서 다시 순회하면서 구하기 때문에 O(n^2) -> 최대 1,000,000일까지 가능하기 때문에 1,000,000,000,000이 된다..; 5초안에 어림도 없다
- 뒤에서부터 접근하는 방법으로 풀이방법 변경
  - 앞에서부터 접근하면 최대 가격을 만날 때 마다 다시 뒤의 최대 가격을 확인해야 하는데, 뒤에서부터 접근하면 이미 최대 가격을 알고 있고, 자기 자신보다 작은 값이 나오면 팔면 되기 때문에
  추가적인 계산이 필요 없다!
#### 1744번 수 묶기
- 양수 / 음수와 0 으로 배열을 분리한 후, 1이 아닌 양수는 큰 수부터 곱하고 남은 수를 더해주었다. 만일 1이 포함된 경우에는 무조건 더해주도록 했다.
- 음수 배열은 가장 작은 수부터 시작해서 두 개씩 곱해준 후 남은 수는 더해주었다. 배열의 수가 홀수일 경우에만 마지막 숫자는 더해주도록 했다.
- 음수 배열에 0이 포함되어 있긴 한데, 따로 처리해주지 않아도 기존 로직대로 처리하면 0과 상관없이 가장 큰 값을 구할 수 있다.
  - 0이 포함되는 경우 배열의 size-1 자리에 오기 때문에 홀수일 경우 더해주든, 짝수일 경우 앞의 숫자와 곱해주든 결국 0이기 때문에 상관없음!
- 이번에는 배열을 두개로 나눠서 했는데, 다음번에는 우선순위큐를 이용하여 구현해보고 싶다.
#### 2847번 게임을 만든 동준이
- 주어진 숫자 중에서 가장 마지막 숫자가 최대 점수가 되어야 하므로 뒤에서부터 순회하면서 이전 레벨의 점수가 현재 점수보다 -1이 되도록 조정했다.
#### 11000번 강의실 배정
- 주어진 강의를 모두 진행하기 위해서 강의실이 몇 개 필요한지 계산하는 문제
  - 하나의 회의실에 최대한 많은 회의를 진행하는 경우의 수를 구하는 회의실 배정 문제와는 다른 맥락이다. 강의는 모두 진행되어야 한다.
1. 모든 강의를 진행해야 하므로, 시간의 흐름대로 강의 시작 순서 오름차순으로 정렬한다.
2. 그와 동시에 종료 시간과의 비교가 필요하다. 따라서 종료 시간을 따로 관리해야 한다 이 때, 우선순위큐를 사용하자
3. 강의를 순차대로 순회한다. 해당 강의의 시작 시간과, 우선순위큐의 종료 시간을 비교해서 강의실을 더 잡아야 하는지 기존 강의실을 사용할 수 있는지를 판단한다.
   - 현재 강의의 시작 시간이 우선순위큐에 저장된 가장 빠른 종료 시간보다 이전이라면 새롭게 우선순위큐에 현재 강의의 종료시간을 저장한다.
4. 최종적으로 모든 강의를 확인하고 난 후, 우선순위큐에 저장된 종료 시간의 개수를 return한다.
- 생각해보니 전체 강의를 저장하는 자료구조도 우선순위큐를 사용해도 될 듯해서 우선순위큐 2개를 사용했다.
#### 1439번 뒤집기
- 더 적게 나타나는 문자열 그룹을 뒤집는 것이 가장 적은 방법만 사용해서 문자열을 통일할 수 있기 때문에 각각 구해준 후 min 값을 구한다.