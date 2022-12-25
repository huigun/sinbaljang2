package myProject01_20221212;

//*
// * Created on 2005. 4. 27.
// *
// * TODO To change the template for this generated file go to
// * Window - Preferences - Java - Code Style - Code Templates
// */
//
///**
// * @author DDosin
// *
// * TODO To change the template for this generated type comment go to
// * Window - Preferences - Java - Code Style - Code Templates
// */
//
///**
// * �ڹٿ��� GUI �ڵ��Ҷ� RED���� ���� �ʰ� �۾��ÿ� ���̾ƿ� �����ϱ� ¥������ �����
// * �⺻�����δ� �� Ŭ���������� ���̾ƿ� ������ �����ϵ��� ���� �Ǿ� ����
// * ���������� null ���̾ƿ��� ���� �����Ǿ� ����
// * ���״� ���ڰ� ���� ���� ���� ^^;; 
// * Ư���� ��������� ������� �ƴ϶� ���� ���� �� �� ���� 
// * �׷��� ���̵����� �������� 3�ð� �ɷ��� ���� �׽�Ʈ���� �� �� �ɸ�
// * 
// * ���̾ƿ� �����ڷ� �⺻������ �ٸ� ���̾ƿ��� ���� �ʴ´ٸ� �̰� �ϳ��� ������ ������ ����
// * �ֻ��� �����̳ʸ� ���� �ְ� ������ JFrame
// * ���۰����� �ȼ����� ����ְ� ũ��� ���� �����̳��� ũ�⿡�� �ۼ�Ʈ�� �ָ�� 
// * 50 �̸� 50% �� �� 
// * ���� ��� addContainer(p1,0,0,50,25); �̸� 
// * p1 �����̳ʸ� ������ 0, 0 ���� �θ� �����̳��� ���� ũ�� 50% ���� ũ�� 25% �� �ָ��
// * �������� ���ΰ� �ۼ�Ʈ ���� 100 �ʰ� �� �ָ� ��� ����.. ^^;;
// * ������Ʈ�� �������� ���������ҰͰ� �׳� ũ�⸦ �������� �Ұ� 
// * addComponent �� ũ�Ⱑ �����ΰ� ���۰��� ������ ��� �ȼ� �� 
// * addComponentResize �� ���۰��� �ȼ��� ������ �伾Ʈ ��
// * 
// * �������� ���� �����̳��� ���� �������� ȭ�� �ȼ������� ��� ����
// * �� ���밪�� �ƴ϶� ������ΰ� ���� �����̳��� ��ġ�� ���ϸ� ���� ����  
// * 
// * ���� scrollpane �����̳ʷ� ��� ���� ���� ������Ʈ�� ����ϸ鼭 �۾�
// 
//

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class NullLayoutManager implements ComponentListener
{
	private Container c;	// �ֻ��� �����̳� �ʼ�
	private Hashtable components;	// ������� �ʿ��� ������Ʈ���� ����
	private Hashtable containers;	// �����̳� ����� ����
//	 ����ڿ� ���� ComponentListener �籸���� �ʿ��� ��츦 ���� ����ġ �ϱ� ���ؼ� 
	private ComponentListener listener;	

	// �����ڷ� �ֻ��� �����̳ʿ� �ֻ��� �����̳��� ũ�Ⱚ ������ ����ڰ�  ComponentListener ������ �Ҷ� �ʿ��� 
	public NullLayoutManager(Container c, int sizeX, int sizeY,ComponentListener listener)
	{
		this. c = c;
		components = new Hashtable();
		containers = new Hashtable();
		c.setLayout(null);
		c.addComponentListener(this);
		c.setSize(sizeX,sizeY);
		
		this.listener = listener;
	}
	
	// �����ڷ� �ֻ��� �����̳ʿ� �ֻ��� �����̳��� ũ�Ⱚ ����
	public NullLayoutManager(Container c, int sizeX, int sizeY)
	{
		this. c = c;
		components = new Hashtable();
		containers = new Hashtable();
		c.setLayout(null);
		c.addComponentListener(this);
		c.setSize(sizeX,sizeY);
	}
	
	// �ֻ��� �����̳ʿ� ������Ʈ�� add �ϴ� ������ x,y �� ������ width ,height �� ����  
	public void addComponent(Component comp, int x, int y, int width, int height)
	{
		comp.setBounds(x,y,width,height);
		c.add(comp);		
	}

	// �ֻ��� �����̳ʿ� ������Ʈ�� add �ϴ� ������ x,y �� ������ widthPer ,heightPer �� ������Ʈ�� ũ�� �伾Ʈ��
	// ���� �����̳��� ũ�Ⱑ ���ϸ� ������Ʈ�� �ڵ����� ��������� 
	public void addComponentResize(Component comp, int x, int y, int widthPer, int heightPer)
	{
		Dimension d = c.getSize();
		//System.out.println(d);
		
		int width = (int)d.getWidth();
		int height = (int)d.getHeight();

		int sizeWidth = width*widthPer/100;
		int sizeHeight = height*heightPer/100;
	//	System.out.println(" "+sizeWidth+" "+sizeHeight);
		comp.setBounds(x,y,sizeWidth,sizeHeight);
		c.add(comp);
		
		if(x<1)
			x=1;
		if(y<1)
			y=1;
		if(width < 1)
			width =1;
		if(height < 1)
			height =1;
		
		
		int startX = (x*100)/width;
		int startY = (y*100)/height;
		PointEx p = new PointEx(startX, startY,widthPer, heightPer);
		
		components.put(comp,p);
		//c.validate();
	}

	// parent �����̳ʿ� ������Ʈ�� add �ϴ� ������ x,y �� ������ width ,height �� ���� 
	public void addComponent(Container parent,Component comp, int x, int y, int width, int height)
	{
		comp.setBounds(x,y,width,height);
		parent.add(comp);
		
	}
	

	// parent �����̳ʿ� ������Ʈ�� add �ϴ� ������ x,y �� ������ widthPer ,heightPer �� ������Ʈ�� ũ�� �伾Ʈ��
	// parent �����̳��� ũ�Ⱑ ���ϸ� ������Ʈ�� �ڵ����� ��������� 
	public void addComponentResize(Container parent,Component comp, int x, int y, int widthPer, int heightPer)
	{
		Dimension d = c.getSize();
		
		//System.out.println(d);
		
		int width = (int)d.getWidth();
		int height = (int)d.getHeight();

		int sizeWidth = width*widthPer/100;
		int sizeHeight = height*heightPer/100;
	//	System.out.println(" "+sizeWidth+" "+sizeHeight);
		comp.setBounds(x,y,sizeWidth,sizeHeight);
		parent.add(comp);
		
		if(x<1)
			x=1;
		if(y<1)
			y=1;
		if(width < 1)
			width =1;
		if(height < 1)
			height =1;
		
		
		int startX = (x*100)/width;
		int startY = (y*100)/height;
		PointEx p = new PointEx(startX, startY,widthPer, heightPer);
		
		components.put(comp,p);
	}
	
	// �ֻ��� �����̳ʿ� child �����̳ʸ� add �ϴ� ������  x,y �� ������ widthPer ,heightPer �� ������Ʈ�� ũ�� �伾Ʈ��
	public void addContainer(Container child, int x, int y, int widthPer, int heightPer)
	{
		Dimension d = c.getSize();
		child.setLayout(null);
		//System.out.println(d);
		
		int width = (int)d.getWidth();
		int height = (int)d.getHeight();

		int sizeWidth = width*widthPer/100;
		int sizeHeight = height*heightPer/100;
	//	System.out.println(" "+sizeWidth+" "+sizeHeight);
		child.setBounds(x,y,sizeWidth,sizeHeight);
		c.add(child);
		
		if(x<1)
			x=1;
		if(y<1)
			y=1;
		if(width < 1)
			width =1;
		if(height < 1)
			height =1;
		
		
		int startX = (x*100)/width;
		int startY = (y*100)/height;
		PointEx p = new PointEx(startX, startY,widthPer, heightPer);
		
		containers.put(child,p);
	}
	
	// �ֻ��� �����̳ʿ� child �����̳ʸ� add �ϴ� ������  x,y �� ������ widthPer ,heightPer �� ������Ʈ�� ũ�� �伾Ʈ��
	// parent �����̳��� ũ�Ⱑ ���ϸ� child �����̳ʵ� �ڵ����� ��������� 
	public void addContainer(Container parent, Container child, int x, int y, int widthPer, int heightPer)
	{
		
		child.setLayout(null);
		Dimension d = c.getSize();
		
		//System.out.println(d);
		
		int width = (int)d.getWidth();
		int height = (int)d.getHeight();

		int sizeWidth = width*widthPer/100;
		int sizeHeight = height*heightPer/100;
	//	System.out.println(" "+sizeWidth+" "+sizeHeight);
		child.setBounds(x,y,sizeWidth,sizeHeight);
		parent.add(child);
		
		if(x<1)
			x=1;
		if(y<1)
			y=1;
		if(width < 1)
			width =1;
		if(height < 1)
			height =1;
		
		
		int startX = (x*100)/width;
		int startY = (y*100)/height;
		PointEx p = new PointEx(startX, startY,widthPer, heightPer);
		
		containers.put(child,p);
	}

	//
	// �������̽� ComponentListener ��� �޾� �� ���� �س��� �޼ҵ�
	//
	public void componentResized(ComponentEvent e)
	{
		
		
		Enumeration<Container> test = containers.keys();
		
		while(test.hasMoreElements())
		{
			Container c = (Container)test.nextElement();
			PointEx p = (PointEx)containers.get(c);
			
			//System.out.println(p);
			
			Container parent = c.getParent();
			
			Dimension d = parent.getSize();
			int width = (int)d.getWidth();
			int height = (int)d.getHeight();
			
			int x = (p.x * width)/100;
			int y = (p.y * height)/100;
			
			int sizeX = (p.width * width)/100;
			int sizeY = (p.height * height)/100;
			
			//System.out.print("startX "+x+" startY "+y);

			//System.out.println(" width "+sizeX+" height "+sizeY);
			c.setLocation(x,y);
			c.setSize(sizeX,sizeY);
			
			//c.repaint();
			
		}
		
		Enumeration enumCom = components.keys();
		
		while(enumCom.hasMoreElements())
		{
			Component com = (Component)enumCom.nextElement();
			PointEx p = (PointEx)components.get(com);
			
			//System.out.println(p);
			
			Container parent = com.getParent();
			Dimension d = parent.getSize();
			int width = (int)d.getWidth();
			int height = (int)d.getHeight();
			int x = (p.x * width)/100;
			int y = (p.y * height)/100;
			int sizeX = (p.width * width)/100;
			int sizeY = (p.height * height)/100;
			//System.out.print("startX "+x+" startY "+y);

			//System.out.println(" width "+sizeX+" height "+sizeY);
			com.setLocation(x,y);
			com.setSize(sizeX,sizeY);
			
		}
			
		c.validate();
		
	}

	public void componentMoved(ComponentEvent e)
	{
		if(listener != null)
		{
			listener.componentMoved(e);
		}
	}	
	public void componentShown(ComponentEvent e)
	{
		if(listener != null)
		{
			listener.componentShown(e);
		}
	}
	public void componentHidden(ComponentEvent e)
	{
		if(listener != null)
		{
			listener.componentHidden(e);
		}
	}
	
	
		// ������ �׽�Ʈ ���� �Ű� ���ʿ� ���� 
	public static void main(String[] args) 
	{
		Frame f = new Frame("test");
		NullLayoutManager aa = new NullLayoutManager(f,500,500);

		Button b1 = new Button("button resize");
		Button b2 = new Button("button static");
		//Button b3 = new Button("button frame");
		
		Panel p1 = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
	//	NullLayoutManager aa1 = new NullLayoutManager(p3,500,500);
		p1.setBackground(Color.black);
		p2.setBackground(Color.BLUE);
		p3.setBackground(Color.GRAY);
		
		aa.addContainer(p1,0,0,50,50);
		aa.addContainer(p2,250,0,50,50);
		aa.addContainer(p3,0,250,100,50);
		
		aa.addComponent(p3,b2,20,20,100,20);
		aa.addComponentResize(p3,b1,150,20,30,20);

		f.show();
	}
	
		// ���� Ŭ������ �������� ������ �����ϱ� ���� �ʿ� 
	class PointEx
	{
		int x;
		int y;
		int width;
		int height;
	
		public PointEx(int x, int y, int width, int height)
		{
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			
		}
		
		public String toString()
		{
			return new String("x-"+x+" y-"+y+" width-"+width+" height-"+height);
		}
	}
	
	
}
