
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
	$scope.secInterval = 1;
	$scope.secLimit = 10800;
	$scope.minInterval = 1;
	$scope.minLimit = 60;
	$scope.name = "Thread-Update";
	var secondChart = Highcharts.chart('secondChart', {
		chart: {
	        animation: false
	    },
	    title: {
	        text: 'Second Chart'
	    },
	    subtitle: {
	        text: 'Source: hagyhang.com'
	    },
	    yAxis: {
	        title: {
	            text: 'ProcRate'
	        }
	    },
	    xAxis: {
	        title: {
	            text: 'Time'
	        },
	        type: 'category',
	        tickPositions: [0,18]
	    },
	    legend: {
	        layout: 'vertical',
	        align: 'right',
	        verticalAlign: 'middle'
	    },
	    series: [{
	        name: 'ProcRate',
	        data: [{}],
	        lineWidth: 0.7
	    }],
	    responsive: {
	        rules: [{
	            condition: {
	                maxWidth: 500
	            },
	            chartOptions: {
	                legend: {
	                    layout: 'horizontal',
	                    align: 'center',
	                    verticalAlign: 'bottom'
	                }
	            }
	        }]
	    },
	    plotOptions: {
	    	series: {
	    		turboThreshold: 10800
	    	}
	    }

	});
	var minuteChart = Highcharts.chart('minuteChart', {
		chart: {
	        animation: false
	    },
	    title: {
	        text: 'Minute Chart'
	    },
	    subtitle: {
	        text: 'Source: hagyhang.com'
	    },
	    yAxis: {
	        title: {
	            text: 'ProcRate'
	        }
	    },
	    xAxis: {
	        title: {
	            text: 'Time'
	        },
	        type: 'category',
	        tickPositions: [0,18]
	    },
	    legend: {
	        layout: 'vertical',
	        align: 'right',
	        verticalAlign: 'middle'
	    },
	    series: [{
	        name: 'ProcRate',
	        data: [{}],
	        lineWidth: 0.7
	    }],
	    responsive: {
	        rules: [{
	            condition: {
	                maxWidth: 500
	            },
	            chartOptions: {
	                legend: {
	                    layout: 'horizontal',
	                    align: 'center',
	                    verticalAlign: 'bottom'
	                }
	            }
	        }]
	    },
	    plotOptions: {
	    	series: {
	    		turboThreshold: 20160
	    	}
	    }

	});
	setInterval(updateSecChart, 1000);
	setInterval(updateMinChart, 10000);
	function sleep(ms) {
	  return new Promise(resolve => setTimeout(resolve, ms));
	}
    function updateSecChart(){
		let points = "";
		if ($scope.secInterval != 0 && $scope.secLimit != 0){
			$http.get("http://localhost:12346/sec_statspoint?interval=" + $scope.secInterval + "&limit=" + $scope.secLimit + "&name=" + $scope.name)
		    .then(function(response) {
		    	points = response.data.points;
		    	console.log(points);
		    	// if (points.length < $scope.limit){
		    	// 	return;
		    	// }
		    	secondChart.xAxis[0].update({
		    		tickPositions: [0, points.length - 1]
		    	}, true);
		    	secondChart.series[0].update({
				    data: points
				}, true);
		    });
		} else {
			// alert("Chon du het di!!!");
		}
					
    }

    function updateMinChart(){
		let points = "";
		if ($scope.minInterval != 0 && $scope.minLimit != 0){
			$http.get("http://localhost:12346/min_statspoint?interval=" + $scope.minInterval + "&limit=" + $scope.minLimit + "&name=" + $scope.name)
		    .then(function(response) {
		    	points = response.data.points;
		    	console.log(points);
		    	// if (points.length < $scope.limit){
		    	// 	return;
		    	// }
		    	minuteChart.xAxis[0].update({
		    		tickPositions: [0, points.length - 1]
		    	}, true);
		    	minuteChart.series[0].update({
				    data: points
				}, true);
		    });
		} else {
			// alert("Chon du het di!!!");
		}
					
    }

});