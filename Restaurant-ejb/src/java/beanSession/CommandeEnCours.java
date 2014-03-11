package beanSession;

import beanEntity.Commande;
import beanEntity.Emplacement;
import beanEntity.LigneCommande;
import beanEntity.Produit;
import beanEntity.Serveur;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CommandeEnCours implements CommandeEnCoursLocal {

    @PersistenceContext(unitName = "Restaurant-ejbPU")
    private EntityManager em;

    @Override
    public boolean creerTable(int capacite, String codeIHM) {
        Emplacement emp = new Emplacement(capacite, codeIHM);
        em.persist(emp);
        return true;
    }

    @Override
    public boolean creerTableWServeur(int capacite, String codeIHM, String noServeur) {
        Emplacement emp = new Emplacement(capacite, codeIHM);
        emp.setServeur(em.find(Serveur.class, noServeur));
        em.persist(emp);
        return true;
    }

    @Override
    public boolean creerServeur(String codeIHM, String nom) {
        boolean test = false;
        if (em.find(Serveur.class, codeIHM) == null) {
            Serveur s = new Serveur(codeIHM, nom);
            em.persist(s);
            test = true;
        }
        return test;
    }

    @Override
    public boolean creerCommandeBidon(Date dateHeure, int nbPersonne) {
        Commande c = new Commande(dateHeure, nbPersonne);
        em.persist(c);
        return true;
    }

    @Override
    public boolean creerCommandeBidonWTable(Date dateHeure, int nbPersonne, int noTable) {
        Commande c = new Commande(dateHeure, nbPersonne);
        c.setTable(em.find(Emplacement.class, noTable));
        em.persist(c);
        return true;
    }
    
    @Override
    public boolean ajouterProduit(int noCommande, Integer noProduit, int qte, String commentaire){
        
        LigneCommande lc = new LigneCommande(qte, commentaire);        
        
        lc.setCommande(em.find(Commande.class, noCommande));
        
        lc.setProduit(em.find(Produit.class, noProduit));
        
        lc.setPrixHTLC((lc.getProduit().getPrixHt())*lc.getQte());
                
        return true;
    }
    
    
    @Override
    public float reglementCommande(int noCommandeARegler, int montant){
        
//        Commande aRegler = em.find
        return 0f;
    }
    
}
