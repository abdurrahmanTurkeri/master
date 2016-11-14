package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import library.BaseEntity_;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-13T21:40:51")
@StaticMetamodel(StudentInformation.class)
public class StudentInformation_ extends BaseEntity_ {

    public static volatile SingularAttribute<StudentInformation, String> studentNumber;
    public static volatile SingularAttribute<StudentInformation, String> studentName;
    public static volatile SingularAttribute<StudentInformation, String> currentDate;
    public static volatile SingularAttribute<StudentInformation, String> teacheMail;
    public static volatile SingularAttribute<StudentInformation, Long> id;
    public static volatile SingularAttribute<StudentInformation, String> schoolName;

}