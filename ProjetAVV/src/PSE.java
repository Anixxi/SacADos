
public class PSE {
    private SacADos s;

    private ABR meilleurSolution;
    private double borneInf;

    public PSE(SacADos s) {
        this.s = s;
    }

    public void resoudrePSE() {
        double bornSup = 0;
        this.borneInf = 0;

        for(Objet o : s.objets)
            bornSup += o.getVi(); // Borne supérieur = la somme des valeurs de touts les objets

        for(Objet o : s.objetsSelectionne)
            this.borneInf += o.getVi(); //Borne inférieur = gloutonne

        if(bornSup != s.valeurTotal()){
            ABR racine = new ABR();
            this.meilleurSolution = racine;

            arbreRecherche(0,racine, bornSup);
            s.vider();
            ajoutRecherche(meilleurSolution);


        }
    }

    /***
     * Permet de créer l'arbre binaires
     * @param indice
     * @param noeud
     * @param maxLimite
     */
    private void arbreRecherche(int indice, ABR noeud, double maxLimite){
        noeud.CreerFilsG(indice, s.objets.get(indice));
        noeud.CreerFilsD();


        if(noeud.getFilsG().getPoids() <= s.poidsMax  && noeud.getFilsG().getValeur() >= this.borneInf ){
            this.meilleurSolution = noeud.getFilsG();
            this.borneInf = this.meilleurSolution.getValeur();
        }

        if(indice < s.objets.size() - 1 && noeud.getPoids() < s.poidsMax){
            arbreRecherche(indice + 1, noeud.getFilsG(), maxLimite );

            double Max = maxLimite - s.objets.get(indice).getVi();
            if(Max >= this.borneInf){
                arbreRecherche(indice + 1, noeud.getFilsD(), Max );
            }

        }
    }

    /***
     * Remonte l'arbre à partir du meilleur noeud récursivement
     * ajoute les objects de la solution trouvée
     */
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
