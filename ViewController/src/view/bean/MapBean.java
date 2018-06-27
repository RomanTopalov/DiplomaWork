package view.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import oracle.adf.view.faces.bi.component.thematicMap.UIPointDataLayer;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.RowKeySet;

public class MapBean {

  //List to contain Location Detail
  private List<LocationDetail> mapDetail = new ArrayList<LocationDetail>();
  // Bindings of page component to access value
  private RichInputText cntryNmBind;
  private RichInputText latitudeBind;
  private RichInputText longitudeBind;
  private RichInputText locationBind;
  private RichInputText descriptionBind;
  
  private UIPointDataLayer dataLayerBind;

  

  public MapBean() {
      // Add Default location to map
      LocationDetail location = new LocationDetail();
      location.setCountryNm("India");
      location.setLocation("Mumbai");
      location.setTextDisp("Economic Capital of India");
      location.setLongitude((float) 72.8258);
      location.setLattitude((float) 18.9750);
      mapDetail.add(location);

      location = new LocationDetail();
      location.setCountryNm("India");
      location.setLocation("Kanpur");
      location.setTextDisp("Industrial City in North India");

      location.setLongitude((float) 80.20);
      location.setLattitude((float) 26.28);
      mapDetail.add(location);

      System.out.println("List is-" + mapDetail);
  }

  public void setMapDetail(List mapDetail) {
      this.mapDetail = mapDetail;
  }

  public List getMapDetail() {
      return mapDetail;
  }


  /**Method to add new Location
   * @param actionEvent
   */
  public void addLocationButton(ActionEvent actionEvent) {
      if (cntryNmBind.getValue() != null && latitudeBind.getValue() != null && longitudeBind.getValue() != null &&
          locationBind.getValue() != null && descriptionBind.getValue() != null) {

          LocationDetail location = new LocationDetail();
          location = new LocationDetail();
          location.setCountryNm(cntryNmBind.getValue().toString());
          location.setLocation(locationBind.getValue().toString());
          location.setTextDisp(descriptionBind.getValue().toString());

          location.setLongitude(Float.parseFloat((String) longitudeBind.getValue()));
          location.setLattitude(Float.parseFloat((String) latitudeBind.getValue()));
          mapDetail.add(location);
          
        FacesContext fc = FacesContext.getCurrentInstance();
             String refreshpage = fc.getViewRoot().getViewId();
            ViewHandler ViewH =
             fc.getApplication().getViewHandler();
             UIViewRoot UIV = ViewH.createView(fc,refreshpage);
             UIV.setViewId(refreshpage);
             fc.setViewRoot(UIV);
      }
  }
  
   public void mapSelectionListener(SelectionEvent selectionEvent) {
       //getDataLayerBind is binding of dvt:pointDataLayer on page.
       RowKeySet selectedMarker = getDataLayerBind().getSelectedRowKeys();
       //Create iterator from RowKeySet
       Iterator iter = selectedMarker.iterator();

       while (iter.hasNext()) {
           String i = iter.next().toString();
           //LocationDetail is the list used to populate table and name is a column of table
           //So here filter list using index and get values then
           LocationDetail mapRow = mapDetail.get(Integer.parseInt(i));
           FacesMessage msg = new FacesMessage("Selected Marker is: " + mapRow.getLocation());
           FacesContext.getCurrentInstance().addMessage(null, msg);
       }}
  public void setDataLayerBind(UIPointDataLayer dataLayerBind) {
    this.dataLayerBind = dataLayerBind;
  }

  public UIPointDataLayer getDataLayerBind() {
    return dataLayerBind;
  }

  public void setCntryNmBind(RichInputText cntryNmBind) {
      this.cntryNmBind = cntryNmBind;
  }

  public RichInputText getCntryNmBind() {
      return cntryNmBind;
  }

  public void setLatitudeBind(RichInputText latitudeBind) {
      this.latitudeBind = latitudeBind;
  }

  public RichInputText getLatitudeBind() {
      return latitudeBind;
  }

  public void setLongitudeBind(RichInputText longitudeBind) {
      this.longitudeBind = longitudeBind;
  }

  public RichInputText getLongitudeBind() {
      return longitudeBind;
  }

  public void setLocationBind(RichInputText locationBind) {
      this.locationBind = locationBind;
  }

  public RichInputText getLocationBind() {
      return locationBind;
  }

  public void setDescriptionBind(RichInputText descriptionBind) {
      this.descriptionBind = descriptionBind;
  }

  public RichInputText getDescriptionBind() {
      return descriptionBind;
  }



}
