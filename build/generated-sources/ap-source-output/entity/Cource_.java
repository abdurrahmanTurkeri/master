package entity;

import entity.CourceContent;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import library.BaseEntity_;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-13T21:40:51")
@StaticMetamodel(Cource.class)
public class Cource_ extends BaseEntity_ {

    public static volatile SingularAttribute<Cource, String> courceName;
    public static volatile SingularAttribute<Cource, String> courseStarDate;
    public static volatile SingularAttribute<Cource, Long> courceId;
    public static volatile SingularAttribute<Cource, CourceContent> courceContent;
    public static volatile SingularAttribute<Cource, String> courceEntDate;

}