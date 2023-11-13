<!DOCTYPE html>
<html>
<head>
    <title>SHOP</title>
</head>
<body>
<h2>Изменение стоимости</h2>
<div>
    Название - ${accessories.nameOfAccessor}<br>
    Производитель - ${accessories.manufacturerOfAccessor}<br>
    Стоимость - ${accessories.priceOfAccessor}<br>
    Животное - ${accessories.animal.kindOfAnimal}(${accessories.animal.breed.breed})<br>
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