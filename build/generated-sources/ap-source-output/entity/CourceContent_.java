package entity;

import entity.ClassRoom;
import entity.Cource;
import entity.Exam;
import entity.StudentCource;
import entity.Subject;
import entity.Teacher;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import library.BaseEntity_;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-16T23:30:50")
@StaticMetamodel(CourceContent.class)
public class CourceContent_ extends BaseEntity_ {

    public static volatile ListAttribute<CourceContent, Exam> examList;
    public static volatile SingularAttribute<CourceContent, Teacher> teacher;
    public static volatile ListAttribute<CourceContent, StudentCource> studenCourceList;
    public static volatile SingularAttribute<CourceContent, Subject> subject;
    public static volatile SingularAttribute<CourceContent, Long> isCanList;
    public static volatile SingularAttribute<CourceContent, ClassRoom> classRoom;
    public static volatile ListAttribute<CourceContent, Cource> courceList;
    public static volatile SingularAttribute<CourceContent, String> classContentName;
    public static volatile SingularAttribute<CourceContent, Long> classContentId;

}