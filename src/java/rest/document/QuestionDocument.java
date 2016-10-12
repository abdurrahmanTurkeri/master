/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.document;

import entity.Answer;
import entity.QuestionType;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author macintoshhd
 */
public class QuestionDocument implements Serializable{

    private long questionId;
    private long questionIndex;
    private String text;
    private boolean soundIncluded;
    private String soundPath;
    private long optionCount;
    private long correctCount;
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
    private long examId;
    private String examName;

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

    public long getCorrectCount() {
        return correctCount;
    }

    public void setCorrectCount(long correctCount) {
        this.correctCount = correctCount;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public long getQuestionPoint() {
        return questionPoint;
    }

    public void setQuestionPoint(long questionPoint) {
        this.questionPoint = questionPoint;
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

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public long getExamId() {
        return examId;
    }

    public void setExamId(long examId) {
        this.examId = examId;
    }


    public QuestionDocument(long questionId, long questionIndex, String text, boolean soundIncluded, String soundPath, long optionCount, long correctCount, QuestionType questionType, long questionPoint, String option1, String option2, String option3, String option4, String option5, String option6, String option7, String option8, String option9, String option10, String corrrect1, String corrrect2, String corrrect3, String corrrect4, String corrrect5, String corrrect6, String corrrect7, String corrrect8, String corrrect9, String corrrect10, String questionAnswer, long examId) {
        this.questionId = questionId;
        this.questionIndex = questionIndex;
        this.text = text;
        this.soundIncluded = soundIncluded;
        this.soundPath = soundPath;
        this.optionCount = optionCount;
        this.correctCount = correctCount;
        this.questionType = questionType;
        this.questionPoint = questionPoint;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.option5 = option5;
        this.option6 = option6;
        this.option7 = option7;
        this.option8 = option8;
        this.option9 = option9;
        this.option10 = option10;
        this.corrrect1 = corrrect1;
        this.corrrect2 = corrrect2;
        this.corrrect3 = corrrect3;
        this.corrrect4 = corrrect4;
        this.corrrect5 = corrrect5;
        this.corrrect6 = corrrect6;
        this.corrrect7 = corrrect7;
        this.corrrect8 = corrrect8;
        this.corrrect9 = corrrect9;
        this.corrrect10 = corrrect10;
        this.questionAnswer = questionAnswer;
        this.examId = examId;
      
    }

    public QuestionDocument() {
    }

}
