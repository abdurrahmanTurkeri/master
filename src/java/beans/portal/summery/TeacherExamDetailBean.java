/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.portal.summery;

import entity.Answer;
import entity.Solution;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import library.FacesUtilities;
import repository.portal.SolutionRepository;

/**
 *
 * @author macintoshhd
 */
@ManagedBean
@ViewScoped
public class TeacherExamDetailBean implements Serializable {

    private Solution solution;
    public long totalPoint;

    public TeacherExamDetailBean() {
        selectSolution();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bu sayfada öğrencinizin ödev başarı durumunu analiz edebilirsiniz.Sol alttaki öğrenci gelişim grafiğine tıklayarak öğrencinizin toplam başarı durumunu gözlemleyebilirsiniz!"));

    }

    public void selectSolution() {
        long solutionId = FacesUtilities.getRequestParameter("solutionId", 0);
        long examId = FacesUtilities.getRequestParameter("examId", 0);
        long studentId = FacesUtilities.getRequestParameter("studentId", 0);

        System.out.println("Solution Id " + solutionId);
        if (solutionId != 0) {
            SolutionRepository solutionRepository = new SolutionRepository();
            solution = solutionRepository.singleByStudentFilter(solutionId);
            solutionRepository.close();

        } else {
            SolutionRepository solutionRepository = new SolutionRepository();
            solution = solutionRepository.filterByStudentAndExam(examId, studentId);
            solutionRepository.close();
        }
    }

    public void calculateTotal() {
        for (Answer ans : solution.getAnswerList()) {
            totalPoint = totalPoint + ans.getPoint();
        }
    }

    public long getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(long totalPoint) {
        this.totalPoint = totalPoint;
    }

    public Solution getSolution() {
        return solution;
    }

    public void setSolution(Solution solution) {
        this.solution = solution;
    }

    public void fake() throws IOException{
    }

    public void gotoGraphics() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("StudentGeneralGraphix.xhtml?studentId=" + solution.getStudent().getStudentId());
    }
}
