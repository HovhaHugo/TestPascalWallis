import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Destermination du nombre d'observation et d'elements
        double nbObservations = 0;
        double nbElements = 0;

        //Creation des echantillons et des valeurs
        Echantillon groupe1 = new Echantillon(1);
        Echantillon groupe2 = new Echantillon(2);
        Echantillon groupe3 = new Echantillon(3);

        Integer[] listeGroupe1 = {66,68,80,72,74,57,75};
        Integer[] listeGroupe2 = {77,68,67,85,89,74,61};
        Integer[] listeGroupe3 = {79,83,78,92,98,69,91};

        for(Integer i : listeGroupe1) {
            groupe1.add(new Observation(i, groupe1));
            //On determine le nombre de valeurs, et d'observations
            nbElements++;
            nbObservations++;
        }

        for(Integer i : listeGroupe2) {
            groupe2.add(new Observation(i, groupe2));
            nbObservations++;
        }

        for(Integer i : listeGroupe3){
            groupe3.add(new Observation(i,groupe3));
            nbObservations++;
        }

        //On ajoute tout cela pour former un tout
        Echantillon groupeFusion = new Echantillon(4);
        groupeFusion.addAll(groupe1);
        groupeFusion.addAll(groupe2);
        groupeFusion.addAll(groupe3);

        //On fait notre liste de rang
        ArrayList<Rang> groupeFusionRang = groupeFusion.getRang();

        for(Rang r : groupeFusionRang){
            System.out.println(r);
        }

        //On effectue le trie des echantillons par leur rangs
        ArrayList<Rang> listeRangGroupe1 = MethodStat.trieParEchantillon(groupeFusionRang,groupe1);
        ArrayList<Rang> listeRangGroupe2 = MethodStat.trieParEchantillon(groupeFusionRang,groupe2);
        ArrayList<Rang> listeRangGroupe3 = MethodStat.trieParEchantillon(groupeFusionRang,groupe3);

        //On calcule la somme des rangs de chaque echantillons
        float sommeRangGroupe1 = MethodStat.sommeRang(listeRangGroupe1);
        float sommeRangGroupe2 = MethodStat.sommeRang(listeRangGroupe2);
        float sommeRangGroupe3 = MethodStat.sommeRang(listeRangGroupe3);

        System.out.println("SommeRangGroupe1 : "+sommeRangGroupe1);
        System.out.println("SommeRangGroupe2 : "+sommeRangGroupe2);
        System.out.println("SommeRangGroupe3 : "+sommeRangGroupe3);

        //On determine les derniere valeurs importante pour faire les calculs
        double k = 3;
        double seuil = 0.05;
        double res = Math.pow(sommeRangGroupe1,2)+Math.pow(sommeRangGroupe2,2)+Math.pow(sommeRangGroupe3,2);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ecrire un la valeur du Khi 2 pour un seuil de "+seuil+"% et avec "+(k-1)+" niveau de liberter : ");

        double khi = scanner.nextDouble();

        System.out.println("Khi 2 = "+khi);
        
        //On effectue la methode de KruskalWallis
        MethodStat.KruskalWallis(nbObservations,res,nbElements,k,khi);
    }
}
