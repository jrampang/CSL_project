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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "WINEMAKER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Winemaker.findAll", query = "SELECT w FROM Winemaker w")
    , @NamedQuery(name = "Winemaker.findByWinemakerId", query = "SELECT w FROM Winemaker w WHERE w.winemakerId = :winemakerId")
    , @NamedQuery(name = "Winemaker.findByWinemakerName", query = "SELECT w FROM Winemaker w WHERE w.winemakerName = :winemakerName")})
public class Winemaker implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "WINEMAKER_ID")
    private String winemakerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "WINEMAKER_NAME")
    private String winemakerName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "winemakerId")
    private Collection<Wine> wineCollection;
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID")
    @ManyToOne(optional = false)
    private Countries countryId;

    public Winemaker() {
    }

    public Winemaker(String winemakerId) {
        this.winemakerId = winemakerId;
    }

    public Winemaker(String winemakerId, String winemakerName) {
        this.winemakerId = winemakerId;
        this.winemakerName = winemakerName;
    }

    public String getWinemakerId() {
        return winemakerId;
    }

    public void setWinemakerId(String winemakerId) {
        this.winemakerId = winemakerId;
    }

    public String getWinemakerName() {
        return winemakerName;
    }

    public void setWinemakerName(String winemakerName) {
        this.winemakerName = winemakerName;
    }

    @XmlTransient
    public Collection<Wine> getWineCollection() {
        return wineCollection;
    }

    public void setWineCollection(Collection<Wine> wineCollection) {
        this.wineCollection = wineCollection;
    }

    public Countries getCountryId() {
        return countryId;
    }

    public void setCountryId(Countries countryId) {
        this.countryId = countryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (winemakerId != null ? winemakerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Winemaker)) {
            return false;
        }
        Winemaker other = (Winemaker) object;
        if ((this.winemakerId == null && other.winemakerId != null) || (this.winemakerId != null && !this.winemakerId.equals(other.winemakerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.Winemaker[ winemakerId=" + winemakerId + " ]";
    }
    
}
