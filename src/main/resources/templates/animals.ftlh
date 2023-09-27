<!DOCTYPE html>
<html>
<head>
    <title>SHOP</title>
    <link rel="stylesheet" type="text/css" href="/style/animals.css">
    <hr>
    <h3><a href="/" style="text-align: center; text-decoration: none"> Главная </a></h3>
    <hr>

</head>
<body>
<form action="/animals" method="get">
    <div style="display:inline-flex">Поиск по названию животного:<input type="text" name="kindOfAnimal">
        <input type="submit" value="Поиск"/></div>
</form>
<br>
<#if animals?has_content>
    <table border="1">
    <tr>
        <th> ID животного </th>
        <th> Вид </th>
        <th> Порода </th>
        <th> Масса(кг) </th>
        <th> Возраст </th>
        <#if user.isManager()>
        <th> Удаление </th>
        </#if>
    </tr>
    <#list animals as animal>
            <tr>
                <th>${animal.id_animals}</th>
                <th>${animal.kindOfAnimal}</th>
                <th>${animal.breed_id.breed}</th>
                <th>${animal.weight_of_animal}</th>
                <th>${animal.age_of_animal}</th>

                <#if user.isManager()>
                <th><form action="/animals/delete/${animal.id_animals}"  method="post" >
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <input type="submit" value="Удалить"/>
                    </form></th></#if>
            </tr>
    </#list>
</table>
    <#else> Данное животное не найдено!
</#if>
<br>
<#if user.isManager()>
    <form action="/breed/create" method="post" enctype="multipart/form-data">
    <div style="display: inline-flex">Название породы:<input type="text" required name="breed"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Добавить породу"/></div>
</form>
<br>
<form action="/animals/create" method="post" enctype="multipart/form-data">
       Название:<input type="text" required name="kindOfAnimal"/><br><br>
       Порода:  <select name="breed_id" required>
           <option disabled SELECTED>Выберите<option>
               <#list breeds as breed>
           <option value="${breed.id_breeds}"> ${breed.breed}</option>
           </#list>
       </select><br><br>
       Вес:     <input type="text" required name="weight_of_animal"/><br><br>
       Возраст: <input type="number"  required name="age_of_animal"/><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
       <input type="submit" value="Добавить животное"/>
</form>
</#if>

</body>
</html>