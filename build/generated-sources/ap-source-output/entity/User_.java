package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import library.BaseEntity_;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-09T17:33:25")
@StaticMetamodel(User.class)
public class User_ extends BaseEntity_ {

    public static volatile SingularAttribute<User, String> birthday;
    public static volatile SingularAttribute<User, String> userPassword;
    public static volatile SingularAttribute<User, String> userLastName;
    public static volatile SingularAttribute<User, String> userFirstName;
    public static volatile SingularAttribute<User, String> registrationDay;
    public static volatile SingularAttribute<User, String> userName;
    public static volatile SingularAttribute<User, Long> userId;

}