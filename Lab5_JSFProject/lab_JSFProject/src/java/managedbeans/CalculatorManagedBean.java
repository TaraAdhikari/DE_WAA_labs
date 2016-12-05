/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author TaraPrasad
 */
@ManagedBean(name = "calculator")
@RequestScoped
public class CalculatorManagedBean {

    /**
     * Creates a new instance of CalculatorManagedBean
     */
    private double firstNum;
    private double secondNum;
    private double result;
    private String buttonId;

    public CalculatorManagedBean() {

    }

    public String getButtonId() {
        return buttonId;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void setButtonId(String buttonId) {
        this.buttonId = buttonId;
    }

    public double getfirstNum() {
        return firstNum;
    }

    public void setfirstNum(double firstNum) {
        this.firstNum = firstNum;
    }

    public double getsecondNum() {
        return secondNum;
    }

    public void setsecondNum(double secondNum) {
        this.secondNum = secondNum;
    }

    public void add() {
        //System.out.println("add function is called.");
        result= this.firstNum + this.secondNum;
    }

    public void multiply() {
       result= this.firstNum * this.secondNum;
    }

    public void divide() {
        result=this.firstNum / this.secondNum;
    }

    public void sub() {
       result= this.firstNum - this.secondNum;
    }
    
    public void result(ActionEvent event){
       
        buttonId=event.getComponent().getClientId();
        System.out.println("button id is: "+buttonId);
        if(buttonId.equals("add")){
            add();
        }else if(buttonId.equals("sub")){
            sub();
        }else if(buttonId.equals("div")){
           divide();
        }else if(buttonId.equals("mul")){
            multiply();
        }else{
            result=0.0;
        }        
    }
}
