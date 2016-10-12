/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.service;

import entity.Answer;
import entity.Exam;
import entity.Question;
import entity.Solution;
import entity.Student;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import repository.admin.ExamRepository;
import repository.admin.StudentRepository;
import repository.portal.SolutionRepository;
import rest.document.AnswerDocument;
import rest.document.QuestionDocument;
import rest.document.SolutionDocument;

/**
 *
 * @author macintoshhd
 */
@Path("question")
public class QuestionSumeryRest {

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/list/{examId}/{studentId}")
    public SolutionDocument getMyQuestions(@PathParam("examId") long examId, @PathParam("studentId") long studentId) {
        System.out.println("rest.service.QuestionSumeryRest.getMyQuestions() "+examId+"  student Id "+studentId);
        SolutionDocument solutionDocument = new SolutionDocument();
        
        try {
            Solution solution;
            try {
                SolutionRepository solutionRepository = new SolutionRepository();
                solution = solutionRepository.filterByStudentAndExam(examId, studentId);
                solutionRepository.close();
                solutionDocument=convertMyData(solution);
            } catch (NoResultException e) {
                ExamRepository examRepository = new ExamRepository();
                Exam exam = examRepository.find(examId);
                examRepository.close();
                StudentRepository studentRepository = new StudentRepository();
                Student student = studentRepository.find(studentId);
                studentRepository.close();
                solution = generateSolution(exam, student);
                 solutionDocument=convertMyData(solution);
            }
            solutionDocument.setResultCode(0);
        } catch (Exception e) {
            solutionDocument.setResultCode(1);
            solutionDocument.setResultMessage(e.getMessage() + " " + e.getClass().getName());

        }
        return solutionDocument;
    }

    public SolutionDocument convertMyData(Solution solution) {
        SolutionDocument solutionDocument = new SolutionDocument();
        solutionDocument.setEndTime(solution.getEndTime());
        solutionDocument.setExamId(solution.getExam().getExamId());
        solutionDocument.setQuestionType(solution.getQuestionType());
        solutionDocument.setRate(solution.getRate());
        solutionDocument.setResult(solution.getResult());
        solutionDocument.setSolutionDate(solution.getSolutionDate());
        solutionDocument.setSolutionId(solution.getSolutionId());
        solutionDocument.setSolutionStatus(solution.getSolutionStatus());
        solutionDocument.setStartTime(solution.getStartTime());
        solutionDocument.setStudentId(solution.getStudent().getStudentId());
        solutionDocument.setStudentName(solution.getStudent().getUser().getUserName());
        solutionDocument.setAnswerList(convertAnswerList(solution));
        return  solutionDocument;
    }
    public List<AnswerDocument> convertAnswerList(Solution solution) {
        List<AnswerDocument> answerDocumentsList = new ArrayList<>();
        for (Answer answer : solution.getAnswerList()) {
            AnswerDocument answerDocument = new AnswerDocument();
            answerDocument.setAnswer1(answer.getAnswer1());
            answerDocument.setAnswer2(answer.getAnswer2());
            answerDocument.setAnswer3(answer.getAnswer3());
            answerDocument.setAnswer4(answer.getAnswer4());
            answerDocument.setAnswer5(answer.getAnswer5());
            answerDocument.setAnswer6(answer.getAnswer6());
            answerDocument.setAnswer7(answer.getAnswer7());
            answerDocument.setAnswer8(answer.getAnswer8());
            answerDocument.setAnswer9(answer.getAnswer9());
            answerDocument.setAnswer10(answer.getAnswer10());
            answerDocument.setAnswerDocumentId(answer.getAnswerId());
            answerDocument.setQuestion(convertQuestionDocument(answer.getQuestion()));
            System.out.println("rest.service.QuestionSumeryRest.convertAnswerList()+ "+answer.getQuestion().getText());
            answerDocumentsList.add(answerDocument);
        }
        return  answerDocumentsList;
    }
    public QuestionDocument convertQuestionDocument(Question q){
        QuestionDocument questionDocument=new QuestionDocument();
        questionDocument.setCorrectCount(q.getCorrectCount());
        questionDocument.setCorrrect1(q.getCorrrect1());
        questionDocument.setCorrrect2(q.getCorrrect2());
        questionDocument.setCorrrect3(q.getCorrrect3());
        questionDocument.setCorrrect4(q.getCorrrect4());
        questionDocument.setCorrrect5(q.getCorrrect5());
        questionDocument.setCorrrect6(q.getCorrrect6());
        questionDocument.setCorrrect7(q.getCorrrect7());
        questionDocument.setCorrrect8(q.getCorrrect8());
        questionDocument.setCorrrect9(q.getCorrrect9());
        questionDocument.setCorrrect10(q.getCorrrect10());
        questionDocument.setExamId(q.getExam().getExamId());
        questionDocument.setOption1(q.getOption1());
        questionDocument.setOption2(q.getOption2());
        questionDocument.setOption3(q.getOption3());
        questionDocument.setOption4(q.getOption4());
        questionDocument.setOption5(q.getOption5());
        questionDocument.setOption6(q.getOption6());
        questionDocument.setOption7(q.getOption7());
        questionDocument.setOption8(q.getOption8());
        questionDocument.setOption9(q.getOption9());
        questionDocument.setOption10(q.getOption10());
        questionDocument.setOptionCount(q.getOptionCount());
        questionDocument.setQuestionAnswer(q.getQuestionAnswer());
        questionDocument.setQuestionId(q.getQuestionId());
        questionDocument.setQuestionIndex(q.getQuestionIndex());
        questionDocument.setQuestionPoint(q.getQuestionPoint());
        questionDocument.setQuestionType(q.getQuestionType());
        questionDocument.setText(q.getText());
        questionDocument.setSoundPath(q.getSoundPath());
        questionDocument.setSoundIncluded(q.isSoundIncluded());
       return  questionDocument;
    }

    private Solution generateSolution(Exam exam, Student currentStudent) {
        Solution solution = new Solution();
        solution.setExam(exam);
        solution.setStudent(currentStudent);
        solution.setAnswerList(new ArrayList<Answer>());
        //  solution.setSolutionStatus(1);
        System.out.println("beans.portal.summery.StudentQuestionSummeryBean.generateSolution()" + solution.getSolutionStatus());
        for (Question question : solution.getExam().getQuestionList()) {
            Answer answer = new Answer();
            answer.setSolution(solution);
            answer.setQuestion(question);
            solution.getAnswerList().add(answer);
        }
        persistSolution(solution);
        return null;
    }

    private void persistSolution(Solution solution) {
        SolutionRepository solutionRepository = new SolutionRepository();
        solutionRepository.persist(solution);
        solutionRepository.close();
    }

}
