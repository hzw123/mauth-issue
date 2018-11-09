<div class="bjui-pageContent">
    <div class="form-group">
		<label class="control-label">卡激活时间：</label>${(bean.createTime?string('yyyy-MM-dd HH:mm:ss'))!}
	</div>
    <div class="form-group">
		<label class="control-label">兑换订单号：</label>${bean.orderNo!}
	</div>
    <div class="form-group">
		<label class="control-label">卡面额：</label>${bean.cardFacePrice!}
	</div>
    <div class="form-group">
		<label class="control-label">卡密：</label>${bean.cardKey!}
	</div>
    <div class="form-group">
		<label class="control-label">身份标识：</label>${bean.authSign!}
	</div>
    <div class="form-group">
		<label class="control-label">code：</label>${bean.code!}
	</div>
    <div class="form-group">
		<label class="control-label">结果：</label>${bean.msg!}
	</div>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">取消</button></li>
    </ul>
</div>