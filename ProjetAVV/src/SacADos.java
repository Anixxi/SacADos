import java.io.BufferedReader;
import java.util.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SacADos {
    public int poidsMax;
    public List<Objet> objetsSelectionne = new ArrayList<Objet>();
    public ArrayList<Objet> objets = new ArrayList<Objet>();;
    public double poidsSac;

    private static SacADos s;
    private static Gloutonne g;
    private static ProgDynamique d;


    /*static List<Objet> objets = new ArrayList<>(Arrays.asList(
            new Objet("Lampe", 2.0, 30.0),
            new Objet("Sac de couchage", 1.0, 20.0),
            new Objet("Camping gaz", 3.0,40.0),
            new Objet("Couteau suisse", 0.2,50.0),
            new Objet("Snickers", 0.1,3.0),
            new Objet("Tente 2 secondes", 3.0,100.0),
            new Objet("Briquet", 0.2,0.3),
            new Objet("Coca", 10.0,20.0),
            new Objet("Chips", 0.2,2.0)

    ));*/

    public SacADos() {
        List<Objet> objets = new ArrayList<Objet>();
        poidsMax = 5;
        poidsSac = 0.0;
    }

    public SacADos(String chemin, float poidsMax) {

    }

    public void initObjects(String chemin) {
        try {
            InputStream flux = new FileInputStream(chemin);
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);
            String ligne;
            while ((ligne = buff.readLine()) != null) {
                Scanner s = new Scanner(ligne).useDelimiter("\\s*;\\s*");
                String nom = s.next();
                float poids = Float.parseFloat(s.next());
                float valeur = Float.parseFloat(s.next());
                objets.add(new Objet(nom, poids, valeur));


            }
            buff.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void ajouter(Objet objet) {
        if (objet.getPi() + this.poidsSac <= this.poidsMax) {
            this.objetsSelectionne.add(objet);
            this.poidsSac += objet.getPi();
        }
    }


    @Override
    public String toString() {
        double valeurTotal = 0;
        for (int i = 0; i < objetsSelectionne.size(); ++i) {
            System.out.println(objetsSelectionne.get(i).toString());
            valeurTotal += objetsSelectionne.get(i).getVi();
        }
        System.out.println("\n poidsSac : " + poidsSac + "valT :" + valeurTotal);
        return "*";
    }

    public static void main(String[] args) {

        msg();
        lectureCommande();
        //SacADos sac1 = new SacADos();

        //System.out.println(sac1);
        //g.resoudreGloutonne(sac1);
        //resoudreDynamique(sac1);
        //System.out.println(sac1);


    }

    private static void msg() {
        System.out.println("******************************************************");
        System.out.println("\nTapez le script de la façon suivante : $>resoudre-sac-a-dos chemin poids-maximal methode \n");
        System.out.print("$>resoudre-sac-a-dos ");


    }
    private static void lectureCommande() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String chemin = sc.next();
            if (chemin.compareTo("exit") == 0)
                return;
            float maxPoids = Float.valueOf(sc.next());
            String methode = sc.next();
            System.out.println("\nDemande de méthode: " + methode + " avec un poids maximal de " + maxPoids + " et le nom du fichier texte est de " + chemin);
            System.out.println("------------------------------------------------------------------------------------------------------------------------");
            s = new SacADos();
            s.initObjects(chemin);
            choixMethode(methode);
        }


    }

    private static void choixMethode(String methode) {
        switch(methode){
            case "glouton":
                Gloutonne g = new Gloutonne(s);
                g.resoudreGloutonne();
                System.out.println(s.toString());
                break;

            case "dynamique" :
                d = new ProgDynamique(s);
                d.resoudreDynamique();
                System.out.println(s.toString());
                break;

            /*case "pse" :
                pse = new PSE(b);
                pse.triPSE();
                System.out.println(b.toString());
                break;*/
            default :
                System.out.println("Erreur de saisie");
        }
    }
}
