<#macro main_template title="Автосервис">
    <#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <meta name="description"
          content="Готовый Интернет-сайт для автосервиса с личным кабинетом для клиентов. История обслуживания автомобилей"/>
    <link href="/resources/ccs/kernel_main0.css.css"
          type="text/css" rel="stylesheet"/>
    <link href="/resources/ccs/page.css"
          type="text/css" rel="stylesheet"/>
    <link href="/resources/ccs/popup.min.css"
          type="text/css"
          rel="stylesheet"/>
    <link href="/resources/ccs/default.css"
          type="text/css" rel="stylesheet"/>
    <link href="/resources/ccs/template_two.css"
          type="text/css" data-template-style="true" rel="stylesheet"/>
    <link href="/resources/ccs/template_one.css"
          type="text/css" data-template-style="true" rel="stylesheet"/>
    <link href="/resources/ccs/custom.css"
          type="text/css" data-template-style="true" rel="stylesheet"/>
    <link href="/resources/ccs/custom2.css"
          type="text/css" data-template-style="true" rel="stylesheet"/>

    <title>${title}</title>
</head>
<body>
<div class="main-page" id="wrap"><!--Оболочка-->
    <div id="header"> <!--Хедер-->
        <div id="logo">
            <a href="/">Автосервис</a>
            <div id="slogan">
                Мы следим за качеством обслуживания!
            </div>
        </div>
        <!--'start_frame_cache_manage_auth_form'-->

        <!--'end_frame_cache_manage_auth_form'-->


        <@security.authorize access="isAnonymous()">
            <div class="manage">
                Управляйте обслуживанием своего автомобиля. Заказывайте ТО для своего автомобиля онлайн. Следите за
                историей
                заказов.<br/>
                <a href="#" class="button_red_smaller enter_button">Вход</a>
                <a href="/registration"
                   class="button_gray_small registration">Регистрация</a>
            </div>
            <div class="user-info">
                <!--'end_frame_cache_my_auto_auth'-->
                <div class="pop_block">
                    <!--'start_frame_cache_auth_form'-->
                    <div class="spacer_block">
                        <div class="bx-system-auth-form">
                            <form id="sys_auth_from" name="login_form" method="post" target="_top"
                                  action="/j_spring_security_check">
                                <input type="text" name="email" maxlength="50" class="text" placeholder="Email"
                                       size="17"/>
                                <input type="password" name="password" maxlength="50" size="17" class="text"
                                       placeholder="Пароль"
                                />
                                <p class="remember-enter">
                                    <input type="checkbox" checked="checked" id="USER_REMEMBER_frm" name="remember-me"
                                           title="Запомнить" class="check"/>
                                    <label class="remember">Запомнить меня</label>
                                    <input class="button_red_smaller" type="submit" name="Login" value="Войти"/>
                                </p>

                                <a rel="nofollow" class="registration"
                                   href="/registration"
                                >Регистрация</a>
                            </form>
                        </div>
                    </div>
                    <div class="bottom_part">
                        <div class="arrow_link"></div>
                    </div>
                    <!--'end_frame_cache_auth_form'-->    <!--'start_frame_cache_personal_form'-->
                    <!--'end_frame_cache_personal_form'--></div>
            </div>
        </@security.authorize>

        <@security.authorize access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
            <div class="user-info">
                <div class="pop_block">
                    <div id="bxdynamic_auth_form"></div>
                    <div id="bxdynamic_personal_form">
                        <div class="spacer_block auth">
                            <div class="login"><a
                                    href="/personal_cabinet"><@security.authentication property="principal.username"/></a>
                            </div>
                            <div class="exit"><a href="/j_spring_security_logout">Выйти</a></div>
                            <div class="clear"></div>
                            <@security.authorize access="hasRole('ROLE_USER')">
                                <div class="status not_serviced">
                                    Не обслуживался
                                </div>
                                <div class="calendar">Плановое ТО: <a href="#">не запланировано</a></div>
                                <a onclick="showPopUp()"
                                   class="button_red_middle sing_up ">Записаться на ремонт / ТО
                                </a>
                            </@security.authorize>
                            <@security.authorize access="hasRole('ROLE_ADMIN')">
                                <br>
                                <a href="/admin"
                                   class="button_red_middle sing_up">Поступившие заявки</a>
                            </@security.authorize>

                        </div>

                    </div>
                </div>
            </div>
        </@security.authorize>

        <div id="contact_top"><!--Контакты в хедере-->
            <div class="link_city">
                <span city="sevastopol" class="current" id="city_current"><var>Севастополь</var><span
                        class="arrow"></span></span>
                <div class="city" style="display: none;">
                    <ul class="list_city">
                        <li city="moskva">Москва</li>
                    </ul>
                </div>
            </div>
            <div class="contacts" id="contacts">
                <div class="contact_city active" city="sevastopol">
                    <!-- Название -->
                    <!-- Дата -->
                    <!-- Превью -->
                    <p class="time">Время работы: будни 9:00 – 18:00</p>
                    <p class="phone"> +7 (978) 000-00-00 </p>
                    <a class="email" href="mailto:sevastopol@autoservice.ru">sevastopol@autoservice.ru</a><br>
                </div>
                <div class="contact_city" city="moskva">
                    <!-- Название -->
                    <!-- Дата -->
                    <!-- Превью -->
                    <p class="time">Время работы: будни 10:00 - 19:00</p>
                    <p class="phone">8(800)555-35-35</p>
                    <a class="email" href="mailto:moscow@autoservice.ru">moscow@autoservice.ru</a><br>
                    <span id="icq">666-666-666</span>
                </div>
            </div>
        </div>
    </div> <!--/Хедер--->
    <div id="content"><!--Контент-->
        <div class="narrow">
            <div class="menu-search"><!--Верхнее меню-->
                <ul class="menu">
                    <li>
                        <@security.authorize access="hasRole('ROLE_ADMIN')">
                        <a href="/admin">
                        </@security.authorize>
                        <@security.authorize access="!hasRole('ROLE_ADMIN')">
                        <a href="/personal_cabinet">
                        </@security.authorize>
                        <nobr>Личный кабинет</nobr>
                    </a>
                        <@security.authorize access="!hasRole('ROLE_ADMIN')">
                            <div class="dropdown">
                                <ul>
                                    <li class="top_level"><a
                                            href="/personal_cabinet/basket"
                                    >Моя корзина</a>
                                    </li>
                                </ul>
                            </div>
                        </@security.authorize>
                    </li>
                    <li>
                        <a href="/services"
                        >
                            <nobr>Сервис</nobr>
                        </a>
                        <div class="dropdown">
                            <ul>
                                <li class="top_level"><a
                                        href="/services/to">Плановое
                                    ТО</a></li>
                                <li class="top_level"><a
                                        href="/services/repair">Ремонт
                                    автомобилей</a></li>

                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="/shop"
                        >
                            <nobr>Запчасти</nobr>
                        </a>
                    <li>
                        <a href="/information"
                        >
                            <nobr>Информация</nobr>
                        </a>
                        <div class="dropdown">
                            <ul>
                                <li class="top_level"><a
                                        href="/information/news">Новости</a></li>
                                <li class="top_level"><a
                                        href="/information/articles"
                                >Статьи</a></li>
                                <li class="top_level"><a
                                        href="/information/spec"
                                >Спецпредложения</a>
                                </li>
                            </ul>
                        </div>
                    </li><li ><a href="/contacts"><nobr>Контакты</nobr></a>

                </li>

                </ul>
                <div class="menu-clear-left"></div>
                <i class="ls"></i><i class="rs"></i>
            </div><!--/Верхнее меню-->
        </div>
        <@m_body/>
    </div>
    <div id="spacer"></div>
    <div id="footer"><!--Футер-->
        <div class="narrow inner_block with_corner footer">
            <ul class="menu_footer">
                <@security.authorize access="hasRole('ROLE_ADMIN')">
                    <li><a href="/admin" class="root-item">Личный кабинет</a></li>
                </@security.authorize>
                <@security.authorize access="!hasRole('ROLE_ADMIN')">
                    <li><a href="/personal_cabinet" class="root-item">Личный кабинет</a></li>
                </@security.authorize>
                <li>
                    <a href="/services"
                       class="root-item">Сервис</a></li>
                <li>
                    <a href="/shop"
                       class="root-item">Запчасти</a></li>
                <li>
                    <a href="/information"
                       class="root-item">Информация</a></li>
            </ul>
            <div class="menu-clear-left"></div>
        </div><!--/Футер--->
    </div><!--/Оболочка-->
</div>

<div id="fade-box" style="opacity: 0.7; display: none;"></div>
    <@security.authorize access="hasRole('ROLE_USER')">
    <form action="/personal_cabinet/claim" method="post" id="pop-form-form"
          style="position: absolute; display: none; top: 114px; left: 50%; margin-left: -240px;">
        <!-- Всплывающая форма -->
        <div id="pop-form">

            <!-- Заголовок -->
            <div class="head_form">
                Записаться на ремонт или ТО                <!-- Закрытие формы -->
                <div onclick="close_form()" id="close_form"></div>
            </div>
            <div class="line_block">
            <p align="center"  id="error_naq" class="errortext">
              <br>
            </p>
            <!-- Тело формы -->
            <div class="container_form">
                <div class="line_block">
                    <span class="input_text">Заявка от: </span>
                    <input disabled type="text" class="text"
                           name="LAST_NAME"
                           value="<@security.authentication property="principal.userInfo.name"/> <@security.authentication property="principal.userInfo.lastname"/> (<@security.authentication property="principal.username"/>)"/>
                </div>
                <div class="line_block">
                    <span class="input_text">Телефон:</span>
                    <input disabled id="telephone" type="text" class="text" name="PERSONAL_PHONE"
                           value="<@security.authentication property="principal.userInfo.telephone"/>">
                    <span class="comment">Телефон необходим, чтобы мы могли оперативно связаться с вами.</span>
                </div>
            </div>

            <!-- Горизонтальная черта -->
            <div class="mark"></div>

            <!-- Тело формы -->
            <div class="container_form">
                <div class="line_block">
                    <span class="input_text">Марка и модель авто:</span>
                    <div class="select_auto">
                        <input disabled id="Car" type="text" class="text" name="Car"
                               value="<@security.authentication property="principal.userInfo.automobile"/>">
                    </div>
                </div>

                <div class="line_block">
                    <span class="input_text"> Причина обращения:</span>
                    <textarea id="REASON" name="REASON"></textarea>
                </div>

                <div class="line_block">
                    <span class="input_text">Желаемая дата и время:</span>
                    <input type="datetime-local" id="DESIRE_DATE" class="text" name="DESIRE_DATE"/>
                </div>


            </div>

            <!-- Кнопка "Отправить" -->
            <div class="footer_form">
                <input  class="button_red_big" type="submit" onclick="return claim()"
                       value="Отправить заявку">
            </div>
        </div>
    </form>
    </@security.authorize>
<script type="text/javascript" src="/resources/js/template.js"
></script>
<script type="text/javascript">
    function claim() {
        var telephone = $('#telephone');
        var car = $('#Car');
        var reason = $('#REASON');
        var date = $('#DESIRE_DATE');
        var error = $('#error_naq');
        if(telephone.val().length == 0){
            error.show();
            error.text('Заполните телефон в личном кабинете');
            return false;
        }
        if(car.val().length == 0){
            error.show();
            error.text('Заполните авто в личном кабинете');
            return false;
        }
        if(reason.val().length ==0){
            error.show();
            error.text('Заполните причину обращения');
            return false;
        }
        if(date.val().length == 0){
            error.show();
            error.text('Заполните желаемую дату и время');
            return false;
        }

        return true;
    }
</script>
<script type="text/javascript">

    $(document).ready(function () {
        $('#sys_auth_from').submit(function (e) {
            if ($('input[name=USER_LOGIN]').val() == 'Логин' && $('input[name=USER_PASSWORD]').val() == 'Пароль') {
                e.preventDefault();
                return false;
            }
        });
    });
</script>
<script src="/resources/js/cphttprequest.js" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("div.jCarouselLite").find("a[rel=vis-tur]").fancybox({
            'transitionIn': 'none',
            'transitionOut': 'none',
            'titlePosition': 'outside',
            'titleFormat': function (title, currentArray, currentIndex, currentOpts) {
                return '&lt;span id="fancybox-title-over"> ' + (currentIndex + 1) + ' / ' + currentArray.length + (title.length ? ' &nbsp; ' + title : '') + '</span>';
            }
        });
    });
</script>
<script type="text/javascript">var B_open = 0;
var I_open = 0;
var U_open = 0;
var QUOTE_open = 0;
var CODE_open = 0;
var text_enter_url = "";
var text_enter_url_name = "";
var text_enter_image = "";
var list_prompt = "";
var error_no_url = "";
var error_no_title = "";
var bbtags = [];
var myAgent = navigator.userAgent.toLowerCase();
var myVersion = parseInt(navigator.appVersion);
var is_ie = ((myAgent.indexOf("msie") != -1) && (myAgent.indexOf("opera") == -1));
var is_nav = ((myAgent.indexOf('mozilla') != -1) && (myAgent.indexOf('spoofer') == -1)
&& (myAgent.indexOf('compatible') == -1) && (myAgent.indexOf('opera') == -1)
&& (myAgent.indexOf('webtv') == -1) && (myAgent.indexOf('hotjava') == -1));
var is_opera = (myAgent.indexOf("opera") != -1);
var is_win = ((myAgent.indexOf("win") != -1) || (myAgent.indexOf("16bit") != -1));
var is_mac = (myAgent.indexOf("mac") != -1);
function mozillaWr(textarea, open, close) {
    var selLength = textarea.textLength;
    var selStart = textarea.selectionStart;
    var selEnd = textarea.selectionEnd;
    if (selEnd == 1 || selEnd == 2)
        selEnd = selLength;
    var s1 = (textarea.value).substring(0, selStart);
    var s2 = (textarea.value).substring(selStart, selEnd)
    var s3 = (textarea.value).substring(selEnd, selLength);
    textarea.value = s1 + open + s2 + close + s3;
    textarea.selectionEnd = 0;
    textarea.selectionStart = selEnd + open.length + close.length;
}
/**
 * @return {boolean}
 */
function showPopUp() {
    var scrollHeight = Math.max(
            document.body.scrollHeight, document.documentElement.scrollHeight,
            document.body.offsetHeight, document.documentElement.offsetHeight,
            document.body.clientHeight, document.documentElement.clientHeight
    );
    var s = $('#fade-box');
    s.css('height', scrollHeight);
    s.css('display', 'block');
    $('#pop-form-form').css('display', 'block');

}
function close_form() {
    $('#fade-box').css('display', 'none');
    $('#pop-form-form').css('display', 'none');
}
function ValidateForm(form) {
    var MessageMax = 64000;
    var MessageLength = document.REPLIER.REVIEW_TEXT.value.length;
    var errors = "";
    if (MessageLength < 3) {
        errors += "";
    }
    if (MessageMax != 0) {
        if (MessageLength > MessageMax) {
            errors += "" + MessageMax + "" + MessageLength;
        }
    }
    if (errors != "") {
        alert(errors);
        return false;
    }
    else {
        document.REPLIER.submit.disabled = true;
        return true;
    }
}
function reply2author(name) {
    document.REPLIER.REVIEW_TEXT.value += name + " \n";
    return false;
}
</script>
<script type="text/javascript">var B_open = 0;
var I_open = 0;
var U_open = 0;
var QUOTE_open = 0;
var CODE_open = 0;
var text_enter_url = "Введите полный адрес (URL)";
var text_enter_url_name = "Введите название сайта";
var text_enter_image = "Введите полный адрес (URL) изображения";
var list_prompt = "Введите пункт списка. Нажмите 'Отмена' или оставьте пробел для завершения списка";
var error_no_url = "Вы должны ввести адрес (URL)";
var error_no_title = "Вы должны ввести название";
var bbtags = [];
var myAgent = navigator.userAgent.toLowerCase();
var myVersion = parseInt(navigator.appVersion);
var is_ie = ((myAgent.indexOf("msie") != -1) && (myAgent.indexOf("opera") == -1));
var is_nav = ((myAgent.indexOf('mozilla') != -1) && (myAgent.indexOf('spoofer') == -1)
&& (myAgent.indexOf('compatible') == -1) && (myAgent.indexOf('opera') == -1)
&& (myAgent.indexOf('webtv') == -1) && (myAgent.indexOf('hotjava') == -1));
var is_opera = (myAgent.indexOf("opera") != -1);
var is_win = ((myAgent.indexOf("win") != -1) || (myAgent.indexOf("16bit") != -1));
var is_mac = (myAgent.indexOf("mac") != -1);
function quoteMessageEx(theAuthor, textMessage) {
    var selection = "";
    if (document.getSelection) {
        selection = document.getSelection();
        selection = selection.replace(/\r\n\r\n/gi, "_newstringhere_");
        selection = selection.replace(/\r\n/gi, " ");
        selection = selection.replace(/  /gi, "");
        selection = selection.replace(/_newstringhere_/gi, "\r\n\r\n");
    }
    else {
        selection = document.selection.createRange().text;
    }
    if (selection == "") {
        selection = textMessage;
    }
    if (selection != "") {
        selection = theAuthor + " пишет:\n" + selection;
        doInsert("[QUOTE]", "[/QUOTE]", false, selection);
    }
}
function mozillaWr(textarea, open, close) {
    var selLength = textarea.length;
    var selStart = textarea.selectionStart;
    var selEnd = textarea.selectionEnd;
    if (selEnd == 1 || selEnd == 2)
        selEnd = selLength;
    var s1 = (textarea.value).substring(0, selStart);
    var s2 = (textarea.value).substring(selStart, selEnd)
    var s3 = (textarea.value).substring(selEnd, selLength);
    textarea.value = s1 + open + s2 + close + s3;
    textarea.selectionEnd = 0;
    textarea.selectionStart = selEnd + open.length + close.length;
}
</script>
<script type="text/javascript">
    $(document).ready(function () {
        if ($.cookie("last_city_id")) {
            // считываем cookie запомненного города и показываем контакты
            $("#contacts .active").removeClass('active');
            $("#contacts .contact_city[city=" + $.cookie("last_city_id") + "]").addClass("active");
            // пока есть прошлый город, используем это
            $("#contact_top .list_city li[city=" + $.cookie("last_city_id") + "]").html($("#city_current var").html());
            $("#contact_top .list_city li[city=" + $.cookie("last_city_id") + "]").attr("city", $("#city_current").attr('city'));
            // меняем блок ссылок на города в соответствие с cookies
            $("#city_current var").html($.cookie("last_city_name"));
            $("#city_current").attr('city', $.cookie("last_city_id"));
        }
        $(document).on('click', "#city_current", function () {
            // показываем список городов
            $(this).toggleClass("open");
            $("#contact_top .city").fadeToggle("3000", "linear");
            $("#contact_top .city").toggleClass("block");
        });
        $(document).on('click', "#contact_top .list_city li", function () {
            // сохранеям значения атрибута 'city' выбранного города
            var city = $(this).attr('city');
            // сохранеям название текущего города
            var name = $("#city_current var").html();
            // устанавливаем cookie для выбранного города
            $.cookie("last_city_id", city, {path: '/'});
            $.cookie("last_city_name", $(this).html(), {path: '/'});
            // скрываем контакты текущего города и показываем контакты выбранного
            $("#contacts .active").removeClass('active');
            $("#contacts .contact_city[city=" + city + "]").addClass("active");
            // меняем местами текущий и выбранный города
            $("#city_current var").html($(this).html());
            $(this).html(name);
            $(this).attr('city', $("#city_current").attr('city'));
            $("#city_current").attr('city', city);
            // скрываем список городов
            $("#contact_top .city").fadeOut('normal');
            $("#city_current").removeClass("open");
            $("#contact_top .city").toggleClass("block");
        });
    });
</script>
</body>
</html></#macro>