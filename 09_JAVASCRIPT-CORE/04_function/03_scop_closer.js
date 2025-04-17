/*
# 문법 설명
1. 함수 스코프는 `function`으로 선언된 변수와 함수에 적용되며, 함수 외부에서는 접근할 수 없다.
2. 블록 스코프는 `let`과 `const`로 선언된 변수에 적용되며, 블록 외부에서는 접근할 수 없다.
3. 클로저는 함수가 선언된 환경을 기억하며, 이를 통해 외부 변수에 접근 가능하다.
*/


/*
스토리
한 마을에 마법사가 있다. 이 마법사는 마법 주문을 외우면 마법 에너지가 점점 쌓인다. 하지만 마법사가 외운 주문은 본인만 기억한다. 이 상황을 코드로 구현하며 클로저의 작동 방식을 학습한다.
*/

// 1. 마법 에너지를 증가시키는 함수
function createWizard() {
    let magicEnergy = 0; // 마법사의 에너지 상태 (외부에서 접근 불가)

    return function castSpell() {
        magicEnergy++; // 주문을 외울 때마다 에너지 증가
        console.log(`현재 마법 에너지: ${magicEnergy}`);
    };
}

const wizard = createWizard();
wizard(); // 현재 마법 에너지: 1
wizard(); // 현재 마법 에너지: 2
wizard(); // 현재 마법 에너지: 3

/*
결과 설명
- createWizard 함수는 magicEnergy 변수를 클로저로 캡처하여, 
castSpell 함수에서 마법 에너지를 유지 및 수정할 수 있다.
- magicEnergy는 외부에서 직접 접근할 수 없으며, 안전하게 보호된다.
*/



// 여러 마법사 생성
function createWizard(name) {
    let magicEnergy = 0; // 각 마법사의 에너지 상태

    return function castSpell() {
        magicEnergy++;
        console.log(`${name}님의 현재 마법 에너지: ${magicEnergy}`);
    };
}

const wizardA = createWizard("엘리자");
const wizardB = createWizard("레온");

wizardA(); // 엘리자님의 현재 마법 에너지: 1
wizardB(); // 레온님의 현재 마법 에너지: 1
wizardA(); // 엘리자님의 현재 마법 에너지: 2
wizardB(); // 레온님의 현재 마법 에너지: 2

/*
결과 설명
- createWizard 함수는 각각 독립적인 magicEnergy 변수를 유지하며,
여러 마법사가 동시에 관리될 수 있다.
- 각 마법사는 자신의 주문 에너지를 기억하며, 
다른 마법사의 상태에 영향을 받지 않는다.
*/




// 마법사의 주문 리스트
function createWizardWithSpells(name) {
    let magicEnergy = 0;
    let spells = []; // 마법사가 외운 주문 목록

    return {
        castSpell: function (spell) {
            magicEnergy++;
            spells.push(spell);
            console.log(`${name}님이 "${spell}" 주문을 외웠습니다.`);
            console.log(`현재 마법 에너지: ${magicEnergy}`);
        },
        showSpells: function () {
            console.log(`${name}님의 주문 목록: ${spells.join(", ")}`);
        }
    };
}

const wizardC = createWizardWithSpells("아르테미스");

wizardC.castSpell("파이어볼"); // 아르테미스님이 "파이어볼" 주문을 외웠습니다.
wizardC.castSpell("아이스 스톰"); // 아르테미스님이 "아이스 스톰" 주문을 외웠습니다.
wizardC.showSpells(); // 아르테미스님의 주문 목록: 파이어볼, 아이스 스톰

/*
결과 설명
createWizardWithSpells 함수는 마법 에너지와 주문 리스트를 클로저로 캡처하며,
마법사가 외운 주문을 안전하게 관리한다.
castSpell 함수는 주문을 외우고 에너지를 증가시키며, 
showSpells 함수는 주문 목록을 출력한다.
*/




// 마법사의 마법 초기화
function createWizardWithReset(name) {
    let magicEnergy = 0;

    return {
        castSpell: function () {
            magicEnergy++;
            console.log(`${name}님의 현재 마법 에너지: ${magicEnergy}`);
        },
        resetEnergy: function () {
            magicEnergy = 0;
            console.log(`${name}님의 마법 에너지가 초기화되었습니다.`);
        }
    };
}

const wizardD = createWizardWithReset("제논");

wizardD.castSpell(); // 제논님의 현재 마법 에너지: 1
wizardD.castSpell(); // 제논님의 현재 마법 에너지: 2
wizardD.resetEnergy(); // 제논님의 마법 에너지가 초기화되었습니다.
wizardD.castSpell(); // 제논님의 현재 마법 에너지: 1


/*
name 변수의 관리 방식
`name` 변수는 외부 함수인 `createWizardWithReset`의 매개변수로 전달되며, 
클로저를 통해 내부 함수에서도 접근 가능하다. 
이는 클로저가 외부 함수의 렉시컬 환경(변수와 매개변수)을 기억하기 때문이다.

- 동작 방식
1. **`createWizardWithReset` 함수 호출**: 함수가 호출될 때, 전달된 매개변수 `name`은 `createWizardWithReset` 함수의 실행 컨텍스트에 저장된다.
2. **클로저 생성**: 반환된 객체의 메서드(`castSpell`, `resetEnergy`)는 `createWizardWithReset` 함수의 실행이 끝난 후에도 `name` 변수에 접근할 수 있다.
3. **렉시컬 환경 유지**: 클로저는 `name` 변수를 포함한 외부 함수의 렉시컬 환경을 캡처하고, 내부 함수가 호출될 때마다 이를 참조한다.
*/

/*
결론
1. 스코프는 변수의 유효 범위를 정의하며, 
클로저는 함수와 렉시컬 환경을 기억해 상태를 유지한다.
2. 클로저를 사용하면 데이터를 안전하게 보호하며, 
외부 함수의 변수를 지속적으로 참조할 수 있다.
3. 클로저는 상태 유지, 데이터 은닉, 독립적인 
객체 생성 등에 유용하게 활용된다.
*/