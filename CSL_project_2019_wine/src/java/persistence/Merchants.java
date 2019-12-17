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
@Table(name = "MERCHANTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Merchants.findAll", query = "SELECT m FROM Merchants m")
    , @NamedQuery(name = "Merchants.findByMerchantId", query = "SELECT m FROM Merchants m WHERE m.merchantId = :merchantId")
    , @NamedQuery(name = "Merchants.findByMerchantName", query = "SELECT m FROM Merchants m WHERE m.merchantName = :merchantName")})
public class Merchants implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "MERCHANT_ID")
    private String merchantId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MERCHANT_NAME")
    private String merchantName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "merchants")
    private Collection<WineAtMerchants> wineAtMerchantsCollection;

    public Merchants() {
    }

    public Merchants(String merchantId) {
        this.merchantId = merchantId;
    }

    public Merchants(String merchantId, String merchantName) {
        this.merchantId = merchantId;
        this.merchantName = merchantName;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
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
        hash += (merchantId != null ? merchantId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Merchants)) {
            return false;
        }
        Merchants other = (Merchants) object;
        if ((this.merchantId == null && other.merchantId != null) || (this.merchantId != null && !this.merchantId.equals(other.merchantId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "merchantId=" + merchantId + " merchantName=" + merchantName;
    }
    
}
