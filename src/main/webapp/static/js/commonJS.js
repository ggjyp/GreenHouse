
function checkPermission() {
    var permission = $("#roleId").val();
    console.log(permission);
    // 普通用户：roleId = 1
    //如果是普通用户则隐藏客户端网站部分控件
    if (permission == 2) {
        //隐藏部分侧边栏
        document.getElementById("sidebarPermission").style.display = "";
        document.getElementById("sidebarLog").style.display = "";
        document.getElementById("sidebarAutoCtrlParam").style.display = "";
    }

}