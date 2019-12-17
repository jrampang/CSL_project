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
@Table(name = "WINE_COLOURS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WineColours.findAll", query = "SELECT w FROM WineColours w")
    , @NamedQuery(name = "WineColours.findByColour", query = "SELECT w FROM WineColours w WHERE w.colour = :colour")})
public class WineColours implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "COLOUR")
    private String colour;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colour")
    private Collection<Wine> wineCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colour")
    private Collection<RatingGuide> ratingGuideCollection;

    public WineColours() {
    }

    public WineColours(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @XmlTransient
    public Collection<Wine> getWineCollection() {
        return wineCollection;
    }

    public void setWineCollection(Collection<Wine> wineCollection) {
        this.wineCollection = wineCollection;
    }

    @XmlTransient
    public Collection<RatingGuide> getRatingGuideCollection() {
        return ratingGuideCollection;
    }

    public void setRatingGuideCollection(Collection<RatingGuide> ratingGuideCollection) {
        this.ratingGuideCollection = ratingGuideCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (colour != null ? colour.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WineColours)) {
            return false;
        }
        WineColours other = (WineColours) object;
        if ((this.colour == null && other.colour != null) || (this.colour != null && !this.colour.equals(other.colour))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.WineColours[ colour=" + colour + " ]";
    }
    
}
