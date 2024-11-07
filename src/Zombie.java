public class Zombie extends Enemy {
    int poisonDamage;

    public Zombie(String name, int health, int attackPower, int poisonDamage) {
        super(name, health, attackPower);
        this.poisonDamage = poisonDamage;
    }

    public void poison(Player player) {
        player.health -= this.poisonDamage;
        System.out.println(this.name + " отравляет " + player.name + " и наносит " + poisonDamage + " урона");
    }
}