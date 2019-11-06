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
@Table(name = "WINE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wine.findAll", query = "SELECT w FROM Wine w")
    , @NamedQuery(name = "Wine.findByWineId", query = "SELECT w FROM Wine w WHERE w.wineId = :wineId")
    , @NamedQuery(name = "Wine.findByWineName", query = "SELECT w FROM Wine w WHERE w.wineName = :wineName")
    , @NamedQuery(name = "Wine.findByWineDescription", query = "SELECT w FROM Wine w WHERE w.wineDescription = :wineDescription")
    , @NamedQuery(name = "Wine.findByLabelPictureFilename", query = "SELECT w FROM Wine w WHERE w.labelPictureFilename = :labelPictureFilename")
    , @NamedQuery(name = "Wine.findByGoodYears", query = "SELECT w FROM Wine w WHERE w.goodYears = :goodYears")
    , @NamedQuery(name = "Wine.findByPriceBottle", query = "SELECT w FROM Wine w WHERE w.priceBottle = :priceBottle")
    , @NamedQuery(name = "Wine.findByPriceHalfBottle", query = "SELECT w FROM Wine w WHERE w.priceHalfBottle = :priceHalfBottle")})
public class Wine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "WINE_ID")
    private String wineId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "WINE_NAME")
    private String wineName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "WINE_DESCRIPTION")
    private String wineDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LABEL_PICTURE_FILENAME")
    private String labelPictureFilename;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "GOOD_YEARS")
    private String goodYears;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE_BOTTLE")
    private float priceBottle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE_HALF_BOTTLE")
    private float priceHalfBottle;
    @JoinColumn(name = "INFO_SOURCE_ID", referencedColumnName = "INFO_SOURCE_ID")
    @ManyToOne(optional = false)
    private InfoSources infoSourceId;
    @JoinColumn(name = "RATING_ID", referencedColumnName = "RATING_ID")
    @ManyToOne(optional = false)
    private RatingGuide ratingId;
    @JoinColumn(name = "WINEMAKER_ID", referencedColumnName = "WINEMAKER_ID")
    @ManyToOne(optional = false)
    private Winemaker winemakerId;
    @JoinColumn(name = "COLOUR", referencedColumnName = "COLOUR")
    @ManyToOne(optional = false)
    private WineColours colour;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wine")
    private Collection<WineGoesWithFood> wineGoesWithFoodCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wine")
    private Collection<WineAtMerchants> wineAtMerchantsCollection;

    public Wine() {
    }

    public Wine(String wineId) {
        this.wineId = wineId;
    }

    public Wine(String wineId, String wineName, String wineDescription, String labelPictureFilename, String goodYears, float priceBottle, float priceHalfBottle) {
        this.wineId = wineId;
        this.wineName = wineName;
        this.wineDescription = wineDescription;
        this.labelPictureFilename = labelPictureFilename;
        this.goodYears = goodYears;
        this.priceBottle = priceBottle;
        this.priceHalfBottle = priceHalfBottle;
    }

    public String getWineId() {
        return wineId;
    }

    public void setWineId(String wineId) {
        this.wineId = wineId;
    }

    public String getWineName() {
        return wineName;
    }

    public void setWineName(String wineName) {
        this.wineName = wineName;
    }

    public String getWineDescription() {
        return wineDescription;
    }

    public void setWineDescription(String wineDescription) {
        this.wineDescription = wineDescription;
    }

    public String getLabelPictureFilename() {
        return labelPictureFilename;
    }

    public void setLabelPictureFilename(String labelPictureFilename) {
        this.labelPictureFilename = labelPictureFilename;
    }

    public String getGoodYears() {
        return goodYears;
    }

    public void setGoodYears(String goodYears) {
        this.goodYears = goodYears;
    }

    public float getPriceBottle() {
        return priceBottle;
    }

    public void setPriceBottle(float priceBottle) {
        this.priceBottle = priceBottle;
    }

    public float getPriceHalfBottle() {
        return priceHalfBottle;
    }

    public void setPriceHalfBottle(float priceHalfBottle) {
        this.priceHalfBottle = priceHalfBottle;
    }

    public InfoSources getInfoSourceId() {
        return infoSourceId;
    }

    public void setInfoSourceId(InfoSources infoSourceId) {
        this.infoSourceId = infoSourceId;
    }

    public RatingGuide getRatingId() {
        return ratingId;
    }

    public void setRatingId(RatingGuide ratingId) {
        this.ratingId = ratingId;
    }

    public Winemaker getWinemakerId() {
        return winemakerId;
    }

    public void setWinemakerId(Winemaker winemakerId) {
        this.winemakerId = winemakerId;
    }

    public WineColours getColour() {
        return colour;
    }

    public void setColour(WineColours colour) {
        this.colour = colour;
    }

    @XmlTransient
    public Collection<WineGoesWithFood> getWineGoesWithFoodCollection() {
        return wineGoesWithFoodCollection;
    }

    public void setWineGoesWithFoodCollection(Collection<WineGoesWithFood> wineGoesWithFoodCollection) {
        this.wineGoesWithFoodCollection = wineGoesWithFoodCollection;
    }

    @XmlTransient
    public Collection<WineAtMerchants> getWineAtMerchantsCollection() {
        return wineAtMerchantsCollection;
    }

    public void setWineAtMerchantsCollection(Collection<WineAtMerchants> wineAtMerchantsCollection) {
        this.wineAtMerchantsCollection = wineAtMerchantsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wineId != null ? wineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wine)) {
            return false;
        }
        Wine other = (Wine) object;
        if ((this.wineId == null && other.wineId != null) || (this.wineId != null && !this.wineId.equals(other.wineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.Wine[ wineId=" + wineId + " ]";
    }
    
}
