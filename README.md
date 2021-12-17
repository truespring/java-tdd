# java-tdd

OOP적인 코드 작업을 위한 Java tdd 연습

## 원칙

### 순수 Java

코드는 순수 Java 만으로 작성한다. Java 만으로 코드를 작성하며 객체지향적으로 작성할 수 있도록 노력한다.

### else 예약어

if 문을 사용하되 else 예약어는 사용하지 않는다. if 문 안에서 해결하고 넘기도록 노력한다.

### 들여쓰기

한 메소드에서는 한 번의 들여쓰기만 허용한다. 

```java
public void positiveAdd(int a, int b) {
  if (a > 0) {
    if (b > 0) {
      ...
    }
  }
}
```

이런 식의 if 안에 if 는 사용해서는 안된다.

### 축약어

용도와 의도를 파악하기위해 축약어를 사용하지 않는다.

```java
public void calcAllNum(int number1, int number2) {
  ...
}

public void calculateAllNumber(int positive, int negative) {
  ...
}
```

축약을 하게되면 의도와 용도를 파악하기 힘들다.(자신의 기억력을 믿지말고, 남들의 추리력을 시험하지 말라)

### 메소드 역할

하나의 메소드는 하나의 역할만 해야한다. 두 가지의 일을 동시에 처리하면 메소드의 역할이 모호해지고 응집도가 낮아진다.

## TDD와 리팩토링

### TDD 연습

- 참고 포스팅 [solar님의 의식적인 연습으로 TDD 리팩토링 연습하기 포스팅](https://velog.io/@solar/자바지기-의식적인-연습으로-TDD-리팩토링-연습하기)

### Lotto 번호 생성

- 과거의 당첨내역을 바탕으로 번호를 생성하는 것이 아닌 1~45번 중 무작위로 6개의 번호를 추출하는 방식 적용
- 코드를 작성하며 TDD로 작성한 코드가 제대로 동작하는지 확인(진행 예정)
- 코드 작성 완료 후 리팩토링(진행 예정)
