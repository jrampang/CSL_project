/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jrampang
 */
@Entity
@Table(name = "WINE_AT_MERCHANTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WineAtMerchants.findAll", query = "SELECT w FROM WineAtMerchants w")
    , @NamedQuery(name = "WineAtMerchants.findByWineId", query = "SELECT w FROM WineAtMerchants w WHERE w.wineAtMerchantsPK.wineId = :wineId")
    , @NamedQuery(name = "WineAtMerchants.findByMerchantId", query = "SELECT w FROM WineAtMerchants w WHERE w.wineAtMerchantsPK.merchantId = :merchantId")
    , @NamedQuery(name = "WineAtMerchants.findByOfferStartDate", query = "SELECT w FROM WineAtMerchants w WHERE w.offerStartDate = :offerStartDate")
    , @NamedQuery(name = "WineAtMerchants.findByOfferEndDate", query = "SELECT w FROM WineAtMerchants w WHERE w.offerEndDate = :offerEndDate")
    , @NamedQuery(name = "WineAtMerchants.findByPriceOnOffer", query = "SELECT w FROM WineAtMerchants w WHERE w.priceOnOffer = :priceOnOffer")})
public class WineAtMerchants implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WineAtMerchantsPK wineAtMerchantsPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OFFER_START_DATE")
    @Temporal(TemporalType.DATE)
    private Date offerStartDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OFFER_END_DATE")
    @Temporal(TemporalType.DATE)
    private Date offerEndDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE_ON_OFFER")
    private float priceOnOffer;
    @JoinColumn(name = "MERCHANT_ID", referencedColumnName = "MERCHANT_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Merchants merchants;
    @JoinColumn(name = "WINE_ID", referencedColumnName = "WINE_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Wine wine;

    public WineAtMerchants() {
    }

    public WineAtMerchants(WineAtMerchantsPK wineAtMerchantsPK) {
        this.wineAtMerchantsPK = wineAtMerchantsPK;
    }

    public WineAtMerchants(WineAtMerchantsPK wineAtMerchantsPK, Date offerStartDate, Date offerEndDate, float priceOnOffer) {
        this.wineAtMerchantsPK = wineAtMerchantsPK;
        this.offerStartDate = offerStartDate;
        this.offerEndDate = offerEndDate;
        this.priceOnOffer = priceOnOffer;
    }

    public WineAtMerchants(String wineId, String merchantId) {
        this.wineAtMerchantsPK = new WineAtMerchantsPK(wineId, merchantId);
    }

    public WineAtMerchantsPK getWineAtMerchantsPK() {
        return wineAtMerchantsPK;
    }

    public void setWineAtMerchantsPK(WineAtMerchantsPK wineAtMerchantsPK) {
        this.wineAtMerchantsPK = wineAtMerchantsPK;
    }

    public Date getOfferStartDate() {
        return offerStartDate;
    }

    public void setOfferStartDate(Date offerStartDate) {
        this.offerStartDate = offerStartDate;
    }

    public Date getOfferEndDate() {
        return offerEndDate;
    }

    public void setOfferEndDate(Date offerEndDate) {
        this.offerEndDate = offerEndDate;
    }

    public float getPriceOnOffer() {
        return priceOnOffer;
    }

    public void setPriceOnOffer(float priceOnOffer) {
        this.priceOnOffer = priceOnOffer;
    }

    public Merchants getMerchants() {
        return merchants;
    }

    public void setMerchants(Merchants merchants) {
        this.merchants = merchants;
    }

    public Wine getWine() {
        return wine;
    }

    public void setWine(Wine wine) {
        this.wine = wine;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wineAtMerchantsPK != null ? wineAtMerchantsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WineAtMerchants)) {
            return false;
        }
        WineAtMerchants other = (WineAtMerchants) object;
        if ((this.wineAtMerchantsPK == null && other.wineAtMerchantsPK != null) || (this.wineAtMerchantsPK != null && !this.wineAtMerchantsPK.equals(other.wineAtMerchantsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.WineAtMerchants[ wineAtMerchantsPK=" + wineAtMerchantsPK + " ]";
    }
    
}
