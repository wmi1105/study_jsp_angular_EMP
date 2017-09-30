<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
              <input type='hidden' name="MPW" value="${login.MPW}">
             <div class="form-group">
                  <label for="name" class="cols-sm-2 control-label">이름</label>
                  <div class="cols-sm-10">
                     <div class="input-group">
                     <span class="input-group-addon"> </span>
                        <input type="text" class="form-control"
                             value="${login.MID}" />
                     </div>
                  </div>
               </div>
        
            
           
               <div class="form-group">
                  <label for="name" class="cols-sm-2 control-label">이름</label>
                  <div class="cols-sm-10">
                     <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user fa"
                           aria-hidden="true"></i></span> <input type="text" class="form-control"
                           name="MNAME"  value="${login.MNAME}" />
                     </div>
                  </div>
               </div>

            

               <div class="form-group">
                  <label for="department" class="cols-sm-2 control-label">부서</label>
                  <div class="cols-sm-10">
                     <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-users fa"
                           aria-hidden="true"></i></span> <input type="text" class="form-control"
                           name="MDP"  value="${login.MDP}" />
                     </div>
                  </div>
               </div>

               <div class="form-group">
                  <label for="phone" class="cols-sm-2 control-label">연락처</label>
                  <div class="cols-sm-10">
                     <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-phone fa"
                           aria-hidden="true"></i></span> <input type="text" class="form-control"
                           name="MPHONE"  value="${login.MPHONE}" />
                     </div>
                  </div>
               </div>

               <div class="form-group">
                  <label for="email" class="cols-sm-2 control-label">이메일</label>
                  <div class="cols-sm-10">
                     <div class="input-group">
                        <span class="input-group-addon"><i
                           class="fa fa-envelope fa" aria-hidden="true"></i></span> <input
                           type="text" class="form-control" name="MMAIL"  value="${login.MMAIL}" />
                     </div>
                  </div>
               </div>
               <div class="form-group ">
                  <input type='file' name='MIMG'value="${login.MIMG}">
               </div>
               
          
               <div class="form-group ">
                  <input type='text'name="checkIn" value="${check.checkIn }"/>
               </div>
               
              
               <div class="form-group ">
                  <input type='text'name="checkIn" value="${check.checkIn }"/>
               </div>


              
           
         </div>
      </div>
      
   </div>
   
              
   

   <script src="/resources/vendor/jquery/jquery.min.js"></script>
   <script src="/resources/vendor/popper/popper.min.js"></script>
   <script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>