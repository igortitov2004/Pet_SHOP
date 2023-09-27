<!DOCTYPE html>
<html>
<head>
    <title>SHOP</title>
</head>
<body>
<form action="/staff/${staff.id_staff}" method="get">
    <input type="submit" value="Назад"/>
</form>
<h3>Изменение данных работника</h3>
<hr>
<form action="/staff/${staff.id_staff}/edit" method="post" enctype="multipart/form-data">
    <div>ФИО:<input type="text" value="${staff.fullName}" required name="fullName"/><br><br>
        Номер паспорта:<input type="text" value="${staff.num_of_passport}" required name="num_of_passport"/><br><br>
        Номер телефона:<input type="text" value="${staff.telNumber}" required name="telNumber"/><br><br>
        Стаж работы:<input type="number" value="${staff.experience}" required name="experience" min="${staff.experience}"  max="50"/><br><br>
        Должность:
        <select name="job_title" required >
            <option value="${staff.job_title}" >${staff.job_title}</option>
                <option value="Менеджер"> Менеджер</option>
                <option value="Продавец-кассир"> Продавец-кассир</option>
        </select><br><br></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Применить"/>
</form>
</body>
</html>