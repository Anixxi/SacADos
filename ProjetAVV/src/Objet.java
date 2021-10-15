
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

    public String getNom() {
        return nom;
    }

    public double getVi() {
        return Vi;
    }

    public double getPi() {
        return Pi;
    }

    public double rapport(){
        return this.Vi/this.Pi;
    }

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
