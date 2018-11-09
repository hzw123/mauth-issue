<#assign base=request.contextPath />
<div class="bjui-pageContent">
	<form action="${base}/admin/cardLog/save" data-toggle="validate" method="post">
        <div class="form-group">
            <label class="control-label x85">储值卡信息ID：</label>
            <input type="text" name="orderCardWaterId" value="" placeholder="储值卡流水id" size="20" data-rule="required">
        </div>
        <div class="form-group">
            <label class="control-label x85">用户ID：</label>
            <input type="text" name="userId" value="" placeholder="卡面额" size="20" data-rule="required">
        </div>
		<div class="form-group">
            <label class="control-label x85">信息：</label>
            <input type="text" name="msg" value="" placeholder="有效期" size="20" data-rule="required"> 天
        </div>
	</form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">取消</button></li>
        <li><button type="submit" class="btn-default">添加</button></li>
    </ul>
</div>