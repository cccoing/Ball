package com.weng.ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * 
 * @ClassName JPanelGame
 * @Description 游戏面板
 * @author apple
 * @Date 2017年8月17日 下午7:42:29
 * @version 1.0.0
 */
public class JPanelGame extends JPanel {
    private static final long serialVersionUID = 1L;
    
    /**
     * @Description 球桌图片
     */
    private static final Image IMG_TABLE;
    /**
     * @Description 球图片
     */
    private static final Image IMG_BALL;
    static {
     // 初始化球桌图片
        IMG_TABLE = new ImageIcon("resources/table.png").getImage();
     // 初始化球图片
        IMG_BALL = new ImageIcon("resources/ball.png").getImage();
    }
    /**
     * @Description 球的x坐标
     */
    private int x = 400;
    /**
     * @Description 球的y坐标
     */
    private int y = 300;
    /**
     * @Description 球的速度
     */
    private int speed = 3;
    /**
     * @Description 球运动的角度
     */
    private double degree = Math.PI / 3;
    /**
     * @Description 小球运动线程
     */
    private Thread ballRunThread;
    
    public JPanelGame() {
        
        ballRunThread = new Thread() {
            @Override
            public void run() {
                while(true) {
                    try {
                        sleep(1000/60);
                        // 小球运动
                        ballRun();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        ballRunThread.start();
    }
    /**
     * @Description 小球运动
     */
    protected void ballRun() {
        x += (int) (speed*Math.cos(degree));
        y += (int) (speed*Math.sin(degree));
        // 球到达右边界
        if (x > 800 - 60) {
            degree = Math.PI -degree;
        }
        // 球到达左边界
        if (x < 60) {
            degree = Math.PI -degree;
        }
        // 球到达下边界
        if (y > 600 -60) {
            degree = -degree;
        }
        // 球到达上边界
        if (y < 60) {
            degree = -degree;
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 绘制球桌
        g.drawImage(IMG_TABLE, 0, 0, 800, 600, null);
        // 绘制球
        g.drawImage(IMG_BALL, x, y, null);
    }
}

