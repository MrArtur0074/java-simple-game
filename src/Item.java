public class Item {
    String name;
    String type; // Например, "health_potion" или "weapon"
    int effectValue;

    public Item(String name, String type, int effectValue) {
        this.name = name;
        this.type = type;
        this.effectValue = effectValue;
    }
}