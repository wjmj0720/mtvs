/*
# 2. switch문과 조건 분기
switch문은 여러 조건 분기를 처리하는 데 간결하고 가독성을 제공한다. 
if-else 문과 달리 값 비교를 중심으로 코드를 간결하게 작성할 수 있다.

# 스토리: 음식점 주문 관리 시스템
1. 손님이 음식 주문 번호를 전달하면 요리를 출력한다.
2. 추가 요청 사항이 있다면 처리한다.
3. 번호에 없는 메뉴일 경우 오류 메시지를 출력한다.
*/

/*
# 1. 기본 구조: if-else로 처리
주문 번호에 따라 음식을 제공한다.
*/
let orderNumber = 3; // 주문 번호
let dish = "";

if (orderNumber === 1) {
    dish = "비빔밥";
} else if (orderNumber === 2) {
    dish = "된장찌개";
} else if (orderNumber === 3) {
    dish = "삼겹살";
} else if (orderNumber === 4) {
    dish = "치킨";
} else {
    dish = "메뉴가 없습니다.";
}

console.log(`주문하신 음식: ${dish}`);

/*
문제점:
1. 조건이 많아질수록 코드가 길고 복잡해짐.
2. 명확한 값 비교 상황에서 switch문을 사용하는 것이 적합.
*/

/*
# 2. switch문으로 처리
switch문을 활용하여 주문 번호에 따른 요리를 출력한다.
*/
switch (orderNumber) {
    case 1:
        dish = "비빔밥";
        break;
    case 2:
        dish = "된장찌개";
        break;
    case 3:
        dish = "삼겹살";
        break;
    case 4:
        dish = "치킨";
        break;
    default:
        dish = "메뉴가 없습니다.";
}

console.log(`주문하신 음식: ${dish}`);

/*
# 3. 추가 요청 사항 처리
음식에 추가 요청 사항이 있을 경우 switch문으로 처리.
*/
let request = "매운맛"; // 추가 요청 사항
let additionalRequest = "";

switch (request) {
    case "매운맛":
        additionalRequest = "매운맛으로 조리합니다.";
        break;
    case "덜 짜게":
        additionalRequest = "덜 짜게 조리합니다.";
        break;
    case "고추 추가":
        additionalRequest = "고추를 추가합니다.";
        break;
    default:
        additionalRequest = "추가 요청이 없습니다.";
}

console.log(`추가 요청 사항: ${additionalRequest}`);

/*
# 4. 여러 주문 처리
여러 주문 번호를 각각 처리하여 음식을 출력한다.
*/
let orderNumber1 = 1;
let orderNumber2 = 2;
let orderNumber3 = 5; // 존재하지 않는 메뉴
let dish1 = "";
let dish2 = "";
let dish3 = "";

switch (orderNumber1) {
    case 1:
        dish1 = "비빔밥";
        break;
    case 2:
        dish1 = "된장찌개";
        break;
    case 3:
        dish1 = "삼겹살";
        break;
    case 4:
        dish1 = "치킨";
        break;
    default:
        dish1 = "메뉴가 없습니다.";
}

switch (orderNumber2) {
    case 1:
        dish2 = "비빔밥";
        break;
    case 2:
        dish2 = "된장찌개";
        break;
    case 3:
        dish2 = "삼겹살";
        break;
    case 4:
        dish2 = "치킨";
        break;
    default:
        dish2 = "메뉴가 없습니다.";
}

switch (orderNumber3) {
    case 1:
        dish3 = "비빔밥";
        break;
    case 2:
        dish3 = "된장찌개";
        break;
    case 3:
        dish3 = "삼겹살";
        break;
    case 4:
        dish3 = "치킨";
        break;
    default:
        dish3 = "메뉴가 없습니다.";
}

console.log(`주문 1: ${dish1}`);
console.log(`주문 2: ${dish2}`);
console.log(`주문 3: ${dish3}`);

/*
결론:
1. switch문은 값 비교 기반의 조건 분기를 간결하게 처리.
2. 반복문 없이도 각 조건을 개별적으로 처리 가능.
*/