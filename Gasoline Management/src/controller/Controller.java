/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

import java.util.List;

/**
 *
 * @author judy
 */
public interface Controller {
    <T> void writeToFile (List<T> list, String fileName);
    <T> List<T> readDataFromFile(String fileName);
    
}
