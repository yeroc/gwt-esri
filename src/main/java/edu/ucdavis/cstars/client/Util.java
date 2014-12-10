package edu.ucdavis.cstars.client;

import com.google.gwt.core.client.JavaScriptObject;

public class Util {
	
	public static native void addObjectToArray(JavaScriptObject object, JavaScriptObject array) /*-{
		array.push(object);
	}-*/;
	
	public static JavaScriptObject objectArrayToJSO(JavaScriptObject[] objects) {
		if( objects == null ) return null;
		JavaScriptObject arr = JavaScriptObject.createArray();
		for( int i = 0; i < objects.length; i++ ) addObjectToArray(objects[i], arr);
		return arr;
	}
	
	public static native void addIntToArray(int val, JavaScriptObject array) /*-{
		array.push(val);
	}-*/;
	
	public static JavaScriptObject intArrayToJSO(int[] ints) {
		if( ints == null ) return null;
		JavaScriptObject arr = JavaScriptObject.createArray();
		for( int i = 0; i < ints.length; i++ ) addIntToArray(ints[i], arr);
		return arr;
	}
	
	public static native void addDoubleToArray(double val, JavaScriptObject array) /*-{
		array.push(val);
	}-*/;
	
	public static JavaScriptObject doubleArrayToJSO(double[] doubles) {
		if( doubles == null ) return null;
		JavaScriptObject arr = JavaScriptObject.createArray();
		for( int i = 0; i < doubles.length; i++ ) addDoubleToArray(doubles[i], arr);
		return arr;
	}
	
	public static native void addStringToArray(String val, JavaScriptObject array) /*-{
		array.push(val);
	}-*/;
	
	public static JavaScriptObject stringArrayToJSO(String[] strings) {
		if( strings == null ) return null;
		JavaScriptObject arr = JavaScriptObject.createArray();
		for( int i = 0; i < strings.length; i++ ) addStringToArray(strings[i], arr);
		return arr;
	}
	
	public static void addEsriLoadHandler(Runnable handler) {
		_addEsriLoadHandler(handler);
	}
	
	private static native void _addEsriLoadHandler(Runnable handler) /*-{
		$wnd.require(["esri/map", "dojo/domReady!"], function(Map) {
			handler.@java.lang.Runnable::run()();
		});
	}-*/;
	
	
	private static native void _addRequiredPackage(String name) /*-{
		$wnd.dojo.require(name);
	}-*/;

	public static native void debugObject(String name, JavaScriptObject jso) /*-{
		if( !$wnd["__gwt_esri_debug"] ) $wnd["__gwt_esri_debug"] = {};
		$wnd.__gwt_esri_debug[name] = jso;
	}-*/;
	
}
