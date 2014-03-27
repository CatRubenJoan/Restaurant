package beanSession;

import beanEntity.Commande;
import beanEntity.LigneCommande;
import beanEntity.Produit;
import beanEntity.TVA;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EJBLigneCommande implements EJBLigneCommandeLocal {

    @PersistenceContext(unitName = "Restaurant-ejbPU")
    private EntityManager em;

    @Override
    public Commande ajoutLigneCommande(String noCommande, int qte, float prixHTLC, String commentaire, String noProduit) {
        int noCom = Integer.parseInt(noCommande);
        Commande enCours = em.find(Commande.class, noCom);
//        em.detach(enCours);
        LigneCommande lc = new LigneCommande(qte, prixHTLC, commentaire);
        //produit
        int noProd = Integer.parseInt(noProduit);
        Produit p = em.find(Produit.class, noProd);
        Collection<LigneCommande> lcs = enCours.getLignesCommande();
        lcs.add(lc);
        lc.setProduit(p);
        lc.setCommande(enCours);
//        TVA vat = new TVA(10f);
//        em.persist(vat);
        lc.setTva(null);
        enCours.setLignesCommande(lcs);
        em.persist(lc);
        em.persist(enCours);
        return enCours;
    }

    @Override
    public Commande modificationLigneCommande(LigneCommande lc2change, LigneCommande lcny) {
        Commande enCours = em.find(Commande.class, lc2change.getCommande().getNumCommande());
        em.detach(enCours);
        Collection<LigneCommande> lcs = enCours.getLignesCommande();
        for (LigneCommande ligneCommande : lcs) {
            if (ligneCommande.equals(lc2change)) {
                lcs.remove(ligneCommande);
                //cas de suppression:qte exprimée 0
                if (lcny.getQte() != 0) {
                    lcs.add(lcny);
                }
            }
        }
        enCours.setLignesCommande(lcs);
        em.persist(enCours);
        return enCours;
    }

    public void persist(Object object) {
        em.persist(object);
    }
}
