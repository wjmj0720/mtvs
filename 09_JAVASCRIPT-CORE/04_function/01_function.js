/*
# 문법 설명
1. 함수 선언: 함수를 정의하여 재사용 가능하게 만든다.
2. 매개변수: 함수에 입력값을 전달하며, 필요에 따라 여러 개를 사용할 수 있다.
3. 반환값: 함수의 실행 결과를 반환한다.
*/


// 스토리: 학생 성적 관리 시스템
// 학생 이름과 점수를 입력받아 성적을 계산하고 결과를 반환하는 프로그램.


/*
# 1. 기본 함수 선언 및 호출
학생 이름과 점수를 입력받아 합격 여부를 판단하는 함수 작성.
*/
function checkPass(name, score) {
    if (score >= 60) {
        return `${name}은(는) 합격입니다.`;
    } else {
        return `${name}은(는) 불합격입니다.`;
    }
  }
  
  console.log(checkPass("홍길동", 75)); // 합격
  console.log(checkPass("김철수", 50)); // 불합격
  
  
  /*
  결과 설명
  - 함수 `checkPass`는 이름과 점수를 입력받아 합격 여부를 문자열로 반환.
  - 점수 기준(60점) 이상일 경우 합격, 미만일 경우 불합격.
  */
  
  
  
  /*
  # 2. 매개변수와 반환값
  여러 학생의 점수를 입력받아 평균 점수를 계산하는 함수 작성.
  */
  function calculateAverage(scores) {
    let total = 0;
    for (let i = 0; i < scores.length; i++) {
        total += scores[i];
    }
    return total / scores.length;
  }
  
  let scores = [80, 90, 75, 65, 95];
  console.log(`평균 점수: ${calculateAverage(scores)}`);
  
  /*
  결과 설명
  - 배열로 전달된 점수들의 평균을 계산해 반환.
  - 다양한 데이터셋에 적용 가능.
  */
  
  
  
  
  /*
  # 3. 기본값을 가진 매개변수
  학생의 이름과 점수를 입력받아, 과락 기준을 기본값으로 설정한 함수 작성.
  */
  function isPass(name, score, passMark = 60) {
    if (score >= passMark) {
        return `${name}은(는) 합격입니다.`;
    } else {
        return `${name}은(는) 불합격입니다.`;
    }
  }
  
  console.log(isPass("이영희", 70)); // 기본 기준: 60점
  console.log(isPass("박민수", 50, 50)); // 기준: 50점
  
  /*
  결과 설명
  - 기본값이 설정된 매개변수는 입력값이 없을 경우 기본값을 사용.
  - 커스텀 기준(50점)도 적용 가능.
  */
  
  
  
  
  /*
  # 4. 함수와 조건문 결합
  학생 이름, 점수, 과목명을 입력받아 합격 여부를 반환하는 함수 작성.
  */
  function detailedResult(name, score, subject) {
    if (score >= 90) {
        return `${name}은(는) ${subject}에서 A등급입니다.`;
    } else if (score >= 80) {
        return `${name}은(는) ${subject}에서 B등급입니다.`;
    } else if (score >= 70) {
        return `${name}은(는) ${subject}에서 C등급입니다.`;
    } else {
        return `${name}은(는) ${subject}에서 F등급입니다.`;
    }
  }
  
  console.log(detailedResult("홍길동", 85, "수학"));
  console.log(detailedResult("김철수", 65, "영어"));
  
  /*
  결과 설명
  - 점수 범위에 따라 A~F 등급을 반환.
  - 각 과목별로 개별적인 결과 제공 가능.
  */
  
  
  
  
  /*
  # 5. 함수와 배열 결합
  여러 학생의 이름과 점수를 배열로 입력받아 합격 여부를 반환하는 함수 작성.
  */
  function checkAllStudents(students) {
    for (let i = 0; i < students.length; i++) {
        // 처음 작성한 함수를 호출함.
        let result = checkPass(students[i].name, students[i].score);
        console.log(result);
    }
  }
  
  let studentList = [    { name: "홍길동", score: 75 },    { name: "김철수", score: 50 },    { name: "이영희", score: 85 }];
  
  checkAllStudents(studentList);
  
  /*
  결과 설명
  - 배열 형태의 데이터와 함수를 결합하여 여러 학생의 결과를 처리.
  - 함수 호출을 반복적으로 활용하여 코드 재사용성 극대화.
  */
  
  /*
  결론:
  1. 함수는 코드를 모듈화하고 재사용성을 높인다.
  2. 매개변수와 반환값을 활용해 다양한 입력과 결과를 처리 가능.
  3. 기본값, 배열 등 다른 문법과 결합하여 복잡한 */