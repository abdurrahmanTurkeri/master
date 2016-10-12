/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import rest.service.ExamRest;
import rest.service.QuestionSumeryRest;
import rest.service.StudentCourceRest;
import rest.service.StudentRest;

/**
 *
 * @author macintoshhd
 */
@ApplicationPath("platform")
public class PlatformApplication
        extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(QuestionSumeryRest.class);
        resources.add(ExamRest.class);
        resources.add(StudentCourceRest.class);
        resources.add(StudentRest.class);
        return resources;
    }
}
