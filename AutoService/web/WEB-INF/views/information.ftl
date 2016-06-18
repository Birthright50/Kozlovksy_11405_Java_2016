<#include "main_template.ftl"/>
<@main_template title="Информация"/>
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
        <!--/Левое меню-->

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
            <li>Информация</li>
        </ul>

        <div class="both"></div>
        <h1>Информация</h1>
        <@security.authorize access="hasRole('ROLE_ADMIN')">
            <br><br>
            <a  name="Login" href="/information/add" class="button_red_big" style="left: 213px; top: -31px; ">Добавить</a>
        </@security.authorize>
        <div class="news_articles">
            <h2 class="big_title">Новости</h2>
            <#if news??>
                <#list news as template>
                    <div class="unit">
                        <div class="foto">
                            <a href="/information/news/${template.getId()}"><img src="${template.getUrlImage()}"
                                                                                 width="116" height="70"
                                                                                 alt="${template.getName()}"
                                                                                 title="${template.getName()}"></a>
                        </div>
                        <div class="description">
                            <!-- Название -->
                            <h3><a href="/information/news/${template.getId()}">${template.getName()}</a></h3>
                            <!-- Дата -->
                            <p class="date">${template.getfDate()}</p>
                            <!-- Превью -->
                            <p class="data">${template.getPreviewText()}</p>
                            <div style="clear:both"></div>
                        </div>
                    </div>
                </#list>
            </#if>

            <a href="/information/news">Все новости</a>
        </div>
        <br><br>
        <div class="news_articles">
            <h2 class="big_title">Статьи</h2>
            <#if articles??>
                <#list articles as template>
                    <div class="unit">
                        <div class="foto">
                            <a href="/information/articles/${template.getId()}"><img src="${template.getUrlImage()}"
                                                                                     width="116" height="71"
                                                                                     alt="${template.getName()}"
                                                                                     title="${template.getName()}"></a>
                        </div>
                        <div class="description">
                            <!-- Название -->
                            <h3><a href="/information/articles/${template.getId()}">${template.getName()}</a></h3>
                            <!-- Превью -->
                            <p class="data">${template.getPreviewText()}</p>
                            <div style="clear:both"></div>
                        </div>
                    </div>
                </#list>
            </#if>
            <a href="/information/articles">Все статьи</a>
        </div>
        <br><br>
        <h2 class="big_title">Спецпредложения</h2>
        <div>
            <#if spec??>
                <#list spec as template>
                    <div>
                        <a href="/information/spec/${template.getId()}">${template.getName()}</a>
                        <p>${template.getPreviewText()}</p>
                    </div>
                </#list>
            </#if>
            <a href="/information/spec">Все Спецпредложения</a>
        </div>
    </div>
</div>


</#macro>