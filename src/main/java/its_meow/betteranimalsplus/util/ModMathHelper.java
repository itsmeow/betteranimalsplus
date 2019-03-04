package its_meow.betteranimalsplus.util;

import net.minecraft.util.math.MathHelper;

public class ModMathHelper {

	public static final double PHI = 1.618033988749894D;
	public static final double PI = Math.PI;
	public static final double TO_DEG = 57.29577951308232D;
	public static final double TO_RAD = 0.017453292519943D;
	public static final double SQRT2 = 1.414213562373095D;

	public static double[] SIN_TABLE = new double[65536];

	static {
		for(int i = 0; i < 65536; ++i) {
			ModMathHelper.SIN_TABLE[i] = Math.sin(i / 65536D * 2 * ModMathHelper.PI);
		}

		ModMathHelper.SIN_TABLE[0] = 0;
		ModMathHelper.SIN_TABLE[16384] = 1;
		ModMathHelper.SIN_TABLE[32768] = 0;
		ModMathHelper.SIN_TABLE[49152] = 1;
	}

	public static double sin(double d) {
		return ModMathHelper.SIN_TABLE[(int) ((float) d * 10430.378F) & 65535];
	}

	public static double cos(double d) {
		return ModMathHelper.SIN_TABLE[(int) ((float) d * 10430.378F + 16384.0F) & 65535];
	}

	public static float approachLinear(float a, float b, float max) {
		return a > b ? a - b < max ? b : a - max : b - a < max ? b : a + max;
	}

	public static double approachLinear(double a, double b, double max) {
		return a > b ? a - b < max ? b : a - max : b - a < max ? b : a + max;
	}

	public static float wrapAngle(float a1, float a2, float delta) {
		float angle = MathHelper.wrapDegrees(a2 - a1);

		if(angle > delta) {
			angle = delta;
		}

		if(angle < -delta) {
			angle = -delta;
		}

		return a1 + angle;
	}

	/**
	 * @param a1
	 *            - The first angle.
	 * @param a2
	 *            - The second angle.
	 * @param p
	 *            - A float between 0.0 and 1.0 that determines the progress
	 *            between the two angles.
	 * @return a rotation angle that is between two other rotation angles. 'a1'
	 *         and 'a2' are the angles between which to interpolate.
	 * 
	 *         Example: angle1 = 30, angle2 = 50, progress = 0.5, return = 40
	 */
	public static float interpolateRotation(float a1, float a2, float p) {
		float angle = a2 - a1;
		angle = angle < -180F ? angle += 360F : angle;
		return a1 + p * (angle = angle >= 180F ? angle -= 360F : angle);
	}

	public static float interpolate(float a, float b, float d) {
		return a + (b - a) * d;
	}

	public static double interpolate(double a, double b, double d) {
		return a + (b - a) * d;
	}

	public static double approachExp(double a, double b, double ratio) {
		return a + (b - a) * ratio;
	}

	public static double approachExp(double a, double b, double ratio, double cap) {
		double d = (b - a) * ratio;

		if(Math.abs(d) > cap) {
			d = Math.signum(d) * cap;
		}

		return a + d;
	}

	public static double retreatExp(double a, double b, double c, double ratio, double kick) {
		double d = (Math.abs(c - a) + kick) * ratio;

		if(d > Math.abs(b - a)) {
			return b;
		}

		return a + Math.signum(b - a) * d;
	}

	public static double clip(double value, double min, double max) {
		if(value > max) {
			value = max;
		}

		if(value < min) {
			value = min;
		}

		return value;
	}

	public static boolean between(double a, double x, double b) {
		return a <= x && x <= b;
	}

	public static int approachExpI(int a, int b, double ratio) {
		int r = (int) Math.round(ModMathHelper.approachExp(a, b, ratio));

		return r == a ? b : r;
	}

	public static int retreatExpI(int a, int b, int c, double ratio, int kick) {
		int r = (int) Math.round(ModMathHelper.retreatExp(a, b, c, ratio, kick));

		return r == a ? b : r;
	}

	public static int floor(double d) {
		int i = (int) d;
		return d < i ? i - 1 : i;
	}

	public static int roundAway(double d) {
		return (int) (d < 0 ? Math.floor(d) : Math.ceil(d));
	}

	public static int compare(int a, int b) {
		return a == b ? 0 : a < b ? -1 : 1;
	}

	public static int compare(double a, double b) {
		return a == b ? 0 : a < b ? -1 : 1;
	}
}