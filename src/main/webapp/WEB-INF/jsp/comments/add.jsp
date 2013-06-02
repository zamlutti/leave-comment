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
		<section>
			<ul class="unstyled">
				<c:forEach items="${errors}" var="error">
					<li class="text-error">${error.message }</li>
				</c:forEach>
			</ul>
			<form class="form-horizontal"
				action="${linkTo[CommentsController].save}" method="post">
				<fieldset>
					<legend>
						Escreva um coment&aacute;rio sobre
						<c:out value="${entry.title}" />
					</legend>
					<div class="control-group">
						<input id="email" type="email" name="comment.email"
							placeholder="Email" />
					</div>
					<div class="control-group">
						<textarea id="comment" name="comment.text"></textarea>
					</div>
					<input type="hidden" name="comment.entry.url" value="${entry.url}" />
					<input type="submit" class="btn" value="Postar" />
				</fieldset>
			</form>
		</section>
		<section>
			<h3>Dizem por a&iacute;...</h3>
			<dl class="dl-horizontal">
				<c:forEach var="comment" items="${entry.comments}">
					<dt>
						<i class="icon-user"></i>
						<c:out value="${comment.email}" />
					</dt>
					<dd>
						<c:out value="${comment.text}" />
					</dd>
				</c:forEach>
			</dl>
		</section>
	</div>
	<footer>
		<span>&copy; 2013 - Karen Dias Zamlutti.</span>
	</footer>
</body>
</html>