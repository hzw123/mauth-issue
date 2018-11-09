<#assign base=request.contextPath />
<div class="bjui-pageContent">
	<form action="${base}/admin/cardInfo/save" data-toggle="validate" method="post">
        <div class="form-group">
            <label class="control-label x85">订单id：</label>
            <input type="text" name="orderCardId" value="" placeholder="订单id" size="20" data-rule="required">
        </div>
        <div class="form-group">
            <label class="control-label x85">备注：</label>
            <input type="text" name="orderCardId" value="" placeholder="备注" size="20" data-rule="required">
        </div>
	</form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">取消</button></li>
        <li><button type="submit" class="btn-default">添加</button></li>
    </ul>
</div>