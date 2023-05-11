package reservation;

import java.util.HashSet;
import java.util.Iterator;

import aeroport.Vol;

//Un client peut faire plusieurs réservations
public class Client {
    private String nom;
    private String reference;
    private String paiement;
    private String contact;
    private int nbReservations;
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

    //On ne stocke pas les vols dans le client pour minimiser le couplage, il est donc impossible de changer de vol (setVol n'existe pas) 
    public Vol getVol() {
        Iterator<Reservation> it = reservations.iterator();
        return it.next().getVol();
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
    @Override
    public String toString() {
        return nom+" a réservé "+nbReservations+" places pour "+getVol();
    }
}
