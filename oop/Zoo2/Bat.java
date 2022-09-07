public class Bat extends Mammal {
    public int energy = 300;

    public void fly() {
        energy -= 50;
        System.out.println("weeeeeeeeee\n" + "Energy Level: " + energy);
    }

    public void eatHuman() {
        energy += 25;
        System.out.println("Nom Nom\n" + "Energy Level: " + energy);
    }

    public void attackTown() {
        energy -= 100;
        System.out.println("Die human! Die!!!\n" + "Energy Level: " + energy);
    }
}