public class Reservation extends Object {

    private long udlejTid;
    private long aflTid;
    private String lokaleID;
    private String tokenID;
    private String eMail;
    private String brugerNavn;


    public long getUdlejTid() {
        return udlejTid;
    }

    public void setUdlejTid(long udlejTid) {
        this.udlejTid = udlejTid;
    }

    public long getAflTid() {
        return aflTid;
    }

    public void setAflTid(long aflTid) {
        this.aflTid = aflTid;
    }

    public String getLokaleID() {
        return lokaleID;
    }

    public void setLokaleID(String lokaleID) {
        this.lokaleID = lokaleID;
    }

    public String getTokenID() {
        return tokenID;
    }

    public void setTokenID(String tokenID) {
        this.tokenID = tokenID;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getBrugerNavn() {
        return brugerNavn;
    }

    public void setBrugerNavn(String brugerNavn) {
        this.brugerNavn = brugerNavn;
    }

    public Reservation(String brugerNavn, String eMail, int udlejTid, int aflTid, String lokaleID, String tokenID) {
        this.udlejTid = udlejTid;
        this.aflTid = aflTid;
        this.lokaleID = lokaleID;
        this.tokenID = tokenID;
        this.eMail = eMail;
        this.brugerNavn = brugerNavn;
    }
    // neew line
}
