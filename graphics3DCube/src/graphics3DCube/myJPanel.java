/**
 *   file: myJPanel.java
 */
package graphics3DCube;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * @author atmanning - atmanning@dbq.edu
 *
 */
public class myJPanel extends JPanel {

	// this subclass is only needed to allow me to Override
	// the paint method to draw my cool graphics!

	ArrayList<cube3D> myObjects = new ArrayList<>();

	void cubeAdd(cube3D c) {
		myObjects.add(c);
	}

	@Override
	public void paint(Graphics g) {

		super.paint(g);

		// without this if statement, the Windowbuilder designer gives a blank panel!
		if (0 < myObjects.size()) {
			
			// draw my cube in the center
			cube3D myCube = myObjects.get(0);
			ArrayList<Point> pnts2D = myCube.cube3Dto2D();

			// translate the cube to the center of this frame
			int xCenter = g.getClipBounds().width / 2;
			int yCenter = g.getClipBounds().height / 2;
			for (Point p : pnts2D) {
				p.x += xCenter;
				p.y += yCenter;
			}

			// just for reference, draw a circle
			g.drawOval(xCenter - 50, yCenter - 50, 100, 100);

			// draw a line between all the points
			Point pntStart = pnts2D.get(0);
			Point pnt1 = null;
			Point pnt2 = null;
			for (Point p : pnts2D) {
				if (null == pnt1)
					pnt1 = p;
				else {
					pnt2 = p;
					g.drawLine(pnt1.x, pnt1.y, pnt2.x, pnt2.y);
					pnt1 = pnt2;
				}
			}

			// finally, connect a line between the last point and first
			g.drawLine(pntStart.x, pntStart.y, pnt2.x, pnt2.y);

		}
	}

}
