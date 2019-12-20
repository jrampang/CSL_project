package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.Wine;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-12-20T19:02:37")
@StaticMetamodel(InfoSources.class)
public class InfoSources_ { 

    public static volatile SingularAttribute<InfoSources, String> infoSourceId;
    public static volatile SingularAttribute<InfoSources, String> infoSourceDescription;
    public static volatile CollectionAttribute<InfoSources, Wine> wineCollection;

}