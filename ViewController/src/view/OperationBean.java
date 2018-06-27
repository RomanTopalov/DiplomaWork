package view;

import java.sql.Timestamp;

import javax.faces.component.UIComponent;

import model.EmployeePojo;
import model.EmployeesViewRowImpl;
import model.JobsViewRowImpl;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;


public class OperationBean {

  public OperationBean() {
  }

  private EmployeePojo employeePojo = new EmployeePojo();
   private RichPopup addPopup;
  private RichPopup deletePopup;
  private RichPopup updatePopup;

  JobsViewRowImpl job = new JobsViewRowImpl();
  
  public void setEmployeePojo(EmployeePojo employeePojo) {
      this.employeePojo = employeePojo;
  }

  public EmployeePojo getEmployeePojo() {
      return employeePojo;
  }

  public String b1_action() {
      
      return null;
  }
  
  public void addNewEmployee() {
      
      System.out.print(employeePojo.toString());
  }


  public String addNewEmployees() {
      try {
          DCBindingContainer bc = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
          DCIteratorBinding iter = bc.findIteratorBinding("EmployeesView1Iterator");
          ViewObject obj = iter.getViewObject(); 
          
           Row r;
            r = obj.createRow();
            r.setAttribute("CommissionPct",employeePojo.getCommissionPct());
            r.setAttribute("FirstName", employeePojo.getFirsName());
            r.setAttribute("LastName", employeePojo.getLastName());
            r.setAttribute("Email", employeePojo.getEmail());
            r.setAttribute("PhoneNumber", employeePojo.getPhoneNumber());
            r.setAttribute("DepartmentId", employeePojo.getDepartmentID());
            r.setAttribute("JobId",employeePojo.getJobID());
            r.setAttribute("HireDate", employeePojo.getHireDate());
            r.setAttribute("ManagerId", employeePojo.getManagerID());
            r.setAttribute("Salary", employeePojo.getSalary());
            
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
  
  public String deleteEmployee() {
      try {
          DCBindingContainer bc = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
          DCIteratorBinding iter = bc.findIteratorBinding("EmployeesView1Iterator");
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
  
  
  public String updateEmployee() {
      try {
          DCBindingContainer bc = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
      //    DCIteratorBinding iter = bc.findIteratorBinding("EmployeesView1Iterator"); 
          oracle.binding.OperationBinding operationBinding;
        
          EmployeesViewRowImpl emplVR =(EmployeesViewRowImpl)bc.findIteratorBinding("EmployeesView1Iterator").getCurrentRow();
          
          operationBinding = bc.getOperationBinding("Commit");
          operationBinding.execute();
          RichPopup popup = getUpdatePopup();
          popup.cancel();
    
            AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
            adfFacesContext.addPartialTarget(getUpdatePopup());
          
          
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
