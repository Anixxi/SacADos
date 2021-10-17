public class PSE {
    private SacADos s;

    private ABR meilleurSolution;
    private double borneInf;
    private Gloutonne glouton = new Gloutonne(s);

    public PSE(SacADos s) {
        this.s = s;
    }

    public void resoudrePSE() {
        double bornSup = 0;
        for(Objet o : s.objets)
            bornSup += o.getValeur();
        glouton.resoudreGloutonne();
        for(Objet o : s.objetsSelectionne)
            this.borneInf += o.getValeur();

        if(bornSup != s.valeurTotal()){
            ABR racine = new ABR();
            this.meilleurSolution = racine;

            arbreRecherche(0,racine, bornSup);
            s.vider();
            ajoutRecherche(meilleurSolution);


        }
    }

    private void arbreRecherche(int indice, ABR noeud, double maxLimite){
        noeud.setFilsG(indice, s.objets.get(indice));
        noeud.setFilsD();

        if(noeud.getFilsG().getPoids() <= s.poidsMax  &&noeud.getFilsG().getValeur() >= this.borneInf ){
            this.meilleurSolution = noeud.getFilsG();
            this.borneInf = this.meilleurSolution.getValeur();
        }

        if(indice < s.objets.size() - 1 && noeud.getPoids() < s.poidsMax){
            arbreRecherche(indice + 1, noeud.getFilsG(), maxLimite );

            double Max = maxLimite - s.objets.get(indice).getValeur();
            if(Max >= this.borneInf){
                arbreRecherche(indice + 1, noeud.getFilsD(), Max );
            }

        }
    }

    private void ajoutRecherche(ABR meilleurNoeud){
        int k;

        if((k = meilleurNoeud.getIndice()) != -1) {
            s.ajouter(s.objets.get(k));
        }

        if(!meilleurNoeud.noeudRacine()) {
            ajoutRecherche(meilleurNoeud.getParent());
        }
    }




}
