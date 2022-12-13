/**
 * @(#) Club.java
 */
package FFSSM;

import java.util.HashSet;
import java.util.Set;

public class Club {
    private HashSet<Plongee> lesPlongees ;
 
    public Moniteur president;

    public String nom;

    public String adresse;

    public String telephone;

    public Club(Moniteur president, String nom, String telephone) {
        this.lesPlongees = new HashSet<Plongee>();
        this.president = president;
        this.nom = nom;
        this.telephone = telephone;
    }

    /**
     * Calcule l'ensemble des plongées non conformes organisées par ce club.
     * Une plongée est conforme si tous les plongeurs de la palanquée ont une licence
     * valide à la date de la plongée
     * @return l'ensemble des plongées non conformes
     */
    public Set<Plongee> plongeesNonConformes() throws Exception {
        Set<Plongee> lesPlongeesNonConformes = new HashSet<Plongee>();
        for(Plongee p : lesPlongees){
            if(!p.estConforme()){
                lesPlongeesNonConformes.add(p);
            }
        }
        if(lesPlongeesNonConformes.isEmpty()){
            throw new Exception("Il n'y a pas de plongées non conformes");
        }
        return lesPlongeesNonConformes;
    }

    /**
     * Enregistre une nouvelle plongée organisée par ce club
     * @param p la nouvelle plongée
     */
    public void organisePlongee(Plongee p) {
        lesPlongees.add(p);
    }
    
    
    public Moniteur getPresident() {
        return president;
    }

    public void setPresident(Moniteur président) {
        this.president = président;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Club{" + "président=" + president + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + '}';
    }

}
