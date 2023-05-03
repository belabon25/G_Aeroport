package aeroport;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Date;
public class Escale implements java.lang.Comparable<Escale>{
    private Date debutEscale;
    private Date finEscale;
    private Aeroport aeroport;

    public Escale(){}
    
    public Duration obtenirDuree() {
        if(this.debutEscale != null && this.finEscale != null) {
            return Duration.of(finEscale.getTime() - debutEscale.getTime(), ChronoUnit.MILLIS);
        }
        return null;
    }

    public Date getDebutEscale() {
        return debutEscale;
    }

    public void setDebutEscale(Date debutEscale) {
        this.debutEscale = debutEscale;
    }

    public Date getFinEscale() {
        return finEscale;
    }

    public void setFinEscale(Date finEscale) {
        this.finEscale = finEscale;
    }

    public Aeroport getAeroport() {
        return aeroport;
    }

    public void setAeroport(Aeroport aeroport) {
        this.aeroport = aeroport;
    }


    @Override
    public int compareTo(Escale o) {
        if(this.debutEscale.before(o.debutEscale)) return -1;
        if(this.debutEscale.after(o.debutEscale)) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return "Escale à " + aeroport.getNom() + " pendant " + obtenirDuree();
    }
}