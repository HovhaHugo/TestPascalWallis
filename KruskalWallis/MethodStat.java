package KruskalWallis;

import java.util.ArrayList;

public class MethodStat {

    /**
     * Methode correspondant au test de Pascal Wallis
     * @param N Le nombre d'elements observer
     * @param res Les rangs des differents echantillons
     * @param ni Le nombre d'elements dans les echantillons
     * @param k Le nombre d'echantillons
     * @param khi La valeur du khi 2
     */
    public static void KruskalWallis(double N, double res, double ni, double k, double khi){
        //Valeur discriminante
        double h = 0D;

        //La formule est la suivante : H = 12/N(N+1) * E (Ri^2/ni) -3(N+1)  (N -> Nb obs; Ri -> Rang de la méthode i)
        h = 12/(N*(N+1))*(res/ni)-3*(N+1);
        System.out.println("On fait donc : ");
        System.out.println("12/("+N+"("+(N+1)+")) x ("+(res/ni)+") - 3 x "+(N+1) + " = " +h);

        //Une fois faites, on fait la comparaison avec le Khi 2. pour savoir si l'on rejette ou pas H0

        if(h>khi){
            System.out.println("On rejette H0 car H > ta : H ="+h+", ta = "+khi);
        }
        else{
            System.out.println("On accpete H0 car H < ta : H ="+h+", ta = "+khi);
        }
    }

    /**
     * Methode correspondant au calcule de ta avec le tableau du Khi 2
     * @param x Le test du khi 2 sur notre seuil de confiance
     * @param y le nombre de valeurs
     * @return
     */
    /**public static Double KhiDeux(double x, double y){
        double khi = 0D;

        //La formule du Khi 2 est la suivante : t = sqrt(2x^2) - sqrt(2y-1)
        khi = Math.sqrt(2*Math.pow(x,2)) - Math.sqrt(2*y-1);

        return khi;
    }*/

     /* Extrait la sous-liste dont les rangs proviennent de l'echantillon passe en parametre
     * @param liste la liste des rangs de tous les echantillons confondus
     * @param echantillon l'echantillon temoin dont il faudra extraire les objets KruskalWallis.Rang de liste
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
    public static float sommeRang(ArrayList<Rang> liste){
        float resultat = 0;

        for(Rang r : liste){
            resultat+=r.rang;
        }

        return resultat;
    }
}
