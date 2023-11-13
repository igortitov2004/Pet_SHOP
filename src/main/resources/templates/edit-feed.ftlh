<!DOCTYPE html>
<html>
<#import "spring.ftl" as spring />
<head>
    <title>SHOP</title>
</head>
<body>
<h2>Изменение стоимости</h2><hr>
<div>
    Название - ${feeds.nameOfFeed}<br>
    Животное - ${feeds.animal.kindOfAnimal}(${feeds.animal.breed.breed})<br>
    Стоимость - ${feeds.priceOfFeed}<br>
    Вес - ${feeds.weightOfFeed}<br>
    Производитель - ${feeds.manufacturerOfFeed}
</div><hr>
<form action="/feeds/${feeds.id_feeds}/edit" method="post" enctype="multipart/form-data">
    Изменение стоимости:<input type="number" step="0.01" min="0.01" max="300" value="${feeds.priceOfFeed}" required name="priceOfFeed"/><br>
    <#if editFeedErr??>
        <div style="color: red">
            ${editFeedErr}
        </div>
    </#if>
    <br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Применить"/>
</form>
</body>
</html>