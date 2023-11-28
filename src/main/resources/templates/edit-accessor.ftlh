<!DOCTYPE html>
<html>
<head>
    <title>SHOP</title>
    <link rel="stylesheet" type="text/css" href="/style/actionHref.css">
    <link rel="stylesheet" type="text/css" href="/style/actionButton.css">
    <hr>
    <h3><div class="ref"><a href="/accessories" style="text-decoration: none">Назад</a></div> </h3>
    <hr>
</head>
<body>
<h3 style="margin-left: 10px">Изменение стоимости</h3>
<hr>
<div style="margin-left: 10px">
    Название - ${accessories.nameOfAccessor}<br>
    Производитель - ${accessories.manufacturerOfAccessor}<br>
    Стоимость - ${accessories.priceOfAccessor} BYN<br>
    Животное - <#if accessories.animal??>
        ${accessories.animal.kindOfAnimal}(${accessories.animal.breed.breed})
    <#else> Животное удалено!
    </#if><br>
</div><hr>
<form action="/accessories/${accessories.id_accessories}/edit" method="post" enctype="multipart/form-data">
    <label for="a" style="margin-left: 10px">Изменение стоимости:</label>
    <input type="number" step="0.01" id="a" min="0.01" max="500" value="${accessories.priceOfAccessor}" required name="priceOfAccessor"/><br>
    <br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <div class="action"><input type="submit" value="Применить"/></div>
</form>
</body>
</html>