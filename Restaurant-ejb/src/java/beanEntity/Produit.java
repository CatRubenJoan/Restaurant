/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEntity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author cdi412
 */
@Entity
public class Produit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String reference;
    @Column
    private String nom;
    private String composition;
    private String qualiteNutritive;
    private String historique;
    private boolean disponibilite;
    private float prixHt;
    @ManyToOne
    private Statut infoStatut;
    @ManyToOne
    @JoinColumn(name = "cuisinier_ID", nullable = true)
    private Cuisinier cuisto;
    @ManyToOne
    @JoinColumn(name = "promo_ID", nullable = true)
    private Promotion promo;
    @ManyToOne
    private SousType sousType;

    public Produit() {
        infoStatut = new Statut("AUCUN", "Aucun");
        cuisto = null;
    }

    public Produit(String nom, String composition, String qualiteNutritive, String historique, boolean disponibilite, float prixHt) {
        this();
        this.nom = nom;
        this.composition = composition;
        this.qualiteNutritive = qualiteNutritive;
        this.historique = historique;
        this.disponibilite = disponibilite;
        this.prixHt = prixHt;
    }

    public Produit(String reference, String nom, String composition, String qualiteNutritive, String historique, boolean disponibilite, float prixHt, SousType sousType) {
        this();
        this.reference = reference;
        this.nom = nom;
        this.composition = composition;
        this.qualiteNutritive = qualiteNutritive;
        this.historique = historique;
        this.disponibilite = disponibilite;
        this.prixHt = prixHt;
        this.sousType = sousType;
    }

    

    public Cuisinier getCuisto() {
        return cuisto;
    }

    public void setCuisto(Cuisinier cuisto) {
        this.cuisto = cuisto;
    }

    public Statut getInfoStatut() {
        return infoStatut;
    }

    public void setInfoStatut(Statut infoStatut) {
        this.infoStatut = infoStatut;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String ref) {
        this.reference = ref;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getQualiteNutritive() {
        return qualiteNutritive;
    }

    public void setQualiteNutritive(String qualiteNutritive) {
        this.qualiteNutritive = qualiteNutritive;
    }

    public String getHistorique() {
        return historique;
    }

    public void setHistorique(String historique) {
        this.historique = historique;
    }

    public boolean isDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public float getPrixHt() {
        return prixHt;
    }

    public void setPrixHt(float prixHt) {
        this.prixHt = prixHt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reference != null ? reference.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.reference == null && other.reference != null) || (this.reference != null && !this.reference.equals(other.reference))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanEntity.Produit[ ref=" + reference + " ]";
    }
}
