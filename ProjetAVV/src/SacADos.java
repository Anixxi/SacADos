import java.io.BufferedReader;
import java.util.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SacADos {
    public double poidsMax;
    public List<Objet> objetsSelectionne = new ArrayList<Objet>();
    public ArrayList<Objet> objets = new ArrayList<Objet>();
    public double poidsSac;

    public SacADos(double poids) {
        poidsMax = poids;
        poidsSac = 0.0;
    }

    public SacADos() {
        poidsSac = 0.0;
    }

    public double valeurTotal(){
        double val = 0;
        for(Objet o : objetsSelectionne){
            val += o.getVi();
        }
        return val;
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

    /***
     * Permet d'ajouter un objet dans le sac s'il y a assez de place
     */
    public void ajouter(Objet objet) {
        if (objet.getPi() + this.poidsSac <= this.poidsMax) {
            this.objetsSelectionne.add(objet);
            this.poidsSac += objet.getPi();
        }
    }


    @Override
    public String toString() {
        double valeurTotal = 0;
        System.out.println("Objets selectionné mis dans le sac : \n");
        for (int i = 0; i < objetsSelectionne.size(); ++i) {
            System.out.println(objetsSelectionne.get(i).toString());
            valeurTotal += objetsSelectionne.get(i).getVi();
        }
        System.out.println("\n Poids total  : " + poidsSac + " | Valeur totale :" + valeurTotal);
        return "*";
    }


    /***
     * Permet de vider la liste d'objects selectionnés
     */
    public void vider() {
        this.objetsSelectionne.clear();
        this.poidsSac = 0.0;
    }

}
