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
import javax.persistence.OneToMany;

/**
 *
 * @author cdi412
 */
@Entity
public class Type implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String infoType;
    @OneToMany(mappedBy = "type")
    private Collection<SousType> lesSousType;

    public Type() {
        lesSousType = new ArrayList();
    }

    public Type(String id, String infoType) {
        this();
        this.id = id;
        this.infoType = infoType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }

    public Collection<SousType> getLesSousType() {
        return lesSousType;
    }

    public void setLesSousType(Collection<SousType> lesSousType) {
        this.lesSousType = lesSousType;
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
        if (!(object instanceof Type)) {
            return false;
        }
        Type other = (Type) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanEntity.Type[ id=" + id + " ]";
    }
    
}
