/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Misc;

/**
 *
 * @author ADMIN
 */
import java.awt.Color;

public class chart {
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValues() {
        return values;
    }

    public void setValues(double values) {
        this.values = values;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public chart(String name, double values, Color color) {
        this.name = name;
        this.values = values;
        this.color = color;
    }

    public chart() {
    }

    private String name;
    private double values;
    private Color color;
    
}
