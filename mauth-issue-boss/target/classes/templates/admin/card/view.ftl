<div class="bjui-pageContent">
    <div class="form-group">
		<label class="control-label">创建时间：</label>${(bean.gmtCreate?string('yyyy-MM-dd HH:mm:ss'))!}
	</div>
    <div class="form-group">
		<label class="control-label">卡名称：</label>${bean.cardName!}
	</div>
	<div class="form-group">
		<label class="control-label">卡类型：</label>${bean.cardType!}
	</div>
    <div class="form-group">
		<label class="control-label">卡面额：</label>${bean.cardFacePrice!} 元
	</div>
    <div class="form-group">
		<label class="control-label">卡状态：</label>
		<#list itemStatusEnums as enumvo>
			<#if bean.cardStatus!= 0 && bean.cardStatus==enumvo.code>
				${enumvo.desc}
			</#if>
		</#list>
	</div>
    <div class="form-group">
		<label class="control-label">有效期：</label>${bean.validityTime!}
	</div>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">取消</button></li>
    </ul>
</div>