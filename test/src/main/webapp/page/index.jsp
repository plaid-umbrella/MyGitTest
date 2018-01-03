<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <meta charset="utf-8">
  <title>Bootstrap</title>
  <!-- Site CSS -->
  <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
  <link href="https://static.bootcss.com/www/assets/css/site.min.css?1505127079951" rel="stylesheet">
  <style>
  .job-hot {
  	position: absolute;
  	color: #d9534f;
  	right: 0;
  	top: 15px;
  }
  </style>
  <!-- Favicons -->
  <link rel="apple-touch-icon-precomposed" href="https://static.bootcss.com/www/assets/ico/apple-touch-icon-precomposed.png?1505127079951">
  <link rel="shortcut icon" href="https://static.bootcss.com/www/assets/ico/favicon.png?1505127079951">
</head>

<body>

  <div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand hidden-sm" href="http://www.bootcss.com" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'navbar-首页'])">Bootstrap中文网</a>
      </div>
      <div class="navbar-collapse collapse" role="navigation">
        <ul class="nav navbar-nav">
          <li class="hidden-sm hidden-md"><a href="http://v2.bootcss.com/"  target="_blank" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'v2doc'])">Bootstrap2中文文档</a></li>
          <li><a href="http://v3.bootcss.com/" target="_blank" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'v3doc'])">Bootstrap3中文文档</a></li>
          <li><a href="http://v4.bootcss.com/" target="_blank" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'v4doc'])">Bootstrap 4.0 预览</a></li>
          <li><a href="/p/lesscss/" target="_blank" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'less'])">Less 教程</a></li>
          <li><a href="http://www.jquery123.com/" target="_blank" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'jquery'])">jQuery API</a></li>
          <li><a href="http://expo.bootcss.com" target="_blank" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'expo'])">网站实例</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right hidden-sm">
          <li><a href="/about/" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'about'])">关于</a></li>
        </ul>
      </div>
    </div>
  </div>
  
  <!-- Bootstrap core JavaScript
  ================================================== -->
  <!-- Placed at the end of the document so the pages load faster -->
  <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
