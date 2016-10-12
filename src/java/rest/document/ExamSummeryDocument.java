/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author macintoshhd
 */
public class ExamSummeryDocument implements Serializable {

    private List<ExamDetailDocument> examDetailDocumentList;

    public List<ExamDetailDocument> getExamDetailDocumentList() {
        if (examDetailDocumentList == null) {
            examDetailDocumentList = new ArrayList<ExamDetailDocument>();
        }
        return examDetailDocumentList;
    }

    public void setExamDetailDocumentList(List<ExamDetailDocument> examDetailDocumentList) {
        this.examDetailDocumentList = examDetailDocumentList;
    }

}
