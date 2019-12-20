package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.Countries;
import persistence.Wine;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-12-20T19:02:37")
@StaticMetamodel(Winemaker.class)
public class Winemaker_ { 

    public static volatile CollectionAttribute<Winemaker, Wine> wineCollection;
    public static volatile SingularAttribute<Winemaker, String> winemakerId;
    public static volatile SingularAttribute<Winemaker, String> winemakerName;
    public static volatile SingularAttribute<Winemaker, Countries> countryId;

}