'use strict';

/**
 * @ngdoc function
 * @name publicApp.controller:CreateCtrl
 * @description
 * # CreateCtrl
 * Controller of the publicApp
 */
angular.module('publicApp')
  .controller('CreateCtrl', function ($scope,$window,$location,api) {
    $scope.createRoom = function(){
      if($scope.roomName != ""){
        console.log($scope.roomName);
        api.createRoom($scope.roomName).then(function(data){
          $window.alert("Room Created!");
          $location.path("/");
        });
      }
    }
  });
