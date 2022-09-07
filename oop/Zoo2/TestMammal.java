public class TestMammal {
    public static void main (String[] args) {
        Mammal one = new Mammal();
        one.displayEnergy();

        Bat bat1 = new Bat();
        bat1.attackTown();
        bat1.attackTown();
        bat1.attackTown();
        bat1.eatHuman();
        bat1.eatHuman();
        bat1.fly();
        bat1.fly();
    }
}