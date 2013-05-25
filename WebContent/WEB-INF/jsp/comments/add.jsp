<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="Comente sobre" />
<meta name="author" content="Karen Zamlutti" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<title>${title}</title>
</head>
<body>
	<header>
		<h1>Comente sobre...</h1>
	</header>
	<div class="container">
		<form action="${linkTo[CommentsController].add}" method="post">
			<fieldset>
				<legend>Escreva um comentário sobre ${title}</legend>
				<input type="email" name="email" placeholder="Email" /> <br>
				<textarea name="comment"></textarea>
				<br> <input type="submit" class="btn" value="Postar">
			</fieldset>
		</form>
	</div>
</body>
</html>