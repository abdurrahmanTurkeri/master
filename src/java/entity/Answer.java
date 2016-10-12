/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;
import library.BaseEntity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 *
 * @author macintoshhd
 */
@Entity
public class Answer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long answerId;
    @ManyToOne
    @JoinColumn(name = "solutionId")
    private Solution solution;
    @ManyToOne 
    @JoinColumn(name = "questionId")
    private Question question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String answer5;
    private String answer6;
    private String answer7;
    private String answer8;
    private String answer9;
    private String answer10;
    public boolean isCorrect() {
        boolean result = false;
        if (question.getCorrectCount() == 1) {
            result = equals(answer1,question.getCorrrect1());
            
        } else if (question.getCorrectCount() == 2) {
            result = equals(answer1,question.getCorrrect1())
                    && equals(answer2,question.getCorrrect2());
        } else if (question.getCorrectCount() == 3) {
            result = equals(answer1,question.getCorrrect1())
                    && equals(answer2,question.getCorrrect2())
                    && equals(answer3,question.getCorrrect3());
        } else if (question.getCorrectCount() == 4) {
            result = equals(answer1,question.getCorrrect1())
                    && equals(answer2,question.getCorrrect2())
                    && equals(answer3,question.getCorrrect3())
                    && equals(answer4,question.getCorrrect4());
        } else if (question.getCorrectCount() == 5) {
            result = equals(answer1,question.getCorrrect1())
                    && equals(answer2,question.getCorrrect2())
                    && equals(answer3,question.getCorrrect3())
                    && equals(answer4,question.getCorrrect4())
                    && equals(answer5,question.getCorrrect5());
        }
        return result;
    }

    private boolean equals(String answer, String correct) {
        if (answer == null || answer.equals("")) {
            return false;
        }
        if (correct == null || correct.equals("")) {
            return false;
        }
        return answer.equals(correct);
    }
    public long getPoint() {
        if (isCorrect()) {
            return question.getQuestionPoint();
        } else {
            return 0;
        }
    }
    @Transient
    private String[] corrects;

    public String[] getCorrects() {
        return corrects;
    }

    public void setCorrects(String[] corrects) {
        this.corrects = corrects;
        if (corrects == null || corrects.length == 0) {
            return;
        } else if (corrects.length == 1) {
            answer1 = corrects[0];
        } else if (corrects.length == 2) {
            answer1 = corrects[0];
            answer2 = corrects[1];
        } else if (corrects.length == 3) {
            answer1 = corrects[0];
            answer2 = corrects[1];
            answer3 = corrects[2];
        } else if (corrects.length == 4) {
            answer1 = corrects[0];
            answer2 = corrects[1];
            answer3 = corrects[2];
            answer4 = corrects[3];
        } else if (corrects.length == 5) {
            answer1 = corrects[0];
            answer2 = corrects[1];
            answer3 = corrects[2];
            answer4 = corrects[3];
            answer5 = corrects[4];
        } else if (corrects.length == 6) {
            answer1 = corrects[0];
            answer2 = corrects[1];
            answer3 = corrects[2];
            answer4 = corrects[3];
            answer5 = corrects[4];
            answer6 = corrects[5];
        } else if (corrects.length == 7) {
            answer1 = corrects[0];
            answer2 = corrects[1];
            answer3 = corrects[2];
            answer4 = corrects[3];
            answer5 = corrects[4];
            answer6 = corrects[5];
            answer7 = corrects[6];
        } else if (corrects.length == 8) {
            answer1 = corrects[0];
            answer2 = corrects[1];
            answer3 = corrects[2];
            answer4 = corrects[3];
            answer5 = corrects[4];
            answer6 = corrects[5];
            answer7 = corrects[6];
            answer8 = corrects[7];
        }

    }

    public long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }

    public Solution getSolution() {
        return solution;
    }

    public void setSolution(Solution solution) {
        this.solution = solution;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
        System.out.println("");
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getAnswer5() {
        return answer5;
    }

    public void setAnswer5(String answer5) {
        this.answer5 = answer5;
    }

    public String getAnswer6() {
        return answer6;
    }

    public void setAnswer6(String answer6) {
        this.answer6 = answer6;
    }

    public String getAnswer7() {
        return answer7;
    }

    public void setAnswer7(String answer7) {
        this.answer7 = answer7;
    }

    public String getAnswer8() {
        return answer8;
    }

    public void setAnswer8(String answer8) {
        this.answer8 = answer8;
    }

    public String getAnswer9() {
        return answer9;
    }

    public void setAnswer9(String answer9) {
        this.answer9 = answer9;
    }

    public String getAnswer10() {
        return answer10;
    }

    public void setAnswer10(String answer10) {
        this.answer10 = answer10;
    }

    public List<String> getCorrects(String val) {
        List<String> corrects = new ArrayList<>();
        if (answer1 != null && !answer1.equals("")) {
            corrects.add(answer1);
        } else if (answer2 != null && !answer2.equals("")) {
            corrects.add(answer2);
        } else if (answer3 != null && !answer3.equals("")) {
            corrects.add(answer3);
        } else if (answer4 != null && !answer4.equals("")) {
            corrects.add(answer4);
        } else if (answer5 != null && !answer5.equals("")) {
            corrects.add(answer2);
        } else if (answer5 != null && !answer6.equals("")) {
            corrects.add(answer6);
        } else if (answer7 != null && !answer7.equals("")) {
            corrects.add(answer7);
        } else if (answer8 != null && !answer8.equals("")) {
            corrects.add(answer8);
        } else if (answer9 != null && !answer9.equals("")) {
            corrects.add(answer9);
        } else if (answer10 != null && !answer10.equals("")) {
            corrects.add(answer10);
        }

        return corrects;
    }

}
