/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.service;

import entity.Exam;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import repository.admin.ExamRepository;
import rest.document.ExamDetailDocument;
import rest.document.ExamSummeryDocument;
import rest.document.ResultDocument;

/**
 *
 * @author macintoshhd
 */
@Path("exam")
public class ExamRest {
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/list/{courceContentId}")
    public ExamSummeryDocument getExamListByCourceContentId(@PathParam("courceContentId") long courceContentId) {
        ExamRepository examRepository = new ExamRepository();
        List<Exam> examList = examRepository.listFilter(courceContentId);
        examRepository.close();
        ExamSummeryDocument examSummeryDocument = new ExamSummeryDocument();
        for (Exam exam : examList) {
            ExamDetailDocument detailDocument = new ExamDetailDocument();
            detailDocument.setCourceContentId(exam.getCourceContent().getClassContentId());
            detailDocument.setExamChart(exam.getExamChart());
            detailDocument.setExamId(exam.getExamId());
            detailDocument.setExamName(exam.getExamName());
            detailDocument.setStatus(exam.getStatus());
            detailDocument.setExamStartDate(exam.getExamStartDate());
            detailDocument.setExamEndDate(exam.getExamEndDate());
            // detailDocument.setTeacherId(exam.getTeacher().getTeacherId());       
            examSummeryDocument.getExamDetailDocumentList().add(detailDocument);
        }
        return examSummeryDocument;
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultDocument putExam(ExamDetailDocument examDetailDocument) {
        ResultDocument resultDocument;
        try {
            Exam exam = new Exam();
            exam.setExamName(examDetailDocument.getExamName());
            ExamRepository examRepository = new ExamRepository();
            examRepository.persist(exam);
            examRepository.close();
            resultDocument = new ResultDocument(0, "Basariyla Eklendi");
        } catch (Exception e) {
            e.printStackTrace();
            resultDocument = new ResultDocument(1, "Hata Oldu" + e.getClass().getName() + " " + e.getMessage());
        }
        return resultDocument;
    }

}
