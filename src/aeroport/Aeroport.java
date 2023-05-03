package aeroport;

import java.util.HashSet;
public class Aeroport {

    private String nom;

    private HashSet<Ville> villes = new HashSet<>();


    public Aeroport(String nom,Ville ville) {
        this.nom=nom;
        if(ville==null) throw new IllegalArgumentException(); //Au moins une ville desservie
        villes.add(ville);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public HashSet<Ville> getVilles() {
        return villes;
    }

    public void setVille(HashSet<Ville> villes) {
        this.villes = villes;
    }
    public void addVille(Ville ville){
        villes.add(ville);
    }
    public void removeVille(Ville ville){
        villes.remove(ville);
    }
    @Override
    public boolean equals(Object obj) {
        return this.nom.equals(((Aeroport)obj).nom);
    }
}
