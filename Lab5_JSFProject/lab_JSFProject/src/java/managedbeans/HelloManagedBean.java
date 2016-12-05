/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author TaraPrasad
 */
@ManagedBean(name = "helloManagedBean")
@RequestScoped
public class HelloManagedBean {

    /**
     * Creates a new instance of HelloManagedBean
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String sayHello() {
        return name;
    }

}
