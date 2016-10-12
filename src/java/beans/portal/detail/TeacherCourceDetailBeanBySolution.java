/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.portal.detail;

import entity.CourceContent;
import entity.Solution;
import entity.Student;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import library.FacesUtilities;
import repository.admin.CourceContentRepository;
import repository.admin.StudentRepository;
import repository.portal.SolutionRepository;
import repository.portal.TeacherCourceDetailRepository;

/**
 *
 * @author macintoshhd
 */
@ManagedBean
@ViewScoped
public class TeacherCourceDetailBeanBySolution implements Serializable {

    private long examId;
    private List<Solution> solutionList;
    private List<Solution> solutionListTemp;
    private String userFullName;

    public TeacherCourceDetailBeanBySolution() {
        getResult();
    }

    public void getResult() {
        examId = FacesUtilities.getRequestParameter("examId", 0);
        SolutionRepository solutionRepository = new SolutionRepository();
        solutionList = solutionRepository.filterByExamAndStudentid(examId);
        for (Solution solution : solutionList) {

        }
        solutionRepository.close();
    }

    public long getExamId() {
        return examId;
    }

    public void setExamId(long examId) {
        this.examId = examId;
    }

    public List<Solution> getSolutionList() {
        return solutionList;
    }

    public void setSolutionList(List<Solution> solutionList) {
        this.solutionList = solutionList;
    }

}
