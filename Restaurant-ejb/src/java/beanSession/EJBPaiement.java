package beanSession;

import beanEntity.Commande;
import beanEntity.MoyenPaiement;
import beanEntity.Paiement;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EJBPaiement implements EJBPaiementLocal {

    @PersistenceContext(unitName = "Restaurant-ejbPU")
    private EntityManager em;

    @Override
    public Paiement creerPaiement(String nomClient, float montantParMoyenTTC, Date dateHeure, String codePaiement, int numCommande) {

        Paiement p=null;
        if (em.find(MoyenPaiement.class, codePaiement)!=null){
        MoyenPaiement mp = em.find(MoyenPaiement.class, codePaiement);

        p = new Paiement(nomClient, montantParMoyenTTC, dateHeure);
        mp.getPaiements().add(p);
        p.setMoyenpaiements(mp);
        
        Commande c= em.find(Commande.class, numCommande);
        c.getPaiements().add(p);
        p.setCommandeReglee(c);
        
        em.persist(p);
        }
        return p;
    }
}
