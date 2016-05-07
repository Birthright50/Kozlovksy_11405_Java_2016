<#include "main_template.ftl"/>
<@main_template title="Добавить"/>
<#macro m_body>
<div class="narrow">
    <div id="right" style=" margin-left:auto;
    margin-right:auto;
    width:900px; "><!--Правая колонка-->
        <ul class="breadcrumb-navigation">
            <li><a href="/" title=""><img src="/resources/images/home.png" width="12" height="12"></a></li>
        </ul>
        <div style="text-align: center" class="both"></div>
        <h1>Добавить информацию</h1>

        <form enctype="multipart/form-data" action="/information/add" method="post" id="add">
            <div id="pop-form" style=" margin-right;width: 100%">
                <!-- Заголовок -->
                <div class="head_form" style="text-align: center">
                    Добавить информацию

                </div>
                <#if RequestParameters.error??>
                    <p style="text-align: center"><span class="errortext">Произошла ошибка<br></span></p>
                </#if>
                <!-- Тело формы -->
                <div class="container_form">

                    <div class="line_block">
                        <span class="input_text">Название</span>
                        <input id="name" type="text" class="text" style="width: 500pt" name="name">
                    </div>
                </div>
                <div class="container_form">
                    <div class="line_block">
                        <span class="input_text">Превью текста</span>
                        <input id="preview" type="text" class="text" style="width: 500pt" name="preview">
                    </div>
                </div>
                <div class="container_form">
                    <div class="line_block">
                        <span class="input_text">Выбор превью-фото</span>
                        <input id="foto" type="file" class="fa-file" style="margin-left: 10pt; width: 500pt"
                               name="foto">
                    </div>
                </div>
                <div class="container_form">
                    <div class="line_block">
                        <span class="input_text">Тип</span>
                        <label for="preview" id="radio" style="margin-left: 10pt">Новость<input id="preview" value="1"
                                                                                                type="radio"
                                                                                                class="fa-file"
                                                                                                name="radio"></label>
                        <label for="preview">Статья<input id="radio" value="2" type="radio" class="fa-file"
                                                          name="radio"></label>
                        <label for="preview">Спецпредложение<input id="radio" value="3" type="radio" class="fa-file"
                                                                   name="radio"></label>

                    </div>
                </div>
                <!-- Горизонтальная черта -->
                <div class="mark"></div>

                <!-- Тело формы -->
                <div class="container_form">
                    <div class="line_block">
                        <span class="input_text">Текст</span>
                        <textarea class="text" style="margin-left: 10pt; width: 100%" name="text"
                                  title=""></textarea>
                    </div>
                </div>

                <!-- Кнопка "Отправить" -->
                <div class="footer_form" style="margin-left: 20%">
                    <input type="hidden" name="request_service" value="Добавить">
                    <input class="button_red_big" onclick="return addType()" type="submit" value="Добавить">
                </div>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript">
    function addType() {
        var radio = $('#radio');
        var name = $('#name');
        var page = $('#page');
        var img = $('#foto');
        var preview = $('#preview');
        if (name.val().length > 2 && img.val().length != 0 && page.val().length > 10 && preview.val().length > 2) {
            return true;
        }
        alert("Нужно заполнить все поля");
        return false;
    }
</script>
</#macro>