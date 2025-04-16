/*
# 비교 연산자의 이해: 스토리와 실습
스토리: 학생들의 시험 점수를 확인하고, 합격 여부를 판단하는 프로그램을 작성한다.
*/

// 학생 점수 데이터
let studentScore = "85"; // 점수는 문자열로 저장됨

// 동등성 비교
if (studentScore == 85) {
    console.log("점수가 일치합니다. 합격 조건을 충족했습니다."); // 출력
} else {
    console.log("점수가 일치하지 않습니다.");
}

// 일치성 비교
if (studentScore === 85) {
    console.log("점수와 타입이 모두 일치합니다.");
} else {
    console.log("점수는 일치하지만 타입이 다릅니다."); // 출력
}

// 부등 연산자
if (studentScore != 90) {
    console.log("점수가 90이 아닙니다."); // 출력
}

// 불일치 연산자
if (studentScore !== 90) {
    console.log("점수와 타입 모두 90이 아닙니다."); // 출력
}

// 크기 비교 연산자
if (studentScore > 70) {
    console.log("학생 점수가 70보다 높습니다. 합격입니다."); // 출력
} else {
    console.log("점수가 낮아 불합격입니다.");
}

// 사전순 비교
let word1 = "apple";
let word2 = "banana";

if (word1 < word2) {
    console.log(word1 + "이(가) " + word2 + "보다 앞에 있습니다."); // 출력: apple이(가) banana보다 앞에 있습니다.
}