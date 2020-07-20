package org.flame.springExample.models;

public class Greeting {

  private long id;
  private String content;
  private String regionName;
  private String environmentName;
  private String providerName;

  public Greeting() {
  }

  public Greeting(long id, String content, String regionName, String environmentName, String providerName) {
    this.id = id;
    this.content = content;
    this.regionName = regionName;
    this.environmentName = environmentName;
    this.providerName = providerName;
  }

  public long getId() {
    return id;
  }

  public String getContent() {
    return content;
  }

  public String getRegionName() {
    return regionName;
  }

  public String getEnvironmentName() {
    return environmentName;
  }

  public String getProviderName() {
    return providerName;
  }

}
