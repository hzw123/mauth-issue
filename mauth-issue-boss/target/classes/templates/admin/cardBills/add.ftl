<#assign base=request.contextPath />
<div class="bjui-pageContent">
	<form action="${base}/admin/cardBills/add" data-toggle="validate" method="post">
        <div class="form-group">
            <label class="control-label x85">储值卡：</label>
            <select name="cardId" data-toggle="selectpicker" data-width="200">
                <#list cardUps as carduo>
                    <option value="${carduo.id}">${carduo.cardName}</option>
                </#list>
            </select>
        </div>
        <div class="form-group">
            <label class="control-label x85">商品数量：</label>
            <input type="text" name="cardCount" value="3" placeholder="商品数量" size="20" data-rule="required">
        </div>

	</form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">取消</button></li>
        <li><button type="submit" class="btn-default">添加</button></li>
    </ul>
</div>