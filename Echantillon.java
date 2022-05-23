import java.util.ArrayList;
import java.util.Comparator;

public class Echantillon extends ArrayList<Observation> {

    int idGroupe;

    public Echantillon(int idGroupe){
        super();
        this.idGroupe = idGroupe;
    }

    /**
     * Creer une liste de Rang a partir de la liste appelante. La fonction prend en compte les valeurs en doubles,
     * mais les valeurs en triples ne sont pas prises en charges correctement
     * @return liste de rang
     */
    public ArrayList<Rang> getRang(){

        ArrayList<Rang> listeRang = new ArrayList<>();

        trierSelonValeurObservation();

        int rang = 1;
        for(int i=0; i<size(); i++){

            int rangEffectif = rang;
            Observation o = get(i);

            if(i<size()-1){
                if(o.valeur.equals(get(i + 1).valeur)){
                    rangEffectif+=0.5;

                }
            }
            listeRang.add(new Rang(o,rangEffectif));
            rang++;
        }

        return listeRang;

    }

    /**
     * Trie la liste selon la valeur des observations
     */
    public void trierSelonValeurObservation(){
        sort(Comparator.comparingInt(o -> o.valeur));
    }


}
