package reservation;

import java.util.HashSet;
import aeroport.Vol;

//Un client peut faire plusieurs réservations
public class Client {
    private String nom;
    private String reference;
    private String paiement;
    private String contact;
    private int nbReservations;
    private Vol vol;
    private HashSet<Reservation> reservations = new HashSet<>();
    public Client(String nom,String paiement, String contact,Vol vol,int nbRes){
        this.nom=nom;
        this.paiement=paiement;
        this.contact=contact;
        nbReservations=nbRes;
        for(int i=0;i<nbReservations;i++)
            reservations.add(new Reservation(this,vol));
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    } 

    public Vol getVol() {
        return vol;
    }

    public void setVol(Vol vol) {
        this.vol = vol;
    }

    public String getReference() {
        return reference;
    }
    public void setReference(String reference) {
        this.reference = reference;
    }  

    public String getPaiement() {
        return paiement;
    }
    public void setPaiement(String paiement) {
        this.paiement = paiement;
    } 

    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }

    public HashSet<Reservation> getReservation() {
        return reservations;
    }
}
