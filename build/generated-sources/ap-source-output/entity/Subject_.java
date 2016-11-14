package entity;

import entity.CourceContent;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import library.BaseEntity_;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-13T21:40:51")
@StaticMetamodel(Subject.class)
public class Subject_ extends BaseEntity_ {

    public static volatile SingularAttribute<Subject, Boolean> mandatory;
    public static volatile ListAttribute<Subject, CourceContent> courceContentList;
    public static volatile SingularAttribute<Subject, Long> subjectId;
    public static volatile SingularAttribute<Subject, String> subjectName;

}