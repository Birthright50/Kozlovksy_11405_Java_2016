<#include "../main_template.ftl"/>
<@main_template title="Заявки"/>
<#macro m_body>
<div class="narrow">
    <h1 align="center">Рассмотрение заявок на ТО/ремонт</h1>
    <div id="right" style=" margin-left:auto;
    margin-right:auto;
    width:1200px; "><!--Правая колонка-->

        <div style="text-align: center" class="both"></div>


        <div class="wrap_table">
            <table class="gray_table request">
                <tbody>
                <tr class="even">
                    <th class="number">№</th>
                    <th class="type">От</th>
                    <th class="type">Авто</th>
                    <th class="status">Статус</th>
                    <th class="status">Причина</th>
                    <th class="date">Желаемое время</th>
                    <th align="center" class="date">Решение</th>
                    <th class="sum">Сумма</th>
                    <th class="date">Коммент</th>
                    <th class="date"></th>
                </tr>
                    <#list claims as claim>
                    <tr class="even">

                        <form action="/admin/claims" method="post">
                            <td align="center">${claim?counter}</td>
                            <td>${claim.getUser().getName()} ${claim.getUser().getLastname()}
                                <br>(${claim.getUser().getEmail()})
                            </td>
                            <td>${claim.getUser().getAutomobile()}</td>
                            <td>${claim.getStatus()}</td>
                            <td >${claim.getReason()}</td>
                            <td>${claim.getfDate()}</td>
                            <#if claim.getStatus()=="Заявка рассматривается">
                            <td align="center"><select name="status">
                                <option selected value="Отклонена">Отклонить</option>
                                <option value="Подтверждена">Подтверить</option>
                            </select></td>
                            <td><input type="number" name="sum"></td>
                            <td><input type="text" name="comment"></td>
                            <input hidden name="id" type="text" value="${claim.getId()}">
                            <td><input class="button_red_small" type="submit" value="OK"></td>
                            <#else>
                            <td align="center">${claim.getStatus()}</td>
                            <td></td>
                            <td align="center">${claim.getSum()}</td>
                            <td align="center">${claim.getResponse()}</td>
                            <td></td>
                            </#if>
                        </form>

                    </tr>
                    </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>
</#macro>