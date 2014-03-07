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
//    @ GeneratedValue(strategy = GenerationType.IDENTITY)
    private String numCommande;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateHeure;
    private int nbPersonne;
//    @ ManyToOne
//    private Emplacement table; 
//    @ OneToMany(mappedBy = "serveur")
//    private Collection<Emplacement> tables;

    public Commande() {
//        tables = new ArrayList<>();
    }

    public Commande(String numCommande, Date dateHeure, int nbPersonne) {
        this.numCommande = numCommande;
        this.dateHeure = dateHeure;
        this.nbPersonne = nbPersonne;
    }

    public Commande(Date dateHeure, int nbPersonne) {
        this.dateHeure = dateHeure;
        this.nbPersonne = nbPersonne;
    }    
    
    public String getNumCommande() {
        return numCommande;
    }

    public void setNumCommande(String numCommande) {
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

    @Override
    public String toString() {
        return "Commande n°" + numCommande;
    }
}
