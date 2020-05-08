import static org.junit.jupiter.api.Assertions.*;

import java.awt.EventQueue;

import org.junit.jupiter.api.Test;

class test_grid_size5x5 {
	
	
	@Test
	void test() {
		int rows = 5;
		int columns = 5;
		
		//draw the map
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() { 
                Drawer ex = new Drawer(rows, columns);
                ex.setVisible(true);
            }
        });
	}

}
