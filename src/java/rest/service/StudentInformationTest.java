/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.service;
import entity.StudentInformation;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import repository.admin.StudentInformationRepository;

/**
 *
 * @author macintoshhd
 */
@Path("student_information")
public class StudentInformationTest {
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/set/{studentNumber}/{studentName}/{teacheMail}/{schoolName}/{currentDate}")
    public void setStudentInfromation(
            @PathParam("studentNumber") String studentNumber,
            @PathParam("studentName") String studentName,
            @PathParam("teacheMail") String teacheMail,
            @PathParam("schoolName") String schoolName,
            @PathParam("currentDate") String currentDate) {
        StudentInformation information = new StudentInformation();
        information.setStudentNumber(studentNumber);
        information.setStudentName(studentName);
           information.setTeacheMail(teacheMail);
        information.setSchoolName(schoolName);
        information.setCurrentDate(currentDate);
        StudentInformationRepository rep = new StudentInformationRepository();
        rep.persist(information);
        rep.close();

    }
}
