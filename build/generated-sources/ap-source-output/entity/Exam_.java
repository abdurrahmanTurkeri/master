package entity;

import entity.CourceContent;
import entity.Question;
import entity.Solution;
import entity.Subject;
import entity.Teacher;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import library.BaseEntity_;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-13T21:40:51")
@StaticMetamodel(Exam.class)
public class Exam_ extends BaseEntity_ {

    public static volatile SingularAttribute<Exam, String> examEndDate;
    public static volatile SingularAttribute<Exam, Teacher> teacher;
    public static volatile SingularAttribute<Exam, String> examChart;
    public static volatile SingularAttribute<Exam, String> examStartDate;
    public static volatile SingularAttribute<Exam, Subject> subject;
    public static volatile SingularAttribute<Exam, String> examName;
    public static volatile SingularAttribute<Exam, CourceContent> courceContent;
    public static volatile SingularAttribute<Exam, Long> examId;
    public static volatile ListAttribute<Exam, Solution> solutionList;
    public static volatile ListAttribute<Exam, Question> questionList;
    public static volatile SingularAttribute<Exam, Long> status;

}