package ding;

public class AttendanceQvo {
  String checkType;
  String userId;
  Long workDate;
  Long userCheckTime;

  public String getCheckType() {
    return checkType;
  }

  public void setCheckType(String checkType) {
    this.checkType = checkType;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public Long getWorkDate() {
    return workDate;
  }

  public void setWorkDate(Long workDate) {
    this.workDate = workDate;
  }

  public Long getUserCheckTime() {
    return userCheckTime;
  }

  public void setUserCheckTime(Long userCheckTime) {
    this.userCheckTime = userCheckTime;
  }
}
