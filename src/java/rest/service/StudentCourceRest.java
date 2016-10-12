/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.service;

import entity.StudentCource;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import repository.admin.StudentCourceRepository;
import rest.document.StudentCourceDetailDocument;
import rest.document.StudentCourceSummeryDocument;

/**
 *
 * @author macintoshhd
 */
@Path("studentcource")
public class StudentCourceRest {
    @GET
   @Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
    @Path("/courceList/{studentId}")
    public StudentCourceSummeryDocument getStudentCourceListByStudentId(@PathParam("studentId") long studentId) {
        StudentCourceRepository courceRepository = new StudentCourceRepository();
        List<StudentCource> examList = courceRepository.filterByStudent(studentId);
        courceRepository.close();
        StudentCourceSummeryDocument studentCourceSummeryDocument = new StudentCourceSummeryDocument();
        for (StudentCource cource : examList) {
            StudentCourceDetailDocument detailDocument = new StudentCourceDetailDocument();
            detailDocument.setStudentCourceId(cource.getStudentCourceId());
            detailDocument.setClassRoomId(cource.getCourceContent().getClassRoom().getClassRoomId());
            detailDocument.setClassRoomName(cource.getCourceContent().getClassRoom().getClassRoomName());
            detailDocument.setStudentId(cource.getStudent().getStudentId());
            detailDocument.setCourceContentName(cource.getCourceContent().getClassContentName());
            studentCourceSummeryDocument.getStudentCourceList().add(detailDocument);
        }
        return studentCourceSummeryDocument;
    }
}