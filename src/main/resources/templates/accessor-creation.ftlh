<!DOCTYPE html>
<html>
<#import "spring.ftl" as spring />
<head>
    <title>SHOP</title>
    <hr>
    <h3><a href="/accessories" style="text-decoration: none">Назад</a></h3>
    <hr>
</head>
<body>
<h3>Добавление аксессуара</h3>
<hr>
<form action="/accessories/create" method="post" enctype="multipart/form-data">
    Название:<input type="text"  required name="nameOfAccessor"/><br>
    <#if accessorErr??>
        <div style="color: red">
            <@spring.bind "newAccessor.nameOfAccessor"/>
            <@spring.showErrors "<br>"/>
        </div>
    </#if>
    <br>
    Животное:<select name="animal" required>
        <#list animals as animal>
        <option value="${animal.id_animals}"> ${animal.kindOfAnimal}: ${animal.breed.breed}</option>
        </#list>
    </select><br><br>
    Стоимость:<input type="number" step="0.01" min="0.01" max="300" required name="priceOfAccessor"/><br><br>
    Производитель:<input type="text"  required name="manufacturerOfAccessor"/><br>
    <#if accessorErr??>
        <div style="color: red">
            <@spring.bind "newAccessor.manufacturerOfAccessor"/>
            <@spring.showErrors "<br>"/>
        </div>
    </#if>
    <br>
    <input type="hidden" value="0" name="amount_of_accessories"/>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Добавить аксессуар"/>
</form>
</body>
</html>