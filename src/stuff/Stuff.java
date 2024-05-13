package src.stuff;

import src.board.Cell;

public abstract class Stuff implements Cell {
    protected String category;
    protected String name;
    protected int stat;

    public Stuff() {
        this.category = "";
        this.name = "";
        this.stat = 0;
    }

    public Stuff(String category, String name, int stat) {
        this.category = category;
        this.name = name;
        this.stat = stat;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }

    public int getStat() {
        return stat;
    }

    @Override
    public String toString() {
        return category + " " + name + " " + stat;
    }
}
