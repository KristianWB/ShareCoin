public class Lokale extends Object {

    private String id;
    private String lokaleBeskr;
    private String ejer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLokaleBeskr() {
        return lokaleBeskr;
    }

    public void setLokaleBeskr(String lokaleBeskr) {
        this.lokaleBeskr = lokaleBeskr;
    }

    public String getEjer() {
        return ejer;
    }

    public void setEjer(String ejer) {
        this.ejer = ejer;
    }

    public Lokale(String id, String lokaleBeskr, String ejer) {
        this.id = id;
        this.lokaleBeskr = lokaleBeskr;
        this.ejer = ejer;
    }
    //new line
}
