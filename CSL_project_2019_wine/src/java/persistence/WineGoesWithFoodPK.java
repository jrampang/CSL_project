/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jrampang
 */
@Embeddable
public class WineGoesWithFoodPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FOOD_NAME")
    private String foodName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "WINE_ID")
    private String wineId;

    public WineGoesWithFoodPK() {
    }

    public WineGoesWithFoodPK(String foodName, String wineId) {
        this.foodName = foodName;
        this.wineId = wineId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getWineId() {
        return wineId;
    }

    public void setWineId(String wineId) {
        this.wineId = wineId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foodName != null ? foodName.hashCode() : 0);
        hash += (wineId != null ? wineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WineGoesWithFoodPK)) {
            return false;
        }
        WineGoesWithFoodPK other = (WineGoesWithFoodPK) object;
        if ((this.foodName == null && other.foodName != null) || (this.foodName != null && !this.foodName.equals(other.foodName))) {
            return false;
        }
        if ((this.wineId == null && other.wineId != null) || (this.wineId != null && !this.wineId.equals(other.wineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.WineGoesWithFoodPK[ foodName=" + foodName + ", wineId=" + wineId + " ]";
    }
    
}
