<%@include file="components/header.jsp" %>
<%@include file="components/navbar.jsp" %>
<div class="row">
	<div class="col-md-4"></div>
	<div class="col-md-4">
		<div class="card">
			<div class="card-header bg-danger">Create Account</div>
			<div class="card-body">

				<table class="table table-borderless">
					<tr>
						<td><input type="text" class="form-control" name="username"
							placeholder="Enter Username" /></td>
					</tr>
					<tr>
						<td><input type="password" class="form-control"
							name="password" placeholder="Enter Password" /></td>
					</tr>
					<tr>
						<td><input type="text" class="form-control" name="firstname"
							placeholder="Enter Firstname" /></td>
					</tr>
					<tr>
						<td><input type="text" class="form-control" name="lastname"
							placeholder="Enter Lastname" /></td>
					</tr>
					<tr>
						<td><input type="submit" class="btn btn-danger"
							value="Create Account" /></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<div class="col-md-4"></div>
</div>
<%@include file="components/footer.jsp" %>ss