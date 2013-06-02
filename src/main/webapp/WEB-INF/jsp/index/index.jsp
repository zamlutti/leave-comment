<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<%@ include file="../header.jsp"%>
<body>
	<header>
		<i class="icon-comment"></i> <span>Comente sobre...</span>
	</header>
	<div class="container">
		<ul class="unstyled">
			<c:forEach items="${errors}" var="error">
				<li class="text-error">${error.message }</li>
			</c:forEach>
		</ul>
		<form class="form-inline" action="${linkTo[IndexController].add}"
			method="post">
			<fieldset>
				<legend>Sobre o que voc&ecirc; deseja comentar?</legend>
				<div class="input-append">
					<input type="text" name="entry.title" placeholder="Tópico" /> <input
						type="submit" class="btn left" value="Comentar" />
				</div>
			</fieldset>
		</form>
	</div>
	<footer>
		<span>&copy; 2013 - Karen Dias Zamlutti.</span>
	</footer>
</body>

</html>