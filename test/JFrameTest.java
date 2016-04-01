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
 * @Description:  һ�仰��������Ĺ���  
 * @Author:       Administrator
 * @CreateDate:   2016��3��28�� ����1:18:07
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016��3��28�� ����1:18:07 
 * @UpdateRemark: ˵�������޸�����  
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
//		tabbedPane.addTab("��ҳ", null, panel, null);
		 //���ô����������  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setSize(960,720);  
        this.setLocationRelativeTo(null);
        setTitle("apiTest");  
        container = getContentPane();  
          
        //����Ĭ���ڶ�����JTabbedPane  
        tabbedPane = new JTabbedPane();  
          
        //��������ߵ�JTabbedPane,���������������ĸ�������ʾJTabbedPane  
//        tabbedPane = new JTabbedPane(JTabbedPane.LEFT);  
          
        //���մ���˳��Ϊ��Ƭ������ӿ�Ƭ��ÿ����Ƭ�����з����в�ͬ�����������addTab����Ҳ�ж������ط�ʽ  
        tabbedPane.addTab("A", new JButton("btn-A"));  
        tabbedPane.addTab("B", new JLabel("lbl-B"));  
//        tabbedPane.addTab("C",new ImageIcon(JFrameTest.class.getResource("welcome.jpg")),new JSplitPane(),"������ʾ��Ϣ������");  
        tabbedPane.addTab("D",new JPasswordField());  
        tabbedPane.addTab("E",new JTextArea());  
          
        //ע�ῨƬ����ѡ��ı��¼�  
        tabbedPane.addChangeListener(new ChangeListener(){  
            public void stateChanged(ChangeEvent arg0) {  
                //����ѡ��Ŀ�Ƭ����  
                tabbedPane.setEnabledAt(tabbedPane.getSelectedIndex(), false);  
            }  
        });  
          
          
        //��ӵ����ݴ���  
        container.add(tabbedPane,BorderLayout.CENTER);  
	}

}
