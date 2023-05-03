package aeroport;

import java.util.HashSet;
public class Ville {
    private String nom;
    
    //Not ordered, having the same value twice is impossible
    private HashSet<Aeroport> aeroports;

    public Ville(String nom){
        this.nom = nom;
    }
    public Ville(String nom,HashSet<Aeroport>aeroports){
        this.nom = nom;
        this.aeroports=aeroports;
    }  

    public void addAeroport(Aeroport a){
        aeroports.add(a);
    }
    public void removeAeroport(Aeroport a){
        aeroports.remove(a);
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    @Override
    public boolean equals(Object obj) {
        return this.nom.equals(((Ville)obj).nom);
    }
}
