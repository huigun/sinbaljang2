package myProject01_20221212;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
class UI extends BasicTabbedPaneUI
{

 @Override
 protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
  // TODO Auto-generated method stub
//���� ���̴� �κ� ���⼭ �׷��ְ�
//  g.setColor(Color.gray);
  g.setColor(Color.black);
  g.drawRoundRect(x, y, w, h, 10, 10);
  g.setFont(new Font("���� ���", Font.PLAIN,15));
  
  if (isSelected)
  {
//����� ���ý� �����ִ� �κ��� �׷��ָ� �˴ϴ�.   
//   g.setColor(Color.gray);
   g.setColor(Color.black);
   g.drawLine(x+4 , y+4 ,  x+w-4 , y+4);
   
  
  }

 }
}

public class TestBasicTabbedPaneUI
{
 public static void main(String[] args)
 {
  JFrame vFrame = new JFrame();
  vFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  vFrame.setSize(200, 200);
 
  JTabbedPane Tab = new JTabbedPane();
  Tab.setUI(new UI());

  Tab.add("�Ǹ�", new JPanel());
  Tab.add("Two", new JPanel());
  Tab.add("Three", new JPanel());
   
  vFrame.getContentPane().add(Tab);
  vFrame.setTitle("Tabs Example");
  vFrame.show();
 }
}