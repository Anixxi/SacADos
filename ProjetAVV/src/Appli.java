import java.util.Scanner;

/***
 *  @author Salim EL DJOUZI, Amudhan COLBERT
 */
public class Appli {
    private static SacADos s;
    private static Gloutonne g;
    private static ProgDynamique d;
    private static PSE pse;

    public static void main(String[] args) {
        msg();
        lectureCommande();
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
            double maxPoids = Double.valueOf(sc.next());
            String methode = sc.next();
            System.out.println("\nDemande de méthode: " + methode + " avec un poids maximal de " + maxPoids + " et le nom du fichier texte est de " + chemin);
            System.out.println("------------------------------------------------------------------------------------------------------------------------");
            s = new SacADos(maxPoids);
            s.initObjects(chemin);
            choixMethode(methode);
        }


    }

    private static void choixMethode(String methode) {
        switch(methode){
            case "glouton":
                g = new Gloutonne(s);
                g.resoudreGloutonne();
                System.out.println(s.toString());
                break;

            case "dynamique" :
                d = new ProgDynamique(s);
                d.resoudreDynamique();
                long fin = System.currentTimeMillis();
                System.out.println(s.toString());

                break;

            case "pse" :
                pse = new PSE(s);
                g = new Gloutonne(s);
                g.resoudreGloutonne();
                pse.resoudrePSE();
                System.out.println(s.toString());
                break;
            default :
                System.out.println("Erreur de saisie");
        }
    }
}
