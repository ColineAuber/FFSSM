/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FFSSM;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author jenie
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Plongeur p1 = new Plongeur("38-2-33-546", "Auber", "Thierry", "67 rue des Cloiseaux", "0654237855", LocalDate.of(1960, 8, 15), 3, GroupeSanguin.AMOINS);
        Plongeur p2 = new Plongeur("39-2-33-526", "Auber", "Jules", "67 rue des Cloiseaux", "0665981256", LocalDate.of(2001, 9, 02), 1, GroupeSanguin.APLUS);

        Moniteur m1 = new Moniteur("34-0-45-766", "Dupe", "Cassandra", "54 rue des Moines", "0634987704", LocalDate.of(1999, 3, 22), 5, GroupeSanguin.BPLUS, 26789);
        Moniteur m2 = new Moniteur("24-8-39-099", "Dupe", "Thomas", "54 rue des Moines", "0622896654", LocalDate.of(1996, 5, 11), 4, GroupeSanguin.BMOINS, 52898);

        Club c1 = new Club(m1, "Les raies", "0145783354");

        Licence l1 = new Licence(p1, "56198G", LocalDate.of(2022, 06, 1), c1);
        
        Site s1 = new Site("Le bateau", "C joli");

        Plongee plo1 = new Plongee(s1, m2, LocalDate.of(2022, 12, 13), 23, 2);

        m1.nouvelleEmbauche(c1, LocalDate.of(2021, 05, 21));
        m2.nouvelleEmbauche(c1, LocalDate.of(2022, 05, 22));

        p1.ajouerLicence(l1);

        System.out.println("Le président du club est : " + c1.getPresident());
        System.out.println("Les plongées non conformes sont :" + c1.plongeesNonConformes());

        c1.organisePlongee(plo1);

        plo1.ajouteParticipant(p2);
        plo1.ajouteParticipant(p1);
    }

}
