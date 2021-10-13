import javax.imageio.stream.IIOByteBuffer;
import java.util.*;
import java.lang.Math.*;

public class SacADos  {
    private final int poidsMax = 5;
    private List<Objet> objetsSelectionne = new ArrayList<Objet>();

    double poidsSac = 0.0;


    static List<Objet> objets = new ArrayList<>(Arrays.asList(
            new Objet("Lampe", 2.0, 30.0),
            new Objet("Sac de couchage", 1.0, 20.0),
            new Objet("Camping gaz", 3.0,40.0),
            new Objet("Couteau suisse", 0.2,50.0),
            new Objet("Snickers", 0.1,3.0),
            new Objet("Tente 2 secondes", 3.0,100.0),
            new Objet("Briquet", 0.2,0.3),
            new Objet("Coca", 10.0,20.0),
            new Objet("Chips", 0.2,2.0)

    ));

    public SacADos() {
        List<Objet> objets = new ArrayList<Objet>();


    }

    public SacADos(String chemin, float poidsMax){

    }

    public void ajouter(Objet objet) {
        if(objet.getPi() + this.poidsSac <= this.poidsMax) {
            this.objetsSelectionne.add(objet);
            this.poidsSac += objet.getPi();
        }
    }

    public static void resoudreGloutonne(SacADos s){

        Collections.sort(s.objets);


        for (int i=0;i<objets.size(); i++ ){

            if(s.poidsMax >= s.objets.get(i).getPi() + s.poidsSac){
                s.objetsSelectionne.add(s.objets.get(i));
                s.poidsSac += s.objets.get(i).getPi();
            }
        }
    }

    public static void resoudreDynamique(SacADos s) {

        int NB_OBJETS = objets.size();
        int PRECISION = 0;

        int PoidsMaxInt = (int) (s.poidsMax * Math.pow(10.0, PRECISION));
        double[][] table = new double[NB_OBJETS][PoidsMaxInt + 1];

        //on remplit la première ligne
        for (int j = 0; j <= PoidsMaxInt; j++) {
            if (objets.get(0).getPi()* Math.pow(10.0, PRECISION) > j) {
                table[0][j] = 0;
            } else {
                table[0][j] = objets.get(0).getVi();
            }
        }

        for (int i = 1; i < NB_OBJETS; ++i) {
            for (int j = 0; j <= PoidsMaxInt; ++j) {
                if (objets.get(i).getPi()* Math.pow(10.0, PRECISION) > j) {
                    table[i][j] = table[i - 1][j];
                } else {
                    table[i][j] = Math.max(table[i - 1][j], table[i - 1][(int) ((j - (objets.get(i).getPi() * Math.pow(10.0, PRECISION))))] + objets.get(i).getVi());
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
                j = j - (int) (objets.get(i).getPi() * Math.pow(10.0, PRECISION));
                if (j >= 0) {
                    s.ajouter(objets.get(i));
                }
                --i;
            }
        }


    @Override
    public String toString() {
        double valeurTotal = 0;
        for(int i = 0; i < objetsSelectionne.size(); ++i) {
            System.out.println(objetsSelectionne.get(i).toString());
            valeurTotal += objetsSelectionne.get(i).getVi();
        }
        System.out.println("\n poidsSac : " +  poidsSac + "valT :" + valeurTotal);
        return "*";
    }

    public static void main(String[] args) {
         SacADos sac1 = new SacADos();

        System.out.println(sac1);
        //resoudreGloutonne(sac1);
        resoudreDynamique(sac1);
        System.out.println(sac1);


    }






}
