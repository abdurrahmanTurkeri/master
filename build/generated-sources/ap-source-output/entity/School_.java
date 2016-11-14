package entity;

import entity.ClassRoom;
import entity.Department;
import entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import library.BaseEntity_;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-13T21:40:51")
@StaticMetamodel(School.class)
public class School_ extends BaseEntity_ {

    public static volatile ListAttribute<School, ClassRoom> classRoomList;
    public static volatile SingularAttribute<School, User> schoolManagerId;
    public static volatile SingularAttribute<School, Long> schoolId;
    public static volatile SingularAttribute<School, String> schoolName;
    public static volatile SingularAttribute<School, Department> department;

}