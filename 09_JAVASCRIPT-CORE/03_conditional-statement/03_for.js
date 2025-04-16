/*
# 문법 설명
for문은 초기화, 조건 검사, 증감 연산을 한 번에 처리할 수 있어 반복 횟수를 제어하기 쉽다. 
조건이 거짓이 되는 순간 반복을 종료한다. for문은 주로 배열과 같은 데이터 구조를 순회하거나, 일정 횟수 반복이 필요한 경우 사용한다.
*/

// 스토리: 마트에서 고객 구매 내역 계산
// 고객의 장바구니에 담긴 상품 가격을 순회하며 총합을 계산한다.
// 특정 상품은 제외하거나 할인을 적용하는 등의 조건을 적용한다.

/*
# 실습 코드
*/

/*
# 1. 기본 사용: 장바구니 총합 계산
고객 장바구니에 담긴 상품 가격 배열의 총합을 계산한다.
*/
let cart = [1200, 1500, 3000, 4500, 1000]; // 상품 가격 배열
let total = 0; // 총합 초기화

for (let i = 0; i < cart.length; i++) {
    total += cart[i]; // 각 상품 가격을 합산
}

console.log(`총 가격: ${total}원`);

/*
결과 설명
- for문을 사용해 배열의 모든 요소를 순회하며 총합을 계산.
- 결과: 배열에 담긴 상품 가격의 총합이 출력된다.
*/

/*
# 2. 조건 적용: 할인 상품 제외
특정 조건에 따라 상품 계산을 건너뛴다(1000원 이하 상품 제외).
*/
let selectiveCart = [1200, 1500, 3000, 4500, 800]; // 상품 가격 배열
let selectiveTotal = 0;

for (let i = 0; i < selectiveCart.length; i++) {
    if (selectiveCart[i] <= 1000) {
        continue; // 1000원 이하 상품 건너뜀
    }
    selectiveTotal += selectiveCart[i];
}

console.log(`1000원 초과 상품 총 가격: ${selectiveTotal}원`);

/*
결과 설명
- continue문을 사용해 특정 조건에서 반복문을 건너뜀.
- 결과: 1000원 초과 상품의 합산이 출력된다.
*/

/*
# 3. 중첩 for문: 카테고리별 상품 합산
쇼핑몰의 카테고리별 상품 가격을 계산한다.
*/
let categories = [
    [1200, 1500], // 카테고리 1
    [3000, 4500, 2500], // 카테고리 2
    [4000, 5000] // 카테고리 3
];

let grandTotal = 0;

for (let i = 0; i < categories.length; i++) {
    let categoryTotal = 0;
    for (let j = 0; j < categories[i].length; j++) {
        categoryTotal += categories[i][j]; // 카테고리별 합산
    }
    grandTotal += categoryTotal; // 전체 합산
    console.log(`카테고리 ${i + 1} 총 가격: ${categoryTotal}원`);
}

console.log(`전체 총 가격: ${grandTotal}원`);

/*
결과 설명
- 중첩 for문을 사용해 각 카테고리의 합산과 전체 합계를 계산.
- 결과: 각 카테고리별 합산 및 전체 합계 출력.
*/

/*
# 4. for문을 사용한 문자열 출력
상품 이름 배열의 각 요소를 출력한다.
*/
let items = ["사과", "바나나", "딸기", "오렌지", "포도"];

for (let i = 0; i < items.length; i++) {
    console.log(`상품 ${i + 1}: ${items[i]}`);
}

/*
결과 설명
- 배열의 각 요소를 순서대로 출력.
- 결과: 상품 이름이 번호와 함께 출력된다.
*/

/*
# 5. for문 제어: 특정 상품 발견 시 종료
특정 상품을 발견하면 계산을 중단한다.
*/
let searchCart = [1200, 1500, 3000, 4500, 5000];
let searchTotal = 0;

for (let i = 0; i < searchCart.length; i++) {
    if (searchCart[i] === 3000) {
        console.log("3000원 상품 발견! 계산 중단.");
        break; // 반복문 종료
    }
    searchTotal += searchCart[i];
}

console.log(`계산된 총 가격: ${searchTotal}원`);

/*
결과 설명
- break문을 사용해 특정 조건에서 반복문을 종료.
- 결과: 3000원 상품 발견 후 합산을 중단.
*/

/*
결론:
1. for문은 반복 횟수가 명확한 경우 적합하며, 초기화, 조건 검사, 증감을 한 곳에서 관리한다.
2. 반복문 제어(`break`, `continue`)를 통해 조건에 따라 반복 흐름을 유연하게 제어할 수 있다.
3. 중첩 for문은 다차원 배열과 같은 복잡한 데이터 구조를 처리하는 데 유용하다.
4. 다양한 사례를 통해 반복문의 응용력을 키울 수 있다.
*/