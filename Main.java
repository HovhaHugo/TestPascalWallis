import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Echantillon groupe1 = new Echantillon(1);
        Echantillon groupe2 = new Echantillon(2);
        Echantillon groupe3 = new Echantillon(3);

        Integer[] listeGroupe1 = {66,68,80,72,74,57,75};
        Integer[] listeGroupe2 = {77,68,67,85,89,74,61};
        Integer[] listeGroupe3 = {79,83,78,92,98,69,91};

        for(Integer i : listeGroupe1)
            groupe1.add(new Observation(i,groupe1));

        for(Integer i : listeGroupe2)
            groupe2.add(new Observation(i,groupe2));

        for(Integer i : listeGroupe3)
            groupe3.add(new Observation(i,groupe3));

        Echantillon groupeFusion = new Echantillon(4);
        groupeFusion.addAll(groupe1);
        groupeFusion.addAll(groupe2);
        groupeFusion.addAll(groupe3);

        ArrayList<Rang> groupeFusionRang = groupeFusion.getRang();

        ArrayList<Rang> listeRangGroupe1 = MethodStat.trieParEchantillon(groupeFusionRang,groupe1);
        ArrayList<Rang> listeRangGroupe2 = MethodStat.trieParEchantillon(groupeFusionRang,groupe2);
        ArrayList<Rang> listeRangGroupe3 = MethodStat.trieParEchantillon(groupeFusionRang,groupe3);

        int sommeRangGroupe1 = MethodStat.sommeRang(listeRangGroupe1);
        int sommeRangGroupe2 = MethodStat.sommeRang(listeRangGroupe2);
        int sommeRangGroupe3 = MethodStat.sommeRang(listeRangGroupe3);



    }
}
