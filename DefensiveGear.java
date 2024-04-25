public class DefensiveGear {
    private String type;
    private String name;
    private int defense;

    public DefensiveGear(String characterClass) {
        setType(characterClass);
        setName(characterClass);
        setDefense(characterClass);
    }

    public void setType(String characterClass) {
        this.type = characterClass.equals("warrior") ? "weapon" : "spell";
    }

    public void setName(String characterClass) {
        this.name = characterClass.equals("warrior") ? "sword" : "fire";
    }

    public void setDefense(String characterClass) {
        this.defense = characterClass.equals("warrior") ? 1 : 1;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getDefense() {
        return defense;
    }
}