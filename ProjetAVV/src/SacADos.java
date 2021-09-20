public class SacADos {
	    Objet[] objet;
	    
	    final int poidsMax = 30;


	    public SacADos() {
	    	this.objet = new Objet[3];
	    	
	    }

	    public SacADos(String chemin, float poidsMax) {

	    }

	   
	    
	    static void échangerÉléments(Objet[] t, int m, int n) {
	        Objet temp = t[m];

	        t[m] = t[n];
	        t[n] = temp;
	      }

	      static int partition(Objet[] t, int premierEl, int n) {
	        double v = rapport(t[premierEl]);                 // valeur pivot
	        int i = premierEl-1;
	        int j = n+1;                  // indice final du pivot

	        while (true) {
	          do {
	            j--;
	          } while (rapport(t[j]) > v);
	          do {
	            i++;
	          } while (rapport(t[i]) < v);
	          if (i<j) {
	            échangerÉléments(t, i, j);
	          } else {
	            return j;
	          }
	        }
	      }

	      static void triRapide(Objet[] t, int m, int n) {
	        if (m<n) {
	          int p = partition(t, m, n);
	          triRapide(t, m, p);
	          triRapide(t, p+1, n);
	        }
	      }

	    public static double rapport(Objet objet){
	        return objet.getValeur()/objet.getPoids();
	    }

	    public static void resoudreGloutonne(Objet[] objet){
	    	triRapide(objet, 0, 3);
	    }
	    
	    public String toString() {
			for(int i = 0; i < objet.length ; ++i) {
				 System.out.println(objet[i].toString());
			}
			return "*";
		}
	    public static void main(String[] args) {
			SacADos sac1 = new SacADos();
			sac1.objet[0] = new Objet("Couteau Suisse", 50.0, 10.0);
		    sac1.objet[1] = new Objet("Lampe Torche", 10.0, 15.0);
		    sac1.objet[2] = new Objet("Trousse", 20.0, 5.0);
		    sac1.toString();
		    resoudreGloutonne(sac1.objet);
		    sac1.toString();
		}
	    
	}
