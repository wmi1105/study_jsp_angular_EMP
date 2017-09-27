<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- Bootstrap 3.3.4 -->
    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
       <link href="/resources/vendor/bootstrap/css/landing-page.css" rel="stylesheet">
       
       
       <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
 
    <script src="/resources/vendor/jquery/jquery.min.js"></script>
<title>main page</title>

</head>


<body>
<!-- Navigation -->
<div class="wrapper">
    <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">E.M.P</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <!-- <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="/sboard/list">글쓰기</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Services</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Contact</a>
            </li>
          </ul>
        </div> -->
      </div>
    </nav>

    <!-- Header -->
      <form action="/include/loginPost" method="post">
    <header class="intro-header">
      <div class="container">
        <div class="intro-message">
	        
	    <ul><input type="text" name="MID" id="MID" placeholder="Id" style="background-color:#D8D8D8;"/></ul>
        <ul><input type="password" name="MPW" id="MPW" placeholder="Password" style="background-color:#D8D8D8;"/></ul>
        <hr class="intro-divider">
         <ul class="list-inline intro-social-buttons">
                <li class="list-inline-item">
              <button type="submit" class="btn btn-primary btn-block btn-flat" >Login</button>
            </li>
            <li class="list-inline-item">
             <button type="button" onClick="location.href='/include/mregister'"class="btn btn-primary btn-block btn-flat" >Join</button>
            </li>
            </ul>
        <!-- 
        <ul><button type="submit" class="btn btn-primary btn-block btn-flat" >Login</button></ul>
	        </form>
	        <ul> <a href="/include/mregister">등록하기</a></ul> -->
	          
	       
          <!-- <h1>Landing Page</h1>
          <h3>A Template by Start Bootstrap</h3>
          <hr class="intro-divider">
          <ul class="list-inline intro-social-buttons">
            <li class="list-inline-item">
              <a href="#" class="btn btn-secondary btn-lg">
                <i class="fa fa-twitter fa-fw"></i>
                <span class="network-name">Twitter</span>
              </a>
            </li>
            <li class="list-inline-item">
              <a href="#" class="btn btn-secondary btn-lg">
                <i class="fa fa-github fa-fw"></i>
                <span class="network-name">Github</span>
              </a>
            </li>
            <li class="list-inline-item">
              <a href="#" class="btn btn-secondary btn-lg">
                <i class="fa fa-linkedin fa-fw"></i>
                <span class="network-name">Linkedin</span>
              </a>
            </li>
          </ul> -->
        </div>
      </div>
       
    </header>


