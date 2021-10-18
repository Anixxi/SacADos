public class ABR {

    private ABR filsG, filsD;
    private final ABR parent;
    private final int profondeur;
    private int indice;
    private double valeur;
    private double poids;


    public ABR() {
        this.parent = this;
        this.profondeur = 0;
        this.valeur = 0.0;
        this.poids = 0.0;
    }

    public ABR(int indice, ABR parent, double val, double poids) {
        this.parent = parent;
        this.profondeur = parent.profondeur + 1;
        this.valeur = val;
        this.poids = poids;
        this.indice = indice;
    }

    public ABR getFilsG() {
        return filsG;
    }

    /***
     * Permet de créer un fils gauche
     */
    public void CreerFilsG(int indice, Objet o) {
        this.filsG = new ABR(indice,this, this.valeur + o.getVi(), this.poids + o.getPi() );
    }

    public ABR getFilsD() {
        return filsD;
    }

    /***
     * Permet de créer un fils droit
     */
    public void CreerFilsD() {
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
