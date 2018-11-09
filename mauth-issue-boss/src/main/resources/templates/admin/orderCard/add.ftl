<#assign base=request.contextPath />
<div class="bjui-pageContent">
	<form action="${base}/admin/orderCard/save" data-toggle="validate" method="post">
        <div class="form-group">
            <label class="control-label x85">订单名称：</label>
            <input type="text" name="orderCardName" value="343" placeholder="订单名称" size="20" data-rule="required">
        </div>
        <div class="form-group">
            <label class="control-label x85">订单类型：</label>
            <select name="orderType" data-toggle="selectpicker" data-width="80">
                <option value="内部">内部</option>
                <option value="对公">对公</option>
                <option value="X事件">X事件</option>
            </select>
        </div>
        <div class="form-group">
            <label class="control-label x85">支付账户：</label>
            <input type="text" name="userPayAccount" value="" placeholder="用户支付账户" size="20" data-rule="required">
        </div>
        <div class="form-group">
            <label class="control-label x85">支付方式：</label>
            <input type="text" name="payType" value="" placeholder="支付方式" size="20" data-rule="required">
        </div>
        <div class="form-group">
            <label class="control-label x85">身份标识：</label>
            <input type="text" name="authSign" value="mauth_card" placeholder="身份标识" size="20" data-rule="required">
        </div>
        <div class="form-group">
            <label class="control-label x85">状态：</label>
            <input type="text" name="status" value="已处理" placeholder="状态" size="20" data-rule="required">
        </div>
        <div class="form-group">
            <label class="control-label x85">有效天数：</label>
            <input type="number" name="days" value="5" placeholder="有效天数" size="20" data-rule="required">
        </div>
        <#--style="padding:0px 177px 0 20px;"-->
        <div class="form-group" >
            <table class="table table-bordered table-hover table-top">
                <thead>
                    <tr><th colspan="3" align="center"><h4>订单详情</h4></th></tr>
                    <tr>
                        <th>储值卡</th>
                        <th>数量</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody id="card-bills">
                    <tr index="0">
                        <td>
                            <select name="list[0].cardId" data-width="100">
                                    <#list cardUps as carduo>
                                        <option value="${carduo.id}">${carduo.cardName}</option>
                                    </#list>
                            </select>
                        </td>
                        <td>
                            <input type="number" name="list[0].amount" value="3" placeholder="数量"  size="6" data-rule="required">
                        </td>
                        <td>
                            <div class="btn btn-default card-bills-add">添加</div>
                            <div class="btn btn-red card-bills-delete hidden">删除</div>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
	</form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">取消</button></li>
        <li><button type="submit" class="btn-default">添加</button></li>
    </ul>
</div>
<script type="text/javascript">
    $(function () {
        var index=0;
        $(".card-bills-add").click(function () {
            var $tr=$(this).parent("td").parent("tr");
            var $_tr=$tr.clone(true);
            index++;
            $_tr.attr("index",index);
            $_tr.children("td").children("select").attr("name","list["+index+"].cardId");
            $_tr.children("td").children("input").attr("name","list["+index+"].amount");
            $_tr.children("td").children("div.btn.btn-default.card-bills-add")
                    .remove();
            $_tr.children("td").children("div.btn.btn-red.card-bills-delete")
                    .removeClass("hidden");
            $("#card-bills").append($_tr);
        });

        $(".card-bills-delete").click(function () {
            index--;
            var $tr=$(this).parent("td").parent("tr");
            var i=parseInt($tr.attr("index"));
            console.log(i);
            while($tr.next("tr").html()!=null){
                $tr.children("td").children("select").attr("name","list["+i+"].cardId");
                $tr.children("td").children("input").attr("name","list["+i+"].amount");
                $tr=$tr.next("tr");
                i++;
            }
            $tr.remove();
        });
    });
</script>