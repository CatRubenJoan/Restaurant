/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author cdi412
 */
@Entity
public class Promotion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private float tauxPromotion;
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @OneToMany(mappedBy = "promo")
    private Collection<Produit> lesProduits;

    public Promotion() {
        lesProduits = new ArrayList();
    }

    public Promotion(float tauxPromotion, Date dateDebut, Date dateFin) {
        this();
        this.tauxPromotion = tauxPromotion;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTauxPromotion() {
        return tauxPromotion;
    }

    public void setTauxPromotion(float tauxPromotion) {
        this.tauxPromotion = tauxPromotion;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Collection<Produit> getLesProduits() {
        return lesProduits;
    }

    public void setLesProduits(Collection<Produit> lesProduits) {
        this.lesProduits = lesProduits;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promotion)) {
            return false;
        }
        Promotion other = (Promotion) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanEntity.Promotion[ id=" + id + " ]";
    }
    
}
