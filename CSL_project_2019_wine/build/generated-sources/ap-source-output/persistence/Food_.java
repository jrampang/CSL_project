package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.WineGoesWithFood;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-12-20T19:02:37")
@StaticMetamodel(Food.class)
public class Food_ { 

    public static volatile SingularAttribute<Food, String> foodName;
    public static volatile CollectionAttribute<Food, WineGoesWithFood> wineGoesWithFoodCollection;
    public static volatile SingularAttribute<Food, String> foodDescription;

}