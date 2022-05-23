public class Rang {

    Observation observation;
    float rang;

    public Rang(Observation o, float r){
        observation = o;
        rang = r;
    }

    @Override
    public String toString(){
        return "Valeur : "+observation.valeur+" | Rang : "+rang+" | Groupe : "+observation.provientDe.idGroupe;
    }

}
