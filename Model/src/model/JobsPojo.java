package model;

import oracle.binding.AttributeContext;
import oracle.binding.RowContext;

public class JobsPojo {

  public JobsPojo() {
    super();
  }

  private int JobId;
  private String JobTitle;
  private int MinSalary;
  private int MaxSalary;

  public void setJobId(int JobId) {
    this.JobId = JobId;
  }

  public int getJobId() {
    return JobId;
  }

  public void setJobTitle(String JobTitle) {
    this.JobTitle = JobTitle;
  }

  public String getJobTitle() {
    return JobTitle;
  }

  public void setMinSalary(int MinSalary) {
    this.MinSalary = MinSalary;
  }

  public int getMinSalary() {
    return MinSalary;
  }

  public void setMaxSalary(int MaxSalary) {
    this.MaxSalary = MaxSalary;
  }

  public int getMaxSalary() {
    return MaxSalary;
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
