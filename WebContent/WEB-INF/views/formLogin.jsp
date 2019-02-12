<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/login" var="url"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="${url}" method="POST">
		<label>
			Login: <input type="text" name="login" />
		</label>
		
		<label>
			Senha: <input type="password" name="senha"/>
		</label>
		
		<button>Gravar</button>
	</form>
</body>
</html>