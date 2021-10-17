public class ABR {

    private ABR filsG, filsD;
    private final ABR parent;
    private final int profondeur;
    private int indice;
    private double valeur;
    private double poids;
    private double borneInf, borneSup;


    public ABR() {
        this.parent = this;
        this.profondeur = 0;
        this.valeur = 0.0;
        this.poids = 0.0;
    }

    public ABR(int indice, ABR parent, double val, double poids) {
        this.parent = this;
        this.profondeur = 0;
        this.valeur = val;
        this.poids = 0.0;
    }

    public ABR getFilsG() {
        return filsG;
    }

    public void setFilsG(int indice, Objet o) {
        this.filsG = new ABR(indice,this, this.valeur + o.getValeur(), this.poids + o.getPi() );
    }

    public ABR getFilsD() {
        return filsD;
    }

    public void setFilsD() {
        this.filsD = new ABR(-1, this, this.valeur, this.poids);
    }

    public ABR getParent() {
        return parent;
    }

    public int getIndice() {
        return indice;
    }

    public double getValeur() {
        return valeur;
    }

    public double getPoids() {
        return poids;
    }

    public boolean noeudRacine(){
        return profondeur == 0 ;
    }
}
