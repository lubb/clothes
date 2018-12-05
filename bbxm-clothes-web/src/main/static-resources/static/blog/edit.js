$(document).ready(function() {

    layui.use(['layer'], function(){
        var layer = layui.layer;
    });

    /**
     * 编辑器
     */
    $('#summernote').summernote({
        placeholder: '输入内容',
        height: 600,
        callbacks: {
            onImageUpload: function(files) {
                sendFile(files[0]);
            }
        }
    });

    codeInit();

    $('.addArticle').click(function(){
        var content = $("#summernote").summernote('code');
        var id = $(".id").val();
        if(content=="" || content ==null){
            layer.msg("请输入内容");
            return;
        }
        $.ajax({
            type: 'POST',
            url: '/article/update' ,
            dataType: 'text',
            contentType:'application/json;charset=UTF-8',
            data:JSON.stringify({'id':id,'description':content}),  //提交json字符串数组，如果提交json字符串去掉[]
            success:function(data){
                layer.msg("更新发布成功");
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

    /**
     * 文章内容初始化
     */
    function codeInit() {
        $.ajax({
            type: 'POST',
            url: '/article/getContentById' ,
            dataType: 'text',
            contentType:'application/json;charset=UTF-8',
            data:JSON.stringify({'id':$('.id').val()}),  //提交json字符串数组，如果提交json字符串去掉[]
            success:function(data){
                $('#summernote' ).summernote('code',data);
            },
            error:function(textStatus, errorThrown){
                console.log(textStatus);
                alert(textStatus);
            }
        });

    }

});