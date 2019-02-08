<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/editaEmpresa" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${linkServletNovaEmpresa}" method="POST">
		<input type="hidden" name="id" value="${empresa.id}" />
		
		<label>
			Nome: <input type="text" name="nome" value="${empresa.nome}"/>
		</label>
		
		<label>
			Data de abertura: <input type="text" name="dataAbertura" value='<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>'/>
		</label>
		
		<button>Gravar</button>
	</form>
</body>
</html>