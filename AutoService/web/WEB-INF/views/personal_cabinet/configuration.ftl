<#include "../main_template.ftl"/>
<@main_template title="Личный кабинет"/>
<#macro m_body>
<div class="narrow">
    <div id="left"><!--Левая колонка-->
        <!--Левое меню-->
        <div id="left-menu"><!--Левое меню-->
            <ul class="left-menu-list">
                <li>
                    <div><a href="/personal_cabinet/my-auto">Обслуживание</a></div>
                <li>
                    <div><a href="/personal_cabinet/basket/">Моя корзина</a></div>
                </li>
                <li>
                    <div><a href="/personal_cabinet/orders/">Мои заказы</a></div>
                </li>
                <li>
                    <div><a href="/personal_cabinet/configuration">Мои настройки</a></div>
                </li>
            </ul>
        </div><!--/Левое меню-->
        <!--/Левое меню-->
        <!--Специиальные предложения -->

        <!--Новости -->

        <!--Как добраться-->
        <p></p>
        <h3 class="up_case"><a>Как добраться</a></h3>
        <div class="banner address">
            <div class="head_banner"></div>
            <p>
                299002, г. Севастополь, ул. Живописная 17
            </p>
            <p>
                125047, г. Москва, ул. Пушкина, дом 21.
            </p>

            <div class="foot_banner"></div>
            <div class="compas"></div>
        </div>
        <p></p>
    </div><!--/Левая колонка-->
    <div id="right"><!--Правая колонка-->
        <ul class="breadcrumb-navigation">
            <li><a href="/" title=""><img src="/resources/images/home.png" width="12" height="12"></a></li>
            <li><span>&nbsp;/&nbsp;</span></li>
            <li><a href="/personal_cabinet" title="Личный кабинет">Личный кабинет</a></li>
            <li><span>&nbsp;/&nbsp;</span></li>
            <li>Мои настройки</li>
        </ul>
        <div class="both"></div>
        <h1>Мои настройки</h1>
        <div class="bx-auth-profile">
            <#if RequestParameters.success??>
                <p style="color: green"><span class="notetext">Изменения сохранены</span></p>
            </#if>
            <p hidden id="error_naq" class="errortext">
                <br>
            </p>
            <#if RequestParameters.error??>
                <p style="color: red"><span class="errortext">Старый пароль введен неверно<br><br></span></p>
            </#if>
            <form method="post" name="form1" action="/personal_cabinet/configuration">
                <!-- начало новой верстки -->
                <div class="my_settings">
                    <div class="tab-section-container">
                        <div class="tab-boby-container products">
                            <div class="container">
                                <div id="tab-about-body" class="tab_body active">
                                    <div class="line_block">
                                        <span class="input_text">Фамилия:<span class="starrequired">*</span></span>
                                        <input id="LAST_NAME" type="text" name="LAST_NAME" maxlength="50"
                                               value="<@security.authentication property="principal.userInfo.lastname"/>"
                                               class="text">
                                    </div>
                                    <div class="line_block">
                                        <span class="input_text">Имя:<span class="starrequired">*</span></span>
                                        <input id="NAME" type="text" name="NAME" maxlength="50"
                                               value="<@security.authentication property="principal.userInfo.name"/>" class="text">
                                    </div>
                                    <div class="line_block">
                                        <span class="input_text">Отчество:</span>
                                        <input id="SECOND_NAME" type="text" name="SECOND_NAME" maxlength="50"
                                               value="<@security.authentication property="principal.userInfo.secondName"/>" class="text">
                                    </div>
                                    <div class="line_block">
                                        <span class="input_text">Телефон:</span>
                                        <input id="PERSONAL_PHONE" type="text" name="PERSONAL_PHONE" maxlength="255"
                                               value="<@security.authentication property="principal.userInfo.telephone"/>" class="text">
                                    </div>
                                    <div class="line_block">
                                        <span class="input_text">Ваше авто:</span>
                                        <input id="AUTO" type="text" name="AUTO" maxlength="255"
                                               value="<@security.authentication property="principal.userInfo.automobile"/>" class="text">
                                    </div>

                                    <div class="line_block">
                                        <span class="input_text">Эл. почта:<span class="starrequired">*</span></span>
                                        <input type="email" disabled name="EMAIL" maxlength="50"
                                               value="<@security.authentication property="principal.userInfo.email"/>"
                                               class="text">
                                    </div>
                                    <div class="line_block">
                                        <span class="input_text">Старый пароль</span>
                                        <input id="OLD_PASSWORD" type="password" name="OLD_PASSWORD" maxlength="50"
                                               value=""
                                               autocomplete="off" class="bx-auth-input">
                                    </div>
                                    <div class="line_block">
                                        <span class="input_text">Новый пароль:</span>
                                        <input id="NEW_PASSWORD" type="password" name="NEW_PASSWORD" maxlength="50"
                                               value=""
                                               autocomplete="off" class="bx-auth-input">
                                    </div>
                                    <div class="line_block">
                                        <span class="input_text">Подтверждение пароля:</span>
                                        <input id="NEW_PASSWORD_CONFIRM" type="password" name="NEW_PASSWORD_CONFIRM"
                                               maxlength="50" value=""
                                               autocomplete="off" class="text">
                                    </div>
                                </div>

                                <div class="bottom_container"><span class="notice"><span class="starrequired">*</span> — поля, обязательные для заполнения</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div style="margin-right: 40%" class="block_button">
                        <input type="submit" name="save" class="button_red_big" value="Сохранить изменения"
                               onclick="return refresh()">

                    </div>
                </div>
                <!-- конец новой верстки -->
            </form>
        </div>
    </div>
</div>
<script type="text/javascript">
    function refresh() {
        var LAST_NAME = $('#LAST_NAME');
        var NAME = $('#NAME');
        var SECOND_NAME = $('#SECOND_NAME');
        var PERSONAL_PHONE = $('#PERSONAL_PHONE');
        var OLD_PASSWORD = $('#OLD_PASSWORD');
        var NEW_PASSWORD = $('#NEW_PASSWORD');
        var AUTO = $('#AUTO');
        var error = $('#error_naq');

        var NEW_PASSWORD_CONFIRM = $('#NEW_PASSWORD_CONFIRM');
        if (LAST_NAME.val().length == 0 || NAME.val().length == 0) {
            error.show();
            error.text("Заполните все обязательные поля");
            return false;
        }
        if (OLD_PASSWORD.val().length != 0) {
            if (NEW_PASSWORD.val() == NEW_PASSWORD_CONFIRM.val()) {
                return true;
            }
            else {
                error.show();
                error.text("Подтверждение пароля неверно");
                return false;
            }
        }
        else {
            if (NEW_PASSWORD.val().length != 0 || NEW_PASSWORD_CONFIRM.val().length != 0) {
                error.show();
                error.text("Введите старый пароль");
                return false;
            }
        }
        return true;
    }
</script>
</#macro>