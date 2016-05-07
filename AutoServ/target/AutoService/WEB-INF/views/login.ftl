<#include "main_template.ftl"/>
<@main_template title="Вход"/>
<#macro m_body>
<div class="narrow">


    <div id="right">
        <ul class="breadcrumb-navigation">
            <li><a href="/" title=""><img src="/resources/images/home.png" width="12" height="12"></a></li>
            <li><span>&nbsp;/&nbsp;</span></li>
            <li>Войти</li>
        </ul>
        <div class="both"></div>
        <h1>Войти</h1>
        <#if RequestParameters.error??>
        <p><span class="errortext">Неверный логин или пароль.<br></span></p>
        </#if>
        <div id="pop-form" class="static">
            <div class="container_form">
                <div style="margin-top: 16px;">

                    <form name="form_auth" method="post" target="_top" action="/j_spring_security_check">

                        <div class="registration-block">
                            <span class="input-text">Логин</span>
                            <input class="text" autocomplete="on" type="text" maxlength="255" value="" name="email">
                        </div>
                        <div class="registration-block">
                            <span class="input-text">Пароль</span>
                            <input class="text" autocomplete="on" type="password" maxlength="255" name="password">
                        </div>
                        <input style="margin-left: 111px;" type="checkbox" id="USER_REMEMBER" name="remember-me"
                               value="Y"><label for="USER_REMEMBER">&nbsp;Запомнить меня на этом компьютере</label>
                        <p></p>
                        <div class="block_button">
                            <a href="/registration" class="button_gray_big" rel="nofollow"><b>Регистрация</b></a>
                            <input type="submit" name="Login" value="Войти" class="button_red_big"
                                   style="left: 213px; top: -31px">
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>
</#macro>