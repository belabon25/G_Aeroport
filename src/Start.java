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
        String ded2 = "22/10/2020 17:26";
        String def2 = "22/10/2020 21:38";
        Ville vEscale2 = new Ville("Paris");
        Aeroport aeroportEscale2 = new Aeroport("CDG",vEscale2);
        aeroportEscale2.addVille(vEscale2);
        Escale es2 = new Escale();
        es2.setAeroport(aeroportEscale2);
        try {
            es2.setDebutEscale(format.parse(ded2));
            es2.setFinEscale(format.parse(def2));
        } catch (Exception e){
            throw new RuntimeException("Unable to format to date");
        }
        System.out.println("Durée de l'escale : "+es2.obtenirDuree());
        volFinal.addEscale(es2);
        System.out.println("Escales durant volFinal : "+ volFinal.getEscales());
        System.out.println("##############################################");
        System.out.println("Test compagnies");
        System.out.println("##############################################");
        Vol vol = new Vol();
        vol.setNumero("abc1");

        Vol vol2 = new Vol();
        vol2.setNumero("abc2");

        Vol voll = new Vol();
        voll.setNumero("023489");
        Vol voll2 = new Vol();
        voll2.setNumero("064778");

        Compagnie compagnie = new Compagnie();
        compagnie.setName("Air France");
        compagnie.addVol(vol);
        compagnie.addVol(vol2);
        Compagnie compagnie2 = new Compagnie();
        compagnie2.setName("Free Fly");
        compagnie2.addVol(voll);
        compagnie2.addVol(voll2);
        compagnie2.removeVol(voll);

        System.out.println("Vols de "+compagnie);
        for(Vol v : compagnie.getVols()){
            System.out.println(v.getNumero());
        }
        System.out.println("Vols de "+compagnie2);
        for(Vol v : compagnie2.getVols()){
            System.out.println(v.getNumero());
        }

        System.out.println("Mise a null de "+vol2);
        vol2.setCompagnie(null);
        System.out.println(vol2.getCompagnie());

        System.out.println("Ajout de "+vol2+" à "+compagnie);
        vol2.setCompagnie(compagnie);
        for(Vol v : compagnie.getVols()){
            System.out.println(v.getNumero());
        }

        System.out.println("##############################################");
        System.out.println("Test reservation");
        System.out.println("##############################################");
        Client c = new Client("Benjamin LABONNE","CB","0739524877",vol,2);
        Client c2 = new Client("Khaled AL_HENDI","cash","khaled_alhendi@gmail.com",vol,1);
        System.out.println(c);
        HashSet<Reservation> r = c.getReservation();
        HashSet<Reservation> r2 = c2.getReservation();
        Iterator<Reservation> iter = r.iterator();
        Iterator<Reservation> iter2 = r2.iterator();
        Reservation res;
        while(iter.hasNext()){
            res = iter.next();
            System.out.println(res.getPassagerID() + ", reservé par :");
            System.out.println(res.getClient().getNom());
            System.out.println("contact : " + res.getClient().getContact());
        }

        Reservation res2;
        while(iter2.hasNext()){
            res2 = iter2.next();
            System.out.println(res2.getPassagerID() + ", reservé par:");
            System.out.println(res2.getClient().getNom());
            System.out.println("contact : " + res2.getClient().getContact());
            res2.getClient().setPaiement("CB");
            System.out.println("paiment par : " + res2.getClient().getPaiement());
            System.out.println(res2.getVol().getCompagnie());


        }

        System.out.println("##############################################");
        System.out.println("Test Aeroport");
        System.out.println("##############################################");
        Ville ville1 = new Ville("Paris");
        Aeroport Aerport1 = new Aeroport("CDG", ville1);
        Aeroport Aerport2 = new Aeroport("Orly", ville1);

        HashSet<Ville> vil1 = Aerport1.getVilles();
        Iterator<Ville> iterv = vil1.iterator();
        Ville vil;
        while(iterv.hasNext()){
            vil = iterv.next();
            System.out.println(vil.getNom() + ":");
            System.out.println("L'aeroport " + Aerport1.getNom() + " est à " + vil.getNom());
            System.out.println("L'aeroport " + Aerport2.getNom() + " est à " + vil.getNom());
        }
    }
}
