import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.util.Random;

class Drawer extends JPanel {

    private static final long serialVersionUID = 1L;
    private JFrame window = new JFrame();
    
  //set the length of each side of the square
    public static final int SQUARESIZE = 10;
    
    //get matrix variables
    public static final int BEZZLE = LOTR_Driver.getBezzle();
    private int rows = 0;
    private int columns = 0;
    
    

    public Drawer(int rows, int columns) {
    	this.rows = rows;
    	this.columns = columns;
        initUI();
    }

    private void initUI() {
        window.add(this);
        window.setTitle("2D Drawing");
        window.setSize((this.columns*SQUARESIZE),(this.rows*SQUARESIZE)+BEZZLE);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    private void doDrawing(Graphics g) {

        /*
            RGB Colors:
            ================================================
            Black       => (0, 0, 0)        => low elevation
            Mid Grey    => (128, 128, 128)  => mid elevation
            White       => (255, 255, 255)  => high elevation

            Grey Scale colors are scaled in matching set of 3 numeric values
        */

        Graphics2D g2d = (Graphics2D) g;
                
        //sets the starting point for drawing squares
        int x = 0, y = 0;
               
        //loops that draw the squares in column major order
        //x moves horizontally, y moves vertically
        for(int i = 0; i < this.columns; ++i){
        	for(int j = 0; j < this.rows; j++) {
        		//g2d.fillRect(x, y, SQUARESIZE, SQUARESIZE);
        		g2d.drawRect(x, y, SQUARESIZE, SQUARESIZE);
        		y += SQUARESIZE;
        	}
        	//reset y back to 0 and then move x one block to the right
        	y = 0;
            x += SQUARESIZE;
        }
        
        //loops through the creatures list and prints the creatures
        for(Creature c: LOTR_Driver.creatures) {
        	Coordinate location = new Coordinate(c.getCoordinate());
        	System.out.println("Location: " + location.toString());
        	
        	Color color = c.getColor();
        	g2d.setColor(color);
        	
        	System.out.println(g2d.getColor().toString());
        	
        	int xC = SQUARESIZE*(c.getCoordinate().getCol());
        	int yC = SQUARESIZE*(c.getCoordinate().getRow());
        	
        	g2d.fillRect(xC, yC, SQUARESIZE, SQUARESIZE);
        }
        

//        g2d.setColor(new Color(0, 0, 0));
//        y = 10; x += 15;
//        for(int i = 0; i < 30; ++i){
//            g2d.fillRect(x, y, 20, 10);
//            y += 15;
//        }
//
//        g2d.setColor(new Color(128, 128, 128));
//        y = 10; x += 15;
//        for(int i = 0; i < 30; ++i){
//            g2d.fillRect(x, y, 10, 10);
//            y += 15;
//        }
//
//        g2d.setColor(new Color(200, 200, 200));
//        y = 10; x += 15;
//        for(int i = 0; i < 30; ++i){
//            g2d.fillOval(x, y, 10, 10);
//            y += 15;
//        }

//        int width = getWidth();
//        int height = getHeight();
//        g2d.setColor(Color.GREEN);
//        String s = "I'm a graphics programmer now!!";
//        g2d.drawString(s, (width / 2) - s.length() * 3 , height / 2);
//
//        g2d.setColor(Color.RED);
//        Random random = new Random();
//        for(int i = 0; i < 2000; i++){
//            x = Math.abs(random.nextInt()) % width;
//            y = Math.abs(random.nextInt()) % height;
//            g2d.drawLine(x, y, x + 2, y + 2);
//        }
    }
} // end class

