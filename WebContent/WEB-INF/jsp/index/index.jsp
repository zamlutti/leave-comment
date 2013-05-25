<!DOCTYPE html>
<html>
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="Comente sobre" />
<meta name="author" content="Karen Zamlutti" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<title>Comente sobre</title>
</head>
<body>
	<header>
		<h1>Comente sobre...</h1>
	</header>
	<div class="container">
		<form action="${linkTo[IndexController].add}" method="post">
			<fieldset>
				<legend>Sobre o que você deseja comentar?</legend>
				<input type="text" name="title" placeholder="Tópico" /> 
				<br>
				<input type="submit" class="btn"
					value="Comentar" />
			</fieldset>
		</form>
	</div>
</body>
</html>