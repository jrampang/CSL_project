package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.Food;
import persistence.Wine;
import persistence.WineGoesWithFoodPK;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-12-20T19:02:37")
@StaticMetamodel(WineGoesWithFood.class)
public class WineGoesWithFood_ { 

    public static volatile SingularAttribute<WineGoesWithFood, String> comments;
    public static volatile SingularAttribute<WineGoesWithFood, WineGoesWithFoodPK> wineGoesWithFoodPK;
    public static volatile SingularAttribute<WineGoesWithFood, Food> food;
    public static volatile SingularAttribute<WineGoesWithFood, Wine> wine;

}