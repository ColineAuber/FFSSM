package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;

public class Plongeur extends Personne{
    private GroupeSanguin grpS;
    private int niveau;
    private Licence licence;
    private ArrayList<Licence> lesLicences ;

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance,int niveau, GroupeSanguin grpS) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
        this.lesLicences = new ArrayList<Licence>();
        this.grpS = grpS;
    }
    
    public Licence derniereLicence() throws Exception{
        if(lesLicences.isEmpty() == true){
            throw new Exception("Le plongeur n'a pas de licence.");
        }else{
            return lesLicences.get(lesLicences.size()-1);
        }
    }
    
    public void ajouerLicence(Licence l){
        lesLicences.add(l);
    }

    @Override
    public String toString() {
        return "Plongeur{" + super.toString() + ", grpS=" + grpS + ", niveau=" + niveau + ", licence=" + licence + ", lesLicences=" + lesLicences + '}';
    }
    
    
    
}
