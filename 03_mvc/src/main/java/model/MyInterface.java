package model;

import common.ActionForward;
import jakarta.servlet.http.HttpServletRequest;

//퍼블릭 생략 가능, abstract 생략 가능 
public interface MyInterface {
  // request 자체를 넘겨줌
  ActionForward getDate(HttpServletRequest request);
  ActionForward getTime(HttpServletRequest request);
  ActionForward getDateTime(HttpServletRequest request);
}
