package ch02;

public class SumOfArrayElements {
    public static void main(String[] args){
        int[] numbers = {5,10,15,20,25};

        for(int i =0; i<numbers.length;i++){
            System.out.println("numbers["+ i+ "] = "+ numbers[i]);
        }

        int total = 0;
        for(int num : numbers){
            total += num;
        }

        System.out.println("모든 요소의 합은 "+total +"입니다.");
    }
}
