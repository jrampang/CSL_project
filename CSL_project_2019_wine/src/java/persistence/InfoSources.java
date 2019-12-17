/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jrampang
 */
@Entity
@Table(name = "INFO_SOURCES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InfoSources.findAll", query = "SELECT i FROM InfoSources i")
    , @NamedQuery(name = "InfoSources.findByInfoSourceId", query = "SELECT i FROM InfoSources i WHERE i.infoSourceId = :infoSourceId")
    , @NamedQuery(name = "InfoSources.findByInfoSourceDescription", query = "SELECT i FROM InfoSources i WHERE i.infoSourceDescription = :infoSourceDescription")})
public class InfoSources implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "INFO_SOURCE_ID")
    private String infoSourceId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "INFO_SOURCE_DESCRIPTION")
    private String infoSourceDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infoSourceId")
    private Collection<Wine> wineCollection;

    public InfoSources() {
    }

    public InfoSources(String infoSourceId) {
        this.infoSourceId = infoSourceId;
    }

    public InfoSources(String infoSourceId, String infoSourceDescription) {
        this.infoSourceId = infoSourceId;
        this.infoSourceDescription = infoSourceDescription;
    }

    public String getInfoSourceId() {
        return infoSourceId;
    }

    public void setInfoSourceId(String infoSourceId) {
        this.infoSourceId = infoSourceId;
    }

    public String getInfoSourceDescription() {
        return infoSourceDescription;
    }

    public void setInfoSourceDescription(String infoSourceDescription) {
        this.infoSourceDescription = infoSourceDescription;
    }

    @XmlTransient
    public Collection<Wine> getWineCollection() {
        return wineCollection;
    }

    public void setWineCollection(Collection<Wine> wineCollection) {
        this.wineCollection = wineCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (infoSourceId != null ? infoSourceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InfoSources)) {
            return false;
        }
        InfoSources other = (InfoSources) object;
        if ((this.infoSourceId == null && other.infoSourceId != null) || (this.infoSourceId != null && !this.infoSourceId.equals(other.infoSourceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.InfoSources[ infoSourceId=" + infoSourceId + " ]";
    }
    
}
