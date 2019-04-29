/*表示，页面所有元素加载完毕之后，执行里面内容*/
$(function () {

    //左边树结构，菜单
    $('#tree').tree({
        url: '/static/json/tree.json',
        lines: true,
        onSelect: function (node) {
            /*在添加之前, 做判断  判断这个标签是否存在 */
            var exists = $("#tabs").tabs("exists", node.text);
            if (exists) {
                /*存在,就让它选中*/
                $("#tabs").tabs("select", node.text);
            } else {
                /*如果不存在 ,添加新标签*/
                $("#tabs").tabs("add", {
                    title: node.text,
                    /*href:node.attributes.url,*!/  /!*href  只引入的是html中body的内容*/
                    content: "<iframe src=" + node.url + " frameborder='0' width='100%' height='100%'></iframe>",
                    closable: true
                })
            }
        },
        /*树结构加载出来就加载第一个结点，就是进来就显示第一个数据*/
        onLoadSuccess: function (node, data) {
            if (data.length > 0) {
                /*找到第一个元素*/
                var n = $('#tree').tree('find', data[0].children[0].id);
                /*调用选中事件*/
                $('#tree').tree('select', n.target);
            }
        }
    })

    $("#tabs").tabs({
        fit: true
    })
});