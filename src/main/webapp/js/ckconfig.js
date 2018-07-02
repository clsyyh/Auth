CKEDITOR.editorConfig = function( config )
{
    config.language = 'zh-cn'; //配置语言
    config.uiColor = '#BFEFFF'; //背景颜色
    config.width = 700; //宽度
    config.height = 300; //高度
    config.skin='kama';
    //工具栏
    config.toolbar =
        [
            ['Source','Bold','Italic'],
            ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
            ['Smiley'],
            ['Styles','Font','FontSize'],
            ['TextColor'],
            ['Undo','Redo']

        ];
};