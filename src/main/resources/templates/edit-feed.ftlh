<!DOCTYPE html>
<html>
<head>
    <title>SHOP</title>
</head>
<body>
<h2>Изменение стоимости</h2>
<form action="/feeds/${feeds.id_feeds}/edit" method="post" enctype="multipart/form-data">
    Изменение стоимости:<input type="text" value="${feeds.price_of_feed}" required name="price_of_feed"/><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Применить"/>
</form>
</body>
</html>