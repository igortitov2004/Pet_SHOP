<!DOCTYPE html>
<html>
<head>
    <title>SHOP</title>
    <hr>
    <h3><a href="/accessories" style="text-decoration: none">Назад</a></h3>
    <hr>
</head>
<body>
<h3>Изменение стоимости</h3>
<hr>
<div>
    Название - ${accessories.nameOfAccessor}<br>
    Производитель - ${accessories.manufacturerOfAccessor}<br>
    Стоимость - ${accessories.priceOfAccessor}<br>
    Животное - <#if accessories.animal??>
        ${accessories.animal.kindOfAnimal}(${accessories.animal.breed.breed})
    <#else> Животное удалено!
    </#if><br>
</div><hr>
<form action="/accessories/${accessories.id_accessories}/edit" method="post" enctype="multipart/form-data">
    Изменение стоимости:<input type="number" step="0.01" min="0.01" max="500" value="${accessories.priceOfAccessor}" required name="priceOfAccessor"/><br>
    <#if editAccessorErr??>
        <div style="color: red">
            ${editAccessorErr}
        </div>
    </#if>
    <br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Применить"/>
</form>
</body>
</html>