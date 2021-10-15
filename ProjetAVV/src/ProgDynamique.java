public class ProgDynamique {
    private SacADos s;

    public ProgDynamique(SacADos sac) {
        s = sac;
    }

    public void resoudreDynamique(){
        int NB_OBJETS = s.objets.size();
        int PRECISION = 0;
        int PoidsMaxInt = (int) (s.poidsMax * Math.pow(10.0, PRECISION));
        double[][] table = new double[NB_OBJETS][PoidsMaxInt + 1];

        //on remplit la première ligne
        for (int j = 0; j <= PoidsMaxInt; j++) {
            if (s.objets.get(0).getPi() * Math.pow(10.0, PRECISION) > j) {
                table[0][j] = 0;
            } else {
                table[0][j] = s.objets.get(0).getVi();
            }
        }

        for (int i = 1; i < NB_OBJETS; ++i) {
            for (int j = 0; j <= PoidsMaxInt; ++j) {
                if (s.objets.get(i).getPi() * Math.pow(10.0, PRECISION) > j) {
                    table[i][j] = table[i - 1][j];
                } else {
                    table[i][j] = Math.max(table[i - 1][j], table[i - 1][(int) ((j - (s.objets.get(i).getPi() * Math.pow(10.0, PRECISION))))] + s.objets.get(i).getVi());
                }
            }
        }

        int i = NB_OBJETS - 1;
        int j = PoidsMaxInt;
        while (table[i][j] == table[i][j - 1]) {
            --j;
        }


        while (j > 0) {
            while (i > 0 && table[i][j] == table[i - 1][j])
                --i;
            j = j - (int) (s.objets.get(i).getPi() * Math.pow(10.0, PRECISION));
            if (j >= 0) {
                s.ajouter(s.objets.get(i));
            }
            --i;
        }
    }
}
