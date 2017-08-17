package com.weng.ui;

import java.awt.Toolkit;

import javax.swing.JFrame;
/**
 * 
 * @ClassName JFrameGame
 * @Description 游戏窗体
 * @author apple
 * @Date 2017年8月17日 下午7:44:16
 * @version 1.0.0
 */
public class JFrameGame extends JFrame {
    private static final long serialVersionUID = 1L;
    
    
    public JFrameGame() {
        /**
         * 初始化窗体
         */
        this.init();
    }

    /**
     * 
     * @Description 初始化窗体
     */
    private void init() {
        // 1.设置窗体标题
        this.setTitle("桌球运动");
        // 2.设置窗体大小
        this.setSize(800, 600);
        // 3.设置窗体关闭方式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 4.静止用户缩放窗体
        this.setResizable(false);
        // 5.窗体居中
        // 5.1 获取屏幕的高
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        // 5.2 获取屏幕的宽
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        // 5.3 计算窗体的坐标
        int x = (width - this.getSize().width) >> 1;
        int y = (height - this.getSize().height) >> 1;
        // 5.4 设置坐标
        this.setLocation(x, y);
        // 6. 设置窗体
        this.add(new JPanelGame());
        // 7. 设置窗体默认可见
        this.setVisible(true);
    }
}
