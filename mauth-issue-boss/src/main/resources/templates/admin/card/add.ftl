<#assign base=request.contextPath />
<div class="bjui-pageContent">
	<form action="${base}/admin/card/save" data-toggle="validate" method="post">
		<div class="form-group">
            <label class="control-label x85">卡名称：</label>
            <input type="text" name="cardName" value="" placeholder="卡名称" size="20" data-rule="required">
        </div>
        <div class="form-group">
            <label class="control-label x85">卡类型：</label>
            <select name="cardType" data-toggle="selectpicker" data-width="200">
                <option value="家乐福卡" selected>家乐福卡</option>
            </select>
        </div>
        <div class="form-group">
            <label class="control-label x85">卡面额：</label>
            <input type="text" name="cardFacePrice" value="" placeholder="卡面额" size="20" data-rule="required">
        </div>
        <div class="form-group">
            <label for="cardStatus" class="control-label x85">卡状态：</label>
            <select name="cardStatus" data-toggle="selectpicker" data-width="200">
				<#list itemStatusEnums as enumvo>
					<option value="${enumvo.code}">${enumvo.desc}</option>
                </#list>
            </select>
        </div>
		<div class="form-group">
            <label class="control-label x85">有效期：</label>
            <input type="text" name="validityTime" value="30" placeholder="有效期" size="20" data-rule="required"> 天
        </div>

	</form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">取消</button></li>
        <li><button type="submit" class="btn-default">添加</button></li>
    </ul>
</div>