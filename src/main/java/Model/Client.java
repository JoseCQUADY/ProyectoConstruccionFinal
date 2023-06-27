package Model;
public class Client {
    private String name;
    private String curp;

    public Client(String name, String curp) {
        this.name = name;
        this.curp = curp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }
}
