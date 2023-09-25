/**
 * 
 */


  var idleTime = 0;

    $(document).ready(function () { //분마다 카운팅

     var idleInterval = setInterval(timerIncrement, 60000); //정상 =1 minute test=1sec 

     //일정시간 움직임이 있으면 초기화

     $(this).mousemove(function (e) { idleTime = 0; });

     $(this).keypress(function (e) { idleTime = 0; }); 
     });


     function timerIncrement() {

      idleTime = idleTime + 1;

      if (idleTime >= 30) { //  정상 = 30 minute // test = 1초

       //새로고침 하거나 로그아웃 처리 
		if(confirm('일정시간동안 동작이 없어 로그아웃 합니다')){ //확인시 로그아웃 취소시 무반응                   
			location.href ='/Kmarket/member/logout.do?success=101';
		}

       //window.location.reload();//생각해보니 이게 새로고침한다고 로그아웃되는 프로세스가 아님; 
       

     }

    }