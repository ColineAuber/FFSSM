/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static java.util.Optional.empty;

public class Moniteur extends Plongeur {

    public int numeroDiplome;
    public List<Embauche> lesEmbauches;

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau, GroupeSanguin grpS, int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance, niveau, grpS);
        this.numeroDiplome = numeroDiplome;
        this.lesEmbauches = new ArrayList<Embauche>();
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est
     * terminée, ce moniteur n'a pas d'employeur.
     *
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel() {
        Embauche laDerniereEmbauche = lesEmbauches.get(lesEmbauches.size() - 1);
        if (lesEmbauches.isEmpty()) {
            return empty();
        } else if (laDerniereEmbauche.estTerminee()) {
            return empty();
        } else {
            Club leDernierEmployeur = laDerniereEmbauche.getEmployeur();
            return Optional.ofNullable(leDernierEmployeur);
        }
    }

    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     *
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) throws Exception {
        Embauche laDerniereEmbauche = lesEmbauches.get(lesEmbauches.size() - 1);
        if(laDerniereEmbauche.estTerminee()){
        Embauche embauche = new Embauche(debutNouvelle, this, employeur);
        lesEmbauches.add(embauche);
        }else{
            throw new Exception("Un moniteur ne peut avoir qu'une embauche à la fois.");
        }
    }

    public List<Embauche> emplois() {
        return lesEmbauches;
    }

    @Override
    public String toString() {
        return "Moniteur{" + super.toString() + ", numeroDiplome=" + numeroDiplome + ", lesEmbauches=" + lesEmbauches + '}';
    }
    
    public void terminerEmbauche(LocalDate fin){
        Embauche laDerniereEmbauche = lesEmbauches.get(lesEmbauches.size() - 1);
        laDerniereEmbauche.terminer(fin);
    }
    

}
