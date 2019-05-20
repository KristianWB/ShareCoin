public class Polet extends Object {
    //polet = token

    private int antal;
    private String id;
    private String lokaleID;


    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLokaleID() {
        return lokaleID;
    }

    public void setLokaleID(String lokaleID) {
        this.lokaleID = lokaleID;
    }

    public Polet(int antal, String id, String lokaleID) {
        this.antal = antal;
        this.id = id;
        this.lokaleID = lokaleID;
    }

    //new line
}