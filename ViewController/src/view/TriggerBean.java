package view;

import javax.faces.event.ActionEvent;

import oracle.adf.share.ADFContext;
import oracle.adf.share.security.SecurityContext;
import oracle.adf.view.rich.component.rich.RichPopup;

public class TriggerBean {

  public TriggerBean() {
  }
  private RichPopup warnigPopup;

  public void setWarnigPopup(RichPopup warnigPopup) {
    this.warnigPopup = warnigPopup;
  }

  public RichPopup getWarnigPopup() {
    return warnigPopup;
  }

  public String goToEmployeeCRUD() {

      MainProcessBean mainProcessBean = new MainProcessBean();
      mainProcessBean.putValue("goToEmployee");
      return "goToRouter";
//    }
  }

  public String goTo_IndexPage() {
    MainProcessBean mainProcessBean = new MainProcessBean();
    mainProcessBean.putValue("index");
    return "goToFirstPage";
  }

}
