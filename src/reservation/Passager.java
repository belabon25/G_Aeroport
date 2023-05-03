package reservation;


//La classe passager ne sert désormais plus qu'a trouver un ID passager différent pour
//chaque réservation (1 personne par réservation)
//Implementée avec le patron de conception singleton
public class Passager {
    private static Passager instance = null;
    private static int nbPassager=0;

    public static Passager getInstance(){
        if (instance==null){
            instance = new Passager();
        }
        return instance;
    }
    public String getPassagerID(){
        nbPassager++;
        return "Passager"+nbPassager;
    } 
}
