public class Player {
    String name;
    int health;
    int attackPower;
    int level = 1;
    int experience = 0;
    Item[] inventory = new Item[10]; // Простой инвентарь с 10 слотами
    Skill[] skills = new Skill[3]; // до 3 навыков

    public void gainExperience(int exp) {
        experience += exp;
        System.out.println("Получено " + exp + " опыта.");
        if (experience >= level * 100) { // Повышение уровня при накоплении достаточного опыта
            levelUp();
        }
    }

    private void levelUp() {
        level++;
        health += 20;
        attackPower += 5;
        experience = 0;
        System.out.println(name + " достиг уровня " + level + "! Здоровье и сила атаки увеличены.");
    }

    public Player(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public void attack(Enemy enemy) {
        enemy.health -= this.attackPower;
        System.out.println(this.name + " атакует " + enemy.name + " и наносит " + this.attackPower + " урона.");
    }

    public void useItemByName(String itemName) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null && inventory[i].name.equals(itemName)) {
                useItem(inventory[i]);
                inventory[i] = null;
                return;
            }
        }
        System.out.println("Предмет " + itemName + " не найден.");
    }

    public void addItemToInventory(Item item) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                inventory[i] = item;
                System.out.println(item.name + " добавлен в инвентарь.");
                return;
            }
        }
        System.out.println("Инвентарь полон!");
    }

    public void useItem(Item item) {
        if (item.type.equals("health_potion")) {
            this.health += item.effectValue;
            System.out.println("Использовано " + item.name + ", здоровье увеличено на " + item.effectValue);
        } else if (item.type.equals("weapon")) {
            this.attackPower += item.effectValue;
            System.out.println("Использовано " + item.name + ", сила атаки увеличена на " + item.effectValue);
        }
    }

    public void addSkill(Skill skill) {
        for (int i = 0; i < skills.length; i++) {
            if (skills[i] == null) {
                skills[i] = skill;
                System.out.println("Навык " + skill.name + " добавлен!");
                return;
            }
        }
        System.out.println("Максимум навыков достигнут!");
    }

    public void useSkill(Skill skill, Enemy enemy) {
        enemy.health -= skill.damage;
        System.out.println(this.name + " использует " + skill.name + " и наносит " + skill.damage + " урона " + enemy.name);
    }
}
