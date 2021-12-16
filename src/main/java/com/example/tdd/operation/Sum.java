package com.example.tdd.operation;

public class Sum {

    public static void main(String[] arge) {
        String text = "123,4123,113:413";
        String[] values = text.split(",|:");
        int[] numbers = toInts(values);
        int total = sum(numbers);

        System.out.println(sum(toInts(text.split(",|:"))));
    }

    // 메소드 분리
    // 현재 두 가지 일을 하고있음
    // 문자열 -> 숫자로 변환, 합을 계산
    public static int sum(String[] values) {
        int result = 0;
        for (String value : values) {
            result += Integer.parseInt(value);
        }
        return result;
    }

    public static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = toInt(values[i]); // 메소드 분리
        }
        return numbers;
    }

    public static int toInt(String value) { // 이 부분이 모든 원시값과 문자열이다.
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }

    public static int sum(int[] numbers) {
        int result = 0;
        for (int value : numbers) {
            result += value;
        }
        return result;
    }

    // compose method 패턴
    // 패턴 적용 메소드의 의도가 잘 드러나도록 동등한 수준의 작업을 하는 여러 단계로 나눈다.
    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) { // 추상화 단계 0
            return 0;
        }
        return sum(toInts(text.split(",|:"))); // 추상화 단계 1
    }

    public static int splitAndSum2(String text) {
        if (isBlank(text)) {
            return 0;
        }
        return sum(toInts(text.split(",|:")));
    }

    public static boolean isBlank(String text) {
        return (text == null || text.isEmpty());
    }
}