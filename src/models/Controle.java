/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Louis
 */
public enum Controle
{

    EXTERNE("externe"),
    AUTOMATIQUE("automatique");

    private final String type;

    Controle(String type)
    {
        this.type = type;
    }
}
