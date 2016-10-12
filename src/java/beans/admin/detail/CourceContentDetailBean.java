package beans.admin.detail;

import entity.CourceContent;
import library.FacesUtilities;
import entity.ClassRoom;
import entity.Exam;
import entity.Question;
import entity.Subject;
import entity.Teacher;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import repository.admin.ClassRoomRepository;
import repository.admin.TeacherRepository;
import repository.admin.CourceContentRepository;
import repository.admin.ExamRepository;
import repository.admin.QuestionRepository;
import repository.admin.SubjectRepository;

@ManagedBean
@ViewScoped
public class CourceContentDetailBean implements Serializable {

    private List<Subject> subjectLsit;
    SubjectRepository subjectRepository;
    private CourceContent courceContent;
    private long classRoomId;
    private long teacherId;
    private long subjectId;

    @PostConstruct
    public void init() {
        subjectRepository = new SubjectRepository();
        subjectLsit = subjectRepository.listByMandatory(true);
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public long getClassRoomId() {
        return classRoomId;
    }
    public void setClassRoomId(long classRoomId) {
        this.classRoomId = classRoomId;
    }
    public CourceContentDetailBean() {
        long courceContentId = FacesUtilities.getRequestParameter("courceContentId", 0);
        if (courceContentId == 0) {
            courceContent = new CourceContent();

            classRoomId = FacesUtilities.getRequestParameter("classRoomId", 0);
            if (classRoomId != 0) {
                ClassRoomRepository classRoomRepository = new ClassRoomRepository();
                ClassRoom classRoom = classRoomRepository.find(classRoomId);
                courceContent.setClassRoom(classRoom);
                classRoomRepository.close();
            }

        } else {
            CourceContentRepository courceContentRepository = new CourceContentRepository();
            courceContent = courceContentRepository.find(courceContentId);
            courceContentRepository.close();
        }

    }

    public CourceContent getCourceContent() {
        return courceContent;
    }

    public void setClassRoom() {
        if (classRoomId != 0) {
            ClassRoomRepository classRoomRepository = new ClassRoomRepository();
            ClassRoom classRoom = classRoomRepository.find(classRoomId);
            classRoomRepository.close();
            courceContent.setIsCanList(1);
            courceContent.setClassRoom(classRoom);
        }
    }

    public void setTeacher() {
        if (teacherId != 0) {
            TeacherRepository teacherRepository = new TeacherRepository();
            Teacher teacher = teacherRepository.find(teacherId);
            courceContent.setTeacher(teacher);
            teacherRepository.close();
        }
    }

    public void setSubject() {
        if (subjectId != 0) {
            System.out.println("Subject id " + subjectId);
            SubjectRepository teacherRepository = new SubjectRepository();
            Subject subject = teacherRepository.find(subjectId);
            courceContent.setSubject(subject);
            teacherRepository.close();
        }
    }

    public void save() {
        try {
            long courceContentId = FacesUtilities.getRequestParameter("courceContentId", 0);
            setClassRoom();
            
            setTeacher();
            setSubject();
            CourceContentRepository courceContentRepository = new CourceContentRepository();
            
            if (courceContentId == 0) {
                
                courceContentRepository.persist(courceContent);
                System.out.println("beans.admin.detail.CourceContentDetailBean.save()"+courceContent.getClassContentId());
                copyExams();
            } else {
                courceContentRepository.merge(courceContent);
               //  copyExams();
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Basari ile kaydedildi"));
            courceContentRepository.close();
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bir yanlis lik oldu " + e.getMessage() + " " + getClass()));

        }
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public List<Subject> getSubjectLsit() {
        return subjectLsit;
    }

    public void setSubjectLsit(List<Subject> subjectLsit) {
        this.subjectLsit = subjectLsit;
    }

    private void copyExams() {
        ExamRepository examRepository = new ExamRepository();
        List<Exam> examList = examRepository.listBySubjectIdNullCourceId(subjectId);
       
        System.out.println("beans.admin.detail.CourceContentDetailBean.copyExams()"+examList.size());
        examRepository.close();
        for (Exam exam : examList) {
            
            copyExam(exam);
        }
    }

    private void copyExam(Exam examSubject) {

        ExamRepository examRepository = new ExamRepository();

        Exam examCource = new Exam();
        examCource.setCourceContent(courceContent);
        examCource.setExamChart(examSubject.getExamChart());
        examCource.setExamName(examSubject.getExamName() + " " + courceContent.getClassContentName());
        examCource.setSubject(examSubject.getSubject());
        examCource.setTeacher(examSubject.getTeacher());
        examCource.setStatus(0L);
        examRepository.persist(examCource);
        examRepository.close();
        QuestionRepository questionRepository = new QuestionRepository();
        List<Question> questionList = questionRepository.listFilter(examSubject.getExamId());
        System.out.println("beans.portal.summery.ExamInformationBean.copyBoard()" + questionList.size());

        for (Question questionSubject : questionList) {
            Question question = new Question();
            question.setQuestionIndex(questionSubject.getQuestionIndex());
            question.setQuestionNumber(questionSubject.getQuestionNumber());
            question.setQuestionType(questionSubject.getQuestionType());
            question.setExam(examCource);
            question.setCorrectCount(questionSubject.getCorrectCount());
            question.setQuestionAnswer(questionSubject.getQuestionAnswer());
            question.setQuestionPoint(questionSubject.getQuestionPoint());
            question.setCorrrect1(questionSubject.getCorrrect1());
            question.setCorrrect2(questionSubject.getCorrrect2());
            question.setCorrrect3(questionSubject.getCorrrect3());
            question.setCorrrect4(questionSubject.getCorrrect4());
            question.setCorrrect5(questionSubject.getCorrrect5());
            question.setCorrrect6(questionSubject.getCorrrect6());
            question.setCorrrect7(questionSubject.getCorrrect7());
            question.setCorrrect8(questionSubject.getCorrrect8());
            question.setCorrrect9(questionSubject.getCorrrect9());
            question.setOption1(questionSubject.getOption1());
            question.setOption2(questionSubject.getOption2());
            question.setOption3(questionSubject.getOption3());
            question.setOption4(questionSubject.getOption4());
            question.setOption5(questionSubject.getOption5());
            question.setOption6(questionSubject.getOption6());
            question.setOption7(questionSubject.getOption7());
            question.setOption8(questionSubject.getOption8());
            question.setOption9(questionSubject.getOption9());
            question.setText(questionSubject.getText());
            question.setSoundIncluded(questionSubject.isSoundIncluded());
            question.setSoundPath(questionSubject.getSoundPath());
            questionRepository.persist(question);
        }

        questionRepository.close();

    }

}
