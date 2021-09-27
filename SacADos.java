import java.util.*;

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

    public static void resoudreGloutonne(SacADos s){

        Collections.sort(s.objets);


        for (int i=0;i<objets.size(); i++ ){

            if(s.poidsMax >= s.objets.get(i).getPi() + s.poidsSac){
                s.objetsSelectionne.add(s.objets.get(i));
                s.poidsSac += s.objets.get(i).getPi();
            }
        }
    }

    @Override
    public String toString() {
        for(int i = 0; i < objets.size(); ++i) {
            System.out.println(objets.get(i).toString());
        }
        return "*";
    }

    public static void main(String[] args) {
         SacADos sac1 = new SacADos();

        System.out.println(sac1.objets);
        resoudreGloutonne(sac1);
        System.out.println(sac1.objetsSelectionne);


    }






}
