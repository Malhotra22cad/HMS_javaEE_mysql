<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--google font for sofia-->
    <link href='https://fonts.googleapis.com/css?family=Sofia' rel='stylesheet'>

    <!--bootstrap CDN-->
    <!-- CSS only -->
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

     <!-- JS, Popper.js, and jQuery -->
       <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
       <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
       <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
   <!---->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Hospital Management</title>
		<link rel = "stylesheet" href = "CSS/styles.css" type = "text/css" />
        
		
       
 </head>
 <style>
 body{
 background-color: #000;
	/* height: 100vh;
	background-image: linear-gradient(rgba(0,0,0,0.2),rgba(0,0,0,0.4)),url(Images/bg5.jpg);
	background-position: center;
	background-size: cover;
	overflow-x: hidden;
	position: relative; */	
	}
	.btn{
	padding: 12px 20px;
	border: 0;
	background: #AF002A;
	font-weight: bold;
	cursor: pointer;
	width: 100%;
	font-weight: bold;
	}
	
	.btn1{
	padding: 12px 20px;
	border: 0;
	color: #fff;
	background: #AF002A;
	font-weight: bold;
	cursor: pointer;
	width: 30%;
	font-weight: bold;
	}
	.btn2{
	padding: 12px 20px;
	border: 0;
	color: #fff;
	background: #AF002A;
	font-weight: bold;
	cursor: pointer;
	width: 30%;
	font-weight: bold;}
	
	.btn:hover, .btn1:hover, .btn2:hover
	{
	border: none;
	outline: none;
	cursor: pointer;
	background: #ffff;
	color: #000;
	font-weight: bold;
	
}
</style>
 <body>
 
<div class="row">  
	
  <div class="col-md-12">
  <nav class="navbar" style="background-color:#AF002A; background-position: center;
	background-size: cover;
	overflow-x: hidden;
	position: relative;">
 <br>
<br>
 
</nav>
</div>
</div>
  <div class="container">
 <br>
 
 <div class="jumbotron jumbotron-fluid" style="background-image: linear-gradient(rgba(0,0,0,0.2),rgba(0,0,0,0.4)),url(Images/hospital2.jpeg);background-position: center;
	background-size: cover;
	overflow-x: hidden;
	position: relative;">
  <div class="container">
    		<center>
		  	<h1 class="display-4" style="font-family: Times New Roman, Times, serif; color: #AF002A; font-weight: bold; background-size: cover;; background-color:#fff;" ><b> Hospital Management System </b></h1>
		  	<h4 class="lead" style="color:#AF002A; background-color: #fff;font-weight: bold;"><b>CRUD Based on JAVA EE and MYSQL</b></h4>
		</center>
  </div>
</div>


<br><center><a href="index.html"><button class="btn1" href="index.jsp" >Back To Home</button></a></center><br>
<br>
<center>
    
 <form action="save" name="" method="post" style="background-image: linear-gradient(rgba(0,0,0,0.2),rgba(0,0,0,0.4)),url(Images/up1.jpg);background-position: center;
	background-size: cover;
	overflow-x: hidden;
	position: relative;">
  <br>
<center><h2 class="card-title" style="font-weight: bold;color: #AF002A; font-size:30px; background-color:#fff">UPDATE PATIENT!!</h2>
<br>
	<label style="padding: 12px 12px 12px 0;display: inline-block; font-weight: bold;color: #AF002A;font-size:25px;">Patient Id<input style="width: 100%; padding: 12px;border: 1px solid #ccc; border-radius: 4px; resize: vertical;" type="number" value="<%=request.getAttribute("patient_id")%>" name="patient_id" readonly></label>
	 
	<br>
	<label style="padding: 12px 12px 12px 0;display: inline-block; font-weight: bold;color: #AF002A; font-size:25px;">First Name<input style="width: 100%; padding: 12px;border: 1px solid #ccc; border-radius: 4px; resize: vertical;" type="text" value="<%=request.getAttribute("first_name")%>" name="first_name" ></label>
	<br>
	<label style="padding: 12px 12px 12px 0;display: inline-block; font-weight: bold;color: #AF002A; font-size:25px;">Room<input style="width: 110%; padding: 12px;border: 1px solid #ccc; border-radius: 4px; resize: vertical;" type="number"  value="<%=request.getAttribute("room_no")%>" name="room_no" required></label>
	<br>
	<label style="padding: 12px 12px 12px 0;display: inline-block; font-weight: bold;color: #AF002A; font-size:25px;">Last Name<input style="width: 95%; padding: 12px;border: 1px solid #ccc; border-radius: 4px; resize: vertical;" type="text"  value="<%=request.getAttribute("last_name")%>" name="last_name" required></label>
	<br> 
	<label style="padding: 12px 12px 12px 0;display: inline-block; font-weight: bold;color: #AF002A; font-size:25px;">Phone Number<input style="width: 100%; padding: 12px;border: 1px solid #ccc; border-radius: 4px; resize: vertical;" type="text" value="<%=request.getAttribute("phone_number")%>"  name="phone_number" required></label>
  <br>
	<label style="padding: 12px 12px 12px 0;display: inline-block; font-weight: bold;color: #AF002A; font-size:25px;">Street Address<input style="width: 100%; padding: 12px;border: 1px solid #ccc; border-radius: 4px; resize: vertical;" type="text"  value="<%=request.getAttribute("street")%>" name="street" required></label>
  <br>
	<label style="padding: 12px 12px 12px 0;display: inline-block; font-weight: bold;color: #AF002A; font-size:25px;">City<input style="width: 100%; padding: 12px;border: 1px solid #ccc; border-radius: 4px; resize: vertical;" type="text"  value="<%=request.getAttribute("city")%>"  name="city" required></label>
	<br>
	<label style="padding: 12px 12px 12px 0;display: inline-block; font-weight: bold;color: #AF002A; font-size:25px;">Email<input style="width: 100%; padding: 12px;border: 1px solid #ccc; border-radius: 4px; resize: vertical;" type="email" value="<%=request.getAttribute("email_add")%>"  name="email_add" required></label>
	<br><br>
  <!-- <label>Department
  <input type="text" value="<%=request.getAttribute("dept")%>"  name="dept" readonly></label>
					<!-- <select class="form-control" name="dept" required>
										<option selected="selected" disabled >none</option>
										<option vaue="Dental">Dental</option>
										<option value="Cardio">Cardio</option>
										<option value="opd">O.P.D</option>
										<option value="Physiology">Physiology</option>
										<option value="Surgery">Surgery</option>
										<option value="Artho">Artho</option>
									</select></label>
			<br> -->
			<br>
				<input type="submit" class="btn2" value="Save">
				<br>
				<br>
  
  
  </form>
  </center>
  <br><br>
</body>
</html>