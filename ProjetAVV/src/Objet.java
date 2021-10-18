
public class Objet implements Comparable<Objet>{
    private String nom;
    private double Vi, Pi;


    public Objet(String inom, double ipoids, double ivaleur) {
        nom = inom;
        Pi = ipoids;
        Vi = ivaleur;
    }

    @Override
    public String toString() {
        return nom + " ; " + "  " + Pi + ";  " + Vi + " " + Vi/Pi ;
    }

    public double getVi() {
        return Vi;
    }

    public double getPi() {
        return Pi;
    }

    /***
     * Permet de calculer le rapport pour chaque object
     */
    public double rapport(){
        return this.Vi/this.Pi;
    }


    /***
     * Permet de comparer un object à un autre
     */
    @Override
    public int compareTo(Objet o) {
        if (this.rapport() > o.rapport())
            return -1;
        else if (this.rapport() < o.rapport())
            return 1;
        else
            return 0;
    }

}
