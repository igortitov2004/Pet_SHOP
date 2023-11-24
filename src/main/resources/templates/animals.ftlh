<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>SHOP</title>
<#--    <link rel="stylesheet" type="text/css" href="/style/animals.css">-->
    <link rel="stylesheet" type="text/css" href="/style/actionHref.css">
    <link rel="stylesheet" type="text/css" href="/style/actionButton.css">
    <link rel="stylesheet" type="text/css" href="/style/removeButton.css">
    <link rel="stylesheet" type="text/css" href="/style/searchButton.css">
    <link rel="stylesheet" type="text/css" href="/style/table.css">
    <link rel="stylesheet" type="text/css" href="/style/tableJS.js">
    <hr>
    <h3><div class="ref"><a href="/" style="text-align: center; text-decoration: none"> Главная </a></div></h3>
    <hr>
</head>
<body>
<form action="/animals" method="get">
        <input style="margin-left: 10px" type="text" name="kindOfAnimal" placeholder="Поиск по названию"><br><br>
       <div class="search"> <input type="submit" value="Поиск"/></div>
</form>
<hr>

<#if animals?has_content>
    <section style="margin-left: 10px">
        <div class="tbl-header">
            <table cellpadding="0" cellspacing="0" border="0">
                <thead>
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
                </thead>
            </table>
        </div>
        <div class="tbl-content">
            <table cellpadding="0" cellspacing="0" border="0">
                <tbody>
                <#list animals as animal>
                    <tr>
                        <td style="text-align: center">${animal.id_animals}</td>
                        <td>${animal.kindOfAnimal}</td>
                        <td>${animal.breed.breed}</td>
                        <td style="text-align: center">${animal.weight_of_animal}</td>
                        <td style="text-align: center">${animal.ageOfAnimal}</td>

                        <#if user.isManager()>
                            <td style="text-align: center"><form action="/animals/delete/${animal.id_animals}"  method="post" >
                                <input type="hidden" name="_csrf" value="${_csrf.token}">
                                <div class="remove"> <input type="submit" value="Удалить"/></div>
                            </form></td></#if>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </section>
<#else> <h4 style="color:red;">Данное животное не найдено!</h4><br>
</#if>
<br>
<#if user.isManager()>
    <form action="/breed/create" method="get" >
       <div class="action"> <input type="submit" value="Добавить породу"/></div>
</form>
<br>
    <form action="/animals/create" method="get" >
       <div class="action">  <input type="submit" value="Добавить животное"/></div>
    </form>
</#if>

</body>
</html>