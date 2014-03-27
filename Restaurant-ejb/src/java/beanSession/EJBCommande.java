package beanSession;

import beanEntity.Commande;
import beanEntity.Emplacement;
import beanEntity.LigneCommande;
import beanEntity.Produit;
import beanEntity.Serveur;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EJBCommande implements EJBCommandeLocal {

    @PersistenceContext(unitName = "Restaurant-ejbPU")
    private EntityManager em;

    @Override
    public Commande creationCommande(String nbPersonne, String noTable){
        int notab = Integer.parseInt(noTable);
        int noper = Integer.parseInt(nbPersonne);
        Emplacement table = em.find(Emplacement.class, notab);     
//        Commande c = new Commande(Calendar.getInstance().getTime(), nbPersonne, table);
        Commande c = new Commande(Calendar.getInstance().getTime(), noper, table);
        em.persist(c);
//        em.detach(c);
        return c;
    }

    @Override
    public Commande uneCommande(int noCommande){
        Commande c = em.find(Commande.class, noCommande); 
        em.detach(c);
        return c;
    }
    
    @Override
    public boolean ajoutPlatCommande(Commande c, Produit p, int qte, String commentaire) {
        boolean platOK = false;
        ArrayList<LigneCommande> lcExistantes = (ArrayList) c.getLignesCommande();

        //initialisation ligne de commande en cours de saisie
        LigneCommande lc = new LigneCommande(qte, commentaire);
        lc.setCommande(c);
        lc.setProduit(p);
        lc.setPrixHTLC(p.getPrixHt() * qte);

        //parcours lignes de commande existantes pour une commande
        if (!lcExistantes.isEmpty()) {
            for (LigneCommande lcom : lcExistantes) {
                //test égalité produits
                if (p.equals(lcom.getProduit())) {
                    //test et opérations quantités
                    if (qte == lcom.getQte()) {
                        platOK = false;
                    } else if (qte == 0) {
                        int ind = lcExistantes.indexOf(lcom);
                        LigneCommande annulation = lcExistantes.remove(ind);
                        platOK = true;
                    } else {
                        //a verifier : remplacement de valeurs dans collection
                        lcom.setQte(qte); 
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

    @Override
    public boolean validerCommande(String noCommande) {
        boolean ok = false;
        Commande c = em.find(Commande.class, noCommande);
        if (c != null) {
            ok = true;
        }
        return ok;
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
