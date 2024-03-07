package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import common.ActionForward;
import jakarta.servlet.http.HttpServletRequest;

// @@.jsp 에서 보여줄 거다 라고 하는 view 의 경로 이름을 반환 
// forward하면 request에 저장된다, contextPath제외하고 작성해야함

public class MyInterfaceImpl implements MyInterface {
//"ofPattern"은 Java의 DateTimeFormatter 클래스의 메서드 중 하나입니다. 
//이 메서드는 날짜와 시간 형식을 지정하는 데 사용됩니다.
// true 가 redirect, false 는 forward(default)
  @Override
  public ActionForward getDate(HttpServletRequest request) {
    request.setAttribute("date", DateTimeFormatter.ofPattern("yyyy. MM. dd.").format(LocalDate.now()));
    return new ActionForward("/view/date.jsp", false);
  }
// format은 DateTimeFormatter를 사용하여 날짜 및 시간을 형식화하는 데 사용됩니다. 
// 이 메서드는 LocalDateTime 객체나 다른 유사한 객체를 형식화된 문자열로 변환합니다.
  @Override
  public ActionForward getTime(HttpServletRequest request) {
    request.setAttribute("time", DateTimeFormatter.ofPattern("HH:mm:ss.SSS").format(LocalTime.now()));
    return new ActionForward("/view/time.jsp", false);
  }

  @Override
  public ActionForward getDateTime(HttpServletRequest request) {
    request.setAttribute("datetime", DateTimeFormatter.ofPattern("yyyy. MM. ss HH:mm:ss.SSS").format(LocalDateTime.now()));
    return new ActionForward("/view/datetime.jsp", false);
  }

}
