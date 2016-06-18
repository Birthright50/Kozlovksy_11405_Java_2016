<#include "main_template.ftl"/>
<@main_template title="Регистрация"/>
<#macro m_body>

<!--suppress ALL -->
<div id="content"><!--Контент-->


    <div class="narrow">


        <div id="right"><!--Правая колонка-->

            <div class="both"></div>
            <h1>Регистрация</h1>
            <div id="pop-form">
                <div class="container_form">
                    <div class="bx-auth">
                        <form method="post" action="/registration"
                              name="bform" id="pop_form_this">
                            <p hidden id="error_naq" class="errortext">
                                <br>
                            </p>

                            <div class="registration-block">
                                <span class="input_text">E-Mail:<span class="starrequired"> *</span> </span> <input
                                    id="email" class="text" type="email" maxlength="50" value=""
                                    name="email" autocomplete="on"> <span id="validEmail"
                                                                                style="background-image: none"></span>
                            </div>
                            <div class="registration-block">
                                <span class="input_text">Пароль:<span class="starrequired"> *</span> </span> <input
                                    id="password"
                                    class="text" type="password" maxlength="50" value="" name="password"
                                    autocomplete="on">
                            </div>
                            <div class="registration-block">
                                <span class="input_text">Подтверждение пароля:<span
                                        class="starrequired"> *</span> </span>
                                <input id="confirm_password" class="text" type="password" maxlength="50" value=""
                                       name="USER_CONFIRM_PASSWORD" autocomplete="on">
                                Пароль должен быть не менее 6 символов длиной.
                            </div>
                            <div class="registration-block">
                                <span class="input_text">Имя: </span> <input id="name" class="text" type="text"
                                                                             maxlength="50"
                                                                             value="" name="name"
                                                                             autocomplete="on">
                            </div>
                            <div class="registration-block">
                                <span class="input_text">Фамилия: </span>
                                <input id="lastname" class="text" type="text" maxlength="50" value=""
                                       name="lastname"
                                       autocomplete="on">
                            </div>

                            <div class="block_button">
                                <a href="/login"
                                   class="button_gray_big" rel="nofollow"><b>Авторизоваться </b> </a>
                                <input
                                        type="submit" onclick="return registration()" name="z"
                                        value="Зарегистрироваться"
                                        class="button_red_big"
                                        style="left: 213px; top: -31px">
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    function registration() {
        var email = $('#email');
        var password = $('#password');
        var confirm = $('#confirm_password');
        var name = $('#name');
        var last_name = $('#lastname');
        var error = $('#error_naq');
        var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        if (!(re.test(email.val()))) {
            error.show();
            error.text("Невалидный e-mail");
            return false;
        }
        if (password.val().length < 6) {
            error.show();
            error.text("Пароль не должен быть меньше 6 символов");
            return false;
        }
        if (password.val() != confirm.val()) {
            error.show();
            error.text("Пароли не совпадают");
            return false;
        }
        if (name.val().length == 0 || last_name.val().length == 0) {
            error.show();
            error.text("Введите имя/фамилию");
            return false;
        }
        var flag = false;
        $.ajax({
            type: "GET",
            url: "/check_email",
            dataType: 'json',
            contentType: 'application/json',
            mimeType: 'application/json',
            async: false,
            data: ({
                email: email.val()
            }),
            success: function (data) {
                if (data.text == "ok") {
                    flag = true;
                }
                else{
                    error.show();
                    error.text("Данный email занят")
                }
            }

        });
        return flag;
    }
</script>
</#macro>