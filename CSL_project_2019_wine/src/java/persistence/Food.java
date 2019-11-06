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
@Table(name = "FOOD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Food.findAll", query = "SELECT f FROM Food f")
    , @NamedQuery(name = "Food.findByFoodName", query = "SELECT f FROM Food f WHERE f.foodName = :foodName")
    , @NamedQuery(name = "Food.findByFoodDescription", query = "SELECT f FROM Food f WHERE f.foodDescription = :foodDescription")})
public class Food implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FOOD_NAME")
    private String foodName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "FOOD_DESCRIPTION")
    private String foodDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "food")
    private Collection<WineGoesWithFood> wineGoesWithFoodCollection;

    public Food() {
    }

    public Food(String foodName) {
        this.foodName = foodName;
    }

    public Food(String foodName, String foodDescription) {
        this.foodName = foodName;
        this.foodDescription = foodDescription;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    @XmlTransient
    public Collection<WineGoesWithFood> getWineGoesWithFoodCollection() {
        return wineGoesWithFoodCollection;
    }

    public void setWineGoesWithFoodCollection(Collection<WineGoesWithFood> wineGoesWithFoodCollection) {
        this.wineGoesWithFoodCollection = wineGoesWithFoodCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foodName != null ? foodName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Food)) {
            return false;
        }
        Food other = (Food) object;
        if ((this.foodName == null && other.foodName != null) || (this.foodName != null && !this.foodName.equals(other.foodName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.Food[ foodName=" + foodName + " ]";
    }
    
}
