<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Website CSS style -->
<link rel="stylesheet" type="text/css"
   href="/resources/vendor/bootstrap/css/register.css">


<link href="/resources/vendor/bootstrap/css/bootstrap.min.css"
   rel="stylesheet" type="text/css" />

<!-- Website Font style -->
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">

<!-- Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Passion+One'
   rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oxygen'
   rel='stylesheet' type='text/css'>
<title>Admin</title>
<script type="text/javascript">
function writeCheck() {
      var form = document.writeForm;
         if (form.MNAME.value == "") {
            alert("이름를 입력해 주세요");
            return form.MNAME.focus();
         } else if (form.MPW.value == "") {
            alert("비밀번호를 입력해 주세요");
            return form.MPW.focus();
         } else if (form.MPW.value != form.confirm.value) {
            alert("비밀번호를 확인해 주세요");
            return form.confirm.focus();
         } else if (form.MIMG.value == "") {
             alert("사진을 등록해 주세요");
             return form.MIMG.focus();
          } else {
            form.action = "/include/mregister";
            form.method="post";
            form.submit();
         }
      }
</script>
</head>
<body>
   <div class="container">
      <div class="row main">
         <div class="panel-heading">
            <div class="panel-title text-center">
               <h1 class="title">Company Name</h1>
               <hr />
            </div>
         </div>
         <div class="main-login main-center">
            <form class="form-horizontal" method="post"
               action="/include/mregister" id="writeForm" name="writeForm" onsubmit="return false;">

               <div class="form-group">
                  <label for="name" class="cols-sm-2 control-label">이름</label>
                  <div class="cols-sm-10">
                     <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user fa"
                           aria-hidden="true"></i></span> <input type="text" class="form-control"
                           name="MNAME" id="MNAME" placeholder="필수 입력란입니다." />
                     </div>
                  </div>
               </div>

               <div class="form-group">
                  <label for="password" class="cols-sm-2 control-label">비밀번호</label>
                  <div class="cols-sm-10">
                     <div class="input-group">
                        <span class="input-group-addon"><i
                           class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <input
                           type="password" class="form-control" name="MPW" id="MPW"
                           placeholder="필수 입력란입니다." />
                     </div>
                  </div>
               </div>

               <div class="form-group">
                  <label for="confirm" class="cols-sm-2 control-label">비밀번호
                     확인</label>
                  <div class="cols-sm-10">
                     <div class="input-group">
                        <span class="input-group-addon"><i
                           class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <input
                           type="password" class="form-control" name="confirm"
                           id="confirm" placeholder="필수 입력란입니다." />
                     </div>
                  </div>
               </div>

               <div class="form-group">
                  <label for="department" class="cols-sm-2 control-label">부서</label>
                  <div class="cols-sm-10">
                     <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-users fa"
                           aria-hidden="true"></i></span> <input type="text" class="form-control"
                           name="MDP" id="MDP" />
                     </div>
                  </div>
               </div>

               <div class="form-group">
                  <label for="phone" class="cols-sm-2 control-label">연락처</label>
                  <div class="cols-sm-10">
                     <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-phone fa"
                           aria-hidden="true"></i></span> <input type="text" class="form-control"
                           name="MPHONE" id="MPHONE" />
                     </div>
                  </div>
               </div>

               <div class="form-group">
                  <label for="email" class="cols-sm-2 control-label">이메일</label>
                  <div class="cols-sm-10">
                     <div class="input-group">
                        <span class="input-group-addon"><i
                           class="fa fa-envelope fa" aria-hidden="true"></i></span> <input
                           type="text" class="form-control" name="MMAIL" id="MMAIL" />
                     </div>
                  </div>
               </div>
               <div class="form-group ">
                  <input type='file' name="MIMG">
               </div>


               <div class="form-group ">
                  <button type="submit"
                     class="btn btn-primary btn-lg btn-block login-button" onClick="writeCheck();">Register</button>
               </div>
               <div class="login-register">
                  <a href="./main">Login</a>
               </div>
            </form>
         </div>
      </div>
   </div>


   <script src="/resources/vendor/jquery/jquery.min.js"></script>
   <script src="/resources/vendor/popper/popper.min.js"></script>
   <script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>