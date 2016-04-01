package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Dimension;
import javax.swing.JMenuBar;
import java.awt.Button;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JSplitPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  test
 * @Package:      test.JFrameTest.java
 * @ClassName:    JFrameTest
 * @Description:  一句话描述该类的功能  
 * @Author:       Administrator
 * @CreateDate:   2016年3月28日 下午1:18:07
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016年3月28日 下午1:18:07 
 * @UpdateRemark: 说明本次修改内容  
 * @Version:      v1.0
 *    
 */
public class JFrameTest extends JFrame {

	private JPanel contentPane;
    private Container container = null ;     
    private JTabbedPane tabbedPane = null ; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameTest frame = new JFrameTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameTest() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(450, 180, 1050, 640);
//		contentPane = new JPanel();
//		contentPane.setPreferredSize(new Dimension(100, 100));
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
//		
//		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
//		tabbedPane.setPreferredSize(new Dimension(5, 30));
//		contentPane.add(tabbedPane, BorderLayout.NORTH);
//		
//		JPanel panel = new JPanel();
//		tabbedPane.addTab("首页", null, panel, null);
		 //设置窗体基本属性  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setSize(960,720);  
        this.setLocationRelativeTo(null);
        setTitle("apiTest");  
        container = getContentPane();  
          
        //创建默认在顶部的JTabbedPane  
        tabbedPane = new JTabbedPane();  
          
        //创建在左边的JTabbedPane,可以在上下左右四个方向显示JTabbedPane  
//        tabbedPane = new JTabbedPane(JTabbedPane.LEFT);  
          
        //按照代码顺序为卡片窗格添加卡片，每个卡片窗格中放置有不同的组件，并且addTab方法也有多种重载方式  
        tabbedPane.addTab("A", new JButton("btn-A"));  
        tabbedPane.addTab("B", new JLabel("lbl-B"));  
//        tabbedPane.addTab("C",new ImageIcon(JFrameTest.class.getResource("welcome.jpg")),new JSplitPane(),"这是提示信息，哈哈");  
        tabbedPane.addTab("D",new JPasswordField());  
        tabbedPane.addTab("E",new JTextArea());  
          
        //注册卡片窗格选择改变事件  
        tabbedPane.addChangeListener(new ChangeListener(){  
            public void stateChanged(ChangeEvent arg0) {  
                //禁用选择的卡片窗格  
                tabbedPane.setEnabledAt(tabbedPane.getSelectedIndex(), false);  
            }  
        });  
          
          
        //添加到内容窗格  
        container.add(tabbedPane,BorderLayout.CENTER);  
	}

}
