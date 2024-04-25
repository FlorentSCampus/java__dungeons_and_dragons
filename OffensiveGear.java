public class OffensiveGear {
    private String type;
    private String name;
    private int attack;

    public OffensiveGear(String characterClass) {
        setType(characterClass);
        setName(characterClass);
        setAttack(characterClass);
    }

    public void setType(String characterClass) {
        this.type = characterClass.equals("warrior") ? "weapon" : "spell"; 
    }

    public void setName(String characterClass) {
        this.name = characterClass.equals("warrior") ? "sword" : "fire"; 
    }

    public void setAttack(String characterClass) {
        this.attack = characterClass.equals("warrior") ? 1 : 1; 
    }

    public String getType() {
        return type; 
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }
}
