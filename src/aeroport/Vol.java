package aeroport;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashSet;
import java.util.TreeSet;
import reservation.Reservation;

public class Vol {

    private String numero;

    private Aeroport depart;

    private Aeroport arrivee;

    private Compagnie compagnie;

    private Date dateDepart;

    private Date dateArrivee;

    private HashSet<Reservation> reservations = new HashSet<>();
    //Ordered, having twice the same value is impossible
    private TreeSet<Escale> escales = new TreeSet<>();

    public Vol() {
    }

    protected Vol(String numero){
        this.numero = numero;
    }

    public Vol(String numero,Aeroport depart, Aeroport arrivee, Compagnie compagnie, Date dateD, Date dateA,TreeSet<Escale>escales){
        if( dateD.compareTo(dateA)>=0 || numero==null || depart==null || arrivee==null || compagnie==null) 
            throw new IllegalArgumentException();
        this.numero=numero;
        this.arrivee=arrivee;
        this.depart=depart;
        this.compagnie=compagnie;
        this.dateDepart=dateD;
        this.dateArrivee=dateA;
        this.escales=escales;
        reservations=new HashSet<Reservation>();
    }

    public Duration obtenirDuree() {
        if(this.dateDepart != null && this.dateArrivee != null) {
            return Duration.of(dateArrivee.getTime() - dateDepart.getTime(), ChronoUnit.MILLIS);
        }
        return null;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public Compagnie getCompagnie() {
        return compagnie;
    }

    public void setCompagnie(Compagnie c){
        if(c==null){compagnie.removeVolFromVol(this);this.compagnie=c;}
        else{
            try {
                compagnie.volChangeCompagnie(this);
            } catch (NullPointerException e) {
                // Happens when the caller is c
            }
            this.compagnie=c;
            c.addVolFromVol(this);
        }
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Aeroport getDepart() {
        return depart;
    }

    public void setDepart(Aeroport depart) {
        this.depart = depart;
    }

    public Aeroport getArrivee() {
        return arrivee;
    }

    public void setArrivee(Aeroport arrivee) {
        this.arrivee = arrivee;
    }

    public TreeSet<Escale> getEscales() {
        return escales;
    }

    public void setEscales(TreeSet<Escale> escales) {
        this.escales = escales;
    }

    //It's a treeSet, no need to verify if it is already in
    public void addEscale(Escale e){
        for (Escale escale : escales) {
            if (escale.getDebutEscale().before(e.getFinEscale()) && e.getDebutEscale().before(escale.getFinEscale()))
                throw new IllegalArgumentException("Il y a déjà une escale sur cette plage horaire !");
            if (e.getDebutEscale().before(escale.getFinEscale()) && escale.getDebutEscale().before(e.getFinEscale()))
                throw new IllegalArgumentException("Il y a déjà une escale sur cette plage horaire !");
        }
        if(e.getDebutEscale().after(dateDepart) && e.getFinEscale().before(dateArrivee))
            escales.add(e);
    }
    //and we can remove without check too
    public void removeEscale(Escale e){
        escales.remove(e);
    }

    public HashSet<Reservation> getReservations() {
        return reservations;
    }

    public void addReservation(Reservation r){
        reservations.add(r);
    }
    public void removeReservation(Reservation r){
        reservations.remove(r);
    }
    @Override
    public boolean equals(Object obj) {
        try {
            return ((Vol) obj).getNumero().equals(this.numero);
        } catch (Exception e){
            return false;
        }
    }
    @Override
    public String toString() {
        return "Vol numéro "+numero;
    }
}
