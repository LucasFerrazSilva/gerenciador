<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nova Empresa</title>
</head>
<body>
	<c:import url="logoutParcial.jsp"></c:import>

	<form action="${linkServletNovaEmpresa}" method="POST">
		<label>
			Nome: <input type="text" name="nome" />
		</label>
		
		<label>
			Data de abertura: <input type="text" name="dataAbertura"/>
		</label>
		
		<button>Gravar</button>
	</form>
</body>
</html>