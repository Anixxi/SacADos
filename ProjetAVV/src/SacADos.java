public class SacADos {
    Objet[] objet;
    final int poidsMax = 30;

    //objet = new Objet[9];
    objet[0]= new Objet("Lampe", 2.0, 30.0);


    public SacADos() {


    }

    public SacADos(String chemin, float poidsMax) {

    }

    @Override
    public String toString() {
        return "$>resoudre-sac-ados";
    }

    static int rechDicho2(/*const*/Objet[] t, int n, int x){ boolean trouve = false;
        int g = 0;
        int h = n-1;
        int m = -1;
        while (g <= h && !trouve){
            m = (g+h)/2;
            if (t[m] == x){ trouve = true;
            }
            else if (t[m] < x){
                g = m+1; }
            else{
                h = m-1;
            } }
        return (trouve ? m : -1);
    }

    private double rapport(Objet objet){
        return objet.Vi/objet.Pi;
    }

    public void resoudreGloutonne(){

    }
}
