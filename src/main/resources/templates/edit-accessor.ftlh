<!DOCTYPE html>
<html>
<head>
    <title>SHOP</title>
</head>
<body>
<h2>Изменение стоимости</h2>
<form action="/accessories/${accessories.id_accessories}/edit" method="post" enctype="multipart/form-data">
    Изменение стоимости:<input type="text" value="${accessories.price_of_accessor}" required name="price_of_accessor"/><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Применить"/>
</form>
</body>
</html>