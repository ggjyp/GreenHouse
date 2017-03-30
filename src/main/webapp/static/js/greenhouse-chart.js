
/**
该js文件中的函数功能是从SiteWhere上获取智能温室数据，再将其以折线图的形式表现出来
 根据url的参数来确定图表显示的数据量
*/


//温度折线图
function temperatureChart(){
    var temperatureArray = [];
    var eventDateArray =[];
    $.ajax({
        //参数page=1,pageSize=5，表示显示最新的5个数据
        url:"http://localhost:8080/sitewhere/api/assignments/b8430c7c-5690-4fc7-ba13-644b66fbbe03/measurements?page=1&pageSize=5",
        dataType: 'html',
        method: 'GET',
        async : false,//设置为同步操作就可以给全局变量赋值成功
        beforeSend: function(request){
            request.setRequestHeader("Content-Type","application/json");
            request.setRequestHeader("X-SiteWhere-Tenant","sitewhere1234567890");
            request.setRequestHeader("Authorization","Basic YWRtaW46cGFzc3dvcmQ=");
        },
        success: function(data) {
            data = eval('(' + data + ')');
            var results = data.results
            for (var i = 0; i < results.length; i++) {
                var measurements = results[i].measurements;
                temperatureArray.push(measurements.temperature);
                eventDateArray.push(results[i].eventDate);
            }
        },
        error: function(xhr) {
            console.log("error");
        }
    })
    //将图表图像绑定至id为temperatureContainer的div上
    var chart = new Highcharts.Chart('temperatureContainer', {
        title: {
            text: '智能温室实时温度数据',
            x: -20
        },
        xAxis: {
            categories: eventDateArray
        },
        yAxis: {
            title: {
                text: '温度 (°C)'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: '°C'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: '温度',
            data: temperatureArray
        }]
    });
}

//湿度折线图
function humidityChart(){
    var humidityArray = [];
    var eventDateArray =[];
    $.ajax({
        url:"http://localhost:8080/sitewhere/api/assignments/b8430c7c-5690-4fc7-ba13-644b66fbbe03/measurements?page=1&pageSize=5",
        dataType: 'html',
        method: 'GET',
        async : false,//设置为同步操作就可以给全局变量赋值成功
        beforeSend: function(request){
            request.setRequestHeader("Content-Type","application/json");
            request.setRequestHeader("X-SiteWhere-Tenant","sitewhere1234567890");
            request.setRequestHeader("Authorization","Basic YWRtaW46cGFzc3dvcmQ=");
        },
        success: function(data) {
            data = eval('(' + data + ')');
            var results = data.results
            for (var i = 0; i < results.length; i++) {
                var measurements = results[i].measurements;
                humidityArray.push(measurements.humidity);
                eventDateArray.push(results[i].eventDate);
            }
        },
        error: function(xhr) {
            console.log("error");
        }
    })
    //将图表图像绑定至id为temperatureContainer的div上
    var chart = new Highcharts.Chart('humidityContainer', {
        title: {
            text: '智能温室实时湿度数据',
            x: -20
        },
        xAxis: {
            categories: eventDateArray
        },
        yAxis: {
            title: {
                text: '湿度 (%RH)'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: '%RH'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: '湿度',
            data: humidityArray
        }]
    });
}
