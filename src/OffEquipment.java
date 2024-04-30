package src;

public class OffEquipment {
    private Object[] warriorBaseOffEquipments = {"WEAPON", "WOODEN SWORD", 5};
    private Object[] wizardBaseOffEquipments = {"SPELL", "FIRE", 5};

    private String type;
    private String name;
    private int attack;

    public OffEquipment() {
    }

    public OffEquipment(Object[] offEquipments) {
        this.type = offEquipments[0];
        this.name = offEquipments[1];
        this.attack = offEquipments[2];
    }

    public Object[] getWarriorBaseOffEquipments() {
        return warriorBaseOffEquipments;
    }

    public Object[] getWizardBaseOffEquipments() {
        return wizardBaseOffEquipments;
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
