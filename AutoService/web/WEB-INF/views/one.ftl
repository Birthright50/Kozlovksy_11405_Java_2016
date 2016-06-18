<#include "main_template.ftl"/>
<@main_template title="${title} - ${template.getName()}"/>
<#macro m_body>
<div class="narrow">
    <div id="left"><!--Левая колонка-->
        <!--Левое меню-->
        <div id="left-menu"><!--Левое меню-->
            <ul class="left-menu-list">
                <li>
                    <div><a href="/information/news">Новости</a></div>
                </li>
                <li>
                    <div><a href="/information/articles">Статьи</a></div>
                </li>
                <li>
                    <div><a href="/information/spec">Спецпредложения</a></div>
                </li>

            </ul>
        </div><!--/Левое меню-->

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
            <li><a href="/information" title="Информация">Информация</a></li>
            <li><span>&nbsp;/&nbsp;</span></li>
            <li>${title}</li>
        </ul>
        <div class="both"></div>
        <h1>${template.getName()}</h1>
        <div class="news_articles">
            <div class="news-detail">
                <span class="news-date-time">${template.getfDate()}</span>
            ${template.getPageText()}
                <div style="clear:both"></div>
                <br>
            </div>
        </div>
        <@security.authorize access="hasRole('ROLE_ADMIN')">
            <br><br>
               <form action="/information/delete/${template.getId()}" method="post">
            <input type="submit" value="Удалить"  name="Login"  class="button_red_big" style="left: 213px; top: -31px; "/>
               </form>
        </@security.authorize>
    </div>
</div>
</#macro>