import aeroport.Aeroport;
import aeroport.Compagnie;
import aeroport.Escale;
import aeroport.Ville;
import aeroport.Vol;
import reservation.*;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Iterator;

public class Start {

    public static void main(String[] args){

        System.out.println("##############################################");
        System.out.println("Test de la mise en place d'un vol");
        System.out.println("##############################################");
        Vol volFinal = new Vol();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        String dd = "21/10/2020 13:00";
        String da = "23/10/2020 02:15";
        
        try {
            volFinal.setDateDepart(format.parse(dd));
            volFinal.setDateArrivee(format.parse(da));
        } catch (Exception e){
            throw new RuntimeException("Unable to format to date");
        }

        System.out.println(volFinal.getDateArrivee());
        System.out.println(volFinal.obtenirDuree().toString().substring(2));

        System.out.println("##############################################");
        System.out.println("Test escale");
        System.out.println("##############################################");
        String ded = "22/10/2020 13:00";
        String def = "22/10/2020 15:15";
        Ville vEscale = new Ville("Mulhouse");
        Aeroport aeroportEscale = new Aeroport("EuroAirport Basel-Mulhouse-Freiburg",vEscale);
        aeroportEscale.addVille(vEscale);
        Escale es = new Escale();
        es.setAeroport(aeroportEscale);
        try {
            es.setDebutEscale(format.parse(ded));
            es.setFinEscale(format.parse(def));
        } catch (Exception e){
            throw new RuntimeException("Unable to format to date");
        }
        System.out.println("Durée de l'escale : "+es.obtenirDuree());
        volFinal.addEscale(es);
        System.out.println("Escales durant volFinal : "+ volFinal.getEscales());
        System.out.println("##############################################");
        System.out.println("Test compagnies");
        System.out.println("##############################################");
        Vol vol = new Vol();
        vol.setNumero("abc1");

        Vol vol2 = new Vol();
        vol2.setNumero("abc2");

        Compagnie compagnie = new Compagnie();
        compagnie.setName("Air France");
        compagnie.addVol(vol);
        compagnie.addVol(vol2);

        for(Vol v : compagnie.getVols()){
            System.out.println(v.getNumero());
        }

        System.out.println(vol.getCompagnie().getName());
        System.out.println(vol2.getCompagnie().getName());

        vol2.setCompagnie(null);
        System.out.println(vol2.getCompagnie());

        vol2.setCompagnie(compagnie);
        for(Vol v : compagnie.getVols()){
            System.out.println(v.getNumero());
        }

        System.out.println("##############################################");
        System.out.println("Test réservation");
        System.out.println("##############################################");
        Client c = new Client("Benjamin LABONNE","CB","Tel",vol,2);
        HashSet<Reservation> r = c.getReservation();
        Iterator<Reservation> iter = r.iterator();
        Reservation res;
        while(iter.hasNext()){
            res = iter.next();
            System.out.println(res.getPassagerID());
        }

        //Vérification réservations vol
        iter = vol.getReservations().iterator();
        while(iter.hasNext()){
            res = iter.next();
            System.out.println(res.getPassagerID());
        }       
    }
}
