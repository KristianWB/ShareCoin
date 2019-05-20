public class Medlemmer extends Object {

        private String firmaNavn;
        private String eMail;
        private String kodeOrd;
        private int cvr;
        private String lokale;
        private String navn;
        private String efterNavn;
        private String id;
        private String medlemsType;
        private int tlfNummer;

        public String getFirmaNavn() {
            return firmaNavn;
        }

        public void setFirmaNavn(String firmaNavn) {
            this.firmaNavn = firmaNavn;
        }

        public String geteMail() {
            return eMail;
        }

        public void seteMail(String eMail) {
            this.eMail = eMail;
        }

        public String getKodeOrd() {
            return kodeOrd;
        }

        public void setKodeOrd(String kodeOrd) {
            this.kodeOrd = kodeOrd;
        }

        public int getCvr() {
            return cvr;
        }

        public void setCvr(int cvr) {
            this.cvr = cvr;
        }

        public String getLokale() {
            return lokale;
        }

        public void setLokale(String lokale) {
            this.lokale = lokale;
        }

        public String getNavn() {
            return navn;
        }

        public void setNavn(String navn) {
            this.navn = navn;
        }

        public String getEfterNavn() {
            return efterNavn;
        }

        public void setEfterNavn(String efterNavn) {
            this.efterNavn = efterNavn;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMedlemsType() {
            return medlemsType;
        }

        public void setMedlemsType(String medlemsType) {
            this.medlemsType = medlemsType;
        }

        public int getTlfNummer() {
            return tlfNummer;
        }

        public void setTlfNummer(int tlfNummer) {
            this.tlfNummer = tlfNummer;
        }

    public Medlemmer(String firmaNavn, String eMail, String kodeOrd, int cvr, String lokale, String navn, String efterNavn, String id, String medlemsType, int tlfNummer) {
            this.firmaNavn = firmaNavn;
            this.eMail = eMail;
            this.kodeOrd = kodeOrd;
            this.cvr = cvr;
            this.lokale = lokale;
            this.navn = navn;
            this.efterNavn = efterNavn;
            this.id = id;
            this.medlemsType = medlemsType;
            this.tlfNummer = tlfNummer;
        }
        //new line
    }

