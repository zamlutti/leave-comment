<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title}</title>
</head>
<body>
    <h1>Escrever comentário sobre ${title}</h1>
    <form action="${linkTo[CommentsController].save}" method="post">
        <input type="email" name="email" placeholder="Email" />
        <br>
        <textarea name="comment"></textarea>
        <br>
        <input type="submit" value="Postar">
    </form>
</body>
</html>