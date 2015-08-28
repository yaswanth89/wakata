'use strict';

/**
 * @ngdoc function
 * @name publicApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the publicApp
 */
angular.module('publicApp')
  .controller('MainCtrl', function ($scope,api) {

    api.allRooms().then(function(data){
      console.log(data);
      $scope.rooms = data;
    })
    $scope.getSchedule = function(){
      if(!!$scope.selected_room){
          console.log($scope.selected_room);
      }
      else{
        alert("please select a room")
      }
    }
  });
