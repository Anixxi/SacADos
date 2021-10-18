public class ProgDynamique {
    private SacADos s;

    public ProgDynamique(SacADos sac) {
        s = sac;
    }


    /***
     * Permet de résoudre avec la programmation dynamique
     */
    public  void resoudreDynamique() {

        int nbObjets = s.objets.size();
        int PoidsMaxInt = (int) (s.poidsMax);
        double[][] table = new double[nbObjets][PoidsMaxInt + 1];

        //on remplit la première ligne
        for (int j = 0; j <= PoidsMaxInt; j++) {
            if ( s.objets.get(0).getPi() > j) {
                table[0][j] = 0;
            } else {
                table[0][j] = s.objets.get(0).getVi();
            }
        }

        for (int i = 1; i < nbObjets; ++i) {
            for (int j = 0; j <= PoidsMaxInt; ++j) {
                if ( s.objets.get(i).getPi() > j) {
                    table[i][j] = table[i - 1][j];
                } else {
                    table[i][j] = Math.max(table[i - 1][j], table[i - 1][j - (int)(s.objets.get(i).getPi())] + s.objets.get(i).getVi());
                }
            }
        }

        //Remontée du tableau
        int i = nbObjets - 1;
        int j = PoidsMaxInt;
        while (table[i][j] == table[i][j - 1])
            --j;
        while (j > 0) {
            while (i > 0 && table[i][j] == table[i - 1][j])
                --i;
            if(i < 0)
                break;
            j = j - (int) (s.objets.get(i).getPi());
            if (j >= 0)
                s.ajouter(s.objets.get(i));
            --i;


        }
    }
}
