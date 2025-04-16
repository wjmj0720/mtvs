/*
# 문법 설명
`while`문은 조건에 따라 반복을 수행하며, 조건이 거짓일 때 실행을 멈춘다. 
`do-while`문은 조건을 나중에 검사하므로 반복을 최소 한 번은 실행한다.
*/

// 스토리: 놀이공원의 입장 조건 확인
// 고객의 나이에 따라 놀이공원에 입장할 수 있는지 확인하고, 입장 가능할 때까지 반복적으로 입력을 받는다.

/*
# 실습 코드
*/

/*
# 1. 기본 사용: while문으로 조건 확인
입장 조건을 만족하지 못하면 반복적으로 나이를 확인한다.
*/
let age = 15; // 초기 나이
let entranceMessage = "";

while (age < 18) {
    entranceMessage = `현재 나이 ${age}세: 입장 불가. 18세 이상만 입장 가능합니다.`;
    console.log(entranceMessage);
    age += 1; // 나이 증가 (가정)
}

entranceMessage = `현재 나이 ${age}세: 입장 가능합니다. 환영합니다!`;
console.log(entranceMessage);

/*
결과 설명
- 조건(`age < 18`)을 만족하는 동안 메시지를 출력.
- 조건이 거짓이 되면 반복을 종료하고 최종 메시지를 출력.
*/

/*
# 2. do-while문: 최소 한 번 실행
입장 시 나이를 확인하며, 조건에 따라 반복적으로 나이를 입력받는다.
*/
let isEligible = false;
do {
    let enteredAge = 16; // 가정된 입력값
    if (enteredAge >= 18) {
        isEligible = true;
        console.log(`입장 가능합니다. 환영합니다!`);
    } else {
        console.log(`입장 불가: ${enteredAge}세. 18세 이상만 입장 가능합니다.`);
    }
} while (!isEligible);

/*
결과 설명
- 최소 한 번 실행 후 조건을 검사하여 반복 여부 결정.
- 18세 이상일 때 입장 메시지를 출력하고 반복 종료.
*/

/*
# 3. 조건 제어: while문에서 break 사용
특정 조건에서 반복을 강제로 종료한다.
*/
let ticketCount = 0; // 초기 티켓 수
let maxTickets = 5;

while (true) {
    ticketCount++;
    console.log(`티켓 발급: 현재 발급된 티켓 수는 ${ticketCount}장입니다.`);
    if (ticketCount === maxTickets) {
        console.log("최대 티켓 수에 도달했습니다. 발급을 종료합니다.");
        break; // 반복 종료
    }
}

/*
결과 설명
- 반복을 강제로 종료하여 불필요한 실행을 방지.
- 최대 티켓 수에 도달하면 반복 종료 메시지 출력.
*/

/*
# 4. 조건 건너뛰기: while문에서 continue 사용
특정 조건에서는 현재 반복을 건너뛴다.
*/
let ticketNumbers = [1, 2, 3, 4, 5]; // 티켓 번호 배열
let skippedNumber = 3;

let i = 0;
while (i < ticketNumbers.length) {
    if (ticketNumbers[i] === skippedNumber) {
        console.log(`티켓 번호 ${skippedNumber} 건너뜀.`);
        i++;
        continue; // 현재 반복 건너뜀
    }
    console.log(`티켓 번호 ${ticketNumbers[i]} 처리 중.`);
    i++;
}

/*
결과 설명
- `continue`로 특정 조건을 건너뛰고 다음 반복으로 이동.
- 지정된 티켓 번호를 건너뛰며 처리.
*/

/*
# 5. 중첩된 조건 확인: while문 중첩 사용
놀이공원의 각 구역별 입장 조건을 확인한다.
*/
let parkSections = ["놀이기구", "수영장", "키즈존"];
let visitorAges = [16, 18, 12];
let j = 0;

while (j < parkSections.length) {
    let k = 0;
    while (k < visitorAges.length) {
        if (visitorAges[k] >= 18) {
            console.log(`구역 ${parkSections[j]}: ${visitorAges[k]}세 입장 가능.`);
        } else {
            console.log(`구역 ${parkSections[j]}: ${visitorAges[k]}세 입장 불가.`);
        }
        k++;
    }
    j++;
}

/*
결과 설명
- 중첩된 while문으로 각 구역별로 방문객의 입장 조건을 확인.
- 각 구역과 방문객 연령별로 입장 가능 여부를 출력.
*/

/*
결론:
1. `while`문은 조건에 따라 반복을 수행하며, 조건이 거짓일 때 종료한다.
2. `do-while`문은 조건 검사 전에 최소 한 번 실행한다.
3. 반복문 제어(`break`, `continue`)를 사용해 반복 흐름을 제어할 수 있다.
4. 다양한 조건과 시나리오를 연습하며 반복문 사용에 익숙해질 수 있다.
*/