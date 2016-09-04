$("#add").click(function(){
	var str = window.prompt("请输入要添加的NAME");
    $.ajax({
        url: "add",
        type: "POST",
        dataType: "json",
        data: {name: str}
    }).then(function(results) {
        if (results.success) {
            alert("添加成功");
        } else {
            alert(results.msg);
        }
        return results;
    });
});

$("#delete").click(function(){
	var str = window.prompt("请输入要删除的NAME");
    $.ajax({
        url: "delete",
        type: "GET",
        dataType: "json",
        data: {name: str}
    }).then(function(results) {
        if (results.success) {
            alert("删除成功");
        } else {
            alert(results.msg);
        }
        return results;
    });
});

$("#search").click(function(){
	$.ajax({
		url: "getAllUser",
		type: "GET",
		dataType: "json",
	}).then(function(results) {
		$("#userListTable").empty();
		var html = "<tr><td>ID</td><td>用户名</td><td>密码</td></tr>";
		for (var i = 0; i < results.length; i++) {
			html += "<tr><td>" + results[i].id + "</td><td>" + results[i].username + "</td><td>" + results[i].password + "</td></tr>"
		}
		$("#userListTable").append(html);
	});
});