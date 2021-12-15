package test;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
//Java8版本测试通过
 
//DemoFrame 继承自 JFrame
public class test2 extends JFrame{
 
    JButton jb1,jb2;// 1个按钮
     
    public test2() {
 
        jb1 = new JButton("弹窗一"); 
        jb2 = new JButton("弹窗二"); 
        JPanel jp = new JPanel();   //创建面板
        jp.add(jb1);jp.add(jb2);
        this.add(jp);//把面板添加到窗口
         
        //弹窗1
        jb1.addActionListener(e->{
            JOptionPane.showMessageDialog(this, "利用JOptionPane弹窗简单窗口", "弹窗1", JOptionPane.INFORMATION_MESSAGE);
        });
         
        //弹窗2
        MyDialog md=new MyDialog(this);
        jb2.addActionListener(e->{
            md.setVisible(true);
        });
         
        //窗体部分的设置
        setTitle("父窗口");//设置标题
        setSize(320, 300); // 设置窗口大小
        setLocationRelativeTo(null); //设置窗口在屏幕的中央
        setDefaultCloseOperation(EXIT_ON_CLOSE);//点击关闭按钮时退出
    }
     
    //main方法
    public static void main(String[] args) {
        EventQueue.invokeLater(()->new test2().setVisible(true));//创建窗口并设置可见
    }
}
 
//自定义弹出窗口类
class MyDialog extends JDialog{
    public MyDialog(test2 frame) {
        super(frame);//给弹窗指定父窗口this
        setTitle("弹窗2"); 
        setModal(true);//!!! 设置为模态窗口,父窗口不能被点击
        setSize(170,92);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//点击关闭按钮时销毁弹窗
         
        //JDialog作为弹窗 有很大的自由度, 可以像JFrame一样添加各种组件
        JLabel jl = new JLabel("利用JDialog 来作为弹窗");
        add(jl);
    }
}
