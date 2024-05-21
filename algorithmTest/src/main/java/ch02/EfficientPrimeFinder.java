package ch02;

public class EfficientPrimeFinder {
    public static void main(String[] args){
        int divisionCount = 0;
        int primeCount = 0;
        int[] primes = new int[500];

        primes[primeCount++] = 2;

        for(int candidate = 3; candidate <= 1000; candidate += 2){
            int i;
            for(i = 1; i < primeCount; i++){
                divisionCount++;
                if(candidate % primes[i] == 0){
                    break;
                }
            }
            if (primeCount == i){
                primes[primeCount++] = candidate;
            }
        }

        for (int i = 0; i< primeCount; i++){
            System.out.println(primes[i]);
        }
        System.out.println("나눗셈 연산을 수행한 횟수: " + divisionCount);
    }
}
