package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Piramide;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Principal extends JFrame {
	
	Graphics2D desenhoPiramide;
	Piramide piramide;
	
	double[][] matrizPontosProjecao = new double[5][4];
	int[][] matrizPontosResultantes = new int[5][2];
	
	int windowXMin = 0;
	int windowXMax = 0;
	int windowYMin = 0;
	int windowYMax = 0;
	
	int viewportXMin = 0;
	int viewportXMax = 0;
	int viewportYMin = 0;
	int viewportYMax = 0;

	private JPanel jPnl_principal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("Câmera Virtual - Pipeline de Visualização 3D");		
		
		setResizable(false);								
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1450, 701);
		jPnl_principal = new JPanel();
		jPnl_principal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(jPnl_principal);
		jPnl_principal.setLayout(null);
		
		JLabel jLbl_imagem = new JLabel("");
		jLbl_imagem.setBackground(Color.GRAY);
		jLbl_imagem.setFont(new Font("Arial", Font.BOLD, 24));
		jLbl_imagem.setHorizontalAlignment(SwingConstants.CENTER);
		jLbl_imagem.setBounds(707, 10, 719, 400);
		jLbl_imagem.setBackground(Color.black);
		jPnl_principal.add(jLbl_imagem);	
		
		JLabel jLbl_menuManipulaObjeto = new JLabel("Manipular o objeto");
		jLbl_menuManipulaObjeto.setFont(new Font("Arial", Font.BOLD, 18));
		jLbl_menuManipulaObjeto.setBounds(10, 10, 256, 40);
		jPnl_principal.add(jLbl_menuManipulaObjeto);
		
		JLabel jLbl_ManipulaObjetoTranslacaoX = new JLabel("Translação - X:");
		jLbl_ManipulaObjetoTranslacaoX.setFont(new Font("Arial", Font.BOLD, 14));
		jLbl_ManipulaObjetoTranslacaoX.setBounds(10, 60, 110, 30);
		jPnl_principal.add(jLbl_ManipulaObjetoTranslacaoX);
		
		JLabel jLbl_ManipulaObjetoEscalaX = new JLabel("Escala - X:");
		jLbl_ManipulaObjetoEscalaX.setFont(new Font("Arial", Font.BOLD, 14));
		jLbl_ManipulaObjetoEscalaX.setBounds(10, 180, 105, 30);
		jPnl_principal.add(jLbl_ManipulaObjetoEscalaX);
		
		JLabel jLbl_ManipulaObjetoRotacaoX = new JLabel("Rotação - X:");
		jLbl_ManipulaObjetoRotacaoX.setFont(new Font("Arial", Font.BOLD, 14));
		jLbl_ManipulaObjetoRotacaoX.setBounds(10, 300, 105, 30);
		jPnl_principal.add(jLbl_ManipulaObjetoRotacaoX);
		
		JLabel jLbl_ManipulaObjetoRotacaoY = new JLabel("Rotação - Y:");
		jLbl_ManipulaObjetoRotacaoY.setFont(new Font("Arial", Font.BOLD, 14));
		jLbl_ManipulaObjetoRotacaoY.setBounds(10, 340, 105, 30);
		jPnl_principal.add(jLbl_ManipulaObjetoRotacaoY);
		
		JLabel jLbl_ManipulaObjetoRotacaoZ = new JLabel("Rotação - Z:");
		jLbl_ManipulaObjetoRotacaoZ.setFont(new Font("Arial", Font.BOLD, 14));
		jLbl_ManipulaObjetoRotacaoZ.setBounds(10, 380, 105, 30);
		jPnl_principal.add(jLbl_ManipulaObjetoRotacaoZ);
		
		JLabel jLbl_ManipulaCameraRotacaoZ = new JLabel("Rotação - Z:");
		jLbl_ManipulaCameraRotacaoZ.setFont(new Font("Arial", Font.BOLD, 14));
		jLbl_ManipulaCameraRotacaoZ.setBounds(357, 260, 118, 30);
		jPnl_principal.add(jLbl_ManipulaCameraRotacaoZ);
		
		JLabel jLbl_ManipulaCameraRotacaoY = new JLabel("Rotação - Y:");
		jLbl_ManipulaCameraRotacaoY.setFont(new Font("Arial", Font.BOLD, 14));
		jLbl_ManipulaCameraRotacaoY.setBounds(357, 220, 118, 30);
		jPnl_principal.add(jLbl_ManipulaCameraRotacaoY);
		
		JLabel jLbl_ManipulaCameraRotacaoX = new JLabel("Rotação - X:");
		jLbl_ManipulaCameraRotacaoX.setFont(new Font("Arial", Font.BOLD, 14));
		jLbl_ManipulaCameraRotacaoX.setBounds(357, 180, 118, 30);
		jPnl_principal.add(jLbl_ManipulaCameraRotacaoX);
		
		JLabel jLbl_ManipulaCameraTranslacaoX = new JLabel("Translação - X:");
		jLbl_ManipulaCameraTranslacaoX.setFont(new Font("Arial", Font.BOLD, 14));
		jLbl_ManipulaCameraTranslacaoX.setBounds(357, 60, 118, 30);
		jPnl_principal.add(jLbl_ManipulaCameraTranslacaoX);
		
		JLabel jLbl_menuManipulaCamera = new JLabel("Manipular a camera");
		jLbl_menuManipulaCamera.setFont(new Font("Arial", Font.BOLD, 18));
		jLbl_menuManipulaCamera.setBounds(357, 10, 256, 40);
		jPnl_principal.add(jLbl_menuManipulaCamera);
		
		JLabel jLbl_menuModificarProjecao = new JLabel("Modificar projeção");
		jLbl_menuModificarProjecao.setHorizontalAlignment(SwingConstants.CENTER);
		jLbl_menuModificarProjecao.setFont(new Font("Arial", Font.BOLD, 18));
		jLbl_menuModificarProjecao.setBounds(10, 420, 664, 40);
		jPnl_principal.add(jLbl_menuModificarProjecao);
		
		JLabel jLbl_menuModificarMapeamento = new JLabel("Modificar mapeamento");
		jLbl_menuModificarMapeamento.setHorizontalAlignment(SwingConstants.CENTER);
		jLbl_menuModificarMapeamento.setFont(new Font("Arial", Font.BOLD, 18));
		jLbl_menuModificarMapeamento.setBounds(684, 420, 742, 40);
		jPnl_principal.add(jLbl_menuModificarMapeamento);
		
		JLabel jLbl_modificarMapeamentoWindow = new JLabel("Window:");
		jLbl_modificarMapeamentoWindow.setHorizontalAlignment(SwingConstants.CENTER);
		jLbl_modificarMapeamentoWindow.setFont(new Font("Arial", Font.BOLD, 14));
		jLbl_modificarMapeamentoWindow.setBounds(694, 470, 327, 30);
		jPnl_principal.add(jLbl_modificarMapeamentoWindow);
		
		JLabel jLbl_modificarMapeamentoViewport = new JLabel("Viewport:");
		jLbl_modificarMapeamentoViewport.setHorizontalAlignment(SwingConstants.CENTER);
		jLbl_modificarMapeamentoViewport.setFont(new Font("Arial", Font.BOLD, 14));
		jLbl_modificarMapeamentoViewport.setBounds(1031, 470, 395, 30);
		jPnl_principal.add(jLbl_modificarMapeamentoViewport);
        
        JLabel jLbl_ManipulaObjetoTranslacaoY = new JLabel("Translação - Y:");
        jLbl_ManipulaObjetoTranslacaoY.setFont(new Font("Arial", Font.BOLD, 14));
        jLbl_ManipulaObjetoTranslacaoY.setBounds(10, 100, 110, 30);
        jPnl_principal.add(jLbl_ManipulaObjetoTranslacaoY);
        
        JLabel jLbl_ManipulaObjetoTranslacaoZ = new JLabel("Translação - Z:");
        jLbl_ManipulaObjetoTranslacaoZ.setFont(new Font("Arial", Font.BOLD, 14));
        jLbl_ManipulaObjetoTranslacaoZ.setBounds(10, 140, 110, 30);
        jPnl_principal.add(jLbl_ManipulaObjetoTranslacaoZ);
        
        JLabel jLbl_ManipulaObjetoEscalaY = new JLabel("Escala - Y:");
        jLbl_ManipulaObjetoEscalaY.setFont(new Font("Arial", Font.BOLD, 14));
        jLbl_ManipulaObjetoEscalaY.setBounds(10, 220, 105, 30);
        jPnl_principal.add(jLbl_ManipulaObjetoEscalaY);
        
        JLabel jLbl_ManipulaObjetoEscalaZ = new JLabel("Escala - Z:");
        jLbl_ManipulaObjetoEscalaZ.setFont(new Font("Arial", Font.BOLD, 14));
        jLbl_ManipulaObjetoEscalaZ.setBounds(10, 260, 105, 30);
        jPnl_principal.add(jLbl_ManipulaObjetoEscalaZ);
        
        JLabel jLbl_ManipulaCameraTranslacaoY = new JLabel("Translação - Y:");
        jLbl_ManipulaCameraTranslacaoY.setFont(new Font("Arial", Font.BOLD, 14));
        jLbl_ManipulaCameraTranslacaoY.setBounds(357, 100, 118, 30);
        jPnl_principal.add(jLbl_ManipulaCameraTranslacaoY);
        
        JLabel jLbl_ManipulaCameraTranslacaoZ = new JLabel("Translação - Z:");
        jLbl_ManipulaCameraTranslacaoZ.setFont(new Font("Arial", Font.BOLD, 14));
        jLbl_ManipulaCameraTranslacaoZ.setBounds(357, 140, 118, 30);
        jPnl_principal.add(jLbl_ManipulaCameraTranslacaoZ);
	    
	    JLabel jLbl_modificarProjecaoPerspectivaFovy = new JLabel("Fovy:");
	    jLbl_modificarProjecaoPerspectivaFovy.setFont(new Font("Arial", Font.BOLD, 14));
	    jLbl_modificarProjecaoPerspectivaFovy.setBounds(10, 510, 105, 30);
	    jPnl_principal.add(jLbl_modificarProjecaoPerspectivaFovy);
	    
	    JLabel jLbl_modificarProjecaoPerspectivaAspect = new JLabel("Aspect: ");
	    jLbl_modificarProjecaoPerspectivaAspect.setFont(new Font("Arial", Font.BOLD, 14));
	    jLbl_modificarProjecaoPerspectivaAspect.setBounds(10, 550, 105, 30);
	    jPnl_principal.add(jLbl_modificarProjecaoPerspectivaAspect);
	    
	    JLabel jLbl_modificarProjecaoPerspectivaZNear = new JLabel("zNear: ");
	    jLbl_modificarProjecaoPerspectivaZNear.setFont(new Font("Arial", Font.BOLD, 14));
	    jLbl_modificarProjecaoPerspectivaZNear.setBounds(10, 590, 105, 30);
	    jPnl_principal.add(jLbl_modificarProjecaoPerspectivaZNear);
	    
	    JLabel jLbl_modificarProjecaoPerspectivaZFar = new JLabel("zFar:");
	    jLbl_modificarProjecaoPerspectivaZFar.setFont(new Font("Arial", Font.BOLD, 14));
	    jLbl_modificarProjecaoPerspectivaZFar.setBounds(10, 630, 105, 30);
	    jPnl_principal.add(jLbl_modificarProjecaoPerspectivaZFar);
	    
	    JLabel jLbl_modificarProjecaoParalelaDistanciaX = new JLabel("Distância - X:");
	    jLbl_modificarProjecaoParalelaDistanciaX.setFont(new Font("Arial", Font.BOLD, 14));
	    jLbl_modificarProjecaoParalelaDistanciaX.setBounds(347, 510, 105, 30);
	    jPnl_principal.add(jLbl_modificarProjecaoParalelaDistanciaX);
	    
	    JLabel jLbl_modificarProjecaoParalelaDistanciaY = new JLabel("Distância - Y:");
	    jLbl_modificarProjecaoParalelaDistanciaY.setFont(new Font("Arial", Font.BOLD, 14));
	    jLbl_modificarProjecaoParalelaDistanciaY.setBounds(347, 550, 105, 30);
	    jPnl_principal.add(jLbl_modificarProjecaoParalelaDistanciaY);
	    
	    JLabel jLbl_modificarProjecaoParalelaDistanciaZ = new JLabel("Distância - Z:");
	    jLbl_modificarProjecaoParalelaDistanciaZ.setFont(new Font("Arial", Font.BOLD, 14));
	    jLbl_modificarProjecaoParalelaDistanciaZ.setBounds(347, 590, 105, 30);
	    jPnl_principal.add(jLbl_modificarProjecaoParalelaDistanciaZ);
	    
	    JLabel jLbl_modificarProjecaoParalelaSeta3 = new JLabel("=>");
	    jLbl_modificarProjecaoParalelaSeta3.setFont(new Font("Arial", Font.BOLD, 14));
	    jLbl_modificarProjecaoParalelaSeta3.setBounds(523, 590, 23, 30);
	    jPnl_principal.add(jLbl_modificarProjecaoParalelaSeta3);
	    
	    JLabel jLbl_modificarProjecaoParalelaSeta2 = new JLabel("=>");
	    jLbl_modificarProjecaoParalelaSeta2.setFont(new Font("Arial", Font.BOLD, 14));
	    jLbl_modificarProjecaoParalelaSeta2.setBounds(523, 550, 23, 30);
	    jPnl_principal.add(jLbl_modificarProjecaoParalelaSeta2);
	    
	    JLabel jLbl_modificarProjecaoParalelaSeta1 = new JLabel("=>");
	    jLbl_modificarProjecaoParalelaSeta1.setFont(new Font("Arial", Font.BOLD, 14));
	    jLbl_modificarProjecaoParalelaSeta1.setBounds(523, 510, 23, 30);
	    jPnl_principal.add(jLbl_modificarProjecaoParalelaSeta1);
	    
	    JLabel jLbl_modificarMapeamentoWindowXMin = new JLabel("X min:");
	    jLbl_modificarMapeamentoWindowXMin.setFont(new Font("Arial", Font.BOLD, 14));
	    jLbl_modificarMapeamentoWindowXMin.setBounds(694, 510, 66, 30);
	    jPnl_principal.add(jLbl_modificarMapeamentoWindowXMin);
	    
	    JLabel jLbl_modificarMapeamentoWindowXMax = new JLabel("X max:");
	    jLbl_modificarMapeamentoWindowXMax.setFont(new Font("Arial", Font.BOLD, 14));
	    jLbl_modificarMapeamentoWindowXMax.setBounds(694, 550, 66, 30);
	    jPnl_principal.add(jLbl_modificarMapeamentoWindowXMax);
	    
	    JLabel jLbl_modificarMapeamentoWindowYMin = new JLabel("Y min:");
	    jLbl_modificarMapeamentoWindowYMin.setFont(new Font("Arial", Font.BOLD, 14));
	    jLbl_modificarMapeamentoWindowYMin.setBounds(694, 590, 66, 30);
	    jPnl_principal.add(jLbl_modificarMapeamentoWindowYMin);
	    
	    JLabel jLbl_modificarMapeamentoWindowYMax = new JLabel("Y max:");
	    jLbl_modificarMapeamentoWindowYMax.setFont(new Font("Arial", Font.BOLD, 14));
	    jLbl_modificarMapeamentoWindowYMax.setBounds(694, 630, 66, 30);
	    jPnl_principal.add(jLbl_modificarMapeamentoWindowYMax);
	    
	    JLabel jLbl_modificarMapeamentoViewportXMin = new JLabel("X min:");
	    jLbl_modificarMapeamentoViewportXMin.setFont(new Font("Arial", Font.BOLD, 14));
	    jLbl_modificarMapeamentoViewportXMin.setBounds(1078, 510, 67, 30);
	    jPnl_principal.add(jLbl_modificarMapeamentoViewportXMin);
	    
	    JLabel jLbl_modificarMapeamentoViewportXMax = new JLabel("X max:");
	    jLbl_modificarMapeamentoViewportXMax.setFont(new Font("Arial", Font.BOLD, 14));
	    jLbl_modificarMapeamentoViewportXMax.setBounds(1078, 550, 67, 30);
	    jPnl_principal.add(jLbl_modificarMapeamentoViewportXMax);
	    
	    JLabel jLbl_modificarMapeamentoViewportYMin = new JLabel("Y min:");
	    jLbl_modificarMapeamentoViewportYMin.setFont(new Font("Arial", Font.BOLD, 14));
	    jLbl_modificarMapeamentoViewportYMin.setBounds(1078, 590, 67, 30);
	    jPnl_principal.add(jLbl_modificarMapeamentoViewportYMin);
	    
	    JLabel jLbl_modificarMapeamentoViewportYMax = new JLabel("Y max:");
	    jLbl_modificarMapeamentoViewportYMax.setFont(new Font("Arial", Font.BOLD, 14));
	    jLbl_modificarMapeamentoViewportYMax.setBounds(1078, 630, 67, 30);
	    jPnl_principal.add(jLbl_modificarMapeamentoViewportYMax);	    	    
  	    
  	    JSpinner jSpn_manipulaObjetoTranslacaoX = new JSpinner();
  	    jSpn_manipulaObjetoTranslacaoX.setModel(new SpinnerNumberModel(Double.valueOf(0), null, null, Double.valueOf(1)));
  	    jSpn_manipulaObjetoTranslacaoX.setFont(new Font("Arial", Font.BOLD, 18));
  	    jSpn_manipulaObjetoTranslacaoX.setForeground(Color.BLACK);
  	    jSpn_manipulaObjetoTranslacaoX.setBackground(Color.LIGHT_GRAY);
  	    jSpn_manipulaObjetoTranslacaoX.setBounds(130, 62, 110, 30);
  	    jPnl_principal.add(jSpn_manipulaObjetoTranslacaoX);
  	    
  	    JSpinner jSpn_manipulaObjetoTranslacaoY = new JSpinner();
  	    jSpn_manipulaObjetoTranslacaoY.setModel(new SpinnerNumberModel(Double.valueOf(0), null, null, Double.valueOf(1)));
  	    jSpn_manipulaObjetoTranslacaoY.setForeground(Color.BLACK);
  	    jSpn_manipulaObjetoTranslacaoY.setFont(new Font("Arial", Font.BOLD, 18));
  	    jSpn_manipulaObjetoTranslacaoY.setBackground(Color.LIGHT_GRAY);
  	    jSpn_manipulaObjetoTranslacaoY.setBounds(130, 100, 110, 30);
  	    jPnl_principal.add(jSpn_manipulaObjetoTranslacaoY);
  	    
  	    JSpinner jSpn_manipulaObjetoEscalaX = new JSpinner();
  	    jSpn_manipulaObjetoEscalaX.setModel(new SpinnerNumberModel(Double.valueOf(1), null, null, Double.valueOf(1)));
  	    jSpn_manipulaObjetoEscalaX.setForeground(Color.BLACK);
  	    jSpn_manipulaObjetoEscalaX.setFont(new Font("Arial", Font.BOLD, 18));
  	    jSpn_manipulaObjetoEscalaX.setBackground(Color.LIGHT_GRAY);
  	    jSpn_manipulaObjetoEscalaX.setBounds(130, 178, 110, 30);
  	    jPnl_principal.add(jSpn_manipulaObjetoEscalaX);
  	    
  	    JSpinner jSpn_manipulaObjetoTranslacaoZ = new JSpinner();
  	    jSpn_manipulaObjetoTranslacaoZ.setModel(new SpinnerNumberModel(Double.valueOf(-1), null, null, Double.valueOf(1)));
  	    jSpn_manipulaObjetoTranslacaoZ.setForeground(Color.BLACK);
  	    jSpn_manipulaObjetoTranslacaoZ.setFont(new Font("Arial", Font.BOLD, 18));
  	    jSpn_manipulaObjetoTranslacaoZ.setBackground(Color.LIGHT_GRAY);
  	    jSpn_manipulaObjetoTranslacaoZ.setBounds(130, 140, 110, 30);
  	    jPnl_principal.add(jSpn_manipulaObjetoTranslacaoZ);
  	    
  	    JSpinner jSpn_manipulaObjetoRotacaoY = new JSpinner();
  	    jSpn_manipulaObjetoRotacaoY.setModel(new SpinnerNumberModel(Double.valueOf(90), null, null, Double.valueOf(1)));
  	    jSpn_manipulaObjetoRotacaoY.setForeground(Color.BLACK);
  	    jSpn_manipulaObjetoRotacaoY.setFont(new Font("Arial", Font.BOLD, 18));
  	    jSpn_manipulaObjetoRotacaoY.setBackground(Color.LIGHT_GRAY);
  	    jSpn_manipulaObjetoRotacaoY.setBounds(130, 336, 110, 30);
  	    jPnl_principal.add(jSpn_manipulaObjetoRotacaoY);
  	    
  	    JSpinner jSpn_manipulaObjetoRotacaoX = new JSpinner();
  	    jSpn_manipulaObjetoRotacaoX.setModel(new SpinnerNumberModel(Double.valueOf(90), null, null, Double.valueOf(1)));
  	    jSpn_manipulaObjetoRotacaoX.setForeground(Color.BLACK);
  	    jSpn_manipulaObjetoRotacaoX.setFont(new Font("Arial", Font.BOLD, 18));
  	    jSpn_manipulaObjetoRotacaoX.setBackground(Color.LIGHT_GRAY);
  	    jSpn_manipulaObjetoRotacaoX.setBounds(130, 298, 110, 30);
  	    jPnl_principal.add(jSpn_manipulaObjetoRotacaoX);
  	    
  	    JSpinner jSpn_manipulaObjetoEscalaZ = new JSpinner();
  	    jSpn_manipulaObjetoEscalaZ.setModel(new SpinnerNumberModel(Double.valueOf(2), null, null, Double.valueOf(1)));
  	    jSpn_manipulaObjetoEscalaZ.setForeground(Color.BLACK);
  	    jSpn_manipulaObjetoEscalaZ.setFont(new Font("Arial", Font.BOLD, 18));
  	    jSpn_manipulaObjetoEscalaZ.setBackground(Color.LIGHT_GRAY);
  	    jSpn_manipulaObjetoEscalaZ.setBounds(130, 258, 110, 30);
  	    jPnl_principal.add(jSpn_manipulaObjetoEscalaZ);
  	    
  	    JSpinner jSpn_manipulaObjetoEscalaY = new JSpinner();
  	    jSpn_manipulaObjetoEscalaY.setModel(new SpinnerNumberModel(Double.valueOf(1), null, null, Double.valueOf(1)));
  	    jSpn_manipulaObjetoEscalaY.setForeground(Color.BLACK);
  	    jSpn_manipulaObjetoEscalaY.setFont(new Font("Arial", Font.BOLD, 18));
  	    jSpn_manipulaObjetoEscalaY.setBackground(Color.LIGHT_GRAY);
  	    jSpn_manipulaObjetoEscalaY.setBounds(130, 220, 110, 30);
  	    jPnl_principal.add(jSpn_manipulaObjetoEscalaY);
  	    
  	    JSpinner jSpn_manipulaObjetoRotacaoZ = new JSpinner();
  	    jSpn_manipulaObjetoRotacaoZ.setModel(new SpinnerNumberModel(Double.valueOf(0), null, null, Double.valueOf(1)));
  	    jSpn_manipulaObjetoRotacaoZ.setForeground(Color.BLACK);
  	    jSpn_manipulaObjetoRotacaoZ.setFont(new Font("Arial", Font.BOLD, 18));
  	    jSpn_manipulaObjetoRotacaoZ.setBackground(Color.LIGHT_GRAY);
  	    jSpn_manipulaObjetoRotacaoZ.setBounds(130, 380, 110, 30);
  	    jPnl_principal.add(jSpn_manipulaObjetoRotacaoZ);
  	    
  	    JSpinner jSpn_manipulaCameraTranslacaoX = new JSpinner();
  	    jSpn_manipulaCameraTranslacaoX.setModel(new SpinnerNumberModel(Double.valueOf(0), null, null, Double.valueOf(1)));
  	    jSpn_manipulaCameraTranslacaoX.setForeground(Color.BLACK);
  	    jSpn_manipulaCameraTranslacaoX.setFont(new Font("Arial", Font.BOLD, 18));
  	    jSpn_manipulaCameraTranslacaoX.setBackground(Color.LIGHT_GRAY);
  	    jSpn_manipulaCameraTranslacaoX.setBounds(462, 59, 110, 30);
  	    jPnl_principal.add(jSpn_manipulaCameraTranslacaoX);
  	    
  	    JSpinner jSpn_manipulaCameraTranslacaoY = new JSpinner();
  	    jSpn_manipulaCameraTranslacaoY.setModel(new SpinnerNumberModel(Double.valueOf(0), null, null, Double.valueOf(1)));
  	    jSpn_manipulaCameraTranslacaoY.setForeground(Color.BLACK);
  	    jSpn_manipulaCameraTranslacaoY.setFont(new Font("Arial", Font.BOLD, 18));
  	    jSpn_manipulaCameraTranslacaoY.setBackground(Color.LIGHT_GRAY);
  	    jSpn_manipulaCameraTranslacaoY.setBounds(462, 100, 110, 30);
  	    jPnl_principal.add(jSpn_manipulaCameraTranslacaoY);
  	    
  	    JSpinner jSpn_manipulaCameraTranslacaoZ = new JSpinner();
  	    jSpn_manipulaCameraTranslacaoZ.setModel(new SpinnerNumberModel(Double.valueOf(5), null, null, Double.valueOf(1)));
  	    jSpn_manipulaCameraTranslacaoZ.setForeground(Color.BLACK);
  	    jSpn_manipulaCameraTranslacaoZ.setFont(new Font("Arial", Font.BOLD, 18));
  	    jSpn_manipulaCameraTranslacaoZ.setBackground(Color.LIGHT_GRAY);
  	    jSpn_manipulaCameraTranslacaoZ.setBounds(462, 140, 110, 30);
  	    jPnl_principal.add(jSpn_manipulaCameraTranslacaoZ);
  	    
  	    JSpinner jSpn_manipulaCameraRotacaoZ = new JSpinner();
  	    jSpn_manipulaCameraRotacaoZ.setModel(new SpinnerNumberModel(Double.valueOf(0), null, null, Double.valueOf(1)));
  	    jSpn_manipulaCameraRotacaoZ.setForeground(Color.BLACK);
  	    jSpn_manipulaCameraRotacaoZ.setFont(new Font("Arial", Font.BOLD, 18));
  	    jSpn_manipulaCameraRotacaoZ.setBackground(Color.LIGHT_GRAY);
  	    jSpn_manipulaCameraRotacaoZ.setBounds(462, 261, 110, 30);
  	    jPnl_principal.add(jSpn_manipulaCameraRotacaoZ);
  	    
  	    JSpinner jSpn_manipulaCameraRotacaoY = new JSpinner();
  	    jSpn_manipulaCameraRotacaoY.setModel(new SpinnerNumberModel(Double.valueOf(0), null, null, Double.valueOf(1)));
  	    jSpn_manipulaCameraRotacaoY.setForeground(Color.BLACK);
  	    jSpn_manipulaCameraRotacaoY.setFont(new Font("Arial", Font.BOLD, 18));
  	    jSpn_manipulaCameraRotacaoY.setBackground(Color.LIGHT_GRAY);
  	    jSpn_manipulaCameraRotacaoY.setBounds(462, 221, 110, 30);
  	    jPnl_principal.add(jSpn_manipulaCameraRotacaoY);
  	    
  	    JSpinner jSpn_manipulaCameraRotacaoX = new JSpinner();
  	    jSpn_manipulaCameraRotacaoX.setModel(new SpinnerNumberModel(Double.valueOf(250), null, null, Double.valueOf(1)));
  	    jSpn_manipulaCameraRotacaoX.setForeground(Color.BLACK);
  	    jSpn_manipulaCameraRotacaoX.setFont(new Font("Arial", Font.BOLD, 18));
  	    jSpn_manipulaCameraRotacaoX.setBackground(Color.LIGHT_GRAY);
  	    jSpn_manipulaCameraRotacaoX.setBounds(462, 180, 110, 30);
  	    jPnl_principal.add(jSpn_manipulaCameraRotacaoX);
  	    
  	    JSpinner jSpn_modificarProjecaoPerspectivaFovy = new JSpinner();
  	    jSpn_modificarProjecaoPerspectivaFovy.setModel(new SpinnerNumberModel(Double.valueOf(67), Double.valueOf(1), null, Double.valueOf(1)));
  	    jSpn_modificarProjecaoPerspectivaFovy.setForeground(Color.BLACK);
  	    jSpn_modificarProjecaoPerspectivaFovy.setFont(new Font("Arial", Font.BOLD, 18));
  	    jSpn_modificarProjecaoPerspectivaFovy.setBackground(Color.LIGHT_GRAY);
  	    jSpn_modificarProjecaoPerspectivaFovy.setBounds(125, 510, 160, 30);
  	    jPnl_principal.add(jSpn_modificarProjecaoPerspectivaFovy);
  	    
  	    JSpinner jSpn_modificarProjecaoPerspectivaAspect = new JSpinner();
  	    jSpn_modificarProjecaoPerspectivaAspect.setModel(new SpinnerNumberModel(Double.valueOf(1), Double.valueOf(1), null, Double.valueOf(1)));
  	    jSpn_modificarProjecaoPerspectivaAspect.setForeground(Color.BLACK);
  	    jSpn_modificarProjecaoPerspectivaAspect.setFont(new Font("Arial", Font.BOLD, 18));
  	    jSpn_modificarProjecaoPerspectivaAspect.setBackground(Color.LIGHT_GRAY);
  	    jSpn_modificarProjecaoPerspectivaAspect.setBounds(125, 550, 160, 30);
  	    jPnl_principal.add(jSpn_modificarProjecaoPerspectivaAspect);
  	    
  	    JSpinner jSpn_modificarProjecaoPerspectivaZNear = new JSpinner();
  	    jSpn_modificarProjecaoPerspectivaZNear.setModel(new SpinnerNumberModel(Double.valueOf(0.1), Double.valueOf(0.1), null, Double.valueOf(0.1)));
  	    jSpn_modificarProjecaoPerspectivaZNear.setForeground(Color.BLACK);
  	    jSpn_modificarProjecaoPerspectivaZNear.setFont(new Font("Arial", Font.BOLD, 18));
  	    jSpn_modificarProjecaoPerspectivaZNear.setBackground(Color.LIGHT_GRAY);
  	    jSpn_modificarProjecaoPerspectivaZNear.setBounds(125, 591, 160, 30);
  	    jPnl_principal.add(jSpn_modificarProjecaoPerspectivaZNear);
  	    
  	    JSpinner jSpn_modificarProjecaoPerspectivaZFar = new JSpinner();
  	    jSpn_modificarProjecaoPerspectivaZFar.setModel(new SpinnerNumberModel(Double.valueOf(1), Double.valueOf(1), null, Double.valueOf(1)));
  	    jSpn_modificarProjecaoPerspectivaZFar.setForeground(Color.BLACK);
  	    jSpn_modificarProjecaoPerspectivaZFar.setFont(new Font("Arial", Font.BOLD, 18));
  	    jSpn_modificarProjecaoPerspectivaZFar.setBackground(Color.LIGHT_GRAY);
  	    jSpn_modificarProjecaoPerspectivaZFar.setBounds(125, 631, 160, 30);
  	    jPnl_principal.add(jSpn_modificarProjecaoPerspectivaZFar);
  	    
  	    JSpinner jSpn_modificarProjecaoParalelaDistanciaXInicial = new JSpinner();
  	    jSpn_modificarProjecaoParalelaDistanciaXInicial.setModel(new SpinnerNumberModel(Double.valueOf(1), Double.valueOf(1), null, Double.valueOf(1)));
  	    jSpn_modificarProjecaoParalelaDistanciaXInicial.setForeground(Color.BLACK);
  	    jSpn_modificarProjecaoParalelaDistanciaXInicial.setFont(new Font("Arial", Font.BOLD, 18));
  	    jSpn_modificarProjecaoParalelaDistanciaXInicial.setBackground(Color.LIGHT_GRAY);
  	    jSpn_modificarProjecaoParalelaDistanciaXInicial.setBounds(462, 510, 49, 30);
  	    jPnl_principal.add(jSpn_modificarProjecaoParalelaDistanciaXInicial);
  	    
  	    JSpinner jSpn_modificarProjecaoParalelaDistanciaYInicial = new JSpinner();
  	    jSpn_modificarProjecaoParalelaDistanciaYInicial.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
  	    jSpn_modificarProjecaoParalelaDistanciaYInicial.setForeground(Color.BLACK);
  	    jSpn_modificarProjecaoParalelaDistanciaYInicial.setFont(new Font("Arial", Font.BOLD, 18));
  	    jSpn_modificarProjecaoParalelaDistanciaYInicial.setBackground(Color.LIGHT_GRAY);
  	    jSpn_modificarProjecaoParalelaDistanciaYInicial.setBounds(462, 550, 49, 30);
  	    jPnl_principal.add(jSpn_modificarProjecaoParalelaDistanciaYInicial);
  	    
  	    JSpinner jSpn_modificarProjecaoParalelaDistanciaZInicial = new JSpinner();
  	    jSpn_modificarProjecaoParalelaDistanciaZInicial.setModel(new SpinnerNumberModel(Double.valueOf(1), Double.valueOf(1), null, Double.valueOf(1)));
  	    jSpn_modificarProjecaoParalelaDistanciaZInicial.setForeground(Color.BLACK);
  	    jSpn_modificarProjecaoParalelaDistanciaZInicial.setFont(new Font("Arial", Font.BOLD, 18));
  	    jSpn_modificarProjecaoParalelaDistanciaZInicial.setBackground(Color.LIGHT_GRAY);
  	    jSpn_modificarProjecaoParalelaDistanciaZInicial.setBounds(462, 591, 49, 30);
  	    jPnl_principal.add(jSpn_modificarProjecaoParalelaDistanciaZInicial);
  	    
  	    JSpinner jSpn_modificarProjecaoParalelaDistanciaXFinal = new JSpinner();
  	    jSpn_modificarProjecaoParalelaDistanciaXFinal.setModel(new SpinnerNumberModel(Double.valueOf(10), Double.valueOf(1), null, Double.valueOf(1)));
  	    jSpn_modificarProjecaoParalelaDistanciaXFinal.setForeground(Color.BLACK);
  	    jSpn_modificarProjecaoParalelaDistanciaXFinal.setFont(new Font("Arial", Font.BOLD, 18));
  	    jSpn_modificarProjecaoParalelaDistanciaXFinal.setBackground(Color.LIGHT_GRAY);
  	    jSpn_modificarProjecaoParalelaDistanciaXFinal.setBounds(556, 509, 49, 30);
  	    jPnl_principal.add(jSpn_modificarProjecaoParalelaDistanciaXFinal);
  	    
  	    JSpinner jSpn_modificarProjecaoParalelaDistanciaYFinal = new JSpinner();
  	    jSpn_modificarProjecaoParalelaDistanciaYFinal.setModel(new SpinnerNumberModel(Double.valueOf(10), Double.valueOf(1), null, Double.valueOf(1)));
  	    jSpn_modificarProjecaoParalelaDistanciaYFinal.setForeground(Color.BLACK);
  	    jSpn_modificarProjecaoParalelaDistanciaYFinal.setFont(new Font("Arial", Font.BOLD, 18));
  	    jSpn_modificarProjecaoParalelaDistanciaYFinal.setBackground(Color.LIGHT_GRAY);
  	    jSpn_modificarProjecaoParalelaDistanciaYFinal.setBounds(556, 549, 49, 30);
  	    jPnl_principal.add(jSpn_modificarProjecaoParalelaDistanciaYFinal);
  	    
  	    JSpinner jSpn_modificarProjecaoParalelaDistanciaZFinal = new JSpinner();
  	    jSpn_modificarProjecaoParalelaDistanciaZFinal.setModel(new SpinnerNumberModel(Integer.valueOf(10), Integer.valueOf(1), null, Integer.valueOf(1)));
  	    jSpn_modificarProjecaoParalelaDistanciaZFinal.setForeground(Color.BLACK);
  	    jSpn_modificarProjecaoParalelaDistanciaZFinal.setFont(new Font("Arial", Font.BOLD, 18));
  	    jSpn_modificarProjecaoParalelaDistanciaZFinal.setBackground(Color.LIGHT_GRAY);
  	    jSpn_modificarProjecaoParalelaDistanciaZFinal.setBounds(556, 590, 49, 30);
  	    jPnl_principal.add(jSpn_modificarProjecaoParalelaDistanciaZFinal);
  	    
  	    JSpinner jSpn_modificarMapeamentoWindowXMin = new JSpinner();
  	    jSpn_modificarMapeamentoWindowXMin.setModel(new SpinnerNumberModel(Integer.valueOf(-1), null, null, Integer.valueOf(1)));
  	    jSpn_modificarMapeamentoWindowXMin.setForeground(Color.BLACK);
  	    jSpn_modificarMapeamentoWindowXMin.setFont(new Font("Arial", Font.BOLD, 18));
  	    jSpn_modificarMapeamentoWindowXMin.setBackground(Color.LIGHT_GRAY);
  	    jSpn_modificarMapeamentoWindowXMin.setBounds(770, 509, 160, 30);
  	    jPnl_principal.add(jSpn_modificarMapeamentoWindowXMin);
  	    
  	    JSpinner jSpn_modificarMapeamentoWindowXMax = new JSpinner();
  	    jSpn_modificarMapeamentoWindowXMax.setModel(new SpinnerNumberModel(Integer.valueOf(1), null, null, Integer.valueOf(1)));
  	    jSpn_modificarMapeamentoWindowXMax.setForeground(Color.BLACK);
  	    jSpn_modificarMapeamentoWindowXMax.setFont(new Font("Arial", Font.BOLD, 18));
  	    jSpn_modificarMapeamentoWindowXMax.setBackground(Color.LIGHT_GRAY);
  	    jSpn_modificarMapeamentoWindowXMax.setBounds(770, 549, 160, 30);
  	    jPnl_principal.add(jSpn_modificarMapeamentoWindowXMax);
  	    
  	    JSpinner jSpn_modificarMapeamentoWindowYMin = new JSpinner();
  	    jSpn_modificarMapeamentoWindowYMin.setModel(new SpinnerNumberModel(Integer.valueOf(-1), null, null, Integer.valueOf(1)));
  	    jSpn_modificarMapeamentoWindowYMin.setForeground(Color.BLACK);
  	    jSpn_modificarMapeamentoWindowYMin.setFont(new Font("Arial", Font.BOLD, 18));
  	    jSpn_modificarMapeamentoWindowYMin.setBackground(Color.LIGHT_GRAY);
  	    jSpn_modificarMapeamentoWindowYMin.setBounds(770, 590, 160, 30);
  	    jPnl_principal.add(jSpn_modificarMapeamentoWindowYMin);
  	    
  	    JSpinner jSpn_modificarMapeamentoWindowYMax = new JSpinner();
  	    jSpn_modificarMapeamentoWindowYMax.setModel(new SpinnerNumberModel(Integer.valueOf(1), null, null, Integer.valueOf(1)));
  	    jSpn_modificarMapeamentoWindowYMax.setForeground(Color.BLACK);
  	    jSpn_modificarMapeamentoWindowYMax.setFont(new Font("Arial", Font.BOLD, 18));
  	    jSpn_modificarMapeamentoWindowYMax.setBackground(Color.LIGHT_GRAY);
  	    jSpn_modificarMapeamentoWindowYMax.setBounds(770, 630, 160, 30);
  	    jPnl_principal.add(jSpn_modificarMapeamentoWindowYMax);
  	    
  	    JSpinner jSpn_modificarMapeamentoViewportXMin = new JSpinner();
  	    jSpn_modificarMapeamentoViewportXMin.setModel(new SpinnerNumberModel(Integer.valueOf(0), null, null, Integer.valueOf(1)));
  	    jSpn_modificarMapeamentoViewportXMin.setForeground(Color.BLACK);
  	    jSpn_modificarMapeamentoViewportXMin.setFont(new Font("Arial", Font.BOLD, 18));
  	    jSpn_modificarMapeamentoViewportXMin.setBackground(Color.LIGHT_GRAY);
  	    jSpn_modificarMapeamentoViewportXMin.setBounds(1155, 510, 160, 30);
  	    jPnl_principal.add(jSpn_modificarMapeamentoViewportXMin);
  	    
  	    JSpinner jSpn_modificarMapeamentoViewportXMax = new JSpinner();
  	    jSpn_modificarMapeamentoViewportXMax.setModel(new SpinnerNumberModel(Integer.valueOf(719), null, null, Integer.valueOf(1)));
  	    jSpn_modificarMapeamentoViewportXMax.setForeground(Color.BLACK);
  	    jSpn_modificarMapeamentoViewportXMax.setFont(new Font("Arial", Font.BOLD, 18));
  	    jSpn_modificarMapeamentoViewportXMax.setBackground(Color.LIGHT_GRAY);
  	    jSpn_modificarMapeamentoViewportXMax.setBounds(1155, 550, 160, 30);
  	    jPnl_principal.add(jSpn_modificarMapeamentoViewportXMax);
  	    
  	    JSpinner jSpn_modificarMapeamentoViewportYMin = new JSpinner();
  	    jSpn_modificarMapeamentoViewportYMin.setModel(new SpinnerNumberModel(Integer.valueOf(0), null, null, Integer.valueOf(1)));
  	    jSpn_modificarMapeamentoViewportYMin.setForeground(Color.BLACK);
  	    jSpn_modificarMapeamentoViewportYMin.setFont(new Font("Arial", Font.BOLD, 18));
  	    jSpn_modificarMapeamentoViewportYMin.setBackground(Color.LIGHT_GRAY);
  	    jSpn_modificarMapeamentoViewportYMin.setBounds(1155, 591, 160, 30);
  	    jPnl_principal.add(jSpn_modificarMapeamentoViewportYMin);
  	    
  	    JSpinner jSpn_modificarMapeamentoViewportYMax = new JSpinner();
  	    jSpn_modificarMapeamentoViewportYMax.setModel(new SpinnerNumberModel(Integer.valueOf(400), null, null, Integer.valueOf(1)));
  	    jSpn_modificarMapeamentoViewportYMax.setForeground(Color.BLACK);
  	    jSpn_modificarMapeamentoViewportYMax.setFont(new Font("Arial", Font.BOLD, 18));
  	    jSpn_modificarMapeamentoViewportYMax.setBackground(Color.LIGHT_GRAY);
  	    jSpn_modificarMapeamentoViewportYMax.setBounds(1155, 631, 160, 30);
  	    jPnl_principal.add(jSpn_modificarMapeamentoViewportYMax);
	    
  	    
  	    
  	    //Instancia e configura a imagem na label
  		BufferedImage img = new BufferedImage(719, 400, BufferedImage.TYPE_INT_ARGB);
  		desenhoPiramide = img.createGraphics();
  		desenhoPiramide.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
  		desenhoPiramide.setBackground(Color.black);
  		desenhoPiramide.clearRect(0, 0, 719, 400);
  	    ImageIcon icon = new ImageIcon(img);
  	    jLbl_imagem.setIcon(icon);
  	    
  	    JCheckBox jChb_modificarProjecaoPerspectivaEscolha = new JCheckBox("Projeção perspectiva:");
  	    jChb_modificarProjecaoPerspectivaEscolha.setSelected(true);
  	    jChb_modificarProjecaoPerspectivaEscolha.addActionListener(new ActionListener() {
  	    	public void actionPerformed(ActionEvent e) {
  	    		jChb_modificarProjecaoPerspectivaEscolha.setSelected(true); 
  	    		jSpn_manipulaObjetoTranslacaoX.setValue(Integer.valueOf(0));
  	    		jSpn_manipulaObjetoTranslacaoY.setValue(Integer.valueOf(0));
  	    		jSpn_manipulaObjetoTranslacaoZ.setValue(Integer.valueOf(-1));
  	    		jSpn_manipulaObjetoEscalaX.setValue(Integer.valueOf(1));
  	    		jSpn_manipulaObjetoEscalaY.setValue(Integer.valueOf(1));
  	    		jSpn_manipulaObjetoEscalaZ.setValue(Integer.valueOf(2));
  	    		jSpn_manipulaObjetoRotacaoX.setValue(Integer.valueOf(90));
  	    		jSpn_manipulaObjetoRotacaoY.setValue(Integer.valueOf(90));
  	    		jSpn_manipulaObjetoRotacaoZ.setValue(Integer.valueOf(0));
  	    		jSpn_manipulaCameraTranslacaoX.setValue(Integer.valueOf(0));
  	    		jSpn_manipulaCameraTranslacaoY.setValue(Integer.valueOf(0));
  	    		jSpn_manipulaCameraTranslacaoZ.setValue(Integer.valueOf(5));
  	    		jSpn_manipulaCameraRotacaoX.setValue(Integer.valueOf(250));
  	    		jSpn_manipulaCameraRotacaoY.setValue(Integer.valueOf(0));
  	    		jSpn_manipulaCameraRotacaoZ.setValue(Integer.valueOf(0));  	    		
  	    	}
  	    });
  	    jChb_modificarProjecaoPerspectivaEscolha.setFont(new Font("Arial", Font.BOLD, 14));
  	    jChb_modificarProjecaoPerspectivaEscolha.setBounds(10, 470, 275, 30);
  	    jPnl_principal.add(jChb_modificarProjecaoPerspectivaEscolha);
  	    
  	    JCheckBox jChb_modificarProjecaoParalelaEscolha = new JCheckBox("Projeção paralela:");
  	    jChb_modificarProjecaoParalelaEscolha.addActionListener(new ActionListener() {
  	    	public void actionPerformed(ActionEvent e) {
  	    		jChb_modificarProjecaoPerspectivaEscolha.setSelected(false);
  	    		jChb_modificarProjecaoParalelaEscolha.setSelected(true);
  	    		jSpn_manipulaObjetoTranslacaoX.setValue(Integer.valueOf(-1));
  	    		jSpn_manipulaObjetoTranslacaoY.setValue(Integer.valueOf(0));
  	    		jSpn_manipulaObjetoTranslacaoZ.setValue(Integer.valueOf(2));
  	    		jSpn_manipulaObjetoEscalaX.setValue(Integer.valueOf(1));
  	    		jSpn_manipulaObjetoEscalaY.setValue(Integer.valueOf(1));
  	    		jSpn_manipulaObjetoEscalaZ.setValue(Integer.valueOf(2));
  	    		jSpn_manipulaObjetoRotacaoX.setValue(Integer.valueOf(0));
  	    		jSpn_manipulaObjetoRotacaoY.setValue(Integer.valueOf(0));
  	    		jSpn_manipulaObjetoRotacaoZ.setValue(Integer.valueOf(-20));
  	    		jSpn_manipulaCameraTranslacaoX.setValue(Integer.valueOf(-6));
  	    		jSpn_manipulaCameraTranslacaoY.setValue(Integer.valueOf(3));
  	    		jSpn_manipulaCameraTranslacaoZ.setValue(Integer.valueOf(0));
  	    		jSpn_manipulaCameraRotacaoX.setValue(Integer.valueOf(260));
  	    		jSpn_manipulaCameraRotacaoY.setValue(Integer.valueOf(0));
  	    		jSpn_manipulaCameraRotacaoZ.setValue(Integer.valueOf(0));
  	    	}
  	    });
  	    jChb_modificarProjecaoParalelaEscolha.setFont(new Font("Arial", Font.BOLD, 14));
  	    jChb_modificarProjecaoParalelaEscolha.setBounds(347, 470, 266, 30);
  	    jPnl_principal.add(jChb_modificarProjecaoParalelaEscolha);
	    desenhoPiramide.setColor(Color.green);   
	    
        //Instancia a piramide e define os pontos iniciais
		piramide = new Piramide();
	    
	    //aplica as alterações para a exibição inicial da piramide
  		piramide.translacao(Double.parseDouble(jSpn_manipulaObjetoTranslacaoX.getValue().toString()),
  							Double.parseDouble(jSpn_manipulaObjetoTranslacaoY.getValue().toString()),
  							Double.parseDouble(jSpn_manipulaObjetoTranslacaoZ.getValue().toString()));
  		piramide.escala(Double.parseDouble(jSpn_manipulaObjetoEscalaX.getValue().toString()),
  						Double.parseDouble(jSpn_manipulaObjetoEscalaY.getValue().toString()),
  						Double.parseDouble(jSpn_manipulaObjetoEscalaZ.getValue().toString()));
  		piramide.rotacaoX(Double.parseDouble(jSpn_manipulaObjetoRotacaoX.getValue().toString()));
  		piramide.rotacaoY(Double.parseDouble(jSpn_manipulaObjetoRotacaoY.getValue().toString()));
  		piramide.rotacaoZ(Double.parseDouble(jSpn_manipulaObjetoRotacaoZ.getValue().toString()));
  		
  		//Adicionar a camera (Altera o mundo para adaptar a visualização)
  		piramide.translacao(-Double.parseDouble(jSpn_manipulaCameraTranslacaoX.getValue().toString()),
							-Double.parseDouble(jSpn_manipulaCameraTranslacaoY.getValue().toString()),
							-Double.parseDouble(jSpn_manipulaCameraTranslacaoZ.getValue().toString()));
  		piramide.rotacaoX(-Double.parseDouble(jSpn_manipulaCameraRotacaoX.getValue().toString()));
  		piramide.rotacaoY(-Double.parseDouble(jSpn_manipulaCameraRotacaoY.getValue().toString()));
  		piramide.rotacaoZ(-Double.parseDouble(jSpn_manipulaCameraRotacaoZ.getValue().toString()));
  		
  		//Realiza a projeção "perspectiva"
  		if((jChb_modificarProjecaoPerspectivaEscolha.isSelected()) && (!jChb_modificarProjecaoParalelaEscolha.isSelected())) {
  	  		matrizPontosProjecao = piramide.projecaoPerspectiva(Double.parseDouble(jSpn_modificarProjecaoPerspectivaFovy.getValue().toString()),
					   Double.parseDouble(jSpn_modificarProjecaoPerspectivaAspect.getValue().toString()),
					   Double.parseDouble(jSpn_modificarProjecaoPerspectivaZNear.getValue().toString()),
					   Double.parseDouble(jSpn_modificarProjecaoPerspectivaZFar.getValue().toString()));
  			
  		}
  		//Realiza a projeção "paralela"
  		else if((!jChb_modificarProjecaoPerspectivaEscolha.isSelected()) && (jChb_modificarProjecaoParalelaEscolha.isSelected())) {  	  		
  			matrizPontosProjecao = piramide.projecaoParalela(
  			Double.parseDouble(jSpn_modificarProjecaoParalelaDistanciaXInicial.getValue().toString()),
  			Double.parseDouble(jSpn_modificarProjecaoParalelaDistanciaXFinal.getValue().toString()),
  			Double.parseDouble(jSpn_modificarProjecaoParalelaDistanciaYInicial.getValue().toString()),
  			Double.parseDouble(jSpn_modificarProjecaoParalelaDistanciaYFinal.getValue().toString()),
  			Double.parseDouble(jSpn_modificarProjecaoParalelaDistanciaYInicial.getValue().toString()),
  			Double.parseDouble(jSpn_modificarProjecaoParalelaDistanciaYFinal.getValue().toString())
  			);
		}
  		else {
  			jChb_modificarProjecaoPerspectivaEscolha.setSelected(true);
  			jChb_modificarProjecaoParalelaEscolha.setSelected(false);
  		}
  			
  		//Realiza o mapeamento
  		matrizPontosResultantes = piramide.mapeamento(matrizPontosProjecao, 
									  				  Integer.parseInt(jSpn_modificarMapeamentoWindowXMin.getValue().toString()), 
									  				  Integer.parseInt(jSpn_modificarMapeamentoWindowXMax.getValue().toString()), 
									  				  Integer.parseInt(jSpn_modificarMapeamentoWindowYMin.getValue().toString()), 
									  				  Integer.parseInt(jSpn_modificarMapeamentoWindowYMax.getValue().toString()), 
									  				  Integer.parseInt(jSpn_modificarMapeamentoViewportXMin.getValue().toString()), 
									  				  Integer.parseInt(jSpn_modificarMapeamentoViewportXMax.getValue().toString()), 
									  				  Integer.parseInt(jSpn_modificarMapeamentoViewportYMin.getValue().toString()), 
									  				  Integer.parseInt(jSpn_modificarMapeamentoViewportYMax.getValue().toString()));
  		  				  				
		//Pinta as linhas na tela 
		//P0 => P1,P3,P4		
		desenhoPiramide.drawLine(matrizPontosResultantes[0][0],matrizPontosResultantes[0][1],matrizPontosResultantes[1][0],matrizPontosResultantes[1][1]);
		desenhoPiramide.drawLine(matrizPontosResultantes[0][0],matrizPontosResultantes[0][1],matrizPontosResultantes[3][0],matrizPontosResultantes[3][1]);
		desenhoPiramide.drawLine(matrizPontosResultantes[0][0],matrizPontosResultantes[0][1],matrizPontosResultantes[4][0],matrizPontosResultantes[4][1]);
		
		//P1 => P2,P4
		desenhoPiramide.drawLine(matrizPontosResultantes[1][0],matrizPontosResultantes[1][1],matrizPontosResultantes[2][0],matrizPontosResultantes[2][1]);
		desenhoPiramide.drawLine(matrizPontosResultantes[1][0],matrizPontosResultantes[1][1],matrizPontosResultantes[4][0],matrizPontosResultantes[4][1]);
		
		//P2 => P3,P4
		desenhoPiramide.drawLine(matrizPontosResultantes[2][0],matrizPontosResultantes[2][1],matrizPontosResultantes[3][0],matrizPontosResultantes[3][1]);
		desenhoPiramide.drawLine(matrizPontosResultantes[2][0],matrizPontosResultantes[2][1],matrizPontosResultantes[4][0],matrizPontosResultantes[4][1]);
		
		//P3 => P4
		desenhoPiramide.drawLine(matrizPontosResultantes[3][0],matrizPontosResultantes[3][1],matrizPontosResultantes[4][0],matrizPontosResultantes[4][1]);
		
		Thread t = new Thread() {
			public void run() {
				try {
					while(true) {
						Thread.sleep(100l);	
						desenhoPiramide.clearRect(0, 0, 719, 400);
						piramide.resetarOsPontos();
						piramide.translacao(Double.parseDouble(jSpn_manipulaObjetoTranslacaoX.getValue().toString()),
				  							Double.parseDouble(jSpn_manipulaObjetoTranslacaoY.getValue().toString()),
				  							Double.parseDouble(jSpn_manipulaObjetoTranslacaoZ.getValue().toString()));
				  		piramide.escala(Double.parseDouble(jSpn_manipulaObjetoEscalaX.getValue().toString()),
				  						Double.parseDouble(jSpn_manipulaObjetoEscalaY.getValue().toString()),
				  						Double.parseDouble(jSpn_manipulaObjetoEscalaZ.getValue().toString()));
				  		piramide.rotacaoX(Double.parseDouble(jSpn_manipulaObjetoRotacaoX.getValue().toString()));
				  		piramide.rotacaoY(Double.parseDouble(jSpn_manipulaObjetoRotacaoY.getValue().toString()));
				  		piramide.rotacaoZ(Double.parseDouble(jSpn_manipulaObjetoRotacaoZ.getValue().toString()));
				  		
				  		//Adicionar a camera (Altera o mundo para adaptar a visualização)
				  		piramide.translacao(-Double.parseDouble(jSpn_manipulaCameraTranslacaoX.getValue().toString()),
											-Double.parseDouble(jSpn_manipulaCameraTranslacaoY.getValue().toString()),
											-Double.parseDouble(jSpn_manipulaCameraTranslacaoZ.getValue().toString()));
				  		piramide.rotacaoX(-Double.parseDouble(jSpn_manipulaCameraRotacaoX.getValue().toString()));
				  		piramide.rotacaoY(-Double.parseDouble(jSpn_manipulaCameraRotacaoY.getValue().toString()));
				  		piramide.rotacaoZ(-Double.parseDouble(jSpn_manipulaCameraRotacaoZ.getValue().toString()));
				  		
				  		
				  	    //Realiza a projeção "perspectiva"
				  		if((jChb_modificarProjecaoPerspectivaEscolha.isSelected()) && (!jChb_modificarProjecaoParalelaEscolha.isSelected())) {
				  	  		matrizPontosProjecao = piramide.projecaoPerspectiva(Double.parseDouble(jSpn_modificarProjecaoPerspectivaFovy.getValue().toString()),
									   Double.parseDouble(jSpn_modificarProjecaoPerspectivaAspect.getValue().toString()),
									   Double.parseDouble(jSpn_modificarProjecaoPerspectivaZNear.getValue().toString()),
									   Double.parseDouble(jSpn_modificarProjecaoPerspectivaZFar.getValue().toString()));
				  			
				  		}
				  		//Realiza a projeção "paralela"
				  		else if((!jChb_modificarProjecaoPerspectivaEscolha.isSelected()) && (jChb_modificarProjecaoParalelaEscolha.isSelected())) {  	  		
				  			matrizPontosProjecao = piramide.projecaoParalela(
				  			Double.parseDouble(jSpn_modificarProjecaoParalelaDistanciaXInicial.getValue().toString()),
				  			Double.parseDouble(jSpn_modificarProjecaoParalelaDistanciaXFinal.getValue().toString()),
				  			Double.parseDouble(jSpn_modificarProjecaoParalelaDistanciaYInicial.getValue().toString()),
				  			Double.parseDouble(jSpn_modificarProjecaoParalelaDistanciaYFinal.getValue().toString()),
				  			Double.parseDouble(jSpn_modificarProjecaoParalelaDistanciaYInicial.getValue().toString()),
				  			Double.parseDouble(jSpn_modificarProjecaoParalelaDistanciaYFinal.getValue().toString())
				  			);
						}
				  		else {
				  			jChb_modificarProjecaoPerspectivaEscolha.setSelected(true);
				  			jChb_modificarProjecaoParalelaEscolha.setSelected(false);
				  		}
				  		
				  		//Realiza o mapeamento
				  		matrizPontosResultantes = piramide.mapeamento(matrizPontosProjecao, 
													  				  Integer.parseInt(jSpn_modificarMapeamentoWindowXMin.getValue().toString()), 
													  				  Integer.parseInt(jSpn_modificarMapeamentoWindowXMax.getValue().toString()), 
													  				  Integer.parseInt(jSpn_modificarMapeamentoWindowYMin.getValue().toString()), 
													  				  Integer.parseInt(jSpn_modificarMapeamentoWindowYMax.getValue().toString()), 
													  				  Integer.parseInt(jSpn_modificarMapeamentoViewportXMin.getValue().toString()), 
													  				  Integer.parseInt(jSpn_modificarMapeamentoViewportXMax.getValue().toString()), 
													  				  Integer.parseInt(jSpn_modificarMapeamentoViewportYMin.getValue().toString()), 
													  				  Integer.parseInt(jSpn_modificarMapeamentoViewportYMax.getValue().toString()));
				  		  				  				
						//Pinta as linhas na tela 
						//P0 => P1,P3,P4		
						desenhoPiramide.drawLine(matrizPontosResultantes[0][0],matrizPontosResultantes[0][1],matrizPontosResultantes[1][0],matrizPontosResultantes[1][1]);
						desenhoPiramide.drawLine(matrizPontosResultantes[0][0],matrizPontosResultantes[0][1],matrizPontosResultantes[3][0],matrizPontosResultantes[3][1]);
						desenhoPiramide.drawLine(matrizPontosResultantes[0][0],matrizPontosResultantes[0][1],matrizPontosResultantes[4][0],matrizPontosResultantes[4][1]);
						
						//P1 => P2,P4
						desenhoPiramide.drawLine(matrizPontosResultantes[1][0],matrizPontosResultantes[1][1],matrizPontosResultantes[2][0],matrizPontosResultantes[2][1]);
						desenhoPiramide.drawLine(matrizPontosResultantes[1][0],matrizPontosResultantes[1][1],matrizPontosResultantes[4][0],matrizPontosResultantes[4][1]);
						
						//P2 => P3,P4
						desenhoPiramide.drawLine(matrizPontosResultantes[2][0],matrizPontosResultantes[2][1],matrizPontosResultantes[3][0],matrizPontosResultantes[3][1]);
						desenhoPiramide.drawLine(matrizPontosResultantes[2][0],matrizPontosResultantes[2][1],matrizPontosResultantes[4][0],matrizPontosResultantes[4][1]);
						
						//P3 => P4
						desenhoPiramide.drawLine(matrizPontosResultantes[3][0],matrizPontosResultantes[3][1],matrizPontosResultantes[4][0],matrizPontosResultantes[4][1]);
						repaint();
					}
				} catch (InterruptedException e) {
					System.out.println("Erro na execução da Thread: " + e);
				}
			}
		};
		t.start();
		
	}
}
