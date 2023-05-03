package aeroport;

import java.util.HashSet;

public class Compagnie {

    private String name;

    private HashSet<Vol> vols = new HashSet<>();


    public Compagnie() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<Vol> getVols() {
        return vols;
    }

    public void setVols(HashSet<Vol> vols) {
        for(Vol v : this.vols){
            v.setCompagnie(this);
        }
    }

    public void addVol(Vol vol){  
        this.vols.add(vol);
        vol.setCompagnie(this);
    }

    public void removeVol(Vol vol){
        vol.setCompagnie(null);
        this.vols.remove(vol);
    }
    protected void volChangeCompagnie(Vol vol){
        this.vols.remove(vol);
    }
    protected void addVolFromVol(Vol vol){
        this.vols.add(vol);
    }
    protected void removeVolFromVol(Vol vol){
        this.vols.remove(vol);
    }

    @Override
    public String toString() {
        return "Compagnie : "+name;
    }
}
