/*
# 조건문과 switch 문 활용
학교 시스템에서 학생의 성적에 따라 평가를 부여한다. 
다양한 조건문을 사용해 프로그램의 동작을 체계적으로 이해한다.
*/

// 1. 기본 조건문: 학생 점수에 따른 합격/불합격 판단
let studentName = "김철수";
let studentScore = 85;

if (studentScore >= 60) {
    console.log(`${studentName}은(는) 합격입니다.`); // 출력: 김철수은(는) 합격입니다.
} else {
    console.log(`${studentName}은(는) 불합격입니다.`);
}

/*
설명:
- 조건 `studentScore >= 60`이 참이면 첫 번째 블록이 실행된다.
- 조건이 거짓이면 `else` 블록이 실행된다.
*/

// 2. `else if`를 활용한 다중 조건 처리: 학생의 점수에 따라 등급 부여
if (studentScore >= 90) {
    console.log(`${studentName}의 등급: A`); // 출력: 김철수의 등급: A
} else if (studentScore >= 80) {
    console.log(`${studentName}의 등급: B`);
} else if (studentScore >= 70) {
    console.log(`${studentName}의 등급: C`);
} else {
    console.log(`${studentName}의 등급: F`);
}


/*
설명:
- 조건을 순차적으로 평가하여 첫 번째로 참인 블록을 실행한다.
- 모든 조건이 거짓이면 마지막 `else` 블록이 실행된다.
*/



/*
# 확장된 조건문
스토리: 학생의 출석률을 추가로 확인하여 최종 합격 여부를 결정한다.
1. 점수 70점 이상 + 출석률 80% 이상: 최종 합격
2. 점수 70점 이상 + 출석률 80% 미만: 보류
3. 점수 70점 미만: 최종 불합격
*/

let studentName1 = "김철수";
let attendanceRate = 75;

if (studentScore >= 70 && attendanceRate >= 80) {
    console.log(`${studentName} - 점수: ${studentScore}, 출석률: ${attendanceRate}% - 최종 합격`);
} else if (studentScore >= 70 && attendanceRate < 80) {
    console.log(`${studentName} - 점수: ${studentScore}, 출석률: ${attendanceRate}% - 보류`);
} else {
    console.log(`${studentName} - 점수: ${studentScore}, 출석률: ${attendanceRate}% - 최종 불합격`);
}


/*
# 조건문 내 다중 분기
스토리: 간단한 계산기를 만들어 입력된 연산자에 따라 결과를 출력한다.
- 연산자는 +, -, *, / 중 하나이다.
*/

let num1 = 10;
let num2 = 5;
let operator = "+";

if (operator === "+") {
    console.log(`결과: ${num1} + ${num2} = ${num1 + num2}`);
} else if (operator === "-") {
    console.log(`결과: ${num1} - ${num2} = ${num1 - num2}`);
} else if (operator === "*") {
    console.log(`결과: ${num1} * ${num2} = ${num1 * num2}`);
} else if (operator === "/") {
    console.log(`결과: ${num1} / ${num2} = ${num1 / num2}`);
} else {
    console.log("잘못된 연산자입니다.");
}


/*
# 조건문과 중첩 분기
스토리: 학생의 성적과 특별 활동 여부를 함께 고려하여 상장을 수여한다.
1. 점수 90점 이상 + 특별 활동: 금상
2. 점수 90점 이상: 은상
3. 점수 80점 이상: 동상
4. 그 외: 상장 없음
*/

let hasSpecialActivity = true;

if (studentScore >= 90) {
    if (hasSpecialActivity) {
        console.log(`${studentName}은(는) 금상을 수여받습니다.`);
    } else {
        console.log(`${studentName}은(는) 은상을 수여받습니다.`);
    }
} else if (studentScore >= 80) {
    console.log(`${studentName}은(는) 동상을 수여받습니다.`);
} else {
    console.log(`${studentName}은(는) 상장을 수여받지 않습니다.`);
}