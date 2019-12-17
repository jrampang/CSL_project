/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jrampang
 */
@Entity
@Table(name = "WINE_GOES_WITH_FOOD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WineGoesWithFood.findAll", query = "SELECT w FROM WineGoesWithFood w")
    , @NamedQuery(name = "WineGoesWithFood.findByFoodName", query = "SELECT w FROM WineGoesWithFood w WHERE w.wineGoesWithFoodPK.foodName = :foodName")
    , @NamedQuery(name = "WineGoesWithFood.findByWineId", query = "SELECT w FROM WineGoesWithFood w WHERE w.wineGoesWithFoodPK.wineId = :wineId")
    , @NamedQuery(name = "WineGoesWithFood.findByComments", query = "SELECT w FROM WineGoesWithFood w WHERE w.comments = :comments")})
public class WineGoesWithFood implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WineGoesWithFoodPK wineGoesWithFoodPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "COMMENTS")
    private String comments;
    @JoinColumn(name = "FOOD_NAME", referencedColumnName = "FOOD_NAME", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Food food;
    @JoinColumn(name = "WINE_ID", referencedColumnName = "WINE_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Wine wine;

    public WineGoesWithFood() {
    }

    public WineGoesWithFood(WineGoesWithFoodPK wineGoesWithFoodPK) {
        this.wineGoesWithFoodPK = wineGoesWithFoodPK;
    }

    public WineGoesWithFood(WineGoesWithFoodPK wineGoesWithFoodPK, String comments) {
        this.wineGoesWithFoodPK = wineGoesWithFoodPK;
        this.comments = comments;
    }

    public WineGoesWithFood(String foodName, String wineId) {
        this.wineGoesWithFoodPK = new WineGoesWithFoodPK(foodName, wineId);
    }

    public WineGoesWithFoodPK getWineGoesWithFoodPK() {
        return wineGoesWithFoodPK;
    }

    public void setWineGoesWithFoodPK(WineGoesWithFoodPK wineGoesWithFoodPK) {
        this.wineGoesWithFoodPK = wineGoesWithFoodPK;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
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
        hash += (wineGoesWithFoodPK != null ? wineGoesWithFoodPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WineGoesWithFood)) {
            return false;
        }
        WineGoesWithFood other = (WineGoesWithFood) object;
        if ((this.wineGoesWithFoodPK == null && other.wineGoesWithFoodPK != null) || (this.wineGoesWithFoodPK != null && !this.wineGoesWithFoodPK.equals(other.wineGoesWithFoodPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.WineGoesWithFood[ wineGoesWithFoodPK=" + wineGoesWithFoodPK + " ]";
    }
    
}
