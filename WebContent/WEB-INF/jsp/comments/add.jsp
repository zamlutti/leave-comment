<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="Comente sobre" />
<meta name="author" content="Karen Zamlutti" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/base.css" rel="stylesheet" media="screen">
<title>Comente sobre ${entry.title}</title>
</head>
<body>
	<header>
		<i class="icon-comment"></i>
		<span>Comente sobre...</span>
	</header>
	<div class="container">
		<section>
			<form class="form-horizontal"
				action="${linkTo[CommentsController].save}" method="post">
				<fieldset>
					<legend>Escreva um comentário sobre ${entry.title}</legend>
					<div class="control-group">
						<input id="email" type="email" name="comment.email"
							placeholder="Email" />
					</div>
					<div class="control-group">
						<textarea id="comment" name="comment.text"></textarea>
					</div>
					<input type="hidden" name="comment.entry" value="${entry}" />
					<input type="submit" class="btn" value="Postar" />
				</fieldset>
			</form>
		</section>
		<section>
			<h2>Dizem por aí...</h2>
			<ul>
				<c:forEach var="comment" items="${entry.comments}">
					<li>
						<i class="icon-comment"></i>
						<cite><c:out value="${comment.email}" /></cite>						
						<blockquote>
							<c:out value="${comment.text}" />
						</blockquote>
					</li>
				</c:forEach>
			</ul>

		</section>
	</div>
</body>
</html>