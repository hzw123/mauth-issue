<div class="bjui-pageContent">
    <div class="form-group">
		<label class="control-label">支付时间：</label>${(bean.gmtCreate?string('yyyy-MM-dd HH:mm:ss'))!}
	</div>
    <div class="form-group">
		<label class="control-label">储值卡信息ID：</label>${bean.orderCardWaterId!}
	</div>
    <div class="form-group">
		<label class="control-label" title="1:创建,2:激活">状态：</label>${bean.status!}
	</div>
    <div class="form-group">
		<label class="control-label">用户ID：</label>${bean.userId!}
	</div>
    <div class="form-group">
		<label class="control-label">信息：</label>${bean.msg!}
	</div>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">取消</button></li>
    </ul>
</div>