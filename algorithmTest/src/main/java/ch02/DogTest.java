package ch02;

public class DogTest {
    public static void main(String[] args){
        Dog myDog;

        myDog = new Dog(); // 인스턴스화

        myDog.breed = "Labrador";
        myDog.age = 5;
        myDog.color = "Brown";
        myDog.bark();
        myDog.displayInfo();

        Dog myDog2 = new Dog("푸들", "갈색");
        myDog.age = 8;

        myDog2.displayInfo();
    }
}
