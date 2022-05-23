import java.util.ArrayList;

public class MethodStat {

    /**
     * Extrait la sous-liste dont les rangs proviennent de l'echantillon passe en parametre
     * @param liste la liste des rangs de tous les echantillons confondus
     * @param echantillon l'echantillon temoin dont il faudra extraire les objets Rang de liste
     * @return une liste contenant tous les rangs venant de echantillon
     */
    public static ArrayList<Rang> trieParEchantillon(ArrayList<Rang> liste, Echantillon echantillon){
        ArrayList<Rang> listeAReturn = new ArrayList<>();

        for(Rang r : liste){

            if(r.observation.provientDe == echantillon){
                listeAReturn.add(r);
            }

        }

        return listeAReturn;
    }

    /**
     * Fait la somme des rangs
     * @param liste la liste de rang
     * @return la somme
     */
    public static int sommeRang(ArrayList<Rang> liste){
        int resultat = 0;

        for(Rang r : liste){
            resultat+=r.rang;
        }

        return resultat;
    }
}
