package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.Winemaker;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-12-20T19:02:37")
@StaticMetamodel(Countries.class)
public class Countries_ { 

    public static volatile CollectionAttribute<Countries, Winemaker> winemakerCollection;
    public static volatile SingularAttribute<Countries, String> countryName;
    public static volatile SingularAttribute<Countries, String> countryId;

}