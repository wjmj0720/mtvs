/*
산술 연산자
산술 연산자는 숫자 데이터를 다룰 때 사용된다
*/

/*
# 산술 연산자: 마을의 금고 관리 이야기
산술 연산자를 사용해 마을 금고의 재정을 관리한다. 
금고의 초기 금화 수와 다양한 재정 상황을 산술 연산으로 해결해 본다.
*/

// 1. 금고 초기화: 금고에 처음 들어 있는 금화는 100개이다.
let goldCoins = 100;
console.log("초기 금화 수:", goldCoins); // 출력: 100

// 2. 덧셈 연산: 마을 사람들이 세금을 내서 금화 30개가 추가되었다.
goldCoins = goldCoins + 30;
console.log("세금 수집 후 금화 수:", goldCoins); // 출력: 130

// 3. 뺄셈 연산: 마을 도로를 수리하는 데 금화 50개를 사용했다.
goldCoins = goldCoins - 50;
console.log("도로 수리 후 금화 수:", goldCoins); // 출력: 80

// 4. 곱셈 연산: 마을 상인이 거래를 통해 금화 2배를 벌어들였다.
goldCoins = goldCoins * 2;
console.log("거래 후 금화 수:", goldCoins); // 출력: 160

// 5. 나눗셈 연산: 금화 절반을 은행에 예치했다.
goldCoins = goldCoins / 2;
console.log("은행 예치 후 금화 수:", goldCoins); // 출력: 80

// 6. 나머지 연산: 금화 7개씩 주민들에게 나눠주고 남은 금화는?
let remainingCoins = goldCoins % 7;
console.log("주민들에게 나눠준 후 남은 금화:", remainingCoins); // 출력: 3

// 7. 증가 연산: 마을 축제에서 금화 1개씩 추가로 기부받았다.
goldCoins++;
console.log("축제 후 금화 수:", goldCoins); // 출력: 81

// 8. 감소 연산: 금화 1개를 부주의로 분실했다.
goldCoins--;
console.log("분실 후 금화 수:", goldCoins); // 출력: 80

// 9. 복합 대입 연산: 상점에서 물건을 판매해 금화 20개를 더 벌었다.
goldCoins += 20; // goldCoins = goldCoins + 20;
console.log("물건 판매 후 금화 수:", goldCoins); // 출력: 100

// 10. 복합 대입 연산: 금화의 일부를 투자해 3배의 수익을 올렸다.
goldCoins *= 3; // goldCoins = goldCoins * 3;
console.log("투자 후 금화 수:", goldCoins); // 출력: 300