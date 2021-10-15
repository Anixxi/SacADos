import java.util.Collections;

public class Gloutonne {
    private SacADos s;

    public Gloutonne(SacADos sac) {
        s = sac;
    }


    public void resoudreGloutonne(){


        Collections.sort(s.objets);


        for (int i = 0; i < s.objets.size(); i++) {

            if (s.poidsMax >= s.objets.get(i).getPi() + s.poidsSac) {
                s.objetsSelectionne.add(s.objets.get(i));
                s.poidsSac += s.objets.get(i).getPi();
            }
        }
    }


}
