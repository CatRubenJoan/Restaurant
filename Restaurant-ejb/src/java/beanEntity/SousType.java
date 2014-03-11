/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author cdi412
 */
@Entity
public class SousType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String infoSousType;
    @OneToMany(mappedBy = "sousType")
    private Collection<Produit> lesProduits;
    @ManyToOne
    private Type type;

    public SousType() {
        lesProduits = new ArrayList();
    }

    public SousType(String id, String infoSousType, Type type) {
        this();
        this.id = id;
        this.infoSousType = infoSousType;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInfoSousType() {
        return infoSousType;
    }

    public void setInfoSousType(String infoSousType) {
        this.infoSousType = infoSousType;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SousType)) {
            return false;
        }
        SousType other = (SousType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanEntity.SousType[ id=" + id + " ]";
    }
    
}
