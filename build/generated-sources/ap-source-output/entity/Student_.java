package entity;

import entity.ClassRoom;
import entity.Solution;
import entity.StudentCource;
import entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import library.BaseEntity_;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-16T23:30:50")
@StaticMetamodel(Student.class)
public class Student_ extends BaseEntity_ {

    public static volatile SingularAttribute<Student, Long> studentId;
    public static volatile SingularAttribute<Student, String> studentEmail;
    public static volatile SingularAttribute<Student, Long> courceContentId;
    public static volatile ListAttribute<Student, StudentCource> studenCourceList;
    public static volatile SingularAttribute<Student, String> dafCode;
    public static volatile SingularAttribute<Student, String> studentNumber;
    public static volatile SingularAttribute<Student, ClassRoom> classRoom;
    public static volatile SingularAttribute<Student, String> quardianPhoneNumber;
    public static volatile ListAttribute<Student, Solution> solutionList;
    public static volatile SingularAttribute<Student, User> user;
    public static volatile SingularAttribute<Student, String> quardianMailAdress;
    public static volatile SingularAttribute<Student, String> gcmToken;

}