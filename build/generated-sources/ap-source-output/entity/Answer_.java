package entity;

import entity.Question;
import entity.Solution;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import library.BaseEntity_;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-13T21:40:51")
@StaticMetamodel(Answer.class)
public class Answer_ extends BaseEntity_ {

    public static volatile SingularAttribute<Answer, Long> answerId;
    public static volatile SingularAttribute<Answer, Question> question;
    public static volatile SingularAttribute<Answer, String> answer7;
    public static volatile SingularAttribute<Answer, String> answer10;
    public static volatile SingularAttribute<Answer, String> answer6;
    public static volatile SingularAttribute<Answer, String> answer9;
    public static volatile SingularAttribute<Answer, String> answer8;
    public static volatile SingularAttribute<Answer, String> answer3;
    public static volatile SingularAttribute<Answer, String> answer2;
    public static volatile SingularAttribute<Answer, String> answer5;
    public static volatile SingularAttribute<Answer, String> answer4;
    public static volatile SingularAttribute<Answer, String> answer1;
    public static volatile SingularAttribute<Answer, Solution> solution;

}