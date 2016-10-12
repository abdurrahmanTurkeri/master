package entity;

import entity.Department;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import library.BaseEntity_;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-09T17:33:25")
@StaticMetamodel(Company.class)
public class Company_ extends BaseEntity_ {

    public static volatile SingularAttribute<Company, Long> companyId;
    public static volatile SingularAttribute<Company, String> companyName;
    public static volatile SingularAttribute<Company, Long> userManagerId;
    public static volatile ListAttribute<Company, Department> departmentList;

}