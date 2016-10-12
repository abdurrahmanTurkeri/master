/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author macintoshhd
 */
public enum QuestionType {
     ONE_OF_MANY("Cokdan Tek Secmeli"),
     MANY_OF_MANY("Cokdan Cok Secmeli"),
     FILL_ONE("Tekli Bosluk Doldurma"),
     FILL_MANY("Coklu Bosluk Doldurma"),
     MATCH_MANY("Coklu Eslestirme"),
     YES_NO_MANY("Dogru Yanlis Eslestirme")
    ;
    private String label;
   

    private QuestionType(String label) {
        this.label = label;
    }
    
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    
    
    
    
    
}
