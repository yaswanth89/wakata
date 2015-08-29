'use strict';

/**
 * @ngdoc function
 * @name publicApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the publicApp
 */
angular.module('publicApp')
  .controller('MainCtrl', function ($scope, $route, $location ,api) {

    api.allRooms().then(function(data){
      $scope.rooms = data;
    })
    $scope.getSchedule = function(){
      if(!!$scope.selected_room){
        var temp = new Date();
        console.log(temp);
        var str = ""+ temp.getFullYear();
        str += "-" + (temp.getMonth() + 1);
        str += "-" + temp.getDate();
        $location.path("/book/"+$scope.selected_room +"/"+str);
      }
      else{
        alert("please select a room")
      }
    }
  });
