package its_meow.betteranimalsplus.common.util;

public class PolarVector3D {
		
		private double thetaX;
		private double thetaY;
		private double r;
		
		public PolarVector3D(double thetaxIn, double thetayIn, double rIn) {
			this.thetaX = thetaxIn;
			this.thetaY = thetayIn;
			this.r = rIn;
		}

		public double getThetaX() {
			return thetaX;
		}

		public void setThetaX(double thetaX) {
			this.thetaX = thetaX;
		}

		public double getThetaY() {
			return thetaY;
		}

		public void setThetaY(double thetaY) {
			this.thetaY = thetaY;
		}

		public double getR() {
			return r;
		}

		public void setR(double r) {
			this.r = r;
		}
		
		
		
	}