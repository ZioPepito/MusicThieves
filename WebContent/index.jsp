<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Music Thieves</title>
		<link rel="icon" href="logo1.png">
		<link rel="stylesheet" href="style.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1">
	</head>
	<body>
		<div id="bg">
			<div id="form" class="col-md-4 col-md-offset-4">
				<form id="searchform" class="form-horizontal" role="form">
					<div style="margin-bottom: 25px" class="input-group">
						<span class="input-group-addon"><i class="glyphicon glyphicon-music"></i></span>
						<input id="keyword" type="text" class="form-control" name="keyword" value="" placeholder="type here" autofocus/>                                     
		         	</div>
		         	<div class="col-md-4 col-md-offset-4">
		         		<input id="submit" class="btn btn-info" type="submit" value="Steal Music"/>  
		         	</div>
		        </form>
		    </div> 
		</div>
	</body>
</html>