package entity;

import entity.CourceContent;
import entity.Exam;
import entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import library.BaseEntity_;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-13T21:40:51")
@StaticMetamodel(Teacher.class)
public class Teacher_ extends BaseEntity_ {

    public static volatile ListAttribute<Teacher, Exam> examList;
    public static volatile SingularAttribute<Teacher, Long> teacherId;
    public static volatile SingularAttribute<Teacher, Boolean> isCanCall;
    public static volatile ListAttribute<Teacher, CourceContent> courceContentList;
    public static volatile SingularAttribute<Teacher, User> user;
    public static volatile SingularAttribute<Teacher, String> gsmNumber;
    public static volatile SingularAttribute<Teacher, String> email;

}