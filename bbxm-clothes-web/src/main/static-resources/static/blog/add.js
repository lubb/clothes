$(document).ready(function() {

    layui.use(['layer'], function(){
        var layer = layui.layer;
    });

    /**
     * 编辑器
     */
    $('#summernote').summernote({
        placeholder: '输入内容',
        height: 400,
        callbacks: {
            onImageUpload: function(files) {
                sendFile(files[0]);
            }
        }
    });

    $("#uploadfile").fileinput({
        language: 'zh', //设置语言
        uploadUrl: "/article/upload", //上传的地址
        allowedFileExtensions: ['png','jpg','gif','jpeg'],//接收的文件后缀
        uploadAsync: true, //默认异步上传
        showUpload: false, //是否显示上传按钮
        showRemove : false, //显示移除按钮
        showBrowse : false, //是否显示浏览按钮
        showPreview : true, //是否显示预览
        showCancel:false,//是否显示取消按钮
        showCaption: false,//是否显示标题
        browseClass: "btn btn-primary", //按钮样式
        dropZoneEnabled: true,//是否显示拖拽区域
        maxFileCount: 1, //表示允许同时上传的最大文件个数
        enctype: 'multipart/form-data',
        validateInitialCount:true
    });

    $("#uploadfile").on("fileuploaded", function (event, data, previewId, index) {
        var response = data.response;
        $(".img").val(response.fileName);
    });

    $('.addArticle').click(function(){
        var content = $("#summernote").summernote('code');
        var title = $(".title").val();
        var remark = $(".remark").val();
        var tagId = $(".tagId").val();
        var img = $(".img").val();
        if(content=="" || content ==null){
            layer.msg("请输入内容");
            return;
        }
        if(title=="" || title ==null){
            layer.msg("请输入标题");
            return;
        }
        if(tagId=="" || tagId ==null){
            layer.msg("请选择标签");
            return;
        }
        if(img=="" || img ==null){
            layer.msg("请上传图片");
            return;
        }
        if(remark=="" || remark ==null){
            layer.msg("请输入副标题");
            return;
        }
        $.ajax({
            type: 'POST',
            url: 'article/save' ,
            dataType: 'text',
            contentType:'application/json;charset=UTF-8',
            data:JSON.stringify({'title':title,'description':content,'tagId':tagId,'img':img,'remark':remark}),  //提交json字符串数组，如果提交json字符串去掉[]
            success:function(data){
                layer.msg("帖子发布成功");
                setTimeout(function () {
                    location.href="/index";
                },2000);
            },
            error:function(textStatus, errorThrown){
                console.log(textStatus);
                alert(textStatus);
            }
        });

    })

    /**
     * 图片上传
     * @param file
     */
    function sendFile(file) {
        let data = new FormData();
        data = new FormData();
        data.append("file", file);
        $.ajax({
            data: data,
            type: "POST",
            url: "/article/upload",
            cache: false,
            contentType: false,
            processData: false,
            success: function(result) {
                let url = '/images/'+result.fileName;
                $("#summernote").summernote('insertImage', url);
            },
            error: function() {
                $(".note-alarm").html("上传失败");
                setTimeout(function() {
                    $(".note-alarm").remove();
                },3000);
            }
        });
    }


});