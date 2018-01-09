function loadSelect(typeCode, position, selectName, selectId) {
    var $select = $("<select name='" + selectName + "'><select/>")
    $select.append($("<option >---请选择---</option>"));
    $.post("${pageContext.request.contextPath}/BaseDictAction", "dict_type_code=" + typeCode + "", function (data) {
        for (var i = 0; i < data.length; i++) {
            var $option = $("<option value='" + data[i].dict_id + "' >" + data[i].dict_item_name + "</option>");
            if (data[i].dict_id == selectId) {
                $option.attr("selected", true);
            }
            $select.append($option);
        }
    }, "json");
    $("#" + position).append($select);
}
