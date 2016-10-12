/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;
import library.BaseEntity;
import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 *
 * @author macintoshhd
 */
@Entity
public class Question extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long questionId;
    private long questionIndex;
    private long questionNumber;//?
    private String text;
    private boolean soundIncluded;
    private String soundPath;
    private long optionCount;
    private long correctCount;
    private boolean optionTextual;//?Metinsel Not used
    private QuestionType questionType;
    private long questionPoint;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String option5;
    private String option6;
    private String option7;
    private String option8;
    private String option9;
    private String option10;

    private String corrrect1;
    private String corrrect2;
    private String corrrect3;
    private String corrrect4;
    private String corrrect5;
    private String corrrect6;
    private String corrrect7;
    private String corrrect8;
    private String corrrect9;
    private String corrrect10;
    
    private String questionAnswer;
    @ManyToOne
    @JoinColumn(name = "examId")
    private Exam exam;

    @Transient
    private String[] correctList = new String[10];

    //Burda exam le iliski kururlacak.
    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    //Correct count alani eklenecek.
    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public long getQuestionIndex() {
        return questionIndex;
    }

    public void setQuestionIndex(long questionIndex) {
        this.questionIndex = questionIndex;
    }

    public long getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(long questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isSoundIncluded() {
        return soundIncluded;
    }

    public void setSoundIncluded(boolean soundIncluded) {
        this.soundIncluded = soundIncluded;
    }

    public String getSoundPath() {
        return soundPath;
    }

    public void setSoundPath(String soundPath) {
        this.soundPath = soundPath;
    }

    public long getOptionCount() {
        return optionCount;
    }

    public void setOptionCount(long optionCount) {
        this.optionCount = optionCount;
    }

    public boolean isOptionTextual() {
        return optionTextual;
    }

    public void setOptionTextual(boolean optionTextual) {
        this.optionTextual = optionTextual;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getOption5() {
        return option5;
    }

    public void setOption5(String option5) {
        this.option5 = option5;
    }

    public String getOption6() {
        return option6;
    }

    public void setOption6(String option6) {
        this.option6 = option6;
    }

    public String getOption7() {
        return option7;
    }

    public void setOption7(String option7) {
        this.option7 = option7;
    }

    public String getOption8() {
        return option8;
    }

    public void setOption8(String option8) {
        this.option8 = option8;
    }

    public String getOption9() {
        return option9;
    }

    public void setOption9(String option9) {
        this.option9 = option9;
    }

    public String getOption10() {
        return option10;
    }

    public void setOption10(String option10) {
        this.option10 = option10;
    }

    public String getCorrrect1() {
        return corrrect1;
    }

    public void setCorrrect1(String corrrect1) {
        this.corrrect1 = corrrect1;
    }

    public String getCorrrect2() {
        return corrrect2;
    }

    public void setCorrrect2(String corrrect2) {
        this.corrrect2 = corrrect2;
    }

    public String getCorrrect3() {
        return corrrect3;
    }

    public void setCorrrect3(String corrrect3) {
        this.corrrect3 = corrrect3;
    }

    public String getCorrrect4() {
        return corrrect4;
    }

    public void setCorrrect4(String corrrect4) {
        this.corrrect4 = corrrect4;
    }

    public String getCorrrect5() {
        return corrrect5;
    }

    public void setCorrrect5(String corrrect5) {
        this.corrrect5 = corrrect5;
    }

    public String getCorrrect6() {
        return corrrect6;
    }

    public void setCorrrect6(String corrrect6) {
        this.corrrect6 = corrrect6;
    }

    public String getCorrrect7() {
        return corrrect7;
    }

    public void setCorrrect7(String corrrect7) {
        this.corrrect7 = corrrect7;
    }

    public String getCorrrect8() {
        return corrrect8;
    }

    public void setCorrrect8(String corrrect8) {
        this.corrrect8 = corrrect8;
    }

    public String getCorrrect9() {
        return corrrect9;
    }

    public void setCorrrect9(String corrrect9) {
        this.corrrect9 = corrrect9;
    }

    public String getCorrrect10() {
        return corrrect10;
    }

    public void setCorrrect10(String corrrect10) {
        this.corrrect10 = corrrect10;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public long getCorrectCount() {
        return correctCount;
    }

    public void setCorrectCount(long correctCount) {
        this.correctCount = correctCount;
    }

    public long getQuestionPoint() {
        return questionPoint;
    }

    public void setQuestionPoint(long questionPoint) {
        this.questionPoint = questionPoint;
    }

    public void formatCorrectList() {
        System.out.println("entity.Question.formatCorrectList()");
        if (corrrect1 != null && !corrrect1.equals("")) {
            correctList[0] = corrrect1;
        } else if (corrrect2 != null && !corrrect2.equals("")) {

            correctList[1] = corrrect2;
        } else if (corrrect3 != null && !corrrect3.equals("")) {

            correctList[2] = corrrect3;
        } else if (corrrect4 != null && !corrrect4.equals("")) {

            correctList[3] = corrrect4;
        } else if (corrrect5 != null && !corrrect5.equals("")) {

            correctList[4] = corrrect5;
        } else if (corrrect5 != null && !corrrect6.equals("")) {

            correctList[5] = corrrect6;
        } else if (corrrect7 != null && !corrrect7.equals("")) {

            correctList[6] = corrrect7;
        } else if (corrrect8 != null && !corrrect8.equals("")) {

            correctList[7] = corrrect8;
        } else if (corrrect9 != null && !corrrect9.equals("")) {

            correctList[8] = corrrect9;
        } else if (corrrect10 != null && !corrrect10.equals("")) {

            correctList[9] = corrrect10;
        }
    }

    public void parseCorrectList() {
        System.out.println("entity.Question.parseCorrectList()"+correctList.length);
        for (int i = 0; i < correctList.length; i++) {
            String correct = correctList[i];
            System.out.println("entity.Question.parseCorrectList() for"+i+" Cevap "+correct);
            if (i == 0) {
                setCorrrect1(correct);
            } else if (i == 1) {
                setCorrrect2(correct);
            } else if (i == 2) {
                setCorrrect3(correct);
            } else if (i == 3) {
                setCorrrect4(correct);
            } else if (i == 4) {
                setCorrrect5(correct);
            } else if (i == 5) {
                setCorrrect6(correct);
            } else if (i == 6) {
                setCorrrect7(correct);
            } else if (i == 7) {
                setCorrrect8(correct);
            } else if (i == 8) {
                setCorrrect9(correct);
            } else if (i == 9) {
                setCorrrect10(correct);
            }

        }
    }

    public String[] getCorrectList() {

        System.out.println("entity.Question.getCorrectList()" + correctList.length);
        return correctList;
    }
    public void setCorrectList(String[] correctList) {
        System.out.println("entity.Question.setCorrectList()" + correctList.length);
        this.correctList = correctList;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

}
