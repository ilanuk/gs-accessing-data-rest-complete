var employeeApp = angular.module('employeeApp', []);

employeeApp.controller('employeeCtrl',  function ($scope, $http) {
  
  $scope.refreshEmployee = function() {
    $http.get('/employee')
    .success(function(data) {
      $scope.employees = data._embedded.employee;
      console.log(data);
    });
  };
  $scope.refreshEmployeeOne = function() {
	  $http.get('/employee/'+$scope.employeeId)
	    .success(function(data) {
	      $scope.employees = data;
	    });
  };
  
  $scope.removeEmployee = function() {
	  $http.get('/employee/'+$scope.employeeId)
    .success($scope.refreshEmployee());
    alert("employee Successfully deleted!");
    
  };
  
  $scope.initEmployee= function() {
    $scope.refreshEmployee();
  };
  
  $scope.addEmployee = function(employeeId) {
    $http.post('/employee')
    .success(function(data) {
      $scope.refreshEmployeeOne();
      alert("employee Successfully added!");
    });
  };
});