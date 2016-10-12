/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.portal.summery;

import entity.QuestionType;
import entity.Solution;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import library.FacesUtilities;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import repository.portal.SolutionRepository;
import repository.portal.StudentGraphicxRepository;

/**
 *
 * @author macintoshhd
 */
@ManagedBean
@ViewScoped
public class StudentGraphicxBean implements Serializable {

    private List<Solution> solutionList;

    public StudentGraphicxBean() {
        selectSolution();
    }

    public void selectSolution() {
        long studentId = FacesUtilities.getRequestParameter("studentId", 0);
        System.out.println("Solution Id " + studentId);
        if (studentId != 0) {
            StudentGraphicxRepository solutionRepository = new StudentGraphicxRepository();
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
    private BarChartModel animatedModel2;

    @PostConstruct
    public void init() {
        createAnimatedModels();
    }

    public BarChartModel getAnimatedModel2() {
        return animatedModel2;
    }

    private void createAnimatedModels() {

        animatedModel2 = initBarModel();
        animatedModel2.setTitle("Ogrencinin Gosterdigi Performans Durumlari");
        animatedModel2.setAnimate(true);
        animatedModel2.setLegendPosition("ne");
        Axis yAxis = animatedModel2.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(100);
    }
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
        ChartSeries tek;
        for (Solution solution : solutionList) {
            tek = new ChartSeries();
            tek.setLabel(QuestionType.ONE_OF_MANY.toString());
            tek.set("CT", solution.getRate());
            model.addSeries(tek);
//            if (solution.getQuestionType() == QuestionType.ONE_OF_MANY) {
//              
//            } else if (solution.getQuestionType() == QuestionType.ONE_OF_MANY) {
//                cok = new ChartSeries();
//                cok.setLabel(QuestionType.ONE_OF_MANY.toString());
//                cok.set("CC", solution.getRate());
//                 model.addSeries(cok);
//            }
        }

        return model;
    }

}
