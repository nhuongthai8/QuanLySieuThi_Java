/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Misc;

/**
 *
 * @author ADMIN
 */
public class Model_Month {

    /**
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * @return the monthText
     */
    public String getMonthText() {
        return monthText;
    }

    /**
     * @param monthText the monthText to set
     */
    public void setMonthText(String monthText) {
        this.monthText = monthText;
    }
    
    public Model_Month(){
        
    }
    
    public Model_Month(int month, String monthText){
        this.month = month; 
        this.monthText = monthText;
    }
    
    private int month;
    private String monthText;
    
    @Override
    public String toString(){
        return monthText;
    }
}
