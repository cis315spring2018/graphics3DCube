/**
 *   file: mainJFrame.java
 */
package graphics3DCube;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


/**
 * @author atmanning - atmanning@dbq.edu
 *
 */
public class mainJFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainJFrame frame = new mainJFrame();
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
	public mainJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JButton btnMoveMe = new JButton("move me");
		contentPane.add(btnMoveMe);
		
		JSlider slider = new JSlider();
		
		// this event is fired when the slider is moved
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider me = (JSlider)e.getSource();
				btnMoveMe.setLocation( me.getValue(),(int)btnMoveMe.getLocation().getY());
			}
		});
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(50);
		slider.setMinimum(50);
		slider.setMaximum(400);
		slider.setMinorTickSpacing(1);
		slider.setSnapToTicks(true);
		slider.setValueIsAdjusting(true);
		slider.setPaintTicks(true);

		sl_contentPane.putConstraint(SpringLayout.NORTH, btnMoveMe, 73, SpringLayout.SOUTH, slider);
		sl_contentPane.putConstraint(SpringLayout.NORTH, slider, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, slider, -104, SpringLayout.EAST, contentPane);

		
		JSlider slider_1 = new JSlider();
		
		// handle movement of the slider
		slider_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider me = (JSlider)e.getSource();
				btnMoveMe.setLocation( (int)btnMoveMe.getLocation().getX(),me.getValue());
			}
		});
		slider_1.setInverted(true);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnMoveMe, 101, SpringLayout.EAST, slider_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, slider_1, 68, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, slider_1, 90, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, slider_1, 10, SpringLayout.WEST, contentPane);
		slider_1.setMinimum(50);
		slider_1.setMaximum(500);
		slider_1.setMajorTickSpacing(100);
		slider_1.setPaintTicks(true);
		slider_1.setPaintLabels(true);
		slider_1.setOrientation(SwingConstants.VERTICAL);
		contentPane.add(slider_1);
		contentPane.add(slider);
	}
}
