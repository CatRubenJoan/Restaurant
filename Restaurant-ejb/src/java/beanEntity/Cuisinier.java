/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author cdi412
 */
@Entity
public class Cuisinier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String codeIHM;
    @Column(nullable = false)
    private String nom;
    @OneToMany(mappedBy = "cuisto")
    private Collection<Produit> lesProduits;

    public Cuisinier() {
        lesProduits = new ArrayList();
    }

    public Cuisinier(String codeIHM, String nom) {
        this();
        this.codeIHM = codeIHM;
        this.nom = nom;
    }

    public Collection<Produit> getLesProduits() {
        return lesProduits;
    }

    public void setLesProduits(Collection<Produit> lesProduits) {
        this.lesProduits = lesProduits;
    }

    public String getCodeIHM() {
        return codeIHM;
    }

    public void setCodeIHM(String codeIHM) {
        this.codeIHM = codeIHM;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeIHM != null ? codeIHM.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuisinier)) {
            return false;
        }
        Cuisinier other = (Cuisinier) object;
        if ((this.codeIHM == null && other.codeIHM != null) || (this.codeIHM != null && !this.codeIHM.equals(other.codeIHM))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanEntity.Cuisinier[ id=" + codeIHM + " ]";
    }
}
