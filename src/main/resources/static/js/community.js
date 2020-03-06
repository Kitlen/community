function post() {
    var questionId = $("#questionId").val();
    var commentContent = $("#commentContent").val();

    if (commentContent == null || commentContent == "") {
        alert("请先输入评论哦");
    } else  {

        $.ajax({
            type: "POST",
            url: "/comment",
            contentType : "application/json",
            data: JSON.stringify({
                "parentId": questionId,
                "content": commentContent,
                "type": 1
            }),
            success: function (data) {
                if (data.code == 200) {
                    $("#commentSection").hide();
                } else {
                    if (data.code == 2003) {
                        var isAccepted = confirm(data.message);
                        if (isAccepted) {
                            window.open("https://github.com/login/oauth/authorize?client_id=1dc4399fcad9011499e0&redirect_uri=http://localhost:8887/callback&scope=user&state=1");
                            window.localStorage.setItem("closable",true);
                        };
                    } else {
                        alert(data.message);
                    }
                }
            },
            dataType: "json"
        })
    }



}