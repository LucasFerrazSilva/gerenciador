<%@ page import="java.util.List, br.com.ferraz.gerenciador.model.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<body>
	
	Usuário logado: ${usuarioLogado.login} <a href="/gerenciador/sair">Sair</a>
	
	<br />
	<br />

	<h3>Lista de empresas</h3>	
	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<li>
				${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
				<a href="mostraEmpresa?id=${empresa.id}">edita</a>
				<a href="removeEmpresa?id=${empresa.id}">remove</a>
			</li>
		</c:forEach>
	</ul>
	
	<a href="formNovaEmpresa">Nova Empresa</a>
</body>
</html>