function yboardList($scope, $http) {
	var yboard = {
			start: 0, 
			limit:10
	}	
	$http({
		url: '/yboard/select',
		method: 'POST',				
		data: board,				
	}).success(function(returnJSON) {
			$scope.yboards = returnJSON.items;
	});
}