package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.InfoSources;
import persistence.RatingGuide;
import persistence.WineAtMerchants;
import persistence.WineColours;
import persistence.WineGoesWithFood;
import persistence.Winemaker;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-12-20T19:02:37")
@StaticMetamodel(Wine.class)
public class Wine_ { 

    public static volatile SingularAttribute<Wine, String> goodYears;
    public static volatile CollectionAttribute<Wine, WineAtMerchants> wineAtMerchantsCollection;
    public static volatile SingularAttribute<Wine, InfoSources> infoSourceId;
    public static volatile SingularAttribute<Wine, String> labelPictureFilename;
    public static volatile SingularAttribute<Wine, String> wineDescription;
    public static volatile SingularAttribute<Wine, String> wineId;
    public static volatile SingularAttribute<Wine, Float> priceHalfBottle;
    public static volatile SingularAttribute<Wine, WineColours> colour;
    public static volatile CollectionAttribute<Wine, WineGoesWithFood> wineGoesWithFoodCollection;
    public static volatile SingularAttribute<Wine, String> wineName;
    public static volatile SingularAttribute<Wine, RatingGuide> ratingId;
    public static volatile SingularAttribute<Wine, Winemaker> winemakerId;
    public static volatile SingularAttribute<Wine, Float> priceBottle;

}