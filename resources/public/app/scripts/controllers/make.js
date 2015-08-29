'use strict';

/**
 * @ngdoc function
 * @name publicApp.controller:MakeCtrl
 * @description
 * # MakeCtrl
 * Controller of the publicApp
 */
angular.module('publicApp')
  .controller('MakeCtrl', function ($scope,$routeParams,api,$window) {
    console.log($routeParams);
    $scope.makeBooking = function(){
      if($scope.doneby != ""){
        api.makeBooking($routeParams.roomID,$routeParams.slot,$routeParams.date,$scope.doneby).then(function(data){
          $window.alert("Booking done!");
          $window.history.back();
        })
      }
    };
  });
