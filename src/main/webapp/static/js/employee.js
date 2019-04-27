/*需要等所有docment加载完毕*/
$(function () {

    /*员工表格数据*/
    $('#dg').datagrid({
        /*发送请求获取数据库数据*/
        url: '/employeeList',
        /*需要展示的列*/
        columns: [[
            {field: 'id', title: 'ID', width: 100, align: 'center'},
            {field: 'username', title: '姓名', width: 100, align: 'center'},
            {field: 'inputtime', title: '入职时间', width: 100, align: 'center'},
            {field: 'telphone', title: '手机号码', width: 100, align: 'center'},
            {field: 'email', title: '邮箱', width: 100, align: 'center'},
            /*部门是一个对象，需要格式化，也不能直接用department.name*/
            {field: 'department', title: '部门', width: 100, align: 'center',
                formatter: function(value,row,index){
                    /*这是一个对象,需要格式化*/
                    if (row.department) {
                        return row.department.name;
                    }
                }},
            {field: 'state', title: '状态', width: 100, align: 'center',
                formatter: function(value,row,index){
                    if(row.state){
                        return "在职";
                    }else {
                        return "<font style='color: red'>离职</font>"
                    }
                }},
            {field: 'admin', title: '管理员', width: 100, align: 'center',
                formatter: function(value,row,index){
                    if(row.admin){
                        return "<font style='color: red'>是</font>";
                    }else {
                        return "否"
                    }
                }}
        ]],
        fit: true,
        /*自适应宽度*/
        fitColumns: true,
        /*顶部工具栏，引用*/
        toolbar: '#tb',
        /*行号显示*/
        rownumbers: true,
        /*分页栏显示*/
        pagination: true
    });

    /*对话框*/
    $("#dialog").dialog({
        width:350,
        height:370,
        closed:true,
        buttons:[{
            text:'保存',
            handler:function(){
                /*提交表单*/
                $("#employeeForm").form("submit",{
                    url:"/saveEmployee",
                    success:function (data) {
                        /*json字符串转换成json对象*/
                        data = $.parseJSON(data);
                        if (data.success){
                            $.messager.alert("温馨提示",data.message);
                            /*关闭对话框 */
                            $("#dialog").dialog("close");
                            /*重新加载数据表格*/
                            $("#dg").datagrid("reload");
                        } else {
                            $.messager.alert("温馨提示",data.msg);
                        }
                    }
                });
            }
        },{
            text:'关闭',
            handler:function(){
                $("#dialog").dialog("close");
            }
        }]
    });

    /*监听添加按钮点击*/
    $("#add").click(function () {
        $("#dialog").dialog("setTitle", "添加员工");
        /*清空表单*/
        $("#employeeForm").form("clear");
        $("#dialog").dialog("open");
    });

    /*部门选择 下拉列表*/
    $("#department").combobox({
        width:160,
        panelHeight:'auto',
        editable:false,
        /*向服务端请求数据*/
        url:'/departList',
        /*对象的name属性显示文本*/
        textField:'name',
        /*对象的id属性作为字段发送给服务器*/
        valueField:'id',
        /*数据加载完毕之后回调，显示placeholder*/
        onLoadSuccess:function () {
            $("#department").each(function(i){
                var span = $(this).siblings("span")[i];
                var targetInput = $(span).find("input:first");
                if(targetInput){
                    $(targetInput).attr("placeholder", $(this).attr("placeholder"));
                }
            });
        }
    });

    /*是否为管理员选择*/
    $("#admin").combobox({
        width:160,
        panelHeight:'auto',
        /*显示的文本*/
        textField:'label',
        /*发送给服务器的字段*/
        valueField:'value',
        editable:false,
        /*少量数据直接使用 data*/
        data:[{
            label:'是',
            value:'true'
        },{
            label:'否',
            value:'false'
        }],
        /*数据加载完毕之后回调，显示placeholder*/
        onLoadSuccess:function () {
            $("#admin").each(function(i){
                var span = $(this).siblings("span")[i];
                var targetInput = $(span).find("input:first");
                if(targetInput){
                    $(targetInput).attr("placeholder", $(this).attr("placeholder"));
                }
            });
        }

    })
})