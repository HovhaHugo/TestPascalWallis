public class MethodStat {

    /**
     * Méthode correspondant au test de Pascal Wallis
     * @param N Le nombre d'elements observer
     * @param res Les rangs des différents echantillons
     * @param k Le nombre d'echantillons
     * @param seuil Le seuile de confiance
     */
    public static void KruskalWallis(double N, double res, double k, double seuil){
        //Valeur discriminante
        double h = 0D;

        //La formule est la suivante : H = 12/N(N+1) * E (Ri^2/ni) -3(N+1)  (N -> Nb obs; Ri -> Rang de la méthode i)
        h = 12/(N*(N+1))*(res/7)-3*(N+1);
        System.out.println("On fait donc : ");
        System.out.println("12/("+N+"("+(N+1)+")) x ("+(res/7)+") - 3 x "+(N+1) + " = " +h);

        //Une fois faites, on fait la comparaison avec le Khi 2. pour savoir si l'on rejette ou pas H0
        double khi = KhiDeux(k-1,21);

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
    public static Double KhiDeux(double x, double y){
        double khi = 0D;

        //La formule du Khi 2 est la suivante : t = sqrt(2x^2) - sqrt(2y-1)
        khi = Math.sqrt(2*Math.pow(x,2)) - Math.sqrt(2*y-1);

        return khi;
    }

}
