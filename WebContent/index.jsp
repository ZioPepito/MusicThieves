<%@page import="musicthieves.wrapper.Song"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Music Thieves | Search Engine</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.css" />
<!-- boostrap -->
<link rel="stylesheet" href="assets/bootstrap/css/social.css" />
<link rel="stylesheet" href="assets/animate.css">
<link rel="stylesheet" href="assets/style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" media="screen" href="http://cdnjs.cloudflare.com/ajax/libs/fancybox/1.3.4/jquery.fancybox-1.3.4.css" />
<!-- jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="icon" href="assets/images/logo.png" />

</head>
<body>

	<!-- Header Starts -->
	<div class="navbar-wrapper ">
		<div class="container">
			<div
				class="navbar navbar-inverse navbar-fixed-top animated fadeInDown"
				role="navigation" id="top-nav">
				<div class="container">
					<div class="navbar-header">
						<!-- Logo Starts -->
						<a href="#home" id="logo"><img src="assets/images/logo.png"
							height="80" alt="logo" /></a>
						<!-- #Logo Ends -->

						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target=".navbar-collapse">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
					</div>

					<!-- Nav Starts -->
					<div class="navbar-collapse  collapse">
						<ul class="nav navbar-nav navbar-right">
							<li class="active"><a href="#home">Home</a></li>
							<li><a href="#about">About</a></li>
							<li><a href="#contact">Contact</a></li>
						</ul>
					</div>
					<!-- #Nav Ends -->
				</div>
			</div>
		</div>
	</div>
	<!-- #Header Starts -->

	<!-- overlay -->
	<div class="container overlay">

		<!-- home banner starts -->
		<div id="home" class="homeinfo">
			<div class="row">
				<div class="fronttext">
					<h2 id="MusicThieves" class="animated fadeInUp">Music Thieves</h2>
					<br />
					<h2 id="subtitle" class=" animated fadeInUp">We steal nothing
						, we borrow data !</h2>
				</div>
			</div>
		</div>
		<!-- home banner ends -->

		<!-- blockblack -->
		<div class="blockblack">

			<!-- Search Starts -->
			<div id="search">
				<div class="row">
					<div class="contactform center">
						<h2>Search</h2>
						<div class="row">
							<div class="col-sm-6 col-sm-offset-3">
								<div class="filler"></div>
								<form id="searchForm" action="" method="post" onSubmit="getResults(); return false;">
									<input type="text" id="input" placeholder="Search" name="searchInput" pattern=".{5,}" required title="write 5 letters or more" value=""/>
									<label class="radio-label">in songs<input type="radio" name="option" value="0" checked="checked" required/></label>
									<label class="radio-label">in artists<input type="radio" name="option" value="1" required/></label>
									<label class="radio-label">in lyrics<input type="radio" name="option" value="2" required/></label>
									<input type="submit" id="subButton" class="btn btn-warning bgcolor" value="Send"/>
								</form>
								<div class="filler"></div>
							</div>
						</div>
						<div id="results">
							<!-- searchResults -->
						</div>
					</div>		
				</div>			
			</div>
			<!-- Search Ends -->
		</div>
		<!--blockblack-->

		<div id="about" class="spacer"></div>
		<!-- blockblack -->
		<div class="blockblack" id="blockblack2">
			<!-- About Starts -->
			<div id="ab">
				<div class="row">
					<div class="col-lg-4 col-sm-4  col-xs-12">
						<img src="assets/images/logo.png" class="img-responsive"
							alt="about" />
					</div>
					<div class="col-lg-5 col-sm-8  col-xs-12">
						<h3>
							<span class="glyphicon glyphicon-music"></span> About Music
							Thieves
						</h3>
						<p>Music Thieves is a simple music search engine that combines
							data from different sources to let you find every song and all
							information about them. You can search your favourite songs or
							artist using the options "in songs" or "in artists", but let us
							explain the "un lyrics" option: you hear a song on the radio and
							you like it but you don't know the title or the singer? Just
							focus on remembering some words and search them, Music Thieves
							will find it for you.</p>
						<blockquote>BEH!</blockquote>
						cit. Luca
					</div>
				</div>
			</div>
			<!-- About Ends -->

		</div>
		<!-- blockblack -->

		<div id="contact" class="spacer"></div>
		<!-- blockblack -->
		<div class="blockblack" id="blockblack2">
			<!-- Contact Starts -->
			<div id="contact" class="contactform center">
				<div class="row">
					<div class="col-sm-6 col-sm-offset-3">
						<h3>
							<span class="glyphicon glyphicon-music"></span> Contact Music
							Thieves Developers
						</h3>
						<h4>
							Get in touch, report a bug or<br> <b>Just say Hello!</b><br>
							E-mail: musicthieves@gmail.com
						</h4>
					</div>
				</div>
			</div>
			<!-- Contact Ends -->

		</div>
		<!-- blockblack -->

	</div>
	<!-- overlay -->


	<!-- Footer Starts -->
	<div id="footer">
		<div class="container">
			Copyright Music Thieves 
			<span style="float: right;">
				Developed by 
				<a href="http://www.facebook.com/gianmarco.russo.750">Gianmarco Russo</a> 
				& 
				<a href="https://www.facebook.com/vincenzomario.conte">Vincenzo Conte</a>
			</span>
		</div>
	</div>
	<!-- # Footer Ends -->

	<script src="http://code.jquery.com/jquery-1.7.1.min.js" type="text/javascript"></script>
	<!-- boostrap -->
	<script src="assets/bootstrap/js/bootstrap.js" type="text/javascript"></script>
	<script src="assets/scripts/plugins.js" type="text/javascript"></script>
	<script src="assets/scripts/script.js" type="text/javascript"></script>

	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/fancybox/1.3.4/jquery.fancybox-1.3.4.pack.min.js"></script>
	<script type="text/javascript" src="assets/scripts/imgZoom.js"></script>
	<script>
	function getResults(){
		$.post("/MusicThieves/searchServlet",
			   {
					searchInput:  document.querySelector('#input').value,
					option: document.querySelector('input[name="option"]:checked').value
			    },
			    function(data, status){
			    	$("#results").html(data);
			    });
	}					
	</script>
</body>
</html>
