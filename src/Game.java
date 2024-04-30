package src;

import java.util.ArrayList;

public class Game {
    Menu menu;
    Player player;
    Attribute attribute;
    OffEquipment offEquipment;
    DefEquipment defEquipment;

    ArrayList<Player> players = new ArrayList<Player>();
    ArrayList<Attribute> attributes = new ArrayList<Attribute>();
    ArrayList<OffEquipment> offEquipments = new ArrayList<OffEquipment>();
    ArrayList<DefEquipment> defEquipments = new ArrayList<DefEquipment>();

    private int playersCount = 1;

    public Game() {
    }

    public void launch() {
        menu = new Menu();
        playersCount = menu.start();

        for (int i = 0; i < playersCount; i++) {
            player = new Player();
            players.add(menu.create(player));
        }

        for (int i = 0; i < playersCount; i++) {
            attribute = new Attribute();

            if (players.get(i).getJob().equals("WARRIOR")) {
                attributes.add(new Attribute(attribute.getWarriorBaseStats()));
            }

            if (players.get(i).getJob().equals("WIZARD")) {
                attributes.add(new Attribute(attribute.getWizardBaseStats()));
            }
        }

        for (int i = 0; i < playersCount; i++) {
            offEquipment = new OffEquipment();
            defEquipment = new DefEquipment();

            if (players.get(i).getJob().equals("WARRIOR")) {
                offEquipments.add(new OffEquipment(offEquipment.getWarriorBaseOffEquipments()));
                defEquipments.add(new DefEquipment(defEquipment.getWarriorBaseDefEquipments()));
            }

            if (players.get(i).getJob().equals("WIZARD")) {
                offEquipments.add(new OffEquipment(offEquipment.getWizardBaseOffEquipments()));
                defEquipments.add(new DefEquipment(defEquipment.getWizardBaseDefEquipments()));
            }
        }

        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i).getName());
            System.out.println(players.get(i).getJob());
            System.out.println("health: " + attributes.get(i).getHealth());
            System.out.println("strength: " + attributes.get(i).getStrength());
            System.out.println(offEquipments.get(i).getType() + " : " + offEquipments.get(i).getName() + ", attk: " + offEquipments.get(i).getAttack());
            System.out.println(defEquipments.get(i).getType() + " : " + defEquipments.get(i).getName() + ", def: " + defEquipments.get(i).getDefense());
        }
    }
}
