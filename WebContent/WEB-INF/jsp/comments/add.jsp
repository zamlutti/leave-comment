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
			<ul>
				<c:forEach var="comment" items="${entry.comments}">
					<li><i class="icon-user"></i><b><c:out value="${comment.email}" /></b>:
						<blockquote>
							<c:out value="${comment.text}" />
						</blockquote></li>
				</c:forEach>
			</ul>

		</section>
	</div>
	<footer>
        <span>&copy; 2013 - Karen Dias Zamlutti.</span>
	</footer>
</body>
</html>