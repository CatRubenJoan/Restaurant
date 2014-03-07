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
public class Statut implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    @Column
    private String infoStatut;

    public Statut() {
    }

    public Statut(String id, String infoStatut) {
        this.id = id;
        this.infoStatut = infoStatut;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInfoStatut() {
        return infoStatut;
    }

    public void setInfoStatut(String infoStatut) {
        this.infoStatut = infoStatut;
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
        if (!(object instanceof Statut)) {
            return false;
        }
        Statut other = (Statut) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanEntity.Statut[ id=" + id + " ]";
    }
    
}
