package com.gdu.prj.utils;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data   
// getter setter를 제공

//https://mockaroo.com/ 사이트에서 board_t 의 내용 만듦
public class MyPageUtils {
  private int total;  // 전체 게시글 개수 (DB에서 구한다.)
  private int dislay; // 한 페이지에 표시할 게시글 개수 (요청 파라미터로 받는다.)
  private int page;   // 현재 페이지 번호 (요청 파라미터로 받는다.)
  private int begin;  // 한 페이지에 표시할 게시글의 시작 번호
  private int end;    // 한 페이지에 표시할 게시글의 종료 번호
  
  private int totalPage;         // 전체 페이지 개수                         (계산한다.)
  private int pagePerBlock = 10; // 한 블록에 표시할 페이지 링크의 개수      (임의로 결정한다.)
  private int beginPage;         // 한 블록에 표시할 페이지 링크의 시작 번호 (계산한다.)
  private int endPage;           // 한 블록에 표시할 페이지 링크의 종료 번호 (계산한다.)
  
  public void setPaging(int total, int display, int page) {
    
    this.total = total;
    this.dislay = display;
    this.page = page;
    
    begin = (page - 1) * display + 1;
    end = begin + display - 1;
    // total 1002
    // display 20
    // page=1   1   20
    // page=2   21  40
    // page=3   41  60
    //..
    // page=50  981  1000
    // page=51  1001 1020
    // 원래 있는 page_no 로 정렬하면 안됨 row_no로 정렬해야함.
    // baseURI : 현재 주소값 <a href="여기에 들어가는 값">
    totalPage = (int)Math.ceil((double)total / display);
    beginPage = ((page - 1) / pagePerBlock) * pagePerBlock + 1;
    endPage = Math.min(totalPage, beginPage + pagePerBlock - 1);
    
    
  }
  
  public String getPaging(String requestURI, String sort, int display) {
  
      StringBuilder builder = new StringBuilder();

      // <
      if(beginPage == 1) {
        builder.append("<div class=\"dont-click\">&lt;</div>");
      } else {
        builder.append("<div><a href=\"" + requestURI + "?page=" + (beginPage - 1) + "&sort=" + sort+"&display=" + display + "\">&lt;</a></div>");
      // < 를 누르면 11 페이지에서 10 페이지로 이동
      }
      
        
      // 1 2 3 4 5 6 7 8 9 10
      for(int p = beginPage; p <= endPage; p++) {
        if(p == page) {
          builder.append("<div class=\"current-page\" href=\"" + requestURI + "?page=" + p + "&sort=" + sort + "&display=" + display + "\">" + p + "</a></div>");
        } else {
          builder.append("<div><a href=\"" + requestURI + "?page=" + p + "&sort=" + sort + "&display=" + display + "\">" + p + "</a></div>");
          
        }
      }

      // >
      if(endPage == totalPage) {
      builder.append("<div class=\"dont-click\">&gt;</div>");
      } else {
        builder.append("<div><a href=\"" + requestURI + "?page=" + (endPage + 1) + "&sort=" + sort + "&display=" + display + "\">&gt;</a></div>");
      }
      
      return builder.toString();
  
  
  
  }
  
  
  
  
}
