import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;
import java.lang.Math;

public class CatRun extends JPanel implements KeyListener {

    int x = 0;
    private int xpos=300; // x position of the cat 
	private int ypos=80;
    private int roadmove=0;
    private ImageIcon tree1,tree2,tree3; // tree image
    private int tree1xpos=400,tree2xpos=-200,tree3xpos=-500,tree4xpos=100,tree5xpos=-300,tree6xpos=500; // x position of the trees
    private int num1=400;
    Random random=new Random(); // random number generator
    private ImageIcon cat;
    private int m = 0;
    int goal = random.nextInt(80,200);
    boolean end = false;

    public CatRun() {
        addKeyListener(this);
        setFocusable(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(new Color(0X82CD47));
        g.fillRect(0, 0, 700, 700);
        g.setColor(new Color(0X9F8772));
        g.fillRect(0,200,700,100);

        // draw the road lines 
        if(roadmove==0)
        {
            for(int i=0; i<=700; i+=100) 
            { 	// draw the road lines
                g.setColor(Color.white);
                g.fillRect(i, 250 ,70, 10); // 
        
            }
            roadmove=1; // set the roadmove to 1
        }
        else if(roadmove==1)
        { // draw the road lines again for the next frame
            for(int i=50; i<=700; i+=100)
            {
                g.setColor(Color.white);
                g.fillRect(i, 250 ,70, 10);
            }
            roadmove=0; // set the roadmove to 0
        }

        try {
            tree1=new ImageIcon(ImageIO.read(getClass().getResource("tree.png"))); // load the tree image
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            tree2=new ImageIcon(ImageIO.read(getClass().getResource("tree.png"))); // load the tree image
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        try {
            tree3=new ImageIcon(ImageIO.read(getClass().getResource("tree.png"))); // load the tree image
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        tree1.paintIcon(this, g, tree1xpos, 0); // draw the tree image on the screen
        num1=random.nextInt(500); // generate a random number
        tree2.paintIcon(this, g, tree2xpos, 0); // draw the tree image on the screen
        tree3.paintIcon(this,g,tree3xpos, 0); // draw the tree image on the screen
        tree1.paintIcon(this,g,tree4xpos, 600);
        tree3.paintIcon(this, g,tree5xpos, 600);
        tree2.paintIcon(this, g,tree6xpos, 600);
        
            
        if(tree1xpos>700)
        { // if the tree goes out of the screen then reset the tree
            num1=random.nextInt(500); // generate a random number
            tree1xpos=-num1; // reset the x position of the tree
        }
        if(tree2xpos>700)
        { 
            num1=random.nextInt(500);
            tree2xpos=-num1;
        }
        if(tree3xpos>700)
        {
            num1=random.nextInt(500);
            tree3xpos=-num1;
        }
        if(tree4xpos>700)
        { // if the tree goes out of the screen then reset the tree
            num1=random.nextInt(500);
            tree4xpos=-num1;
        }
        if(tree5xpos>700)
        {
            num1=random.nextInt(500);
            tree5xpos=-num1;
        }
        if(tree6xpos>700)
        { // if the tree goes out of the screen then reset the tree
            num1=random.nextInt(500);
            tree6xpos=-num1;
        }

        // load image for cat
		try {
			cat=new ImageIcon(ImageIO.read(getClass().getResource("cat.png"))); // load the cat image 
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		// cat=new ImageIcon("cat.png");
		cat.paintIcon(this,g,xpos,ypos); // draw the cat image on the screen

        
        //km
        if(m < 39){    
            g.setColor(Color.red);
            g.fillRect(40,35,150,50);
            g.setColor(Color.black);
            g.fillRect(45,40, 140, 40);
            g.setColor(Color.white);
            g.setFont(new Font("MV Boli",Font.BOLD,30));
            g.drawString(m + " m", 50, 67);
        }        
        if(end == false){
            g.setColor(Color.red);
            g.fillRect(340,35,300,50);
            g.setColor(Color.black);
            g.fillRect(345,40, 290, 40);
            g.setColor(Color.white);
            g.setFont(new Font("MV Boli",Font.BOLD,30));
            g.drawString(goal + " mを目指せ！", 350, 67);
        }
        //ENTERが押されたら
        else if(end == true){
            g.setColor(Color.red);
            g.fillRect(40,35,630,50);
            g.setColor(Color.black);
            g.fillRect(45,40, 620, 40);
            g.setColor(Color.white);
            g.setFont(new Font("MV Boli",Font.BOLD,30));
            g.drawString("あなた: " + m + "m 目標: " + goal + "m 差は " + Math.abs(goal - m) + "m!", 50, 67);
        }
    }
        public static void main(String[] args) {
            JFrame frame = new JFrame();
            frame.setBounds(300,10,700,300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new CatRun());
            frame.setVisible(true);
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                x -= 10;
                tree1xpos+=50;
                tree2xpos+=50;
                tree3xpos+=50;
                tree4xpos+=50;
                tree5xpos+=50;
                tree6xpos+=50;
                m++;
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                x += 10;
                tree1xpos-=50;
                tree2xpos-=50;
                tree3xpos-=50;
                tree4xpos-=50;
                tree5xpos-=50;
                tree6xpos-=50;
                m--;
            } 
            else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                end = true;
            }
            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
}