package beanEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Paiement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numFacture;
    private String nomClient;
    private float montantParMoyenTTC;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateHeure;
    @ManyToOne
    private Commande commandeReglee;
    @ManyToOne
    private MoyenPaiement moyenpaiements;

    public Paiement() {
        
    }

    public MoyenPaiement getMoyenpaiements() {
        return moyenpaiements;
    }

    public void setMoyenpaiements(MoyenPaiement moyenpaiements) {
        this.moyenpaiements = moyenpaiements;
    }

    public Paiement(String nomClient, float montantParMoyenTTC, Date dateHeure) {
        this();
        this.nomClient = nomClient;
        this.montantParMoyenTTC = montantParMoyenTTC;
        this.dateHeure = dateHeure;
    }
    
    public int getNumFacture() {
        return numFacture;
    }

    public void setNumFacture(int numFacture) {
        this.numFacture = numFacture;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public float getMontantParMoyenTTC() {
        return montantParMoyenTTC;
    }

    public void setMontantParMoyenTTC(float montantParMoyenTTC) {
        this.montantParMoyenTTC = montantParMoyenTTC;
    }

    public Date getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Date dateHeure) {
        this.dateHeure = dateHeure;
    }

    public Commande getCommandeReglee() {
        return commandeReglee;
    }

    public void setCommandeReglee(Commande commandeReglee) {
        this.commandeReglee = commandeReglee;
    }

//    public MoyenPaiement getMoyenpaiements() {
//        return moyenpaiements;
//    }
//
//    public void setMoyenpaiements(MoyenPaiement moyenpaiements) {
//        this.moyenpaiements = moyenpaiements;
//    }

    @Override
    public String toString() {
        return "Paiement n°" + numFacture;
    }
}
