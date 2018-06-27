package view.bean;

public class LocationDetail {

  public LocationDetail() {
    super();
  }
  

      private String location; // Name of Location
      private String countryNm; // Name of Country
      private String textDisp; // Additional Information to display
      private float lattitude; // Latitude of location
      private float longitude; // Longitude of Location

      public void setLocation(String location) {
          this.location = location;
      }

      public String getLocation() {
          return location;
      }

      public void setCountryNm(String countryNm) {
          this.countryNm = countryNm;
      }

      public String getCountryNm() {
          return countryNm;
      }

      public void setTextDisp(String textDisp) {
          this.textDisp = textDisp;
      }

      public String getTextDisp() {
          return textDisp;
      }

      public void setLattitude(float lattitude) {
          this.lattitude = lattitude;
      }

      public float getLattitude() {
          return lattitude;
      }

      public void setLongitude(float longitude) {
          this.longitude = longitude;
      }

      public float getLongitude() {
          return longitude;
      }
  }


