package edu.ucdavis.cstars.client;

import java.util.List;

import com.google.gwt.core.client.JsArrayString;

import edu.ucdavis.cstars.client.amd.AmdModuleDefinition;

public class Loader
{
  public static void amdScript(List<AmdModuleDefinition> dependencies, Runnable script) {
    JsArrayString modules = JsArrayString.createArray().cast();
    String args = "";
    for (AmdModuleDefinition dependency : dependencies) {
      modules.push(dependency.getName());
      if (dependency.getArgAlias() != null) {
        args += dependency.getArgAlias() + ", ";
      }
    }
    // trim trailing , 
    args = trimOffEnd(args, 2);
    
    _exec(modules, script);
  }
  
  private static String trimOffEnd(String input, int num) {
    if (input.length() > num) {
      return input.substring(0, input.length() - num);
    } else {
      return input;
    }
  }
  
  private native static void _exec(JsArrayString modules, Runnable script) /*-{
    $wnd.require(modules, function(Map) {
      script.@java.lang.Runnable::run()();
    });
  }-*/;  
}
