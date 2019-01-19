<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<#include "../static.datatables.ftl"/>

</head>
<body class="gray-bg">
<!--新增，修改模态框-->
<div id="userModal" class="modal fade" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <div class="row">
                    <form role="form" method="post" enctype="multipart/form-data">
                        <div class="col-sm-6 b-r">
                            <h3 class="m-t-none m-b" id="modalTitle"></h3>
                            <input id="userid" type="text" style="display: none" name="id">
                            <div class="form-group">
                                <label>用户名：</label>
                                <input type="text" id="username" name="username" placeholder="请输入用户名"
                                       class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>邮箱：</label>
                                <input type="email" id="email" name="email" placeholder="请输入邮箱" class="form-control"
                                       required>
                            </div>
                            <div class="form-group">
                                <label>电话：</label>
                                <input type="telephone" id="telephone" name="telephone" placeholder="请输入手机号"
                                       class="form-control" required>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <h3 class="m-t-none m-b">&nbsp;</h3>
                            <div class="form-group">
                                <label>密码：</label>
                                <input type="password" id="password" name="password" placeholder="请输入密码"
                                       class="form-control" required>
                            </div>
                            <div class="form-group" id="file">
                                <label>文件上传：</label>
                                <input type="file" name="file">
                            </div>
                            <div class="form-group">
                                <label>备注：</label>
                                <textarea class="form-control" id="remark" rows="3" name="remark"></textarea>
                            </div>
                            <div>
                                <button class="btn btn-sm btn-primary pull-right m-t-n-xs" type="submit">
                                    <strong>确定</strong></button>
                                <button type="button" class="btn btn-sm btn-default pull-right m-t-n-xs"
                                        data-dismiss="modal">关闭
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>用户列表</h5>
                    <div class="ibox-tools">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-wrench"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="#" onclick="showUserModal()">添加用户</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="ibox-content">
                    <table id="table_id_example"
                           class="table table-striped table-bordered table-hover dataTables-example">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>用户名</th>
                            <th>邮箱</th>
                            <th>联系方式</th>
                            <th>备注</th>
                            <th>创建时间</th>
                            <th>上次登录时间</th>
                            <th>登陆次数</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody></tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    var userTable = $('#table_id_example').DataTable({
        ajax: '${base}/user/getAll',
        language: {url: "${base}/language/db_zh_CN.json"},
        dom: 'lfBrtip',
        buttons: [{
            extend: 'excel',
            text: '导出',
            title: '用户列表数据',
            exportOptions: {
                modifier: {
                    page: 'all'
                },
                columns: [0, 1, 2, 3, 4, 5, 6, 7]
            }
        }, {
            extend: 'print',
            text: '打印',
            exportOptions: {
                modifier: {
                    page: 'all'
                },
                columns: [0, 1, 2, 3, 4, 5, 6, 7]
            }
        }],
        columns: [
            {data: 'id', visible: false},
            {data: 'username'},
            {data: 'email'},
            {data: 'telephone'},
            {data: 'remark'},
            {data: 'createDate'},
            {data: 'lastLoginDate'},
            {data: 'loginTimes'},
            {
                render: function (data, type, row, meta) {
                    return '<button type="button" onclick="showUserModal(\'' + row.id + '\');" class="btn btn-primary btn-xs" style="margin-right: 1px"><span class="glyphicon glyphicon-pencil">Edit</span></button>' +
                            '<button type="button" onclick="del(\'' + row.id + '\')" class="btn btn-primary btn-xs"><span class="glyphicon glyphicon-trash">Del</span></button>';
                }
            }
        ]
    });

    var options = {
        success: function (responseText, statusText, xhr) {
            if (responseText.responseCode != "200") {
                toastr.error(responseText.responseMessage, "失败");
            } else {
                $('#userModal').modal('hide');//关闭模态框
                toastr.success("操作成功！", "成功");
                userTable.ajax.reload();
            }
        },
        resetForm: true,
        timeout: 3000
    }
    showUserModal = function (id) {
        if (id) {
            $("#modalTitle").html("编辑用户");
            options.url = "${base}/user/update";
            $.get(
                    "${base}/user/findOne/" + id,
                    function (response, status, xhr) {
                        $("#username").val(response.username);
                        $("#password").val(response.password);
                        $("#userid").attr("value", response.id);
                        $("#email").val(response.email);
                        $("#telephone").val(response.telephone);
                        $("#remark").val(response.remark);
                        $('#userModal').modal('show');
                        $("#username").attr("readonly", true);
                    }
            );
        } else {
            $("#modalTitle").html("添加用户");
            options.url = "${base}/user/register";
            $('#userModal').modal('show');
        }
    }

    //模态框开启
    $('#userModal').on('show.bs.modal', function () {
        $("form").find("input").each(function () {
            $(this).attr("readonly", false);
        })
    })

    //模态框关闭
    $('#userModal').on('hidden.bs.modal', function () {
        $("form").resetForm();
    })

    /**
     * 删除数据
     * @param id
     */
    del = function (id) {
        if (confirm('确定删除该条数据吗？')) {
            $.get(
                    "${base}/user/delete/" + id,
                    function (response, status, xhr) {
                        if (response.responseCode == "200") {
                            toastr.success("删除成功！", "成功");
                            userTable.ajax.reload();
                        } else {
                            toastr.error(response.responseMessage, "失败");
                        }
                    }
            );
        }
    }

    $(document).ready(function () {
        $('form').submit(function () {
            $(this).ajaxSubmit(options);
            // !!! Important !!!
            // always return false to prevent standard browser submit and page navigation
            return false;
        });
    })
</script>
</body>
</html>