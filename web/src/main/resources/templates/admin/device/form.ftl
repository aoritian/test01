<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> - 表单验证 jQuery Validation</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="${ctx!}/assets/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${ctx!}/assets/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${ctx!}/assets/css/animate.css" rel="stylesheet">
    <link href="${ctx!}/assets/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">

    <div class="row">
    <#--<div class="col-sm-12">-->
    <#--<div class="ibox float-e-margins">-->
        <div class="ibox-title">
            <h5>完整验证表单</h5>
        </div>
        <div class="ibox-content">
            <form class="form-horizontal m-t" id="frm" method="post" action="${ctx!}/admin/device/edit">
                <input type="hidden" id="id" name="id" value="${device.id}">
                <div class="form-group">
                    <label class="col-sm-3 control-label">设备序列号：</label>
                    <div class="col-sm-8">
                        <input id="deviceSn" name="deviceSn" class="form-control" type="text"
                               value="${device.deviceSn}" <#if device?exists> readonly="readonly"</#if> >
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">地点：</label>
                    <div class="col-sm-8">
                        <input id="location" name="location" class="form-control" type="text" value="${device.location}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">激活状态：</label>
                    <div class="col-sm-8">
                        <select name="status" class="form-control">
                            <option value="0" <#if device.status == 0>selected="selected"</#if>>未激活</option>
                            <option value="1" <#if device.status == 1>selected="selected"</#if>>已激活</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">是否封禁：</label>
                    <div class="col-sm-8">
                        <select name="deleteStr" class="form-control">
                            <option value="0" <#if device.deleteStr == 0>selected="selected"</#if>>未封禁</option>
                            <option value="1" <#if device.deleteStr == 1>selected="selected"</#if>>已封禁</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">创建日期：</label>
                    <div class="col-sm-8">
                        <input id="createTime" name="createTime" readonly="readonly"
                               class="laydate-icon form-control layer-date" value="${device.createTime}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">公司ID：</label>
                    <div class="col-sm-8">
                        <input id="groupId" name="groupId" class="form-control" value="${device.groupId}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">硬件版本：</label>
                    <div class="col-sm-8">
                        <input id="hardwareVer" name="hardwareVer" class="form-control" value="${device.hardwareVer}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">软件ID：</label>
                    <div class="col-sm-8">
                        <input id="appId" name="appId" class="form-control" value="${device.appId}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">IP地址：</label>
                    <div class="col-sm-8">
                        <input id="ip" name="ip" class="form-control" value="${device.ip}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">备注：</label>
                    <div class="col-sm-8">
                        <input id="remark" name="remark" class="form-control" value="${device.remark}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-8 col-sm-offset-3">
                        <button id="233" class="btn btn-primary" type="submit">提交</button>
                    </div>
                </div>
            </form>
        <#--</div>-->
        <#--</div>-->
        </div>
    </div>

</div>


<!-- 全局js -->
<script src="${ctx!}/assets/js/jquery.min.js?v=2.1.4"></script>
<script src="${ctx!}/assets/js/bootstrap.min.js?v=3.3.6"></script>

<!-- 自定义js -->
<script src="${ctx!}/assets/js/content.js?v=1.0.0"></script>

<!-- jQuery Validation plugin javascript-->
<script src="${ctx!}/assets/js/plugins/validate/jquery.validate.min.js"></script>
<script src="${ctx!}/assets/js/plugins/validate/messages_zh.min.js"></script>
<script src="${ctx!}/assets/js/plugins/layer/layer.min.js"></script>
<script src="${ctx!}/assets/js/plugins/layer/laydate/laydate.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        //外部js调用
        laydate({
            elem: '#createTime', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
            event: 'focus' //响应事件。如果没有传入event，则按照默认的click
        });

        $("#frm").validate({
            rules: {

            },
            messages: {},
            submitHandler: function (form) {
                $.ajax({
                    type: "POST",
                    dataType: "json",
                    url: "${ctx!}/admin/device/dedit",
                    data: $(form).serialize(),
                    success: function (msg) {
                        layer.msg(msg.message, {time: 2000}, function () {
                            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                            parent.layer.close(index);
                        });
                    }
                });
            }
        });
    });
</script>

</body>

</html>
