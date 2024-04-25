public class Character {
    private String username;
    private String characterClass;

    public Character() {
        this.username = "";
        this.characterClass = "";
    }

    public Character(String username) {
        this.username = username;
        this.characterClass = "";
    }

    public Character(String username, String characterClass) {
        this.username = username;
        this.characterClass = characterClass;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public String getUsername() {
        return username;
    }

    public String getCharacterClass() {
        return characterClass;
    }
}