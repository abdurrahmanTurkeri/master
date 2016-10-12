/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.service;

import entity.Student;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import repository.portal.StudentLoginRepository;
import rest.document.ResultDocument;
import rest.document.StudentDocument;

/**
 *
 * @author macintoshhd
 */
@Path("student")
public class StudentRest {
    @GET
    @Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
    @Path("/login/{userName}/{pasword}/{token}")
    public StudentDocument getExamListByCourceContentId(@PathParam("userName") String userName, @PathParam("pasword") String pasword,@PathParam("token") String token) {
        ResultDocument resultDocument;
        StudentDocument studentDocument=null;
        try {
            StudentLoginRepository studentLoginRepository = new StudentLoginRepository();
            Student student = studentLoginRepository.listFilterByUserNameAndPassword(userName, pasword);
            student.setGcmToken(token);
            studentLoginRepository.merge(student);
            studentLoginRepository.close();
            resultDocument = new ResultDocument(0, "SUCCES");
            studentDocument = new StudentDocument();
//            studentDocument.setClassRoomId(student.getClassRoom().getClassRoomId());
            studentDocument.setDafCode(student.getDafCode());
            studentDocument.setQuardianMailAdress(student.getQuardianMailAdress());
            studentDocument.setQuardianPhoneNumber(student.getQuardianPhoneNumber());
            studentDocument.setStudentEmail(student.getStudentEmail());
            studentDocument.setStudentId(student.getStudentId());
            studentDocument.setClassRoomId(student.getClassRoom().getClassRoomId());
            studentDocument.setStudentName(student.getUser().getUserFirstName() + " " + student.getUser().getUserLastName());
            studentDocument.setStudentNumber(student.getStudentNumber());
            studentDocument.setUserId(student.getUser().getUserId());
            studentDocument.setUserName(student.getUser().getUserName());
        } catch (Exception e) {
            e.printStackTrace();
            resultDocument = new ResultDocument(1, "ERROR" + e.getClass().getName() + " " + e.getMessage());
        }
        return studentDocument;
    }
}
