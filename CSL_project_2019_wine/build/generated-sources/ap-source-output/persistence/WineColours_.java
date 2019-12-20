package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.RatingGuide;
import persistence.Wine;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-12-20T19:02:37")
@StaticMetamodel(WineColours.class)
public class WineColours_ { 

    public static volatile SingularAttribute<WineColours, String> colour;
    public static volatile CollectionAttribute<WineColours, Wine> wineCollection;
    public static volatile CollectionAttribute<WineColours, RatingGuide> ratingGuideCollection;

}