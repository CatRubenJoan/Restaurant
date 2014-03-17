package beanSession;

import beanEntity.Commande;
import beanEntity.Emplacement;
import beanEntity.LigneCommande;
import beanEntity.Produit;
import beanEntity.Serveur;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EJBCommande implements EJBCommandeLocal {

    @PersistenceContext(unitName = "Restaurant-ejbPU")
    private EntityManager em;

//        Commande c = new Commande(new GregorianCalendar().getInstance().getTime(), noCommande);
    
    @Override
    public boolean ajoutPlatCommande(Commande c, Produit p, int qte, String commentaire) {

        boolean platOK = false;
        ArrayList<LigneCommande> lcExistantes = (ArrayList) c.getLignesCommande();

        LigneCommande lc = new LigneCommande(qte, commentaire);
        lc.setCommande(c);
        lc.setProduit(p);
        lc.setPrixHTLC(p.getPrixHt() * qte);

        if (!lcExistantes.isEmpty()) {
            for (LigneCommande lcom : lcExistantes) {
                if (p.equals(lcom.getProduit())) {
                    if (qte == lcom.getQte()) {
                        platOK = false;
                    } else {
                        lcom.setQte(qte); //verifier remplacement de valeurs dans collection
                        platOK = true;
                    }
                } else {
                    lcExistantes.add(lc);
                    platOK = true;
                }
            }
        } else {
            //initialiser collection ligne commande
            ArrayList<LigneCommande> lcInit = new ArrayList<>();
            lcInit.add(lc);
            c.setLignesCommande(lcInit);
            platOK = true;
        }
        return platOK;
    }

    /*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ TESTS @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
    @Override
    public boolean creerTable(int capacite, String codeIHM) {
        Emplacement emp = new Emplacement(capacite, codeIHM);
        em.persist(emp);
        return true;
    }

    @Override
    public boolean creerTableWServeur(int capacite, String codeIHM, String noServeur) {
        Emplacement emp = new Emplacement(capacite, codeIHM);
        Serveur ser = em.find(Serveur.class, noServeur);
        emp.setServeur(ser);
//        Collection<Emplacement> al = new ArrayList<>();
//        al.add(emp);
//        ser.setTables(al);
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
    public float reglementCommande(int noCommandeARegler, int montant) {

//        Commande aRegler = em.find
        return 0f;
    }
}
