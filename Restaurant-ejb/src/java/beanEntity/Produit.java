/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEntity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author cdi412
 */
@Entity
public class Produit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String reference;
    @Column
    String nom;
    String composition;
    String qualiteNutritive;
    String historique;
    boolean disponibilite;
    float prixHt;

    public Produit() {
    }
    
    public Produit(String nom, String composition, String qualiteNutritive, String historique, boolean disponibilite, float prixHt) {
        this.nom = nom;
        this.composition = composition;
        this.qualiteNutritive = qualiteNutritive;
        this.historique = historique;
        this.disponibilite = disponibilite;
        this.prixHt = prixHt;
    }

    public Produit(String reference, String nom, String composition, String qualiteNutritive, String historique, boolean disponibilite, float prixHt) {
        this.reference = reference;
        this.nom = nom;
        this.composition = composition;
        this.qualiteNutritive = qualiteNutritive;
        this.historique = historique;
        this.disponibilite = disponibilite;
        this.prixHt = prixHt;
    }
    
    public String getReference() {
        return reference;
    }

    public void setReference(String ref) {
        this.reference = reference;
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
