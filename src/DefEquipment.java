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

    public int[] getWarriorBaseDefEquipments() {
        return warriorBaseDefEquipments;
    }

    public int[] getWizardBaseDefEquipments() {
        return wizardBaseDefEquipments;
    }

    public int getType() {
        return type;
    }

    public int getName() {
        return name;
    }

    public int getDefense() {
        return defense;
    }
}
