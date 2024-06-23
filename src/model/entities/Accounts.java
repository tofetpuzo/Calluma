/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kebank_datababse.model.entities;

/**
 *
 * @author femitemiola
 */
public class Accounts {

    private final int accountcode;
    private String name;

    public Accounts(int accountcode, String name) {
        this.accountcode = accountcode;
        this.name = name;
    }

    public int getAccountcode() {
        return accountcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

