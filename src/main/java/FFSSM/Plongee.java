/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Plongee {

	public Site lieu;

	public Moniteur chefDePalanquee;

	public LocalDate date;

	public int profondeur;

	public int duree;
        
        public Set<Plongeur> lesParticipants ;

	public Plongee(Site lieu, Moniteur chefDePalanquee, LocalDate date, int profondeur, int duree) {
		this.lieu = lieu;
		this.chefDePalanquee = chefDePalanquee;
		this.date = date;
		this.profondeur = profondeur;
		this.duree = duree;
                this.lesParticipants = new HashSet<Plongeur>();
	}

	public void ajouteParticipant(Plongeur participant) {
		lesParticipants.add(participant);
	}

	public LocalDate getDate() {
		return date;
	}

	/**
	 * Détermine si la plongée est conforme.Une plongée est conforme si tous les plongeurs de la palanquée ont une
 licence valide à la date de la plongée
	 * @return vrai si la plongée est conforme
     * @throws java.lang.Exception
	 */
	public boolean estConforme() throws Exception {
		for(Plongeur p : lesParticipants){
                    return p.derniereLicence().estValide(date);
                }
                throw new Exception("La liste de participant est vide.");
	}

}
