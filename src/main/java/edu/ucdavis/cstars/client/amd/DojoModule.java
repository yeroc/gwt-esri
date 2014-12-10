package edu.ucdavis.cstars.client.amd;


public enum DojoModule implements AmdModuleDefinition
{
  DOM_READY("dojo/domReady!", null);

  private final String name;
  private final String argAlias;
  
  private DojoModule(String name, String argAlias) {
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
