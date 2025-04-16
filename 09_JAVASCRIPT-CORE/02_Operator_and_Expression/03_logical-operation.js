/*
이해를 돕는 스토리: 쇼핑몰 예제
쇼핑몰에서 다음과 같은 논리 연산이 필요하다:
1. 사용자가 로그인했고, 충분한 잔액이 있어야 상품을 구매할 수 있다.
2. 쿠폰이 있다면 잔액이 부족해도 구매가 가능하다.
3. 비회원은 쇼핑몰에 접근할 수 없다.
*/

// 사용자 데이터
let isLoggedIn = true; // 사용자 로그인 여부
let hasBalance = 50; // 사용자 잔액
let itemPrice = 40; // 상품 가격

// AND 연산자: 구매 조건
if (isLoggedIn && hasBalance >= itemPrice) {
    console.log("구매가 가능합니다."); // 출력
} else {
    console.log("구매 조건을 충족하지 못했습니다.");
}

// OR 연산자: 쿠폰으로 구매 가능 여부
let hasCoupon = false;
if (isLoggedIn && (hasBalance >= itemPrice || hasCoupon)) {
    console.log("쿠폰 또는 잔액으로 구매 가능합니다.");
} else {
    console.log("쿠폰과 잔액 모두 부족합니다."); // 출력
}

// NOT 연산자: 비회원 접근 제한
if (!isLoggedIn) {
    console.log("로그인이 필요합니다.");
} else {
    console.log("쇼핑몰에 오신 것을 환영합니다."); // 출력
}

// 단축 평가: 기본값 설정
let userName = null;
let displayName = userName || "Guest";
console.log("환영합니다, " + displayName); // 출력: 환영합니다, Guest

// Nullish Coalescing 연산자
let specialOffer = null;
let offerText = specialOffer ?? "오늘의 특별 혜택은 없습니다.";
console.log(offerText); // 출력: 오늘의 특별 혜택은 없습니다.