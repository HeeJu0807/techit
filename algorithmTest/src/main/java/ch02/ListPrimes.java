package ch02;

public class ListPrimes {
    public static void main(String[] args){
        int divisionCount = 0;

        for(int num = 2; num <= 1000; num++){
            boolean isPrime = true;
            for(int divisor = 2; divisor < num; divisor++){
                divisionCount++;
                if(num%divisor == 0){
                    isPrime = false;
                    break;
                }
            }
            if (isPrime){
                System.out.println(num);
            }
        }

        System.out.println("나눗셈 연산을 수행한 횟수: " + divisionCount);
    }
}
