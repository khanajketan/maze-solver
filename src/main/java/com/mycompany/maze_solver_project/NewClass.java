/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver_project;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.util.*;

/**
 *
 * @author Ketan
 */
public class NewClass extends JFrame{
    private int [][] maze =
    {{1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,0,0,0,1,0,1,1,1},
        {1,0,1,1,1,1,0,1,1,1,0,1},
        {1,0,0,0,1,0,0,1,1,1,0,1},
        {1,1,1,0,0,1,0,1,1,0,0,1},
        {1,0,0,1,0,0,0,1,1,0,0,1},
        {1,1,1,1,0,1,0,1,0,1,0,1},
        {1,0,0,0,0,1,0,0,0,1,1,1},
        {1,0,0,0,0,1,1,1,0,0,0,1},
        {1,0,0,1,0,1,0,0,0,9,0,1},
        {1,1,1,1,1,0,1,0,0,0,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1}
    };
    public List<Integer> path = new ArrayList<>();
    
    public NewClass(){
        setTitle("Maze Solver");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DepthFirst.searchPath(maze, 1, 1, path);
    }
    
    @Override
    public void paint(Graphics g){
        g.translate(120,120);
        for(int i=0; i<maze.length; i++){
            for(int j=0; j<maze[0].length; j++){
                Color color;
                color = switch (maze[i][j]) {
                    case 1 -> Color.BLACK;
                    case 9 -> Color.RED;
                    default -> Color.WHITE;
                };
                g.setColor(color);
                g.fillRect(30*j, 30*i, 30, 30);
                g.setColor(Color.RED);
                g.drawRect(30*j,30*i, 30, 30);
                    
                }
        }
        for(int i=0; i<path.size(); i+=2){
            int pathx = path.get(i);
            int pathy = path.get(i+1);
            
            System.out.println("X cordinate" + pathx);
            System.out.println("Y cordinate" + pathy);
            g.setColor(Color.GREEN);
            g.fillRect(30*pathx, 30*pathy, 20, 20);
        }
        
    }
    public static void main(String[] args){
        NewClass view = new NewClass();
        view.setVisible(true);
    }
}
