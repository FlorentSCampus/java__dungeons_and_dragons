package src;

public class DefEquipment {
    private Object[] warriorBaseDefEquipments = {"SHIELD", "", 0};
    private Object[] wizardBaseDefEquipments = {"PHILTRA", "", 0};

    private String type;
    private String name;
    private int defense;

    public DefEquipment() {
    }

    public DefEquipment(Object[] defEquipments) {
        this.type = defEquipments[0];
        this.name = defEquipments[1];
        this.defense = defEquipments[2];
    }

    public Object[] getWarriorBaseDefEquipments() {
        return warriorBaseDefEquipments;
    }

    public Object[] getWizardBaseDefEquipments() {
        return wizardBaseDefEquipments;
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
