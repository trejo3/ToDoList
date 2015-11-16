<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>New Task</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    
<nav class="navbar navbar-default navbar-inverse">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Home</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="ProductListServlet">Task List <span class="sr-only">(current)</span></a></li>
        <li class="active"><a href="#">Completed Tasks <span class="sr-only">(current)</span></a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li style="color:white">Hello, ${userID }</li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
    </br >
<div class="container">
<div class="panel panel-default">
<div align="center">
<h1>New Task</h1>
</div>
  <div class="panel-body">
		
	<form class="form-horizontal" method="post" action="NewTask">
  <div class="form-group">
    <label for="inputDesc" class="col-sm-2 control-label">Task Description:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="newDesc" name="newDesc" placeholder="What do you have to do?">
    </div>
  </div>
  <div class="form-group">
    <label for="inputUID" class="col-sm-2 control-label">User ID:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="newUID" name="newUID" placeholder="Who is it assigned to?">
    </div>
  </div>
    <div class="form-group">
    <label for="inputDue" class="col-sm-2 control-label">Due:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="newDate" name="newDate" placeholder="DD-MM-YY">
    </div>
  </div>
    <div class="form-group">
    <label for="inputPriority" class="col-sm-2 control-label">Priority:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="newPriority" name="newPriority" placeholder="1-5">
    </div>
  </div>
  <div class="form-group">
    <label for="inputStatus" class="col-sm-2 control-label">Status:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="newStatus" name="newStatus" placeholder="0 (not started) - 3 (completed)">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default btn-lg">Add it!</button>
    </div>
  </div>
</form>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"
		integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ=="
		crossorigin="anonymous"></script>
   
</body>
</html>