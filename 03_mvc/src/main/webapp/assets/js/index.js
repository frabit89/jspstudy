/**
 * 
 */

//호스트
const getContextPath = ()=>{
  
  const host = location.host; /* http://localhost:8080 */
  const url = location.href; /* http://localhost:8080/mvc/getDate.do */
  const begin = url.indexOf(host) + host.length;
  const end = url.indexOf('/', begin + 1);
  return url.substring(begin, end);
}

 const getDateTime = ()=>{
   const type = document.getElementById('type');
   if(type.value === 'date'){
     location.href = getContextPath() + '/getDate.do';
     //위치로 이동할 수 있게 만들어줌.
     //contextPath: mvc
   } else if(type.value === 'time'){
     location.href = getContextPath() + '/getTime.do';
     // 요청마다 servlet을 만드는건 mvc 패턴이 아니다? 무슨 소린지 모르겠음.
     // 하나의 servlet이 가입 탈퇴 로그인 로그아웃 등을 다 받음
     // 그리고 그 servlet이 모든 요청을 받아서 요청 받았을 시 그에 따른 Java에 보냄.
     // suffix값 *.do 방식으로 으로 사용.
     // 하나의 서블릿에 url mapping을 *.do라고 수정만 해주면 하나의 서블릿 머시기 안들림
     // controller package 만든곳에 servlet을 만들어 mapping값을 *.do 라고 설정.
   } else if(type.value === 'datetime'){
     location.href = getContextPath() + '/getDateTime.do';
   }
 }
 
 document.getElementById('btn').addEventListener('click', getDateTime);
 