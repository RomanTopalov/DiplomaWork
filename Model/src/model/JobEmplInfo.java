package model;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.binding.AttributeContext;
import oracle.binding.RowContext;

public class JobEmplInfo {

  public JobEmplInfo() {
    super();
  }

  private int employeeId;
  private String firsName;
  private String lastName;
  private String jobId;
  private BigDecimal salary;
  private String location;

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }

  public int getEmployeeId() {
    return employeeId;
  }

  public void setFirsName(String firsName) {
    this.firsName = firsName;
  }

  public String getFirsName() {
    return firsName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setJobId(String jobId) {
    this.jobId = jobId;
  }

  public String getJobId() {
    return jobId;
  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }

  public BigDecimal getSalary() {
    return salary;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getLocation() {
    return location;
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
