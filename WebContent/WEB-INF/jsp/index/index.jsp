<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Comente sobre</title>
</head>
<body>
	<h1>Sobre o que você deseja comentar?</h1>
	<form action="${linkTo[IndexController].add}" method="post">
	    <input type="text" name="title" />
	    <input type="submit" value="Ir" />
	</form>
</body>
</html>