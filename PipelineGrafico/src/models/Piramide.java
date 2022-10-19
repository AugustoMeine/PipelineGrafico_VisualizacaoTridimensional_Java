package models;

public class Piramide {
	double[] p0 = {0.5,0.5,0,1};
	double[] p1 = {-0.5,0.5,0,1};
	double[] p2 = {-0.5,-0.5,0,1};
	double[] p3 = {0.5,-0.5,0,1};
	double[] p4 = {0,0,0.5,1};
	
	public Piramide() {					
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Piramide piramide = new Piramide();							
	}
	
	public void resetarOsPontos() {
		//Necessário para realizar a atualização da imagem
		p0[0] = 0.5;p0[1] = 0.5;p0[2] = 0;p0[3] = 1;
		p1[0] = -0.5;p1[1] = 0.5;p1[2] = 0;p1[3] = 1;
		p2[0] = -0.5;p2[1] = -0.5;p2[2] = 0;p2[3] = 1;
		p3[0] = 0.5;p3[1] = -0.5;p3[2] = 0;p3[3] = 1;
		p4[0] = 0;p4[1] = 0;p4[2] = 0.5;p4[3] = 1;		
	}
	
	public double[] multiplicaMatriz(double[][] matriz, double[][] ponto) {		
		
		double valorAux;
		int count = 0;
		double[] pontoAux = new double[4];
		for(int i = 0; i < 4; i ++) { // i = linha da matriz resultante
			for(int j = 0; j < 1; j++) { // j = coluna da matriz resultante
				valorAux = 0;				
				for(int k = 0; k < 4; k++) {// k = número que se igualou na multiplicação
					valorAux += (matriz[i][k] * ponto[k][j]);
				}				
				pontoAux[count] = valorAux;
				//System.out.print("[" + valorAux + "] ");
				count++;
			}			
		}
		//System.out.println();
		return(pontoAux);
	}
	
	public void translacao(double x, double y, double z) {			
		
		double[][] matrizTranslacao = new double[4][4];
		double[][] matrizPonto = new double[4][1];
		
		matrizTranslacao[0][0] = 1; matrizTranslacao[0][1] = 0;matrizTranslacao[0][2] = 0;matrizTranslacao[0][3] = x;
		matrizTranslacao[1][0] = 0; matrizTranslacao[1][1] = 1;matrizTranslacao[1][2] = 0;matrizTranslacao[1][3] = y;
		matrizTranslacao[2][0] = 0; matrizTranslacao[2][1] = 0;matrizTranslacao[2][2] = 1;matrizTranslacao[2][3] = z;
		matrizTranslacao[3][0] = 0; matrizTranslacao[3][1] = 0;matrizTranslacao[3][2] = 0;matrizTranslacao[3][3] = 1;
		
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p0[i];
		}
		p0 = multiplicaMatriz(matrizTranslacao,matrizPonto);
		
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p1[i];
		}
		p1 = multiplicaMatriz(matrizTranslacao,matrizPonto);
		
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p2[i];
		}
		p2 = multiplicaMatriz(matrizTranslacao,matrizPonto);
		
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p3[i];
		}
		p3 = multiplicaMatriz(matrizTranslacao,matrizPonto);
		
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p4[i];
		}
		p4 = multiplicaMatriz(matrizTranslacao,matrizPonto);		
		
	}
	
public void escala(double x, double y, double z) {			
		
	double[][] matrizTranslacao = new double[4][4];
	double[][] matrizPonto = new double[4][1];
	
	matrizTranslacao[0][0] = x; matrizTranslacao[0][1] = 0;matrizTranslacao[0][2] = 0;matrizTranslacao[0][3] = 0;
	matrizTranslacao[1][0] = 0; matrizTranslacao[1][1] = y;matrizTranslacao[1][2] = 0;matrizTranslacao[1][3] = 0;
	matrizTranslacao[2][0] = 0; matrizTranslacao[2][1] = 0;matrizTranslacao[2][2] = z;matrizTranslacao[2][3] = 0;
	matrizTranslacao[3][0] = 0; matrizTranslacao[3][1] = 0;matrizTranslacao[3][2] = 0;matrizTranslacao[3][3] = 1;
	
	for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p0[i];
		}
		p0 = multiplicaMatriz(matrizTranslacao,matrizPonto);
		
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p1[i];
		}
		p1 = multiplicaMatriz(matrizTranslacao,matrizPonto);
		
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p2[i];
		}
		p2 = multiplicaMatriz(matrizTranslacao,matrizPonto);
		
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p3[i];
		}
		p3 = multiplicaMatriz(matrizTranslacao,matrizPonto);
		
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p4[i];
		}
		p4 = multiplicaMatriz(matrizTranslacao,matrizPonto);						
	}

	public void rotacaoX(double x) {
		double[][] matrizTranslacao = new double[4][4];
		double[][] matrizPonto = new double[4][1];
		double c = (double) Math.cos(Math.toRadians(x));
		double s = (double) Math.sin(Math.toRadians(x));
		matrizTranslacao[0][0] = 1; matrizTranslacao[0][1] = 0;matrizTranslacao[0][2] = 0;matrizTranslacao[0][3] = 0;
		matrizTranslacao[1][0] = 0; matrizTranslacao[1][1] = c;matrizTranslacao[1][2] = (-1 * s);matrizTranslacao[1][3] = 0;
		matrizTranslacao[2][0] = 0; matrizTranslacao[2][1] = s;matrizTranslacao[2][2] = c;matrizTranslacao[2][3] = 0;
		matrizTranslacao[3][0] = 0; matrizTranslacao[3][1] = 0;matrizTranslacao[3][2] = 0;matrizTranslacao[3][3] = 1;
		
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p0[i];
		}
		this.p0 = multiplicaMatriz(matrizTranslacao,matrizPonto);
		
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p1[i];
		}
		this.p1 = multiplicaMatriz(matrizTranslacao,matrizPonto);
		
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p2[i];
		}
		this.p2 = multiplicaMatriz(matrizTranslacao,matrizPonto);
		
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p3[i];
		}
		this.p3 = multiplicaMatriz(matrizTranslacao,matrizPonto);
		
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p4[i];
		}
		this.p4 = multiplicaMatriz(matrizTranslacao,matrizPonto);	
	}
	
	public void rotacaoY(double y) {
		double[][] matrizTranslacao = new double[4][4];
		double[][] matrizPonto = new double[4][1];
		
		double c = (double) Math.cos(Math.toRadians(y));
		double s = (double) Math.sin(Math.toRadians(y));		
		matrizTranslacao[0][0] = c; matrizTranslacao[0][1] = 0;	matrizTranslacao[0][2] = s;	matrizTranslacao[0][3] = 0;
		matrizTranslacao[1][0] = 0; matrizTranslacao[1][1] = 1;	matrizTranslacao[1][2] = 0; matrizTranslacao[1][3] = 0;
		matrizTranslacao[2][0] = -s;matrizTranslacao[2][1] = 0;	matrizTranslacao[2][2] = c;	matrizTranslacao[2][3] = 0;
		matrizTranslacao[3][0] = 0; matrizTranslacao[3][1] = 0;	matrizTranslacao[3][2] = 0;	matrizTranslacao[3][3] = 1;
		
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p0[i];
		}
		this.p0 = multiplicaMatriz(matrizTranslacao,matrizPonto);
		
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p1[i];
		}
		this.p1 = multiplicaMatriz(matrizTranslacao,matrizPonto);
		
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p2[i];
		}
		this.p2 = multiplicaMatriz(matrizTranslacao,matrizPonto);
		
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p3[i];
		}
		this.p3 = multiplicaMatriz(matrizTranslacao,matrizPonto);
		
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p4[i];
		}
		this.p4 = multiplicaMatriz(matrizTranslacao,matrizPonto);	
	}
	
	public void rotacaoZ(double z) {
		double[][] matrizTranslacao = new double[4][4];
		double[][] matrizPonto = new double[4][1];
		double c = (double) Math.cos(Math.toRadians(z));
		double s = (double) Math.sin(Math.toRadians(z));
		matrizTranslacao[0][0] = c; matrizTranslacao[0][1] = (-1*s);matrizTranslacao[0][2] = 0;matrizTranslacao[0][3] = 0;
		matrizTranslacao[1][0] = s; matrizTranslacao[1][1] = c;matrizTranslacao[1][2] = 0;matrizTranslacao[1][3] = 0;
		matrizTranslacao[2][0] = 0; matrizTranslacao[2][1] = 0;matrizTranslacao[2][2] = 1;matrizTranslacao[2][3] = 0;
		matrizTranslacao[3][0] = 0; matrizTranslacao[3][1] = 0;matrizTranslacao[3][2] = 0;matrizTranslacao[3][3] = 1;
		
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p0[i];
		}
		this.p0 = multiplicaMatriz(matrizTranslacao,matrizPonto);
		
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p1[i];
		}
		this.p1 = multiplicaMatriz(matrizTranslacao,matrizPonto);
		
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p2[i];
		}
		this.p2 = multiplicaMatriz(matrizTranslacao,matrizPonto);
		
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p3[i];
		}
		this.p3 = multiplicaMatriz(matrizTranslacao,matrizPonto);
		
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p4[i];
		}
		this.p4 = multiplicaMatriz(matrizTranslacao,matrizPonto);	
	}
	
	public int[][] mapeamento(double[][] matrizEntradaPontosProjecao,int windowXMin, int windowXMax, int windowYMin, int windowYMax, int viewportXMin, int viewportXMax, int viewportYMin, int viewportYMax) {			
		double[][] matrizAux = matrizEntradaPontosProjecao;
		int[][] matrizResultante = new int[5][2];
		
		for(int i = 0; i < 5; i++) {
			matrizResultante[i][0] = (int) (( (matrizAux[i][0] - windowXMin) * (viewportXMax - viewportXMin) ) / (windowXMax - windowXMin)) + viewportXMin;
			matrizResultante[i][1] = (int) (( (matrizAux[i][1] - windowYMin) * (viewportYMin - viewportYMax) ) / (windowYMin - windowYMax)) + viewportYMax;
		}
				
		return(matrizResultante);
	}
	
	public double[][] projecaoPerspectiva(double fovy, double aspect, double zNear, double zFar) {
		double[][] matrizPerspectiva = new double[4][4];
		double[][] matrizPonto = new double[4][1];
		double[] pontosAux = new double[4];
		double[][] matrizAux = new double[5][4];
		
		double a = (double) (1/(Math.tan(Math.toRadians(fovy)/2) * aspect));
		double b = (double) (1/(Math.tan(Math.toRadians(fovy)/2)));
		double c = (double) ((zFar + zNear)/(zNear - zFar));
		double d = (double) ((2 * zFar * zNear)/(zNear - zFar));
		
		matrizPerspectiva[0][0] = a; matrizPerspectiva[0][1] = 0;matrizPerspectiva[0][2] = 0;matrizPerspectiva[0][3] = 0;
		matrizPerspectiva[1][0] = 0; matrizPerspectiva[1][1] = b;matrizPerspectiva[1][2] = 0;matrizPerspectiva[1][3] = 0;
		matrizPerspectiva[2][0] = 0; matrizPerspectiva[2][1] = 0;matrizPerspectiva[2][2] = c;matrizPerspectiva[2][3] = d;
		matrizPerspectiva[3][0] = 0; matrizPerspectiva[3][1] = 0;matrizPerspectiva[3][2] = -1;matrizPerspectiva[3][3] = 0;
		
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p0[i];
		}
		pontosAux = multiplicaMatriz(matrizPerspectiva,matrizPonto);		
		for(int i = 0; i < 4; i++) {
			matrizAux[0][i] = pontosAux[i];
		}
				
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p1[i];
		}
		pontosAux = multiplicaMatriz(matrizPerspectiva,matrizPonto);		
		for(int i = 0; i < 4; i++) {
			matrizAux[1][i] = pontosAux[i];
		}
		
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p2[i];
		}
		pontosAux = multiplicaMatriz(matrizPerspectiva,matrizPonto);		
		for(int i = 0; i < 4; i++) {
			matrizAux[2][i] = pontosAux[i];
		}
		
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p3[i];
		}
		pontosAux = multiplicaMatriz(matrizPerspectiva,matrizPonto);		
		for(int i = 0; i < 4; i++) {
			matrizAux[3][i] = pontosAux[i];
		}
		
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p4[i];
		}
		pontosAux = multiplicaMatriz(matrizPerspectiva,matrizPonto);		
		for(int i = 0; i < 4; i++) {
			matrizAux[4][i] = pontosAux[i];
		}	
		
		//divide para normalizar o valor de "W"
		for(int i= 0; i < 5; i++) {
			for(int j= 0; j < 4; j++) {
				matrizAux[i][j] = matrizAux[i][j] / matrizAux[i][3];
			}
		}						
		return(matrizAux);
	}		
	
	public double[][] projecaoParalela(double xLeft, double xRight, double yBottom, double yTop, double zNear, double zFar) {
		double[][] matrizPerspectiva = new double[4][4];
		double[][] matrizPonto = new double[4][1];
		double[] pontosAux = new double[4];
		double[][] matrizAux = new double[5][4];
		
		double a = 2 / (xRight - xLeft);
		double b = 2 / (yTop - yBottom);
		double c = -(2 / (zFar - zNear));
		double d = -((zFar + zNear)/(zFar - zNear));
		double e = -((yTop + yBottom)/(yTop - yBottom));
		double f = -((xRight + xLeft)/(xRight - xLeft));
		
		matrizPerspectiva[0][0] = a; matrizPerspectiva[0][1] = 0;matrizPerspectiva[0][2] = 0;matrizPerspectiva[0][3] = f;
		matrizPerspectiva[1][0] = 0; matrizPerspectiva[1][1] = b;matrizPerspectiva[1][2] = 0;matrizPerspectiva[1][3] = e;
		matrizPerspectiva[2][0] = 0; matrizPerspectiva[2][1] = 0;matrizPerspectiva[2][2] = c;matrizPerspectiva[2][3] = d;
		matrizPerspectiva[3][0] = 0; matrizPerspectiva[3][1] = 0;matrizPerspectiva[3][2] = 0;matrizPerspectiva[3][3] = 1;
		
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p0[i];
		}
		pontosAux = multiplicaMatriz(matrizPerspectiva,matrizPonto);		
		for(int i = 0; i < 4; i++) {
			matrizAux[0][i] = pontosAux[i];
		}
				
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p1[i];
		}
		pontosAux = multiplicaMatriz(matrizPerspectiva,matrizPonto);		
		for(int i = 0; i < 4; i++) {
			matrizAux[1][i] = pontosAux[i];
		}
		
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p2[i];
		}
		pontosAux = multiplicaMatriz(matrizPerspectiva,matrizPonto);		
		for(int i = 0; i < 4; i++) {
			matrizAux[2][i] = pontosAux[i];
		}
		
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p3[i];
		}
		pontosAux = multiplicaMatriz(matrizPerspectiva,matrizPonto);		
		for(int i = 0; i < 4; i++) {
			matrizAux[3][i] = pontosAux[i];
		}
		
		for(int i = 0; i < 4; i++) {
			matrizPonto[i][0] = p4[i];
		}
		pontosAux = multiplicaMatriz(matrizPerspectiva,matrizPonto);		
		for(int i = 0; i < 4; i++) {
			matrizAux[4][i] = pontosAux[i];
		}	
		
		//divide para normalizar o valor de "W"
		for(int i= 0; i < 5; i++) {
			for(int j= 0; j < 4; j++) {
				matrizAux[i][j] = matrizAux[i][j] / matrizAux[i][3];
			}
		}						
		return(matrizAux);
	}	
	
}