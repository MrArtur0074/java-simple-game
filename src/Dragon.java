public class Dragon extends Enemy {
    int fireBreathDamage;

    public Dragon(String name, int health, int attackPower, int fireBreathDamage) {
        super(name, health, attackPower);
        this.fireBreathDamage = fireBreathDamage;
    }

    public void breatheFire(Player player) {
        player.health -= this.fireBreathDamage;
        System.out.println(this.name + " дышит огнем и наносит " + fireBreathDamage + " урона " + player.name);
    }
}