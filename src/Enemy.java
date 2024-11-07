public class Enemy {
    String name;
    int health;
    int attackPower;

    public Enemy(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public void attack(Player player) {
        player.health -= this.attackPower;
        System.out.println(this.name + " атакует " + player.name + " и наносит " + this.attackPower + " урона.");
    }
}
