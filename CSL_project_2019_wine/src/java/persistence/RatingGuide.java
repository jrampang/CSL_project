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
@Table(name = "RATING_GUIDE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RatingGuide.findAll", query = "SELECT r FROM RatingGuide r")
    , @NamedQuery(name = "RatingGuide.findByRatingId", query = "SELECT r FROM RatingGuide r WHERE r.ratingId = :ratingId")
    , @NamedQuery(name = "RatingGuide.findByRatingDescription", query = "SELECT r FROM RatingGuide r WHERE r.ratingDescription = :ratingDescription")})
public class RatingGuide implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "RATING_ID")
    private String ratingId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "RATING_DESCRIPTION")
    private String ratingDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ratingId")
    private Collection<Wine> wineCollection;
    @JoinColumn(name = "COLOUR", referencedColumnName = "COLOUR")
    @ManyToOne(optional = false)
    private WineColours colour;

    public RatingGuide() {
    }

    public RatingGuide(String ratingId) {
        this.ratingId = ratingId;
    }

    public RatingGuide(String ratingId, String ratingDescription) {
        this.ratingId = ratingId;
        this.ratingDescription = ratingDescription;
    }

    public String getRatingId() {
        return ratingId;
    }

    public void setRatingId(String ratingId) {
        this.ratingId = ratingId;
    }

    public String getRatingDescription() {
        return ratingDescription;
    }

    public void setRatingDescription(String ratingDescription) {
        this.ratingDescription = ratingDescription;
    }

    @XmlTransient
    public Collection<Wine> getWineCollection() {
        return wineCollection;
    }

    public void setWineCollection(Collection<Wine> wineCollection) {
        this.wineCollection = wineCollection;
    }

    public WineColours getColour() {
        return colour;
    }

    public void setColour(WineColours colour) {
        this.colour = colour;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ratingId != null ? ratingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RatingGuide)) {
            return false;
        }
        RatingGuide other = (RatingGuide) object;
        if ((this.ratingId == null && other.ratingId != null) || (this.ratingId != null && !this.ratingId.equals(other.ratingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.RatingGuide[ ratingId=" + ratingId + " ]";
    }
    
}
