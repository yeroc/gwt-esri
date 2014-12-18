package edu.ucdavis.cstars.client.amd;

/**
 * Define modules with argument aliases as per documentation at
 * https://developers.arcgis.com/javascript/jsapi/argument_aliases.html.
 */
public enum EsriModule implements AmdModuleDefinition
{
  ESRI_MAP("esri/map", "Map"),
  ESRI_LAYERS_FEATURE("esri/layers/FeatureLayer", "FeatureLayer"),
  ESRI_DIJIT_OVERVIEW("esri/dijit/OverviewMap", "OverviewMap");

  private final String name;
  private final String argAlias;
  
  private EsriModule(String name, String argAlias) {
    this.name = name;
    this.argAlias = argAlias;
  }
  
  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getArgAlias() {
    return argAlias;
  }
}
