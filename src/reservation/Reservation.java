package reservation;
import aeroport.Vol;

//Une personne par réservation
public class Reservation {
    private Vol vol;
    private Client client;
    private String passagerID;
    public Reservation(Client client,Vol vol) {
        this.client=client;
        this.passagerID=Passager.getInstance().getPassagerID();
        this.vol=vol;
    }
    public Vol getVol() {
        return vol;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getPassagerID() {
        return passagerID;
    }

    public void setPassagerID(String passagerID) {
        this.passagerID = passagerID;
    }
    
}
