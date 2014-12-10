package edu.ucdavis.cstars.client.amd;

public class GenericModule implements AmdModuleDefinition
{
  private final String name;
  private final String argAlias;
  
  public GenericModule(String name, String argAlias) {
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
