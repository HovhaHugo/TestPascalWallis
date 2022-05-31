package Friedman;

import KruskalWallis.Echantillon;
import KruskalWallis.MethodStat;
import KruskalWallis.Observation;
import KruskalWallis.Rang;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //Création échantillon

        Double[] listeGroupe1 = {4d,9d,6d,2.5,13.5};
        Double[] listeGroupe2 = {5d,12d,6.2,2.9,15d};
        Double[] listeGroupe3 = {4.5,11d,7.4,3.2,15.3};

        Echantillon groupe1 = new Echantillon(1);
        Echantillon groupe2 = new Echantillon(2);
        Echantillon groupe3 = new Echantillon(3);

        for(Double i : listeGroupe1)
            groupe1.add(new Observation(i,groupe1));

        for(Double i : listeGroupe2)
            groupe2.add(new Observation(i,groupe2));

        for(Double i : listeGroupe3)
            groupe3.add(new Observation(i,groupe3));

        //Fin création échantillons


        //Appairer par ligne
        ArrayList<Echantillon> listeParLigne = new ArrayList<>();

        for(int i=0; i< groupe1.size(); i++){
            Echantillon e = new Echantillon(i);
            e.add(new Observation(listeGroupe1[i],groupe1));
            e.add(new Observation(listeGroupe2[i],groupe2));
            e.add(new Observation(listeGroupe3[i],groupe3));
            listeParLigne.add(e);
        }

        ArrayList<ArrayList<Rang>> rangParLigne = new ArrayList<>();

        System.out.println("Rang par ligne: ");
        for(int i=0; i< listeParLigne.size(); i++){
            ArrayList<Rang> AAjouter = listeParLigne.get(i).getRang();
            rangParLigne.add(AAjouter);
            System.out.println(AAjouter.get(0)+" || "+AAjouter.get(1)+" || "+AAjouter.get(2));
        }

        //On range les rangs par echantillon d'origine
        ArrayList<Rang> rangGroupe1 = new ArrayList();
        ArrayList<Rang> rangGroupe2 = new ArrayList();
        ArrayList<Rang> rangGroupe3 = new ArrayList();

        for(int i=0; i<rangParLigne.size(); i++){
            rangGroupe1.addAll(MethodStat.trieParEchantillon(rangParLigne.get(i), groupe1));
            rangGroupe2.addAll(MethodStat.trieParEchantillon(rangParLigne.get(i), groupe2));
            rangGroupe3.addAll(MethodStat.trieParEchantillon(rangParLigne.get(i), groupe3));
        }

        float r1 = MethodStat.sommeRang(rangGroupe1);
        float r2 = MethodStat.sommeRang(rangGroupe2);
        float r3 = MethodStat.sommeRang(rangGroupe3);

        System.out.println("Somme rang echantillon 1 : "+r1);
        System.out.println("Somme rang echantillon 2 : "+r2);
        System.out.println("Somme rang echantillon 3 : "+r3);



    }
}
