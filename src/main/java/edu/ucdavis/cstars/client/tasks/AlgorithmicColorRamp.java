package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.dojo.Color;

/**
 * Class added v2.6
 * Create an algorithmic color ramp to define the range of colors used in the renderer generated by the GenerateRendererTask. 
 * The algorithmic color ramp is defined by specifying two colors and the algorithm used to traverse the intervening color 
 * spaces. Specify the from and to colors using dojo.color.
 * 
 * There are three algorithms that can be used to define the color values between the from and to colors: 'cie-lab', 'hsv', 
 * and 'lab-lch'. There is very little difference between these algorithms when the from and the to colors are of the same 
 * or very similar hues. But when the hues for the from and to colors are different (Hue is different by 40 or more on a 
 * 0-360 scale), the algorithms produce different results. The 'hsv' algorithim traverses the hue difference in a purely 
 * linear fashion, resulting in a bright ramp where all intermediate colors are represented. For instance, a ramp from 
 * red to green would include orange, yellow, and yellow-green. The 'cie-lab' and 'lab-lch' produce a more blended result. 
 * Thus, a ramp from dark green to orange would not contain a bright yellow, but instead a more brown and green-gold or 
 * green-brown intermediate color. The advantage of the 'cie-lab' algorithm is that the colors of the ramp are visually 
 * equidistant, which can produce a better ramp.
 * 
 * @author Justin Merz
 */
public class AlgorithmicColorRamp extends JavaScriptObject {

	public static enum Algorithm {
		NOT_SET(""),
		/**
		 * Blends the from and to colors without traversing the intervening hue space.
		 */
		CIE_LAB("cie-lab"),
		/**
		 * The hue, saturation, value (hsv) algorithm is a linear traverse of colors between pairs: 
		 * Color 1 H to Color 2 H, Color 1 S to Color 2 S, and Color 1 V to Color 2 V.
		 */
		HSV("hsv"),
		/**
		 * The lab-lch algorithm is very similar to the cie-lab but does not seek the shortest path 
		 * between colors.
		 */
		LAB_LCH("lab-lch");
		private String val;
		private  Algorithm(String value){
			val = value;
		}
		public String getValue(){
			return val;
		}
		public static Algorithm get(String a) {
			for( int i = 0; i < Algorithm.values().length; i++ ){
				if( Algorithm.values()[i].getValue().contentEquals(a) ){
					return Algorithm.values()[i];
				}
			}
			return Algorithm.NOT_SET;
		}
	}
	
	protected AlgorithmicColorRamp() {}
	
	/**
	 * Creates a new AlgorithmicColorRamp object.
	 * 
	 * @return
	 */
	public static native AlgorithmicColorRamp create() /*-{
		return new $wnd.esri.tasks.AlgorithmicColorRamp();
	}-*/;
	
	/**
	 * The algorithim used to generate the colors between the fromColor and toColor. Each algorithim 
	 * uses different methods for generating the intervening colors.
	 * 
	 * @return Algorithm
	 */
	public final Algorithm getAlgorithm() {
		return Algorithm.get(_getAlgorithm());
	}
	
	private final native String _getAlgorithm() /*-{
		return this.algorithm;
	}-*/;
	
	/**
	 * Set the algorithm parameter.
	 * 
	 * @param algorithm - The algorithim used to generate the colors between the fromColor and toColor. Each 
	 * algorithim uses different methods for generating the intervening colors.
	 */
	public final void setAlgorithm(Algorithm algorithm) {
		_setAlgorithm(algorithm.getValue());
	}
	
	private final native void _setAlgorithm(String algorithm) /*-{
		this.algorithm = algorithm;
	}-*/;
	
	/**
	 * The first color in the color ramp.
	 * 
	 * @return Color
	 */
	public final native Color getFromColor() /*-{
		return this.fromColor;
	}-*/;
	
	/**
	 * Set the fromColor parameter.
	 * 
	 * @param fromColor - The first color in the color ramp.
	 */
	public final native void setFromColor(Color fromColor) /*-{
		this.fromColor = this.fromColor;
	}-*/;
	
	/**
	 * The last color in the color ramp.
	 * 
	 * @return Color
	 */
	public final native Color getToColor() /*-{
		return this.toColor;
	}-*/;
	
	/**
	 * Set the toColor parameter.
	 * 
	 * @param toColor - The last color in the color ramp.
	 */
	public final native void setToColor(Color toColor) /*-{
		this.toColor = this.toColor;
	}-*/;
	
	/**
	 * Returns an easily serializable object representation of an algorithmic color ramp.
	 * 
	 * @return JavaScriptObject
	 */
	public final native JavaScriptObject toJson() /*-{
		return this.toJson();
	}-*/;

}
