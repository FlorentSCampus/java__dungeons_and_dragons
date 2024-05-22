package file.db;

public class Config {
    private String HOSTNAME;
    private String DBNAME;
    private String USERNAME;
    private String PWD;

    public Config(){
        this.HOSTNAME = "localhost";
        this.DBNAME = "dbName";
        this.USERNAME = "root";
        this.PWD = "root";
    }

    public String getURL() {
        return "jdbc:mysql://" + HOSTNAME + "/" + DBNAME;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public String getPWD() {
        return PWD;
    }
}
