/**
 * validation.js
 */
/*<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.1.min.js"></script>
<!-- ajaxSubmit -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.3.0/jquery.form.min.js"></script>
<script type="text/javascript">*/
$(function(){
   $("#regist").click(function(){
      $("#frm").ajaxSubmit({  //CSR
         type: "POST",
         url: "userRegist",
         beforeSubmit : function(){
            if($("#userId").val() == ""){
               alert("아이디를 입력해주세요.");
               $("#userId").focus();
               return false;               
            }
            if($("#userPw").val() == ""){
               alert("비밀번호를 입력해주세요.");
               $("#userPw").focus();
               return false;
            }
            if($("#userPwCon").val() != $("#userPw").val()){
               alert("비밀번호를 확인해주세요.");
               $("#userPwCon").focus();
               return false;
            }
            if($("#userName").val() == ""){
               alert("이름을 입력해주세요.");
               $("#userName").focus();
               return false;
            }
            if($("#pmEmpNum").val() == 0){
               alert("직원번호를 입력해주세요.");
               $("#pmEmpNum").focus();
               return false;
            }
         },
         success : function(result){
            if(result==200){
               location.href="/";
            }
         },
         error : function(){
            alert("서버오류");
         }
      });
   });
});

