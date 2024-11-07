//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Player player = new Player("Artur", 100, 15);
        Enemy zombie = new Zombie("Зомби", 50, 5, 3);
        Enemy dragon = new Dragon("Дракон", 150, 20, 25);

        /* Создадим скилл и зелье лечения */
        Skill fireball = new Skill("Огненный шар", 30, 10);
        Item healthPotion = new Item("Зелье здоровья", "health_potion", 50);

        /* Добавим игроку */
        player.addSkill(fireball);
        player.addItemToInventory(healthPotion);

        // Бой с первым врагом (зомби)
        System.out.println("Начинается бой с " + zombie.name + "!");
        battle(player, zombie, scanner);

        if (player.health > 0) {
            System.out.println("Игрок побеждает " + zombie.name + " и получает опыт!");
            player.gainExperience(50);

            // Бой с драконом, если игрок победил зомби
            System.out.println("Начинается бой с " + dragon.name + "!");
            battle(player, dragon, scanner);

            if (player.health > 0) {
                System.out.println("Поздравляем! Игрок победил всех врагов и выиграл!");
            } else {
                System.out.println("Игрок проиграл...");
            }
        } else {
            System.out.println("Игрок проиграл...");
        }

        scanner.close();
    }

    public static void battle(Player player, Enemy enemy, Scanner scanner) {
        while (enemy.health > 0 && player.health > 0) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Атаковать");
            System.out.println("2. Использовать зелье здоровья");
            System.out.println("3. Использовать навык");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> player.attack(enemy);
                case 2 -> player.useItemByName("health_potion");
                case 3 -> {
                    if (player.skills[0] != null) {
                        player.useSkill(player.skills[0], enemy);
                    } else {
                        System.out.println("Нет доступных навыков!");
                    }
                }
                default -> System.out.println("Некорректный выбор. Попробуйте снова.");
            }

            // Атака врага, если он еще жив
            if (enemy.health > 0) {
                enemy.attack(player);
            }
        }

        // Проверка, кто выиграл бой
        if (player.health <= 0) {
            System.out.println(player.name + " был повержен.");
        } else {
            System.out.println("Побежден " + enemy.name);
        }
    }
}