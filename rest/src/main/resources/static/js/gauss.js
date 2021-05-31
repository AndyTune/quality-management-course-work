app = angular.module('gauss', []);

app.controller("GaussController", function ($scope, $http) {

    $scope.successGetGaussCallback = function (response) {
         $scope.gauss = response.data;
         $scope.errormessage="";
    };

    $scope.errorGetGaussCallback = function (error) {
        console.log(error);
        $scope.errormessage="Unable to get solution";
    };

    $scope.getGauss = function () {
        $http.get('/public/rest/gauss').then($scope.successGetGaussCallback, $scope.errorGetGaussCallback);
    };

    $scope.successDeleteGaussCallback = function (response) {
        for (var i = 0; i < $scope.gauss.length; i++) {
                $scope.gauss.splice(i, 1);
        }
        $scope.errormessage="";
        $http.get('/public/rest/gauss').then($scope.successGetGaussCallback, $scope.errorGetGaussCallback);
    };

    $scope.errorDeleteGaussCallback = function (error) {
        console.log(error);
        $scope.errormessage="Unable to delete last result; check if there are any related records exist.";
    };

    $scope.deleteGauss = function () {
        $http.delete('/public/rest/gauss').then($scope.successDeleteGaussCallback, $scope.errorDeleteGaussCallback);
    };


    $scope.successAddGaussCallback = function (response) {
        $http.get('/public/rest/gauss').then($scope.successGetGaussCallback, $scope.errorGetGaussCallback);
        $scope.errormessage="";
    };

    $scope.errorAddGaussCallback = function (error) {
        console.log(error);
        $scope.errormessage="Impossible to create matrix";
    };

    $scope.addGauss = function () {
        const body = { a: [[$scope.a1, $scope.a2, $scope.a3], 
        		    [$scope.a4, $scope.a5, $scope.a6], 
        		    [$scope.a7, $scope.a8, $scope.a9]],
        	       y: [$scope.b1, $scope.b2, $scope.b3] };
        $http.post('/public/rest/gauss', body).then($scope.successAddGaussCallback, $scope.errorAddGaussCallback);

        // $http.post('/public/rest/gauss/' + $scope.a1 + '/' + $scope.a2 + '/' + $scope.a3 + '/' + $scope.b1 + '/' + $scope.a4 + '/' +
        //      $scope.a5 + '/' + $scope.a6 + '/' + $scope.b2 + '/' + $scope.a7 + '/' + $scope.a8 + '/' +
        //      $scope.a9 + '/' + $scope.b3).then($scope.successAddGaussCallback, $scope.errorAddGaussCallback);
    };
});
