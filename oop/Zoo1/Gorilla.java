public class Gorilla extends Mammal {
    
    public void throwSomething() {
        energy -= 5;
        System.out.println("Gorilla has thrown somthing!\n" + "Energy level: " + energy);
    }

    public void eatBanana() {
        energy += 5;
        System.out.println("Gorilla has eaten!\n" + "Energy level: " + energy);
    }

    public void climb() {
        energy -= 10;
        System.out.println("Gorilla just climbed a tree!\n" + "Energy level: " + energy);
    }
}