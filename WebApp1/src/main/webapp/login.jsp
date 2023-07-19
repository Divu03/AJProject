<%@include file="components/header.jsp" %>
<%@include file="components/navbar.jsp" %>
<div class="row">
	<div class="col-md-4"></div>
	<div class="col-md-4">
		<form action="authenticate" method="post">
			<div class="card">
				<div class="card-header bg-danger">Employee Login</div>
				<div class="card-body">
				
					<span class="errormsg">${ERROR}</span>
					
					<input type="text" class="form-control" name="username"
						placeholder="Username"> <br /> <input type="password"
						class="form-control" name="password" placeholder="Password"><br />
					<input type="submit" class="btn btn-danger fullwidth" value="Login" />
				</div>
			</div>
		</form>
	</div>
	<div class="col-md-4"></div>
</div>
<%@include file="components/footer.jsp" %>