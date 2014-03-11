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
