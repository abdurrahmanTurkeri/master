package entity;

import entity.CourceContent;
import entity.School;
import entity.Student;
import entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import library.BaseEntity_;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-16T23:30:50")
@StaticMetamodel(ClassRoom.class)
public class ClassRoom_ extends BaseEntity_ {

    public static volatile SingularAttribute<ClassRoom, Long> classRoomId;
    public static volatile SingularAttribute<ClassRoom, School> school;
    public static volatile ListAttribute<ClassRoom, Student> studentList;
    public static volatile SingularAttribute<ClassRoom, User> classTeacher;
    public static volatile SingularAttribute<ClassRoom, String> classRoomName;
    public static volatile ListAttribute<ClassRoom, CourceContent> courceContentList;

}