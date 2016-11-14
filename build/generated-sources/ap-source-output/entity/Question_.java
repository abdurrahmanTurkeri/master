package entity;

import entity.Exam;
import entity.QuestionType;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import library.BaseEntity_;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-13T21:40:51")
@StaticMetamodel(Question.class)
public class Question_ extends BaseEntity_ {

    public static volatile SingularAttribute<Question, Long> questionId;
    public static volatile SingularAttribute<Question, Long> correctCount;
    public static volatile SingularAttribute<Question, Boolean> soundIncluded;
    public static volatile SingularAttribute<Question, Long> questionPoint;
    public static volatile SingularAttribute<Question, String> corrrect10;
    public static volatile SingularAttribute<Question, Long> questionNumber;
    public static volatile SingularAttribute<Question, Long> optionCount;
    public static volatile SingularAttribute<Question, Long> questionIndex;
    public static volatile SingularAttribute<Question, String> option3;
    public static volatile SingularAttribute<Question, String> option4;
    public static volatile SingularAttribute<Question, String> option1;
    public static volatile SingularAttribute<Question, String> text;
    public static volatile SingularAttribute<Question, String> option2;
    public static volatile SingularAttribute<Question, String> option10;
    public static volatile SingularAttribute<Question, String> soundPath;
    public static volatile SingularAttribute<Question, String> option9;
    public static volatile SingularAttribute<Question, String> option7;
    public static volatile SingularAttribute<Question, String> option8;
    public static volatile SingularAttribute<Question, String> option5;
    public static volatile SingularAttribute<Question, String> option6;
    public static volatile SingularAttribute<Question, Exam> exam;
    public static volatile SingularAttribute<Question, Boolean> optionTextual;
    public static volatile SingularAttribute<Question, String> corrrect8;
    public static volatile SingularAttribute<Question, String> questionAnswer;
    public static volatile SingularAttribute<Question, String> corrrect9;
    public static volatile SingularAttribute<Question, String> corrrect6;
    public static volatile SingularAttribute<Question, String> corrrect7;
    public static volatile SingularAttribute<Question, String> corrrect4;
    public static volatile SingularAttribute<Question, String> corrrect5;
    public static volatile SingularAttribute<Question, String> corrrect2;
    public static volatile SingularAttribute<Question, QuestionType> questionType;
    public static volatile SingularAttribute<Question, String> corrrect3;
    public static volatile SingularAttribute<Question, String> corrrect1;

}