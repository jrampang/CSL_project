package persistence;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.Merchants;
import persistence.Wine;
import persistence.WineAtMerchantsPK;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-12-20T19:02:37")
@StaticMetamodel(WineAtMerchants.class)
public class WineAtMerchants_ { 

    public static volatile SingularAttribute<WineAtMerchants, Date> offerStartDate;
    public static volatile SingularAttribute<WineAtMerchants, WineAtMerchantsPK> wineAtMerchantsPK;
    public static volatile SingularAttribute<WineAtMerchants, Float> priceOnOffer;
    public static volatile SingularAttribute<WineAtMerchants, Merchants> merchants;
    public static volatile SingularAttribute<WineAtMerchants, Date> offerEndDate;
    public static volatile SingularAttribute<WineAtMerchants, Wine> wine;

}