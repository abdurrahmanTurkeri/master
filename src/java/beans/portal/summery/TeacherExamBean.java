/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.portal.summery;

import entity.Solution;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import library.FacesUtilities;
import repository.portal.SolutionRepository;

/**
 *
 * @author macintoshhd
 */
@ManagedBean
@ViewScoped
public class TeacherExamBean implements Serializable{

    private List<Solution> solutionList;
    public TeacherExamBean() {
        selectSolution();
    }
    public void selectSolution() {
        long studentId = FacesUtilities.getRequestParameter("studentId", 0);
        System.out.println("Solution Id "+studentId);
        if (studentId != 0) {
            SolutionRepository solutionRepository = new SolutionRepository();
            solutionList = solutionRepository.listByStudentFilter(studentId);
            solutionRepository.close();
        }
    }

    public List<Solution> getSolutionList() {
        return solutionList;
    }

    public void setSolutionList(List<Solution> solutionList) {
        this.solutionList = solutionList;
    }

    

}
