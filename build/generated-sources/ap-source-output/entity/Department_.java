package entity;

import entity.Company;
import entity.School;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import library.BaseEntity_;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-16T23:30:50")
@StaticMetamodel(Department.class)
public class Department_ extends BaseEntity_ {

    public static volatile SingularAttribute<Department, String> departmentName;
    public static volatile ListAttribute<Department, School> schoolList;
    public static volatile SingularAttribute<Department, Long> departmentId;
    public static volatile SingularAttribute<Department, Company> company;
    public static volatile SingularAttribute<Department, Long> salesManagerId;

}