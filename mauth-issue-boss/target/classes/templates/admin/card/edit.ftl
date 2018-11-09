<#assign base=request.contextPath /> 
<div class="bjui-pageContent">
	<form action="${base}/admin/card/update" data-toggle="validate" method="post">
		<input type="hidden" name="id" value="${bean.id}"/>
		<div class="form-group">
            <label class="control-label x85">创建时间：</label>
            <input type="text" name="gmtCreate" value="${(bean.gmtCreate?string('yyyy-MM-dd HH:mm:ss'))!}" placeholder="创建时间" size="20" readonly>
        </div>
		<div class="form-group">
            <label class="control-label x85">卡名称：</label>
            <input type="text" name="cardName" value="${bean.cardName!}" placeholder="卡名称" size="20">
        </div>
        <div class="form-group">
            <label class="control-label x85">卡类型：</label>
            <select name="cardType" data-toggle="selectpicker" data-width="200">
                <option value="">全部</option>
                <option value="家乐福卡"
                <#if bean.cardType=='家乐福卡'> selected</#if>
                >家乐福卡</option>

            </select>
        </div>
		<div class="form-group">
            <label class="control-label x85">卡面额：</label>
            <input type="text" name="cardFacePrice" value="${bean.cardFacePrice!}" placeholder="卡面额" size="20">
        </div>
		<div class="form-group">
            <label class="control-label x85">卡状态：</label>
            <select name="cardStatus" data-toggle="selectpicker" data-width="200">
                <option value="0">全部</option>
				<#list itemStatusEnums as enumvo>
					<option value="${enumvo.code}"
                    <#if bean.cardStatus=enumvo.code>
                        selected
                    </#if>
                    >${enumvo.desc}</option>
                </#list>
            </select>
        </div>
		<div class="form-group">
            <label class="control-label x85">有效期天数：</label>
            <input type="text" name="validityTime" value="${bean.validityTime!}" placeholder="有效天数" size="20">
        </div>
	</form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">取消</button></li>
        <li><button type="submit" class="btn-default">修改</button></li>
    </ul>
</div>