package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.Wine;
import persistence.WineColours;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-12-20T19:02:37")
@StaticMetamodel(RatingGuide.class)
public class RatingGuide_ { 

    public static volatile SingularAttribute<RatingGuide, WineColours> colour;
    public static volatile SingularAttribute<RatingGuide, String> ratingId;
    public static volatile CollectionAttribute<RatingGuide, Wine> wineCollection;
    public static volatile SingularAttribute<RatingGuide, String> ratingDescription;

}