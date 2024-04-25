package gear;

public class Defense {
    private String type;
    private String name;
    private int defense;

    public Defense(String role) {
        setType(role);
        setName(role);
        setDefense(role);
    }

    public void setType(String role) {
        this.type = role.equals("warrior") ? "weapon" : "spell";
    }

    public void setName(String role) {
        this.name = role.equals("warrior") ? "sword" : "fire";
    }

    public void setDefense(String role) {
        this.defense = role.equals("warrior") ? 1 : 1;
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