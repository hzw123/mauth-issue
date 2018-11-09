<div class="bjui-pageContent">
    <div class="form-group">
        <label class="control-label">创建时间：</label>${(bean.gmtCreate?string('yyyy-MM-dd HH:mm:ss'))!}
    </div>
    <div class="form-group">
        <label class="control-label">修改时间：</label>${(bean.gmtModified?string('yyyy-MM-dd HH:mm:ss'))!}
    </div>
    <div class="form-group">
        <label class="control-label">卡面额：</label>${bean.cardFacePrice!}
    </div>
    <div class="form-group">
        <label class="control-label">卡密：</label>${bean.uuid!}
    </div>
    <div class="form-group">
		<label class="control-label">卡类型：</label>${bean.cardType!}
	</div>
    <div class="form-group">
		<label class="control-label">订单号：</label>${bean.orderNo!}
	</div>
    <div class="form-group">
		<label class="control-label">订单支付流水号：</label>${bean.serialNo!}
	</div>
    <div class="form-group">
		<label class="control-label">身份标识：</label>${bean.authSign!}
	</div>
    <div class="form-group">
		<label class="control-label" title="1 创建 2激活">状态：</label>
        <#if bean.status=1>没有激活
        <#else>已激活
        </#if>
	</div>
    <div class="form-group">
		<label class="control-label" title="单位：天">激活有效期：</label>${bean.days!}
	</div>
    <div class="form-group">
		<label class="control-label">是否过期：</label>${(bean.expire?string('已过期','没有过期'))!}
	</div>
    <div class="form-group">
		<label class="control-label">备注：</label>${bean.remark!}
	</div>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">取消</button></li>
    </ul>
</div>