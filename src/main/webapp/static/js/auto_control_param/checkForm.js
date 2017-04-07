var paramName_empty = '<span class="help-inline" style="color:red;">请输入自控参数名称</span>';
var paramName_existed = '<span class="help-inline" style="color:red;">自控参数名称已存在</span>';
var temperatureMin_empty = '<span class="help-inline" style="color:red;">请输入温度下限</span>';
var temperatureMin_higher = '<span class="help-inline" style="color:red;">温度下限不得高于温度上限</span>';
var temperatureMax_empty = '<span class="help-inline" style="color:red;">请输入温度上限</span>';
var temperatureMax_lower = '<span class="help-inline" style="color:red;">温度上限不得低于土壤温度下限</span>';
var humidityMin_empty = '<span class="help-inline" style="color:red;">请输入湿度下限</span>';
var humidityMin_higher = '<span class="help-inline" style="color:red;">湿度下限不得高于湿度上限</span>';
var humidityMax_empty = '<span class="help-inline" style="color:red;">请输入湿度上限</span>';
var humidityMax_lower = '<span class="help-inline" style="color:red;">湿度上限不得低于湿度下限</span>';
var lightIntensityMin_empty = '<span class="help-inline" style="color:red;">请输入光照强度下限</span>';
var lightIntensityMin_higher = '<span class="help-inline" style="color:red;">光照强度下限不得高于湿度上限</span>';
var lightIntensityMax_empty = '<span class="help-inline" style="color:red;">请输入光照强度上限</span>';
var lightIntensityMax_lower = '<span class="help-inline" style="color:red;">光照强度上限不得低于湿度下限</span>';
var soilMoistureMin_empty = '<span class="help-inline" style="color:red;">请输入土壤湿度下限</span>';
var soilMoistureMin_higher = '<span class="help-inline" style="color:red;">土壤湿度下限不得高于土壤湿度上限</span>';
var soilMoistureMax_empty = '<span class="help-inline" style="color:red;">请输入土壤湿度上限</span>';
var soilMoistureMax_lower = '<span class="help-inline" style="color:red;">土壤湿度上限不得低于土壤湿度下限</span>';
var info_right = '<span></span>';


var paramName_flag = false;
var temperatureMin_flag = false;
var temperatureMax_flag = false;
var humidityMin_flag = false;
var humidityMax_flag = false;
var lightIntensityMin_flag = false;
var lightIntensityMax_flag = false;
var soilMoistureMin_flag = false;
var soilMoistureMax_flag = false;

function setParamNameFlagTrue() {
    paramName_flag =true;
}

/*
 * 自控参数名检测
 */
function checkParamName(paramName) {
    if (paramName.value.length < 1) {
        showInfo("paramNameNotice", paramName_empty);
    }
    else {
        $.ajax({ //一个Ajax过程
            type: "post", //以post方式与后台沟通
            url :"/autoControlParam/checkParamName", //与此页面沟通
            // dataType:'json',//返回的值以 JSON方式 解释
            data: 'paramName='+paramName.value, //发给的数据
            success: function(json){//如果调用成功
                if(json.flag){
                    showInfo("paramNameNotice", paramName_existed);
                }else {
                    paramName_flag = true;
                    showInfo("paramNameNotice", info_right);
                    change_submit();
                    return;
                }
            }
        });
    }
    change_submit();
}

/*
 * 温度下限检测
 */
function checkTemperatureMin( temperatureMin )
{
    if(temperatureMin.value.length < 1){
        showInfo("temperatureMinNotice",temperatureMin_empty);
    }
    else {
        temperatureMin_flag = true;
        showInfo("temperatureMinNotice",info_right);
    }
    change_submit();
}
/*
 * 温度上限检测
 */
function checkTemperatureMax( temperatureMax )
{
    if(temperatureMax.value.length < 1){
        showInfo("temperatureMaxNotice",temperatureMax_empty);
    }
    else {
        temperatureMax_flag = true;
        showInfo("temperatureMaxNotice",info_right);
    }
    change_submit();
}

/*
 * 湿度下限检测
 */
function checkHumidityMin( humidityMin )
{
    if(humidityMin.value.length < 1){
        showInfo("humidityMinNotice",humidityMin_empty);
    }
    else {
        humidityMin_flag = true;
        showInfo("humidityMinNotice",info_right);
    }
    change_submit();
}
/*
 * 湿度上限检测
 */
function checkHumidityMax( humidityMax )
{
    if(humidityMax.value.length < 1){
        showInfo("humidityMaxNotice",humidityMax_empty);
    }
    else {
        humidityMax_flag = true;
        showInfo("humidityMaxNotice",info_right);
    }
    change_submit();
}

/*
 * 光照强度下限检测
 */
function checkLightIntensityMin( lightIntensityMin )
{
    if(lightIntensityMin.value.length < 1){
        showInfo("lightIntensityMinNotice",lightIntensityMin_empty);
    }
    else {
        lightIntensityMin_flag = true;
        showInfo("lightIntensityMinNotice",info_right);
    }
    change_submit();
}
/*
 * 光照强度上限检测
 */
function checkLightIntensityMax( lightIntensityMax )
{
    if(lightIntensityMax.value.length < 1){
        showInfo("lightIntensityMaxNotice",lightIntensityMax_empty);
    }
    else {
        lightIntensityMax_flag = true;
        showInfo("lightIntensityMaxNotice",info_right);
    }
    change_submit();
}

/*
 * 土壤湿度下限检测
 */
function checkSoilMoistureMin( soilMoistureMin )
{
    if(soilMoistureMin.value.length < 1){
        showInfo("soilMoistureMinNotice",soilMoistureMin_empty);
    }
    else {
        soilMoistureMin_flag = true;
        showInfo("soilMoistureMinNotice",info_right);
    }
    change_submit();
}
/*
 * 土壤湿度上限检测
 */
function checkSoilMoistureMax( soilMoistureMax )
{
    if(soilMoistureMax.value.length < 1){
        showInfo("soilMoistureMaxNotice",soilMoistureMax_empty);
    }
    else {
        soilMoistureMax_flag = true;
        showInfo("soilMoistureMaxNotice",info_right);
    }
    change_submit();
}

/*
 * 按钮状态设置
 */
function change_submit(){
    if(paramName_flag&&temperatureMin_flag&&temperatureMax_flag&&humidityMin_flag&&humidityMax_flag&&lightIntensityMin_flag&&lightIntensityMax_flag&&soilMoistureMin_flag&&soilMoistureMax_flag){
        document.forms['form'].elements['submit'].disabled = '';
    }
    else
    {
        document.forms['form'].elements['submit'].disabled = 'disabled';
    }
}

/*
 * 公用程序
 */
function showInfo(target,Infos){
    document.getElementById(target).innerHTML = Infos;
}