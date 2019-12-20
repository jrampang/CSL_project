package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.WineAtMerchants;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-12-20T19:02:37")
@StaticMetamodel(Merchants.class)
public class Merchants_ { 

    public static volatile CollectionAttribute<Merchants, WineAtMerchants> wineAtMerchantsCollection;
    public static volatile SingularAttribute<Merchants, String> merchantId;
    public static volatile SingularAttribute<Merchants, String> merchantName;

}