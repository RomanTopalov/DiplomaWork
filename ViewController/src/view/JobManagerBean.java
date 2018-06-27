package view;

import com.model.Employees;

import java.util.List;

import model.EmployeesViewRowImpl;
import model.JobEmplInfo;
import model.JobsPojo;

import model.JobsViewRowImpl;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

public class JobManagerBean {
  private boolean isActive = true;
  private JobsPojo jobsPojo = new JobsPojo();
  private RichPopup addPopup;
  private RichPopup deletePopup;
  private RichPopup updatePopup;
  private JobEmplInfo jobEmplInfo = new JobEmplInfo();
  

  public JobManagerBean() {
  }
  
  public String Add_JobAction() {
    try {
        DCBindingContainer bc = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding iter = bc.findIteratorBinding("JobsView1Iterator");
        ViewObject obj = iter.getViewObject(); 
        
         Row r;
          r = obj.createRow();
          r.setAttribute("JobTitle",jobsPojo.getJobTitle());
          r.setAttribute("MinSalary",jobsPojo.getMinSalary());
          r.setAttribute("MaxSalary",jobsPojo.getMaxSalary());
        obj.insertRow(r);
        oracle.binding.OperationBinding operationBinding;
        operationBinding = bc.getOperationBinding("Commit");
        operationBinding.execute();
      
        RichPopup popup = getAddPopup();
        popup.cancel();
         popup.hide();
      
      addPopup.cancel();

    } catch (Exception e) {
        // TODO: Add catch code
        e.printStackTrace();
    }
    
    return "";
  }
  
  public String Update_JobAction() {
    try {
        DCBindingContainer bc = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        oracle.binding.OperationBinding operationBinding;    
       JobsViewRowImpl emplVR =(JobsViewRowImpl)bc.findIteratorBinding("JobsView1Iterator").getCurrentRow();  
        operationBinding = bc.getOperationBinding("Commit");
        operationBinding.execute();
        RichPopup popup = getUpdatePopup();
        popup.cancel();
         popup.hide();
   
        AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
        adfFacesContext.addPartialTarget(getUpdatePopup());
        
        
    } catch (Exception e) {
        // TODO: Add catch code
        e.printStackTrace();
    }
    
    return "";
  }
  
  public String delete_JobAction() {
      try {
          DCBindingContainer bc = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
          DCIteratorBinding iter = bc.findIteratorBinding("JobsView1Iterator");
          ViewObject obj = iter.getViewObject();

          Row r;
          r = obj.getCurrentRow();            
          r.remove();
          oracle.binding.OperationBinding operationBinding;
          operationBinding = bc.getOperationBinding("Commit");
          operationBinding.execute();
          RichPopup popup = getDeletePopup();
          
          popup.cancel();
          popup.hide();

      } catch (Exception e) {
          // TODO: Add catch code
          e.printStackTrace();
      }
      return "";
  }
  
  
  
  public String closePopup(){
      addPopup.cancel();
      deletePopup.cancel();
      updatePopup.cancel();
      
      return "";
  }
  
  

  public void showAddtInfojob() {

  }

  public void setIsActive(boolean isActive) {
    this.isActive = isActive;
  }

  public boolean isIsActive() {
    return isActive;
  }

 

  public void setJobsPojo(JobsPojo jobsPojo) {
    this.jobsPojo = jobsPojo;
  }

  public JobsPojo getJobsPojo() {
    return jobsPojo;
  }

  public void setAddPopup(RichPopup addPopup) {
    this.addPopup = addPopup;
  }

  public RichPopup getAddPopup() {
    return addPopup;
  }

  public void setDeletePopup(RichPopup deletePopup) {
    this.deletePopup = deletePopup;
  }

  public RichPopup getDeletePopup() {
    return deletePopup;
  }

  public void setUpdatePopup(RichPopup updatePopup) {
    this.updatePopup = updatePopup;
  }

  public RichPopup getUpdatePopup() {
    return updatePopup;
  }

 

}
