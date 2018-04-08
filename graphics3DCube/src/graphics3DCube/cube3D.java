/**
 *   file: cube3D.java
 */
package graphics3DCube;

import java.awt.Point;
import java.util.ArrayList;


/**
 * @author atmanning - atmanning@dbq.edu
 *
 */
public class cube3D {
	
	// a cube consists of an arraylist of 3D points
	ArrayList<Point3D> corners = new ArrayList<>();
	double xTheta = 0;
	double yTheta = 0;
	double zTheta = 0;
	double dScaleFactor = 1;
	
	cube3D() { // default return unit cube centered at 0,0,0
		double x = -0.5;
		double y = -0.5;
		double z = -0.5;
		
		corners.add(new Point3D(x,y,z));
		z = -z;
		corners.add(new Point3D(x,y,z));
		y = -y;
		corners.add(new Point3D(x,y,z));
		z = -z;
		corners.add(new Point3D(x,y,z));
		x = -x;
		corners.add(new Point3D(x,y,z));
		z = -z;
		corners.add(new Point3D(x,y,z));
		y = -y;
		corners.add(new Point3D(x,y,z));
		z = -z;
		corners.add(new Point3D(x,y,z));		

	}  // end constructor
	
	
	// scale all dimensions equally
	public void scaleXYZ( double f ) {
		for( Point3D p : corners ) {
			p.x *= f;
			p.y *= f;
			p.z *= f;
		}
	}
	
	
	ArrayList<Point> cube3Dto2D() {
		// render a 3D cube into 2D plane
		ArrayList<Point> corners2D = new ArrayList<>();
		
		// Project each point from cube3D onto the 2D plane
		for( Point3D p : corners ) {
			double cx = Math.cos(xTheta);
			double cy = Math.cos(yTheta);
			double cz = Math.cos(zTheta);
			double sx = Math.sin(xTheta);
			double sy = Math.sin(yTheta);
			double sz = Math.sin(zTheta);
			double dx = cy*(sz*p.y + cz*p.x)-sy*p.z;
			double dy = sx*(cy*p.z + sy*(sz*p.y+cz*p.x)) + cx*(cz*p.y -sz*p.x);
			double dz = cx*(cy*p.z + sy*(sz*p.y+cz*p.x)) - sx*(cz*p.y -sz*p.x);
		
			double bx = dx * dScaleFactor;
			double by = dy * dScaleFactor;
			
			corners2D.add( new Point((int)bx, (int)by ));
		}
		
		return corners2D;
	}  // end cube3Dto2D

}
