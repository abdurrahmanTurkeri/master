package entity;

import entity.CourceContent;
import entity.Student;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import library.BaseEntity_;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-09T17:33:25")
@StaticMetamodel(StudentCource.class)
public class StudentCource_ extends BaseEntity_ {

    public static volatile SingularAttribute<StudentCource, Long> studentCourceId;
    public static volatile SingularAttribute<StudentCource, Student> student;
    public static volatile SingularAttribute<StudentCource, CourceContent> courceContent;

}