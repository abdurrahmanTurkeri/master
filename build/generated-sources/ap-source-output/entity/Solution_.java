package entity;

import entity.Answer;
import entity.Exam;
import entity.QuestionType;
import entity.Student;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import library.BaseEntity_;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-16T23:30:50")
@StaticMetamodel(Solution.class)
public class Solution_ extends BaseEntity_ {

    public static volatile SingularAttribute<Solution, Exam> exam;
    public static volatile SingularAttribute<Solution, Float> result;
    public static volatile ListAttribute<Solution, Answer> answerList;
    public static volatile SingularAttribute<Solution, Student> student;
    public static volatile SingularAttribute<Solution, Float> rate;
    public static volatile SingularAttribute<Solution, String> startTime;
    public static volatile SingularAttribute<Solution, Long> solutionId;
    public static volatile SingularAttribute<Solution, String> endTime;
    public static volatile SingularAttribute<Solution, QuestionType> questionType;
    public static volatile SingularAttribute<Solution, String> solutionDate;
    public static volatile SingularAttribute<Solution, Long> solutionStatus;

}