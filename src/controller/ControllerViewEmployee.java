/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bean.Beans;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import material.management.CategoryJPanel;
import material.management.CustomerJPanel;
import material.management.InforJPanel;
import material.management.ProductJPanel;

/**
 *
 * @author Administrator
 */
public class ControllerViewEmployee {
    private JPanel root;
    private String kindSelected = "";
    private List<Beans> listItem = null;
    
    public ControllerViewEmployee(JPanel jpnRoot)
    {
        this.root = jpnRoot;
    }
    
    public void setView(JPanel jpnItem, JLabel jlbItem)
    {
        kindSelected = "Customer";
        jpnItem.setBackground(new Color(200,200,200));
        jlbItem.setBackground(new Color(200,200,200));
        
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new CustomerJPanel());
        root.validate();
        root.repaint();
    }
    public void setEvent(List<Beans> listItem){
        this.listItem = listItem;
        for (Beans item : listItem){
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(),item.getJpn(),item.getJlb()));
        }
    }
    class LabelEvent implements MouseListener{
        private JPanel node;
        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
        
        @Override
        public void mouseClicked(MouseEvent e){
            switch(kind){
                case "Customer":
                    node = new CustomerJPanel();                 
                    break;
                case "Product":
                    node = new ProductJPanel();
                    break;
                case "Category":
                    node = new CategoryJPanel();
                    break;
                case "Infor":
                    node = new InforJPanel();
                    break;
                default:
                    node = new CustomerJPanel();
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(200,200,200));
            jlbItem.setBackground(new Color(200,200,200));
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(200,200,200));
            jlbItem.setBackground(new Color(200,200,200));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)){
                jpnItem.setBackground(new Color(200,200,200));
                jlbItem.setBackground(new Color(200,200,200));
            }
        }
        private void setChangeBackground(String kind){
            for (Beans item : listItem){
                if (item.getKind().equalsIgnoreCase(kind)){
                    item.getJlb().setBackground(new Color(200,200,200));
                    item.getJpn().setBackground(new Color(200,200,200)); 
                } else {
                    item.getJlb().setBackground(new Color(200,200,200));
                    item.getJpn().setBackground(new Color(200,200,200)); 
                }
            }
        }
    }
}
