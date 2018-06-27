package model;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.Date;

import oracle.binding.AttributeContext;
import oracle.binding.RowContext;

public class EmployeePojo {

  public EmployeePojo() {
    super();
  }

  private int EmployeeID;
  private String FirsName;
  private String LastName;
  private String Email;
  private String PhoneNumber;
  private Timestamp HireDate;
  private String JobID;
  private BigDecimal Salary;
  private BigDecimal CommissionPct;
  private int ManagerID;
  private int DepartmentID;

  public void setEmployeeID(int EmployeeID) {
    this.EmployeeID = EmployeeID;
  }

  public int getEmployeeID() {
    return EmployeeID;
  }

  public void setFirsName(String FirsName) {
    this.FirsName = FirsName;
  }

  public String getFirsName() {
    return FirsName;
  }

  public void setLastName(String LastName) {
    this.LastName = LastName;
  }

  public String getLastName() {
    return LastName;
  }

  public void setEmail(String Email) {
    this.Email = Email;
  }

  public String getEmail() {
    return Email;
  }

  public void setPhoneNumber(String PhoneNumber) {
    this.PhoneNumber = PhoneNumber;
  }

  public String getPhoneNumber() {
    return PhoneNumber;
  }

  public void setHireDate(Timestamp HireDate) {
    this.HireDate = HireDate;
  }

  public Timestamp getHireDate() {
    return HireDate;
  }

  public void setJobID(String JobID) {
    this.JobID = JobID;
  }

  public String getJobID() {
    return JobID;
  }

  public void setSalary(BigDecimal Salary) {
    this.Salary = Salary;
  }

  public BigDecimal getSalary() {
    return Salary;
  }

  public void setCommissionPct(BigDecimal CommissionPct) {
    this.CommissionPct = CommissionPct;
  }

  public BigDecimal getCommissionPct() {
    return CommissionPct;
  }

  public void setManagerID(int ManagerID) {
    this.ManagerID = ManagerID;
  }

  public int getManagerID() {
    return ManagerID;
  }

  public void setDepartmentID(int DepartmentID) {
    this.DepartmentID = DepartmentID;
  }

  public int getDepartmentID() {
    return DepartmentID;
  }

  public boolean setAttributeValue(AttributeContext p0, Object p1) {
    return false;
  }

  public Object createRowData(RowContext p0) {
    return null;
  }

  public Object registerDataProvider(RowContext p0) {
    return null;
  }

  public boolean removeRowData(RowContext p0) {
    return false;
  }

  public void validate() {
  }

}
