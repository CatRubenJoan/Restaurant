package beanEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class Commande implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @ GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numCommande;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateHeure;
    private int nbPersonne;
    @ ManyToOne
    private Emplacement table; 
    @ OneToMany(mappedBy = "commandeReglee")
    private Collection<Paiement> paiements;
    @ OneToMany(mappedBy = "commande")
    private Collection<LigneCommande>lignesCommande;
    
    public Commande() {
        paiements = new ArrayList<>();
        lignesCommande = new ArrayList<>();
    }

    public Commande(int numCommande, Date dateHeure, int nbPersonne) {
        this.numCommande = numCommande;
        this.dateHeure = dateHeure;
        this.nbPersonne = nbPersonne;
    }

    public Commande(Date dateHeure, int nbPersonne) {
        this.dateHeure = dateHeure;
        this.nbPersonne = nbPersonne;
    }    
    
    public int getNumCommande() {
        return numCommande;
    }

    public void setNumCommande(int numCommande) {
        this.numCommande = numCommande;
    }

    public Date getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Date dateHeure) {
        this.dateHeure = dateHeure;
    }

    public int getNbPersonne() {
        return nbPersonne;
    }

    public void setNbPersonne(int nbPersonne) {
        this.nbPersonne = nbPersonne;
    }

    public Emplacement getTable() {
        return table;
    }

    public void setTable(Emplacement table) {
        this.table = table;
    }

    public Collection<Paiement> getPaiements() {
        return paiements;
    }

    public void setPaiements(Collection<Paiement> paiements) {
        this.paiements = paiements;
    }

    public Collection<LigneCommande> getLignesCommande() {
        return lignesCommande;
    }

    public void setLignesCommande(Collection<LigneCommande> lignesCommande) {
        this.lignesCommande = lignesCommande;
    }

    @Override
    public String toString() {
        return "Commande n°" + numCommande + "\n\t Table : "+table;
    }
}
