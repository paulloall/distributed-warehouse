package br.furb.diswah.view;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.layout.AC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;
import br.furb.diswah.resource.MessageBundle;
import br.furb.diswah.service.LoginService;
import br.furb.diswah.transport.TransportFactory;
import br.furb.diswah.transport.TransportMethod;
import br.furb.diswah.transport.TransportProperties;

/**
 * 
 * @author Andr� Felipe de Almeida {almeida.andref@gmail.com}
 */
public class LoginScreen extends JFrame{
	
	private JPanel pnPrincipal;
	
	private JLabel lbLogin;
	private JTextField tfLogin;
	
	private JLabel lbPassword;
	private JPasswordField pfPassword;
	
	private JButton btLogin;
	private JButton btCancel;

	public LoginScreen(){
		configFrame();
		createComponents();
	}

	/**
	 * 
	 */
	private void configFrame() {
		try {
			//UIManager.setLookAndFeel(nlaf);
		} catch (Exception e) {
			System.err.println("Ocorreu um erro ao carregar o look and feel.");
		}
		setLayout(new MigLayout(new LC().insets("10").debug(debugMillis),new AC().grow(),new AC().grow()));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(407, 295));
        setResizable(false);
        setLocation(new Point(1800,200));
        setTitle(MessageBundle.getInstance().getMessage("frame.login.title"));
	}
	private int debugMillis = 10;
	/**
	 * 
	 */
	private void createComponents() {
		pnPrincipal = new JPanel(new MigLayout("debug, insets 10","[align right][grow]","grow"));
		
		lbLogin = new JLabel(MessageBundle.getInstance().getMessage("frame.login.label.login"));
		pnPrincipal.add(lbLogin);
		tfLogin = new JTextField();
		pnPrincipal.add(tfLogin, "growx,wrap");
		
		lbPassword = new JLabel(MessageBundle.getInstance().getMessage("frame.login.label.password"));
		pnPrincipal.add(lbPassword);
		pfPassword = new JPasswordField();
		pnPrincipal.add(pfPassword, "growx,wrap");

		btLogin = new JButton(MessageBundle.getInstance().getMessage("frame.login.button.login"));
		btLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				TransportProperties prop = new TransportProperties();
				prop.setHost("localhost");
				try {
					LoginService service = TransportFactory.createCommunication(prop, TransportMethod.RMI)
														   .requestInterface(LoginService.class, new Object[]{});
					service.login(tfLogin.getText(), pfPassword.getText());
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		});
		pnPrincipal.add(btLogin,"");
		
		btCancel = new JButton(MessageBundle.getInstance().getMessage("frame.login.button.cancel"));
		pnPrincipal.add(btCancel);
		
		this.add(pnPrincipal,"grow");
	}
	
	public static void main(String[] args) {
		new LoginScreen().setVisible(true);
	}
	
}