package gear;

public class Attack {
    private String type;
    private String name;
    private int attack;

    public Attack(String role) {
        setType(role);
        setName(role);
        setAttack(role);
    }

    public void setType(String role) {
        this.type = role.equals("warrior") ? "weapon" : "spell"; 
    }

    public void setName(String role) {
        this.name = role.equals("warrior") ? "sword" : "fire"; 
    }

    public void setAttack(String role) {
        this.attack = role.equals("warrior") ? 1 : 1; 
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
