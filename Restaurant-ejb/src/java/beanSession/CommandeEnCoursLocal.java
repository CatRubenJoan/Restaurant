<<<<<<< HEAD
package beanSession;

import java.util.Date;
import javax.ejb.Local;

@Local
public interface CommandeEnCoursLocal {

    public boolean creerCommandeBidon(Date dateHeure, int nbPersonne);

    public boolean creerCommandeBidonWTable(Date dateHeure, int nbPersonne, int noTable);

    public boolean creerTable(int capacite, String codeIHM);

    public boolean creerServeur(String codeIHM, String nom);

    public boolean creerTableWServeur(int capacite, String codeIHM, String noServeur);

    public float reglementCommande(int noCommandeARegler, int montant);

    public boolean ajouterProduit(int noCommande, Integer noProduit, int qte, String commentaire);
}
=======
package beanSession;

import java.util.Date;
import javax.ejb.Local;

@Local
public interface CommandeEnCoursLocal {

    public boolean creerCommandeBidon(Date dateHeure, int nbPersonne);

    public boolean creerCommandeBidonWTable(Date dateHeure, int nbPersonne, int noTable);

    public boolean creerTable(int capacite, String codeIHM);

    public boolean creerServeur(String codeIHM, String nom);

    public boolean creerTableWServeur(int capacite, String codeIHM, String noServeur);

    public float reglementCommande(int noCommandeARegler, int montant);

    public boolean ajouterProduit(int noCommande, Integer noProduit, int qte, String commentaire);
}
>>>>>>> 704ae19452976f42c3d3b36aa187ad2dd7f58f7f
