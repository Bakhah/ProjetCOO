/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import javax.swing.JPanel;

/**
 *
 * @author hourdinf
 */
public class VueContainer extends JPanel
{
    private Vue vue;
    
    public VueContainer(Vue v)
    {
        this.add(v);
    }
    public Vue getVue()
    {
        return (Vue)this.getComponent(0);
    }
}
